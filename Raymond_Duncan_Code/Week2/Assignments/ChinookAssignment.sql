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
CREATE OR REPLACE PROCEDURE all_employees


-----------           4.2 Stored Procedure Input Parameters           -----------
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.

-----------           4.3 Stored Procedure Output Parameters           -----------
--Task – Create a stored procedure that returns the name and company of a customer.


/*************************************************************************
**                         5.0 SQL Transactions                         **
*************************************************************************/
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table


/*************************************************************************
**                         6.0 Triggers                         **
*************************************************************************/
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

-----------           6.1 AFTER/FOR           -----------
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into them table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.


/*************************************************************************
**                               7.0 JOINS                              **
*************************************************************************/
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

-----------           7.1 INNER           -----------
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

-----------           7.2 OUTER           -----------
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

-----------           7.3 RIGHT           -----------
--Task – Create a right join that joins album and artist specifying artist name and title.

-----------           7.4 CROSS           -----------
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

-----------           7.5 SELF           -----------
--Task – Perform a self-join on the employee table, joining on the reportsto column.

-----------           7.6 Complicated Join assignment           -----------
-- Create an inner join between all tables in the chinook database.



-----   DO NOT CONTINUE!!!

/*************************************************************************
**                          9.0 Administration                          **
*************************************************************************/
-- In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.

--Task – Create a .bak file for the Chinook database 