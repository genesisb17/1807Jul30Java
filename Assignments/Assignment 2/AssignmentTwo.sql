--2.1; 
--Select all records from employee table
SELECT * FROM employee;

--Select all records from the employee table where last name is King
SELECT * FROM employee
WHERE lastname = 'King';

--Select all records from the employee table where first name is andrew and reportsto is NULL
SELECT * FROM employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

--2.2 ORDER BY
--Select all albums in Album table and sort result set in descending order by title
SELECT * FROM album
ORDER BY title DESC;

--Select first name from Customer and sort result set in ascending order by city
SELECT firstname
FROM customer
ORDER BY city ASC;

--2.3 INSERT INTO;
--Insert two new records into Genre table
INSERT INTO genre(genreid, name)
VALUES (27, 'Future Trap');

--Insert two new records into Employee table
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,
address, city, state, country, postalcode, phone, fax, email)
VALUES(10, 'Benz', 'Merecedes', 'CEO', NULL, '02-JAN-47', '24-OCT-95', '423 Amber Ave', 
'Lethbridge', 'AB', 'CANADA', 'T2P 2T3','+1 (403) 456-4230', '+1 (403) 444-5621', 'mercedes@chinookcorp.com');

SELECT * FROM customer;

--Insert two new records into Customer table
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state,
country, postalcode, phone, fax, email, supportrepid)
VALUES(61, 'Carlson', 'Carlton', 'Giant', '23 Meslo ort', 'Bejing', 'China', 'China', 
'39912', '+400 39902932', NULL, 'thecarlton@dance.com', 3);

--2.4 UPDATE;
--Update aaron mitchell in customer table to robert walter
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE;
--Select all invoices that have a total between 15 and 50
SELECT billingaddress
FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN;
--Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total
BETWEEN 15 AND 50;

--Select all employees hired between 1st and June 2003 and 1st of March 2004 
SELECT * FROM employee
WHERE hiredate
BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Have to make sure that the bottom foreign key is deleted work your way up
DELETE FROM employee
where 
DELETE FROM invoice
WHERE customerid = 34;

DELETE FROM customer
where firstname = 'Robert' AND lastname = 'Walter';

--3.1 System Defined Functions
--Create a function that returns the current time
CREATE OR REPLACE FUNCTION length_of_med(mediatype_id number)
RETURN number
IS length_of_media number;
BEGIN
    SELECT length(name)
    INTO length_of_media
    FROM mediatype
    WHERE mediatypeid = mediatype_id;
    RETURN length_of_media;
END;
/
SELECT * FROM invoice;
--3.2 System user defined function
CREATE OR REPLACE FUNCTION total_invoice 
BEGIN
END;
/

--3.2
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_tot_invoice
RETURN number
IS 
    avg_tot number;
BEGIN
    SELECT avg(total)
    INTO avg_tot
    FROM invoice;
    RETURN avg_tot;
END;
/
--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION max_track
RETURN number
IS 
    max_t number;
BEGIN
    SELECT max(unitprice)
    INTO max_t
    FROM track;
    RETURN max_t;
END;
/
--3.3 User Defined Function
CREATE OR REPLACE FUNCTION avg_price
RETURN number
IS 
    avg_invoiceline number;
BEGIN
    SELECT AVG(unitprice)
    INTO avg_invoiceline
    FROM invoiceline;
    RETURN avg_invoiceline;
END;
/ 

--3.4 User Defined Table Valued Functions
--Create a function that returns all employees who are born after 1968
DECLARE
    c_birthdate employee.birthdate%type;
    c_firstname employee.firstname%type;
    c_lastname employee.lastname%type;
    CURSOR employees IS
    SELECT birthdate, firstname, lastname FROM employee;
BEGIN
    OPEN employees;
    LOOP
    FETCH employees INTO c_birthdate, c_firstname, c_lastname;
        EXIT WHEN employees%notfound;
        IF (c_birthdate > '01-JAN-68')THEN
            dbms_output.put_line(c_firstname || ' ' || c_lastname || ' ' || c_birthdate);
        END IF;     
    END LOOP;
    CLOSE employees;
END;
/
--4.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees

CREATE OR REPLACE PROCEDURE first_and_last 
IS 
    CURSOR c_emp IS SELECT * FROM employee;
    r_emp c_emp%ROWTYPE;
BEGIN
    OPEN c_emp;
    LOOP
        FETCH c_emp into r_emp;
        EXIT WHEN c_emp%NOTFOUND;
            DBMS_OUTPUT.put_line(r_emp.firstname || ' ' || r_emp.lastname);
    END LOOP;
    CLOSE c_emp;
END;
/

execute first_and_last();

--4.2 Stored Procedure Input Parameters
CREATE or REPLACE PROCEDURE per_info(c_birthdate date, 
    c_address varchar2, c_city varchar2,
    c_tstate varchar2, c_country varchar2, c_postalcode varchar2, c_phone varchar2,
    emp_id number)
IS 
BEGIN
    UPDATE employee 
    SET birthdate = c_birthdate, address = c_address,
    city = c_city, state = c_tstate, country = c_country,
    postalcode = c_postalcode, phone = c_phone
    WHERE employeeid = emp_id;
END;
/

execute per_info('23-JAN-30', '23 Street st', 'Lowell', 'Massachusetts', 'United States', '34231', '(+1) 9784403339', 1);
SELECT*FROM employee;
    
CREATE OR REPLACE PROCEDURE manager_name(employee_id number)
IS 
manager_number number;
first_name varchar2(20);
last_name varchar2(20);
BEGIN

    SELECT reportsto
    INTO manager_number
    FROM employee
    WHERE employeeid = employee_id;

    SELECT firstname, lastname
    INTO first_name, last_name
    FROM employee
    WHERE employeeid = manager_number;
    
    IF manager_number <> NULL THEN
    DBMS_OUTPUT.put_line(first_name || ' ' || last_name);
    END IF;
END;
/
execute manager_name(2);
/

--4.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and the company of a customer

CREATE OR REPLACE PROCEDURE customer_company(customer_fname OUT varchar2, 
customer_lname OUT varchar2, customer_comp OUT varchar2, customer_id number)
IS
BEGIN
    SELECT firstname, lastname, company
    INTO customer_fname, customer_lname, customer_comp
    FROM customer
    WHERE customerid = customer_id;
END;
/
DECLARE
    customer_fname varchar2(20);
    customer_lname varchar2(20);
    customer_comp varchar2(200);
BEGIN
    customer_company(customer_fname, customer_lname, customer_comp, 1);
    DBMS_OUTPUT.put_line(customer_fname || ' ' || customer_lname || ': ' || customer_comp);
END;
/
-- 5.0 Transactions
--Create a transaction that given a invoiceid will delete that invoice (There may be constraints that rely on this,
--find out how to resolve them.
CREATE OR REPLACE PROCEDURE delete_invoice(given_id number)
IS 
BEGIN
    DELETE FROM invoiceline
    WHERE invoiceid = given_id;

    DELETE FROM invoice
    WHERE invoiceid = given_id;

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE inserts_newr(customer_id number,
first_name varchar2, lastname varchar2, company varchar2,
address varchar2, city varchar2, state varchar2, country varchar2,
postalcode varchar2, phone varchar2, fax varchar2, email varchar2,
support_rep_id number)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname,
    company, address, city, state, country, postalcode, phone, fax,
    email, supportrepid)
    VALUES(customer_id, first_name, lastname, company,
    address, city, state, country, postalcode, phone, fax, email,
    support_rep_id);
    COMMIT;
END;
/
--TRIGGER
CREATE OR REPLACE TRIGGER employee_row_added
AFTER INSERT
   ON employee
BEGIN
    DBMS_OUTPUT.put_line('ROW HAS BEEN INSERTED INTO EMPLOYEE, TRIGGER MESSAGE');
END;
/
/*INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,
address, city, state, country, postalcode, phone, fax, email)
VALUES(10, 'Benz', 'Merecedes', 'CEO', NULL, '02-JAN-47', '24-OCT-95', '423 Amber Ave', 
'Lethbridge', 'AB', 'CANADA', 'T2P 2T3','+1 (403) 456-4230', '+1 (403) 444-5621', 'mercedes@chinookcorp.com');

DELETE FROM employee
WHERE employeeid = 10;
*/
CREATE OR REPLACE TRIGGER album_row_update
AFTER UPDATE
   ON album
BEGIN
    DBMS_OUTPUT.put_line('ROW HAS BEEN UPDATED IN ALBUM, TRIGGER MESSAGE');
END;
/
CREATE OR REPLACE TRIGGER customer_row_deleted
AFTER DELETE
   ON customer
BEGIN
    DBMS_OUTPUT.put_line('ROW HAS BEEN REMOVED FROM CUSTOMER, TRIGGER MESSAGE');
END;
/
--7.0 JOINS 
--7.1 CREATE an inner join that joins customers and orders and specifies the name of the customer and invoiceid
SELECT firstname, lastname, invoiceid
FROM customer
INNER JOIN invoice 
ON customer.customerid = invoice.customerid;

--SELECT*FROM invoice;

--7.2 CREATE an outer join that joins the customer and invoice table, specifying customerid, firstname, lastname, invoiceid,
--total
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.3 RIGHT; Create a right join that joins album and artist specifying artist name and title
SELECT artist.name, album.title
FROM album
RIGHT JOIN artist
ON artist.artistid = album.artistid;

--7.4 CROSS; Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT artist.name, album.title
FROM artist
CROSS JOIN album
ORDER BY artist.name ASC;

--7.5 SELF; Perform a self-join on the employees table, joining on the reportsto column
SELECT T1.firstname, T1.reportsto 
FROM employee T1, employee T2;

--7.6 Complicated Join Assignment; Create an inner join between all tables in chinook database
SELECT employee.firstname, employee.lastname
FROM ((employee
INNER JOIN customer ON employee.employeeid = customer.supporterid
INNER JOIN invoice ON customer.customerid = invoice.customerid
INNER JOIN invoiceline ON invoice.invoiceid = invoiceline.invoiceid
INNER JOIN track ON invoiceline.trackid = track.trackid
INNER JOIN mediatype ON track.mediatypeid = mediatype.mediatypeid
INNER JOIN genre ON genre.genreid = track.genreid
INNER JOIN album ON album.albumid = track.albumid
INNER JOIN playlisttrack ON playlisttrack.trackid = track.trackid
INNER JOIN playlist ON playlist.playlistid = playlisttrack.playlistid));

