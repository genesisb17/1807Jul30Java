/*
  Sammy Eang Week 2 Assignment
*/


--2.0 SQL Queries
-- In this section you will be performing various queries against the Oracle Chinook database.

-- 2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT *
FROM employee;
-- Task – Select all records from the Employee table where last name is King.
SELECT *
FROM employee
WHERE lastname = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * 
FROM employee 
WHERE firstname = 'Andrew'
AND reportsto IS null;

-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM album
ORDER BY title DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname
FROM customer
ORDER BY city;

-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO genre (genreid, name)
VALUES ('50', 'Pop Rock');
INSERT INTO genre (genreid, name)
VALUES ('51', 'Alt Rock');
-- Task – Insert two new records into Employee table
INSERT INTO employee (employeeid, firstname, lastname)
VALUES ('90210', 'Johnny', 'Bravo');
INSERT INTO employee (employeeid, firstname, lastname)
VALUES ('90211', 'Shaggy', 'Rogers');
-- Task – Insert two new records into Customer table
INSERT INTO customer (customerid, firstname, lastname, email)
VALUES ('90212', 'Harry', 'Potter', 'hpotter@harvard.edu');

-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET lastname = 'Walter', firstname = 'Robert'
WHERE  lastname = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT *
FROM invoice
WHERE billingaddress like 'T%';

-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * 
FROM invoice
WHERE total BETWEEN 15 AND 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoice
DROP CONSTRAINT fk_invoicecustomerid;
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';


-- 3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time.
Create or replace function curDate
return date is currdate date;
begin
select sysdate into currdate from dual;
return currdate;
end;
/
select curdate from dual;
-- Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function media_length(mtid int)
return number is len number;
begin
SELECT length(name) into len from mediatype where mediatypeid = mtid;
return len; 
end;
/
select media_length(1) from dual;


-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
create or replace function totalave
return number is average number;
begin
select avg(total) into average from invoice;
return average;
end;
/
select totalave from dual;
-- Task – Create a function that returns the most expensive track
create or replace function most
return number is mostexp number;
begin
select max(unitprice) into mostexp from track;
return mostexp;
end;
/
select most from dual;

--3.3 User Defined Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function aveinvoice
return number is ave number;
begin
select avg(unitprice) into ave from invoiceline;
return ave;
end;
/
select aveinvoice from dual;
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
create or replace function oldemployees
return sys_refcursor as c1 sys_refcursor;
  begin
  open c1
  for
  select firstname, lastname from employee where birthdate > '31-DEC-67';
return c1;
end;
/
select oldemployees from dual;


--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE or replace PROCEDURE get_employee_name
is 
emp_temp employee.firstname%type;
cursor c1
is
  select CONCAT(CONCAT(firstname, ' '), lastname) from employee;
begin
open c1;
  loop
    fetch c1 into emp_temp;
    exit when c1%notfound;
    dbms_output.put_line(emp_temp);
  end loop;
close c1;
end;
/
execute get_employee_name;

-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE or replace PROCEDURE update_employee
is
begin
  update employee set lastname = firstname
  where employeeid = 2;
end;
/

execute update_employee;
-- Task – Create a stored procedure that returns the managers of an employee.
CREATE or replace PROCEDURE get_manager(empid number)
is 
  emp_temp employee.firstname%type;
cursor c1
is
  select concat(concat(manager.firstname, ' '), manager.lastname) 
  from employee underling
  inner join employee manager
  on underling.reportsto = manager.employeeid
  where underling.employeeid = empid;
begin
open c1;  
  loop
    fetch c1 into emp_temp;
    exit when c1%notfound;
    dbms_output.put_line(emp_temp);
  end loop;
close c1;
end;
/

execute get_manager(1);
-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE or replace PROCEDURE get_customer_deets
is 
cust_temp customer.firstname%type;
cust_temp2 customer.company%type;
cursor c1
is
  select concat(concat(firstname, ' '), lastname) from customer;
cursor c2
is
  select company from customer;
begin
open c1;  
open c2;
  loop
    fetch c1 into cust_temp;
    fetch c2 into cust_temp2;
    exit when c1%notfound;
    dbms_output.put_line('Name: ' || cust_temp || ' Company: ' || cust_temp2);
  end loop;
close c1;
close c2;
end;
/
execute get_customer_deets;

--5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored
-- procedure.
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
-- rely on this, find out how to resolve them).
ALTER TABLE invoice
DROP CONSTRAINT fk_invoicecustomerid;
create or replace procedure deliid(iid number)
is
begin
  DELETE FROM invoice where invoiceid = iid;
  commit;
end;
/

execute deliid(1);
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
-- table
create or replace procedure insertrec(cid number, fn string, ln string, mail string)
is
begin
  insert into customer(customerid, firstname, lastname, email)
  values (cid, fn, ln, mail);
  commit;
end;
/

execute insertrec(1, 'hi', 'hello', 'hihello@aol.com');
-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER trig1
after insert on employee
for each row
begin
  commit;
end;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER trig2
after insert on album
for each row
begin
  commit;
end;


-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER trig3
after delete on customer
for each row
begin
  commit;
end;


-- 7.0 JOINS
-- In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;

-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM artist
RIGHT JOIN album
ON artist.artistid = album.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT artist.name, album.title
FROM artist
CROSS JOIN album
ORDER BY artist.NAME;

-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.firstname as Employee_FN, a.lastname as Employee_LN, b.firstname as Manager_FN, b.lastname as Manager_LS
FROM employee a, employee b
WHERE  a.reportsto = b.employeeid;

-- 7.6 Complicated Join assignment
-- Create an inner join between all tables in the chinook database.
select employee.firstname as Emp_FN, employee.lastname as Emp_LN, customer.firstname as Cus_FN, 
customer.lastname as Cus_LN, invoice.invoiceid, invoiceline.invoicelineid, track.name as track_name, 
mediatype.name as media_type, artist.name as artist, album.title as album, genre.name as genre, 
playlist.name as playlist
from employee
  inner join customer
  on employee.employeeid = customer.supportrepid
  inner join invoice
  on invoice.customerid = customer.customerid
  inner join invoiceline 
  on invoice.invoiceid = invoiceline.invoiceid
  inner join track
    inner join mediatype
    on track.mediatypeid = track.mediatypeid
    inner join album
      join artist
      on album.artistid = artist.artistid
    on album.albumid = track.albumid
    inner join genre
    on genre.genreid = track.genreid
    inner join playlisttrack
      inner join playlist
      on playlist.playlistid = playlisttrack.playlistid
    on playlisttrack.trackid = track.trackid
  on invoiceline.trackid = track.trackid;
