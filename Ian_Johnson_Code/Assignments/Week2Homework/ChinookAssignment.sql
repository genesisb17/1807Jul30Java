/*
 * Ian Johnson Week 2 Assignment
 */

-- 2.1 SELECT
-- Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
-- Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
-- Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY /* ASC */;

-- 2.4 INSERT INTO
-- Insert two new records into Genre table.
INSERT INTO GENRE (GENREID, NAME) VALUES (
    -- So I don't have to figure out a proper GENREID myself.
    (SELECT MAX(GENREID) + 1 FROM GENRE),
    'Punk rock'
);
INSERT INTO GENRE (GENREID, NAME) VALUES (
    -- So I don't have to figure out a proper GENREID myself.
    (SELECT MAX(GENREID) + 1 FROM GENRE),
    'Indie'
);
-- Insert two new records into Employee table.
INSERT INTO EMPLOYEE (
    EMPLOYEEID,
    LASTNAME,
    FIRSTNAME,
    TITLE,
    REPORTSTO,
    BIRTHDATE,
    HIREDATE,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    /* FAX, */ -- Who uses fax any more anyways?
    EMAIL
) VALUES (
    (SELECT MAX(EMPLOYEEID) + 1 FROM EMPLOYEE),
    'Johnson',
    'Ian',
    'Developer',
    8,
    '09-MAY-96',
    CURRENT_DATE, -- Use the current date.
    '2925 Rensselaer Ct.',
    'Vienna',
    'USA',
    '22181',
    '7038198495',
    'iantimothyjohnson@gmail.com'
);
INSERT INTO EMPLOYEE (
    EMPLOYEEID,
    LASTNAME,
    FIRSTNAME,
    TITLE,
    REPORTSTO,
    BIRTHDATE,
    HIREDATE,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    /* FAX, */ -- Who uses fax any more anyways?
    EMAIL
) VALUES (
    (SELECT MAX(EMPLOYEEID) + 1 FROM EMPLOYEE),
    'Smith',
    'John',
    'Senior junior senior advisor',
    (SELECT EMPLOYEEID FROM EMPLOYEE WHERE FIRSTNAME = 'Ian'),
    '10-JUL-67',
    CURRENT_DATE,
    '567 Test Street',
    'New York City',
    'New York',
    'USA',
    '55555',
    '7777777777',
    'john.smith@generic.com'
);
-- Insert two new records into Customer table.
INSERT INTO CUSTOMER (
    CUSTOMERID,
    FIRSTNAME,
    LASTNAME,
    COMPANY,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    FAX,
    EMAIL,
    SUPPORTREPID
) VALUES (
    (SELECT MAX(CUSTOMERID) + 1 FROM CUSTOMER),
    'Jane',
    'Doe',
    'Revature',
    '111 Example Street',
    'Seattle',
    'Washington',
    'USA',
    '22222',
    '5555555555',
    '5555555555',
    'janedoe@revature.com',
    (SELECT EMPLOYEEID FROM EMPLOYEE WHERE FIRSTNAME = 'Ian')
);
INSERT INTO CUSTOMER (
    CUSTOMERID,
    FIRSTNAME,
    LASTNAME,
    COMPANY,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    FAX,
    EMAIL,
    SUPPORTREPID
) VALUES (
    (SELECT MAX(CUSTOMERID) + 1 FROM CUSTOMER),
    'William',
    'Shakespeare',
    'Self-employed',
    'The Globe Theatre',
    'London',
    'Greater London',
    'United Kingdom',
    '11111', -- I don't know what it actually is :(
    '7038675309',
    '1234567890',
    'bill.shakespeare@gmail.com',
    (SELECT EMPLOYEEID FROM EMPLOYEE WHERE FIRSTNAME = 'Ian')
);

-- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter.
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”.
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Select all invoices with a billing address like “T%”.
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Select all invoices that have a total between 15 and 50.
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
-- Select all employees hired between 1st of June 2003 and 1st of March 2004.
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
-- First, let's delete all the invoices that refer to Robert Walter; in order to
-- do this, we must first delete all the invoice lines that refer to those invoices.
-- The view below will make this easier:
CREATE VIEW RW_INVOICES AS
SELECT INVOICEID FROM INVOICE
WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID FROM RW_INVOICES);

-- Deleting rows from a view deletes the rows from the underlying table, so it's
-- easy to delete the invoices related to Robert Walter.
DELETE FROM RW_INVOICES;

-- Finally, we can delete Robert Walter, since everything depending on him has been deleted.
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.0 SQL Functions
-- 3.1 System Defined Functions
-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time RETURN VARCHAR2 AS
BEGIN
    -- Relevant Oracle docs that I looked up in order to make this:
    -- https://docs.oracle.com/cd/B19306_01/server.102/b14200/functions079.htm (LOCALTIMESTAMP)
    -- https://docs.oracle.com/cd/B19306_01/server.102/b14200/functions180.htm (TO_CHAR)
    RETURN TO_CHAR(LOCALTIMESTAMP, 'HH24:MI:SS');
END;
/
SELECT current_time FROM dual;

-- Create a function that returns the length of a mediatype from the mediatype table.
CREATE OR REPLACE FUNCTION mediatype_length(mediatype_id NUMBER) RETURN NUMBER AS
    len NUMBER;
BEGIN
    SELECT LENGTH(name) INTO len FROM mediatype WHERE mediatypeid = mediatype_id;
    RETURN len;
END;
/
SELECT mediatype_length(1) FROM dual;

-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices.
CREATE OR REPLACE FUNCTION avg_invoice_total RETURN NUMBER AS
    avg_total NUMBER(10, 2);
BEGIN
    SELECT AVG(total) INTO avg_total FROM invoice;
    RETURN avg_total;
END;
/
SELECT avg_invoice_total FROM dual;

-- Create a function that returns the most expensive track.
CREATE OR REPLACE FUNCTION most_expensive_track RETURN NUMBER AS
    ret_track_id NUMBER(10);
    top_price NUMBER(10, 2);
BEGIN
    -- First, we find the maximum price, and then we find the track ID corresponding to that price.
    SELECT MAX(unitprice) INTO top_price FROM track;
    SELECT trackid INTO ret_track_id FROM track
    WHERE unitprice = top_price AND ROWNUM = 1; -- In the event that there is more than one track with that price, choose the first.
    RETURN ret_track_id;
END;
/
SELECT * FROM track WHERE trackid = most_expensive_track;

-- 3.3 User Defined Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table.
CREATE OR REPLACE FUNCTION avg_invoiceline_price RETURN NUMBER AS
    avg_price NUMBER(10, 2);
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
/
SELECT avg_invoiceline_price FROM dual;

-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION get_employees_after_1968 RETURN SYS_REFCURSOR AS
    cur_employees SYS_REFCURSOR;
BEGIN
    OPEN cur_employees FOR SELECT * FROM employee WHERE birthdate >= '01-JAN-68';
    RETURN cur_employees;
END;
/

DECLARE
    cur_employees SYS_REFCURSOR := get_employees_after_1968();
    fetched employee%ROWTYPE;
BEGIN
    LOOP
        FETCH cur_employees INTO fetched;
        EXIT WHEN cur_employees%NOTFOUND;
        DBMS_OUTPUT.put_line(fetched.firstname || ' ' || fetched.lastname);
    END LOOP;
END;
/

-- 4.0 Stored Procedures
-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_employee_names(cur_names OUT SYS_REFCURSOR) AS
BEGIN
    -- A cursor should be fine for this, allowing us to iterate through the result set.
    OPEN cur_names FOR SELECT firstname, lastname FROM employee;
END;
/

DECLARE
    cur_employee_names SYS_REFCURSOR;
    first_name VARCHAR(20);
    last_name VARCHAR(20);
BEGIN
    get_employee_names(cur_employee_names);
    LOOP
        FETCH cur_employee_names INTO first_name, last_name;
        EXIT WHEN cur_employee_names%NOTFOUND;
        DBMS_OUTPUT.put_line(first_name || ' ' || last_name);
    END LOOP;
    CLOSE cur_employee_names;
END;
/

-- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee_name(employee_id IN NUMBER, first_name IN VARCHAR2, last_name IN VARCHAR2) AS
BEGIN
    UPDATE employee SET firstname = first_name, lastname = last_name WHERE employeeid = employee_id;
END;
/

CALL update_employee_name(1, 'Test', 'Employee');
SELECT * FROM employee WHERE employeeid = 1;

-- Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE TYPE EmployeeIDs IS TABLE OF NUMBER(10);
/
CREATE OR REPLACE PROCEDURE get_managers(employee_id_num IN NUMBER, cur_managers OUT SYS_REFCURSOR) AS
    manager_ids EmployeeIDs := EmployeeIDs();
    employee_id NUMBER(10) := employee_id_num;
    manager_id NUMBER(10);
BEGIN
    LOOP
        -- We collect the manager IDs of each higher-up into a table iteratively, moving on to the manager of
        -- whoever we just inserted on the next iteration.
        SELECT reportsto INTO manager_id FROM employee WHERE employeeid = employee_id;
        EXIT WHEN manager_id IS NULL;
        -- Of course you can't just INSERT INTO TABLE(manager_ids) VALUES (manager_id); that would be too simple.
        manager_ids.EXTEND;
        manager_ids(manager_ids.COUNT) := manager_id;
        employee_id := manager_id;
    END LOOP;
    OPEN cur_managers FOR
        -- You also can't use IN TABLE(manager_ids) :(
        SELECT * FROM employee WHERE employeeid IN (SELECT * FROM TABLE(manager_ids));
END;
/

DECLARE
    cur_managers SYS_REFCURSOR;
    fetched_employee employee%ROWTYPE;
BEGIN
    get_managers(10, cur_managers);
    LOOP
        FETCH cur_managers INTO fetched_employee;
        EXIT WHEN cur_managers%NOTFOUND;
        DBMS_OUTPUT.put_line(fetched_employee.firstname || ' ' || fetched_employee.lastname);
    END LOOP;
    CLOSE cur_managers;
END;
/

-- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customer_name_and_company(customer_id IN NUMBER, cname OUT VARCHAR2, ccompany OUT VARCHAR2) AS
BEGIN
    SELECT firstname || ' ' || lastname, company INTO cname, ccompany FROM customer WHERE customerid = customer_id;
END;
/

DECLARE
    cname VARCHAR2(100);
    ccompany VARCHAR2(100);
BEGIN
    get_customer_name_and_company(1, cname, ccompany);
    DBMS_OUTPUT.put_line('Name: ' || cname || ', Company: ' || ccompany);
END;
/

-- 5.0 Transactions
-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice_transaction(invoice_id NUMBER) AS
BEGIN
    SET TRANSACTION NAME 'del_invoice';
    -- First, we need to delete all the lines in the invoice.
    DELETE FROM invoiceline WHERE invoiceid = invoice_id;
    -- Now, we can delete the invoices themselves.
    DELETE FROM invoice WHERE invoiceid = invoice_id;
    COMMIT;
END;
/

CALL delete_invoice_transaction(1);

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table.
CREATE OR REPLACE PROCEDURE insert_new_customer(
    customerid NUMBER,
    firstname VARCHAR2,
    lastname VARCHAR2,
    company VARCHAR2,
    address VARCHAR2,
    city VARCHAR2,
    state VARCHAR2,
    country VARCHAR2,
    postalcode VARCHAR2,
    phone VARCHAR2,
    fax VARCHAR2,
    email VARCHAR2,
    supportrepid NUMBER
) AS
BEGIN
    SET TRANSACTION NAME 'insert_customer';
    -- Very large INSERT incoming...
    INSERT INTO customer VALUES (
        customerid,
        firstname,
        lastname,
        company,
        address,
        city,
        state,
        country,
        postalcode,
        phone,
        fax,
        email,
        supportrepid
    );
    COMMIT;
END;
/

CALL insert_new_customer(
    10000,
    'Ian',
    'Johnson',
    'Revature',
    '2925 Rensselaer Ct.',
    'Vienna',
    'VA',
    'United States of America',
    '22181',
    '7038198495',
    NULL,
    'iantimothyjohnson@gmail.com',
    NULL
);

-- 6.0 Triggers
-- 6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER trig_employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('A new employee was inserted, named ' || :NEW.firstname || ' ' || :NEW.lastname);
END;
/

INSERT INTO employee(employeeid, lastname, firstname) VALUES(1001, 'Smith', 'John'); -- Let's test it out.

-- Create an after update trigger on the album table that fires after a row is inserted in the table.
CREATE OR REPLACE TRIGGER trig_album_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('An album (ID ' || :NEW.albumid || ') was updated.');
END;
/

UPDATE album SET TITLE = 'An album was updated!' WHERE albumid = 1;

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER trig_customer_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('Customer ' || :OLD.firstname || ' ' || :OLD.lastname || ' is no longer with us :(');
END;
/

DELETE FROM customer WHERE customerid = 1;
-- NOTE: it is interesting that the trigger fires even though the deletion was unsuccessful (because foreign key
-- references still existed).

-- 7.0 JOINS
-- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME || ' ' || CUSTOMER.LASTNAME AS CUSTOMER_NAME, INVOICE.INVOICEID
FROM CUSTOMER
JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

-- 7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID AS CUSTOMERID, C.FIRSTNAME AS FIRSTNAME, C.LASTNAME AS LASTNAME, I.INVOICEID AS INVOICEID, I.TOTAL AS TOTAL
FROM CUSTOMER C
FULL OUTER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST, ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID -- This is really no different from a normal JOIN, just written differently.
ORDER BY ARTIST.NAME;

-- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT MANAGER.FIRSTNAME || ' ' || MANAGER.LASTNAME AS MANAGER,
       SUBORDINATE.FIRSTNAME || ' ' || SUBORDINATE.LASTNAME AS SUBORDINATE
FROM EMPLOYEE MANAGER
FULL OUTER JOIN EMPLOYEE SUBORDINATE
ON SUBORDINATE.REPORTSTO = MANAGER.EMPLOYEEID;

-- 7.6 Complicated Join assignment
-- Create an inner join between all tables in the chinook database.
-- An alternate version of this may be found in the HUGE-JOIN.sql file in this folder.
SELECT
    TRACK.NAME AS TRACK,
    ALBUM.TITLE AS ALBUM,
    ARTIST.NAME AS ARTIST,
    GENRE.NAME AS GENRE,
    MEDIATYPE.NAME AS MEDIATYPE,
    PLAYLISTTRACK.PLAYLISTID AS PLAYLIST_ID,
    PLAYLIST.NAME AS PLAYLIST,
    INVOICELINE.UNITPRICE AS TRACK_PRICE,
    CUSTOMER.FIRSTNAME AS CUSTOMER_NAME,
    INVOICE.INVOICEDATE AS INVOICEDATE,
    EMPLOYEE.FIRSTNAME AS SUPPORTREP_NAME
FROM TRACK
JOIN ALBUM ON TRACK.ALBUMID = ALBUM.ALBUMID
JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
JOIN GENRE ON TRACK.GENREID = GENRE.GENREID
JOIN MEDIATYPE ON TRACK.MEDIATYPEID = MEDIATYPE.MEDIATYPEID
JOIN PLAYLISTTRACK ON PLAYLISTTRACK.TRACKID = TRACK.TRACKID
JOIN PLAYLIST ON PLAYLIST.PLAYLISTID = PLAYLISTTRACK.PLAYLISTID
JOIN INVOICELINE ON INVOICELINE.TRACKID = TRACK.TRACKID
JOIN INVOICE ON INVOICE.INVOICEID = INVOICELINE.INVOICEID
JOIN CUSTOMER ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEEID = CUSTOMER.SUPPORTREPID;

-- 9.0 Administration
-- Create a .bak file for the Chinook database.
-- From what I can tell, you can go into the Tools menu of SQL Developer and use the "Database Export" feature to make
-- a "backup" script that you can run to set up the database (very similar to the initial Chinook setup script).