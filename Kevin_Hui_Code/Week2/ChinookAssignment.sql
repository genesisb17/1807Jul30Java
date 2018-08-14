--2.0 SQL Queries
--2.1 SELECT
--Task – Select all records from the Employee table.

SELECT * FROM EMPLOYEE;
/
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
/
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
/
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
/
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
/


--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME) VALUES(26,'Broadway Play');
/
INSERT INTO GENRE (GENREID, NAME) VALUES(27,'Anime');
/

--Task – Insert two new records into Employee table
INSERT INTO Employee
(EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES
(9,'Franklin','Dustin','Sales Support Agent','2',TO_DATE('1973-8-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-4-1 00:00:00','yyyy-mm-dd hh24:mi:ss'),'118-3052 Interdum Ave','Calgary','AB','Canada','E8B 6M3','(506) 721-1525','(506) 474-0742','dustin@chinookcorp.com');
/
INSERT INTO Employee
(EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES
(10,'Trevino','Porter','Sales Support Agent','2',TO_DATE('1973-8-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-4-1 00:00:00','yyyy-mm-dd hh24:mi:ss'),'P.O. Box 339, 4024 Posuere Rd.','Calgary','AB','Canada','X0X 1X4','(867) 125-2566','(867) 287-5697','porter@chinookcorp.com');
/
--Task – Insert two new records into Customer table

INSERT INTO customer
(customerid,firstname,lastname,address,city,state,country,postalcode,phone,fax,email,supportrepid)
VALUES
(60,'Delilah','Skinner','P.O. Box 298, 749 Nec St.','Auburn','ME','US','36264','(291) 707-6833','(494) 956-0612','aliquam@lectusum.ca',3);
/
INSERT INTO customer
(customerid,firstname,lastname,address,city,state,country,postalcode,phone,fax,email,supportrepid)
VALUES
(61,'Jacob','Bird','500-6287 Eu Rd.','Des Moines','IA','US','43366','(222) 739-2491','(650) 383-3861','facilisis.vitae@odiosempercursus.co.uk',2);
/

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
/
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
/
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('01-JUL-03', 'dd-MON-yy') AND TO_DATE('01-MAR-04', 'dd-MON-yy');
/

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'; -- This will not work now
/

--3.0 SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
    RETURN DATE IS curr_date DATE;
BEGIN
    SELECT SYSDATE INTO curr_date FROM DUAL;
    RETURN curr_date;
END;
/
SELECT CURRENT_TIME FROM DUAL;
/
--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatype_length (mtypeId NUMBER)
    RETURN NUMBER IS len_result NUMBER := 0;
BEGIN
    SELECT LENGTH(NAME) INTO len_result FROM MEDIATYPE WHERE MEDIATYPEID = mtypeId;
    RETURN len_result;
END;
/
SELECT mediatype_length(1) FROM DUAL; -- Uses media type ID to select.
/

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average_invoice
    RETURN NUMBER IS avg_result NUMBER := 0;
BEGIN
    SELECT AVG(TOTAL) INTO avg_result FROM INVOICE;
    RETURN avg_result;
END;
/
SELECT average_invoice FROM DUAL;
/
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive
    RETURN NUMBER IS max_result NUMBER := 0;
BEGIN
    SELECT MAX(UNITPRICE) INTO max_result FROM TRACK;
    RETURN max_result;
END;
/
SELECT most_expensive FROM DUAL;
/

--3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_invoiceline
    RETURN NUMBER IS avg_result NUMBER := 0;
BEGIN
    SELECT AVG(UNITPRICE) INTO avg_result FROM INVOICELINE;
    RETURN avg_result;
END;
/
SELECT average_invoiceline FROM DUAL;
/

    --3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
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

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE emp_full_name AS
BEGIN
    FOR i IN (SELECT FIRSTNAME || ' ' || LASTNAME AS FULLNAME FROM EMPLOYEE)
    LOOP
        DBMS_OUTPUT.PUT_LINE(i.FULLNAME);
    END LOOP;
END;
/
EXECUTE emp_full_name;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee (
    fname IN VARCHAR2(20 BYTE),
    lname IN VARCHAR2(20 BYTE),
    addr IN VARCHAR2(

--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER trig_employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('A new employee was inserted, named ' || :NEW.firstname || ' ' || :NEW.lastname);
END;
/
INSERT INTO employee(employeeid, lastname, firstname) VALUES(10000, 'Green', 'Dan');
/

--Task - Create an after update trigger on the album table that fires after a row is inserted in the table.
CREATE OR REPLACE TRIGGER trig_album_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('Album (ID ' || :NEW.albumid || ') was updated.');
END;
/
UPDATE album SET TITLE = 'Something Something new Album' WHERE albumid = 1;
/

--Task - Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER trig_customer_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('Customer ' || :OLD.firstname || ' ' || :OLD.lastname || ' removed.');
END;
/
DELETE FROM customer WHERE customerid = 1;
/

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME || ' ' || CUSTOMER.LASTNAME AS CUSTOMER_NAME, INVOICE.INVOICEID
FROM CUSTOMER
JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
/
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID AS CUSTOMERID, C.FIRSTNAME AS FIRSTNAME, C.LASTNAME AS LASTNAME, I.INVOICEID AS INVOICEID, I.TOTAL AS TOTAL
FROM CUSTOMER C
FULL OUTER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;
/
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;
/
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST, ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME;
/
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT MANAGER.FIRSTNAME || ' ' || MANAGER.LASTNAME AS MANAGER,
       SUBORDINATE.FIRSTNAME || ' ' || SUBORDINATE.LASTNAME AS SUBORDINATE
FROM EMPLOYEE MANAGER
FULL OUTER JOIN EMPLOYEE SUBORDINATE
ON SUBORDINATE.REPORTSTO = MANAGER.EMPLOYEEID;
/
--7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.
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







