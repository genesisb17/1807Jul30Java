/*
Raymond Duncan Week 2 Assignment
*/


/************************************************************************
**                           2.0 SQL Queries                           **
************************************************************************/
-- In this section you will be performing various queries against the Oracle Chinook database.

-----------         2.1 SELECT         -----------
--Task – Select all records from the Employee table.
select * from employee;
--Task – Select all records from the Employee table where last name is King.
select * from employee where lower(lastname) = 'king';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where lower(firstname) = 'andrew' and reportsto is null;

-----------         2.2 ORDER BY         -----------
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album
order by title desc;
--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer
order by city asc;

-----------         2.3 INSERT INTO         -----------
--Task – Insert two new records into Genre table
select * from genre order by name;
select * from genre order by genreid desc;
--Insert Funk
insert into genre(genreid,name)
values(26,'Funk');
--Insert Noise
insert into genre(genreid,name)
values(27,'Noise');
--Task – Insert two new records into Employee table
select * from employee;
--Insert John Doe
insert into employee(employeeid,firstname,lastname)
values(9,'John','Doe');
--Insert Jane Doe
insert into employee(employeeid,firstname,lastname)
values(10,'Jane','Doe');
--Task – Insert two new records into Customer table
select * from customer;
--Insert Raymond Duncan
insert into customer(customerid,firstname,lastname,email)
values(60,'Raymond','Duncan','raymond.duncan@gmail.com');
--insert Anthony Duncan
insert into customer(customerid,firstname,lastname,email)
values(61,'Anthony','Duncan','anthony.duncan@gmail.com');

-----------         2.4 UPDATE         -----------
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname = 'Robert', lastname = 'Walter' where firstname = 'Aaron' and lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

-----------         2.5 LIKE         -----------
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';

-----------         2.6 BETWEEN         -----------
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between to_date('01/06/2003', 'DD/MM/YYYY') and to_date('01/03/2004', 'DD/MM/YYYY');

-----------         2.7 DELETE         -----------
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
select * from customer where firstname = 'Robert' and lastname = 'Walter';
select * from invoice where customerid = 32;
select * from invoiceline where invoiceid = 50;

alter table invoice 
    drop CONSTRAINT "FK_INVOICECUSTOMERID";
alter table invoice
    add CONSTRAINT "FK_INVOICECUSTOMERID" FOREIGN KEY ("CUSTOMERID") REFERENCES "CHINOOK"."CUSTOMER" ("CUSTOMERID") ON DELETE CASCADE ENABLE;
alter table invoiceline 
    drop CONSTRAINT "FK_INVOICELINEINVOICEID";
alter table invoiceline  
    add CONSTRAINT "FK_INVOICELINEINVOICEID" FOREIGN KEY ("INVOICEID") REFERENCES "CHINOOK"."INVOICE" ("INVOICEID") ON DELETE CASCADE ENABLE;
    
delete from customer where firstname = 'Robert' and lastname = 'Walter';
select * from customer where firstname = 'Robert' and lastname = 'Walter';
select * from invoice where customerid = 32;
select * from invoiceline where invoiceid = 50;

insert into mediatype values(20,'Betamax');
insert into track(trackid,name,mediatypeid,milliseconds,unitprice) values(9000,'Best track',20,50,10);
delete from mediatype where name = 'Betamax' cascade;


/************************************************************************
**                         3.0 SQL Functions                           **
************************************************************************/
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

-----------           3.1 System Defined Functions           -----------
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time
RETURN TIMESTAMP WITH TIME ZONE AS time TIMESTAMP WITH TIME ZONE;
BEGIN
SELECT CURRENT_TIMESTAMP INTO time FROM DUAL;
RETURN time;
END;
/
SELECT get_time() FROM DUAL;
--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatype_length1 --Assuming that the length refers to the average length of the datatype
RETURN NUMBER AS length NUMBER;
BEGIN
SELECT length(name) as "Media Name Length" INTO length FROM mediatype;
RETURN length;
END;
/
SELECT mediatype_length1() FROM DUAL;

CREATE OR REPLACE FUNCTION mediatype_length2(mtype IN VARCHAR2) --Assuming that the length refers to the length of the name of the mediatype
RETURN NUMBER AS length NUMBER;
BEGIN
SELECT avg(milliseconds)/1000 as "Media Length(s)" INTO length 
FROM track t JOIN mediatype m ON t.mediatypeid = m.mediatypeid
WHERE m.name = mtype;
RETURN length;
END;
/

SELECT * FROM mediatype;
SELECT mediatype_length2('MPEG audio file') AS "Average MPEG length(s)" FROM DUAL;

-----------           3.2 System Defined Aggregate Functions           -----------
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION invoice_average
RETURN NUMBER AS average NUMBER;
BEGIN
SELECT avg(total) INTO average FROM invoice;
RETURN round(average,2);
END;
/
SELECT invoice_average() AS "Invoice Average($)" FROM dual;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive_track
RETURN VARCHAR2 AS t VARCHAR2(200 BYTE);
BEGIN
SELECT name INTO t FROM (SELECT name FROM track ORDER BY unitprice) WHERE rownum = 1;
RETURN t;
END;
/
SELECT most_expensive_track() AS "Most expensive track" FROM DUAL;


-----------           3.3 User Defined Functions           -----------
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_invoiceline_price --Assuming tha this function is to find the average price of all items in the table
return NUMBER AS average NUMBER;
BEGIN 
SELECT avg(unitprice) INTO average FROM invoiceline;
RETURN round(average,2);
END;
/
SELECT average_invoiceline_price() AS "Average invoice price($)" FROM DUAL;



-----------           3.4 User Defined Table Valued Functions           -----------
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE my_record AS OBJECT (
"EMPLOYEEID" NUMBER , 
	"LASTNAME" VARCHAR2(20 BYTE), 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"TITLE" VARCHAR2(30 BYTE), 
	"REPORTSTO" NUMBER, 
	"BIRTHDATE" DATE, 
	"HIREDATE" DATE, 
	"ADDRESS" VARCHAR2(70 BYTE), 
	"CITY" VARCHAR2(40 BYTE), 
	"STATE" VARCHAR2(40 BYTE), 
	"COUNTRY" VARCHAR2(40 BYTE), 
	"POSTALCODE" VARCHAR2(10 BYTE), 
	"PHONE" VARCHAR2(24 BYTE), 
	"FAX" VARCHAR2(24 BYTE), 
	"EMAIL" VARCHAR2(60 BYTE)
);
/
CREATE OR REPLACE TYPE my_table AS TABLE OF my_record;
/
CREATE OR REPLACE FUNCTION employees_born_post_1968
RETURN my_table AS employees my_table;
BEGIN
SELECT * INTO employees FROM employee WHERE birthdate BETWEEN to_date('12-31-1968', 'MM-DD-YYYY') AND (SELECT CURRENT_DATE FROM DUAL);
END;
/

SELECT * FROM employee;
SELECT * FROM employee WHERE birthdate BETWEEN to_date('12-31-1968', 'MM-DD-YYYY') AND (SELECT CURRENT_DATE FROM DUAL);


/*******************************************************************************
**                         4.0 SQL Stored Procedures                          **
*******************************************************************************/
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

-----------           4.1 Basic Stored Procedure           -----------
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE employee_names(l_employees OUT SYS_REFCURSOR) AS
--    l_employees SYS_REFCURSOR;
    l_firstname employee.firstname%TYPE;
    l_lastname employee.lastname%TYPE;
BEGIN
    OPEN l_employees for select firstname,lastname from employee;
END;
/

DECLARE l_employees SYS_REFCURSOR;
BEGIN
    NULL;
END;
/

VARIABLE l_employees REFCURSOR;
EXECUTE employee_names(:l_employees);
PRINT L_EMPLOYEES;

-----------           4.2 Stored Procedure Input Parameters           -----------
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_address(empl_id IN employee.employeeid%TYPE, new_addr IN employee.address%TYPE) AS
BEGIN
    UPDATE employee set address = new_addr;
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_managers(empl_id IN employee.employeeid%TYPE) AS
    eid employee.employeeid%TYPE := empl_id;
    fname employee.firstname%TYPE;
    lname employee.lastname%TYPE;
BEGIN
    --Print the employee's name
    SELECT firstname,lastname INTO fname,lname FROM employee WHERE employeeid = eid;
    dbms_output.put_line(fname || ' ' || lname || ' reports to:');
    SELECT reportsto INTO eid FROM employee WHERE employeeid = eid;
    
    LOOP
    IF eid >= 1 THEN
        SELECT firstname,lastname INTO fname,lname FROM employee WHERE employeeid = eid;
        dbms_output.put_line(fname || ' ' || lname);
        SELECT reportsto INTO eid FROM employee WHERE employeeid = eid;
    ELSE 
        EXIT; 
    END IF;
    END LOOP;
END;
/
EXECUTE get_managers(empl_id=>1/*number*/);

-----------           4.3 Stored Procedure Output Parameters           -----------
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE customer_info(cust_id IN customer.customerid%TYPE) AS
    fname customer.firstname%TYPE;
    lname customer.lastname%TYPE;
    comp customer.company%TYPE;
BEGIN
    SELECT firstname,lastname,company INTO fname,lname,comp FROM customer WHERE customerid = cust_id;
    dbms_output.put_line(fname || ' ' || lname || ' works for company ' || comp);
END;
/
EXECUTE customer_info(3);

/*************************************************************************
**                         5.0 SQL Transactions                         **
*************************************************************************/
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice(inv_id IN invoice.invoiceid%TYPE) AS
BEGIN
    SAVEPOINT pre_invoice_delete;
    --Logic for deleting the invoice
    DELETE FROM invoice WHERE invoiceid = inv_id;
    
    IF SQL%ROWCOUNT = 0 THEN
        ROLLBACK TO pre_invoice_delete;
    END IF;
    COMMIT;
END;
/
select * from invoice where invoiceid = 6;
EXECUTE delete_invoice(6);
select * from invoice where invoiceid = 6;
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE new_customer(
    cust_fname IN customer.firstname%TYPE,
    cust_lname IN customer.lastname%TYPE,
    cust_email IN customer.email%TYPE,
    cust_id OUT NUMBER
) AS
BEGIN
    SAVEPOINT pre_customer_insertion;
    SELECT max(customerid)+1 INTO cust_id FROM customer;
    dbms_output.put_line(cust_id);
    INSERT INTO customer(customerid,firstname,lastname,email) VALUES(cust_id,cust_fname,cust_lname,cust_email);
    IF SQL%ROWCOUNT = 0 THEN 
        ROLLBACK TO pre_customer_insertion;
        dbms_output.put_line('Rolling back customer insertion');
    END IF;
    COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE new_invoice(
    cust_fname IN customer.firstname%TYPE,
    cust_lname IN customer.lastname%TYPE,
    cust_email IN customer.email%TYPE,
    inv_total IN invoice.total%TYPE
) AS
    cust_id NUMBER;
    inv_id NUMBER;
    inv_date DATE;
BEGIN
    dbms_output.put_line('Starting procedure');
    SELECT customerid INTO cust_id FROM customer WHERE firstname = cust_fname AND lastname = cust_lname AND email = cust_email;
    <<invoice_insertion>>   
    SELECT max(invoiceid)+1 INTO inv_id FROM invoice;
    SELECT CURRENT_DATE INTO inv_date FROM DUAL;
    dbms_output.put_line('Starting procedure 2');
    ------------------- Atomic transaction 2 -------------------
    SAVEPOINT pre_invoice_insertion;
    INSERT INTO invoice(invoiceid,customerid,invoicedate,total)
    VALUES(inv_id,cust_id,inv_date,inv_total);
    IF SQL%ROWCOUNT = 0 THEN 
        ROLLBACK TO pre_invoice_insertion;
        dbms_output.put_line('Rolling back invoice insertion');
    END IF;
    COMMIT;
    ------------------------------------------------------------
    EXCEPTION WHEN OTHERS THEN
        dbms_output.put_line('Entering exception');
        --Nested procedure to create new customer profile
        ------------------- Atomic transaction 1 -------------------
        EXECUTE IMMEDIATE new_customer(cust_fname,cust_lname,cust_email,cust_id);
        GOTO invoice_insertion;
        ------------------------------------------------------------
END;
/

select * from invoice;
select * from invoiceline;
select sum(unitprice) from invoiceline where invoiceid = 40;
select * from invoiceline order by quantity desc;
select max(invoiceid)+1 from invoice;
VARIABLE date NUMBER;
SELECT 1 INTO date FROM DUAL;
IF SQL%ROWCOUNT = 0 THEN 
SELECT * FROM DUAL; 
END IF;

SELECT 1 FROM DUAL;

SELECT * FROM customer WHERE firstname = 'Ronald';
EXECUTE new_invoice('Ronald','McDonald','ronald@mcdonald.com',9.99);
EXECUTE new_invoice('Ronalds','MacDonald','ronald@mcdonald.com',9.99);
SELECT * FROM customer WHERE firstname = 'Ronalds';
SELECT * FROM invoice WHERE customerid = 62;



/*************************************************************************
**                         6.0 Triggers                         **
*************************************************************************/
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

-----------           6.1 AFTER/FOR           -----------
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
SELECT max(employeeid) FROM employee;
CREATE SEQUENCE emp_id_generator 
MINVALUE 0
START WITH 9
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER emp_insertion_success
AFTER INSERT ON employee
BEGIN
    dbms_output.put_line('My Trigger: Successful employee insertion!');
END;
/
INSERT INTO employee(employeeid,firstname,lastname,email)
VALUES((SELECT max(employeeid)+1 FROM employee),'Ron','Swanson','rswanson@pawnee.gov');
INSERT INTO employee(employeeid,firstname,lastname,email)
VALUES((SELECT max(employeeid)+1 FROM employee),'Leslie','Knope','lknopw@pawnee.gov');
INSERT INTO employee(employeeid,firstname,lastname,email)
VALUES((SELECT max(employeeid)+1 FROM employee),'Tom','Haverford','thaverford@pawnee.gov');
INSERT INTO employee(employeeid,firstname,lastname,email)
VALUES((SELECT max(employeeid)+1 FROM employee),'Bill','Withers','bwithers@aol.com');
--Task – Create an after update trigger on the album table that fires after a row is updated in the table
CREATE OR REPLACE TRIGGER album_update_success
AFTER UPDATE ON album
BEGIN
    dbms_output.put_line('My Trigger: Album update successful');
END;
/
SELECT * FROM album;
INSERT INTO album
VALUES((SELECT max(albumid)+1 FROM album),'D A R N.',2);
UPDATE album SET artistid = 3 WHERE title = 'D A R N.';
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete_success
AFTER DELETE ON customer
BEGIN
    dbms_output.put_line('My Trigger: Customer delete successful');
END;
/
SELECT * FROM customer ORDER BY customerid DESC;
DELETE FROM customer WHERE customerid = 62;


/*************************************************************************
**                               7.0 JOINS                              **
*************************************************************************/
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

-----------           7.1 INNER           -----------
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.firstname,c.lastname,i.invoiceid FROM customer c INNER JOIN invoice i ON c.customerid = i.customerid ORDER BY c.firstname,c.lastname,i.invoiceid;

-----------           7.2 OUTER           -----------
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.customerid,c.firstname,c.lastname,i.invoiceid,i.total FROM customer c FULL OUTER JOIN invoice i ON c.customerid = i.customerid ORDER BY c.firstname,c.lastname,i.invoiceid;

-----------           7.3 RIGHT           -----------
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ar.artistid,ar.name,al.title FROM album al RIGHT JOIN artist ar ON al.artistid = ar.artistid ORDER BY ar.name; 

-----------           7.4 CROSS           -----------
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist CROSS JOIN album;

-----------           7.5 SELF           -----------
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e.firstname AS "Employee Firstname", e.lastname AS "Employee Lastname", m.firstname AS "Manager Firstname", m.lastname AS "Manager Lastname"
FROM employee e LEFT JOIN employee m ON e.reportsto = m.employeeid ORDER BY m.firstname,m.lastname,e.firstname,e.lastname;

-----------           7.6 Complicated Join assignment           -----------
-- Create an inner join between all tables in the chinook database.
SELECT 
    c.firstname as "Customer firstname",
    c.lastname as "Customer lastname",
    c.company as "Company",
    c.address as "Customer address",
    c.city as "Customer city",
    c.state as "Customer state",
    c.postalcode as "Customer postal code",
    c.phone as "Customer phone",
    c.fax as "Customer fax",
    c.email as "Customer email",
    e.firstname as "Customer firstname",
    e.lastname as "Customer lastname",
    e.title as "Support rep title",
    m.firstname as "Support rep manager firstname",
    m.lastname as "Support rep manager lastname",
    e.birthdate as "Support rep birthdate",
    e.hiredate as "Support rep hiredate",
    e.address as "Support rep address",
    e.city as "Support rep city",
    e.state as "Support rep state",
    e.postalcode as "Support rep postal code",
    e.phone as "Support rep phone",
    e.fax as "Support rep fax",
    e.email as "Support rep email",
    i.invoiceid as "Invoice ID",
    i.invoicedate as "Invoice date",
    i.billingaddress as "Invoice billing address",
    i.billingstate as "Invoice billing state",
    i.billingcountry as "Invoice billing country",
    i.billingpostalcode as "Invoice billing postal code",
    i.total as "Invoice total",
    il.invoicelineid as "Invoice line id",
    il.trackid as "Track ID",
    il.unitprice as "Invoice line price",
    il.quantity as "Invoice line quantity",
    t.name as "Track name",
    t.albumid as "Album ID",
    al.title as "Album title",
    al.artistid as "Artist ID",
    ar.name as "Artist name",
    t.mediatypeid as "Mediatype ID",
    mt.name as "Media type",
    t.genreid as "Genre ID",
    g.name as "Genre",
    t.composer as "Composer",
    t.milliseconds as "Track length (ms)",
    t.bytes as "Track size (B)",
    t.unitprice as "Track price",
    pl.playlistid as "Playlist ID",
    pl.name as "Playlist name"    
FROM customer c
    FULL OUTER JOIN employee e ON c.supportrepid = e.employeeid
    FULL OUTER JOIN employee m ON e.reportsto = m.employeeid
    FULL OUTER JOIN invoice i ON c.customerid = i.customerid
    FULL OUTER JOIN invoiceline il ON i.invoiceid = il.invoiceid
    FULL OUTER JOIN track t ON il.trackid = t.trackid
    FULL OUTER JOIN playlisttrack plt ON plt.trackid = t.trackid
    FULL OUTER JOIN playlist pl ON pl.playlistid = plt.playlistid
    FULL OUTER JOIN genre g ON t.genreid = g.genreid
    FULL OUTER JOIN album al ON t.albumid = al.albumid
    FULL OUTER JOIN artist ar ON al.artistid = ar.artistid
    FULL OUTER JOIN mediatype mt ON t.mediatypeid = mt.mediatypeid;



-----   DO NOT CONTINUE!!!
-----   DON'T FORGET TO FIX 3.4 AND 5.0 TASK 3!!!

/*************************************************************************
**                          9.0 Administration                          **
*************************************************************************/
-- In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.

--Task – Create a .bak file for the Chinook database 