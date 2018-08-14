/*
Molly Merritt Week 2 Assignment
*/



--------------------------------------------------------------------
----------------- 2.0 SQL Queries ----------------------------------
--------------------------------------------------------------------

----------------- 2.1 SELECT
-- Select all records from the Employee table.
SELECT* from Employee;

-- Select all records from the Employee table where the last name is King.
SELECT * from Employee where lastname = 'King';

-- Select all records from the Employee table where first name is Andrew
SELECT * from Employee where firstname = 'Andrew' AND resportsto IS null;


----------------- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title
select title from Album order by title asc;

-- Select first name from Customer and sort result set in ascending order by city
select firstname from customer order by city asc;


----------------- 2.3 INSERT INTO
-- Insert two new records into Genre table
insert into genre (genreid,name) values(26,'Screamo');
insert into genre (genreid,name) values(27,'Vocaloid');

-- Insert two new records into Employee table
insert into employee (employeeid, lastname, firstname, title, reportsto,
  birthdate, hiredate, address, city, state, country, postalcode, phone,
  fax, email)
  values (9, 'Merritt', 'Molly', 'IT Staff', 8, '04-APR-96', '30-JUL-18',
  '11730 Plaza American Dr Suite 205', 'Reston', 'VA', 'USA', 'T1H 1Y9',
  '+1 (919) 376-6068', '+1 (919) 376-6068', 'merritt.mry@gmail.com');
insert into employee (employeeid, lastname, firstname, title, reportsto,
  birthdate, hiredate, address, city, state, country, postalcode, phone,
  fax, email)
  values (10, 'Sherman', 'P.', 'Diver', 9, '01-JAN-90', '10-AUG-18',
  '42 Wallaby Way', 'Sydney', 'NSW', 'Australia', 'T1H 1Y6',
  '+1 (555) 555-5555', '+1 (777) 777-7777', 'findme@nemo.com');

-- Insert two new records into Customer table
insert into customer (customerid, firstname, lastname, company, address,
  city, state, country, postalcode, phone, fax, email, supportrepid)
  values (60, 'Molly', 'Merritt', 'multicult.fm', 'Marheinekepl. 15',
  'Berlin', '', 'Germany', 10961, '+49 30 50566536', '+49 30 50566536',
  'merritt@multicult.fm', '4');
insert into customer (customerid, firstname, lastname, company, address,
  city, state, country, postalcode, phone, fax, email, supportrepid)
  values (61, 'Mickey', 'Mouse', 'Disney', 'Disney World', 'Orlando', 'FL',
  'USA', 10000, '+1 (919) 555-5555', '+1 (919) 555-5555',
  'mickeymouse@disney.com', '5');


----------------- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter
update customer set firstname = 'Robert' where firstname = 'Aaron';
update customer set lastname = 'Walter' where lastname = 'Mitchell';

-- Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';


----------------- 2.5 LIKE
-- Select all invoices with a billing address like "T%"
select * from invoice where billingaddress like 'T%';


----------------- 2.6 BETWEEN
-- Select all invoices that have a total between 15 and 30
select * from invoice where total between 15 and 30;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';


----------------- 2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter
delete from invoiceline where invoiceid IN (select invoiceid from invoice 
  where customerid = (select customerid from customer 
  where firstname = 'Robert' and lastname = 'Walter'));
  
delete from invoice where customerid = (select customerid from customer 
  where firstname = 'Robert' and lastname = 'Walter');

delete from customer where firstname = 'Robert' and lastname = 'Walter';



--------------------------------------------------------------------
----------------- 3.0 SQL Functions --------------------------------
--------------------------------------------------------------------


----------------- 3.1 System Defined Functions
-- Create a function that returns the current time
create or replace function get_current_time
  return time
  is currTime time;
BEGIN
  currTime := CURTIME();
  return currTime;
END;
/

-- Create a fucntion that returns the length of a mediatype from the mediatype table
create or replace function get_mediatype_length
  return mediatypeLength
  is mediatypeLength number;
BEGIN
  mediatypeLength := select LENGTH(name) from mediatype where mediatypeid = 1;
  return mediatypeLength;
END;
/
select * from mediatype;

----------------- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices
create or replace function get_avg_total_invoices
  return avgTotalInvoices
  is avgTotalInvoices number;
BEGIN
  select avg(total) into avgTotalInvoices from invoices;
  return avgTotalInvoices;
END;
/
select * from track;

-- Create a function that returns the most expensive track
create or replace function get_most_expensive_track
  return mostExpensiveTrackPrice
  is mostExpensiveTrackPrice number;
BEGIN
  select max(unitprice) into mostExpensiveTrackPrice from track;
  return mostExpensiveTrackPrice;
END;
/


----------------- 3.3 User Defined Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function get_avg_invoice_price
  return avgInvoicePrice
  is avgInvoicePrice number;
BEGIN
  select avg(total) into avgInvoicePrice from invoice;
  return avgInvoicePrice;
END;
/


----------------- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968
create or replace function get_employees_after_1968
  return employeesAfter1968
  is employeesAfter1968 number;
BEGIN
  select * into employeesAfter1968 from employee where birthdate > '01-JAN-1968'
  return employeesAfter1968;
END;
/



--------------------------------------------------------------------
----------------- 4.0 Stored Procedures ----------------------------
--------------------------------------------------------------------


----------------- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees
CREATE PROCEDURE getEmployeeNames
AS
  select firstname, lastname from employee;
GO;
/
EXEC getEmployeeNames;


----------------- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee
CREATE PROCEDURE updateEmployeeInfo
  @eEmployeeID number
  @eBirthdate date
  @eAddress varchar2(70)
  @eCity varchar2(40)
  @eState varchar2(40)
  @eCountry varchar2(40)
  @ePostalcode varchar2(10)
  @ePhone varchar2(24)
  @eEmail varchar2(60)
AS
  update employee set birthdate = eBirthdate;
  update employee set address = eAddress;
  update employee set city = eCity;
  update employee set state = eState;
  update employee set country = eCountry;
  update employee set postalcode = ePostalcode;
  update employee set phone = ePhone;
  update employee set email = eEmail;
GO;
/


-- Create a stored procedure that returns the managers of an employee
CREATE PROCEDURE getManagers
  @eEmployeeID number
AS
  select reportsto from employee where (employeeid = eEmployeeID);
GO;
/


----------------- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer
CREATE PROCEDURE customerNameCompany
  @customerid number
  @customerFirstName varchar2(40)
  @customerLastName varchar2(20)
  @customerCompany varchar2(80)
AS
  select customerFirstName = firstname, customerLastName = lastname, customerCompany = company
  from customer
  where customerid = @customerid
GO;
/
select * from customer;


--------------------------------------------------------------------
----------------- 5.0 Transactions ---------------------------------
--------------------------------------------------------------------

-- Create a transaction that given an invoiceid will delete that invoice
BEGIN TRANSACTION
  BEGIN TRY
    delete from invoice where invoiceid = 
    COMMIT TRANSACTION
  END TRY
  BEGIN CATCH
    ROLLBACK TRANSACTION
  END CATCH
GO;
/

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE PROCEDURE insertNewCustomer
  @CustomerId NUMBER NOT NULL,
  @FirstName VARCHAR2(40) NOT NULL,
  @LastName VARCHAR2(20) NOT NULL,
  @Company VARCHAR2(80),
  @Address VARCHAR2(70),
  @City VARCHAR2(40),
  @State VARCHAR2(40),
  @Country VARCHAR2(40),
  @PostalCode VARCHAR2(10),
  @Phone VARCHAR2(24),
  @Fax VARCHAR2(24),
  @Email VARCHAR2(60) NOT NULL,
  @SupportRepId NUMBER,
AS
  BEGIN TRANSACTION
    BEGIN TRY
      update customer set customerid = @customerid;
      update customer set firstname = @firstname;
      update customer set lastname = @lastname;
      update customer set company = @company;
      update customer set address = @address;
      update customer set city = @city;
      update customer set state = @state;
      update customer set country = @country;
      update customer set postalcode = @postalcode;
      update customer set phone = @phone;
      update customer set fax = @fax;
      update customer set email = @email;
      update customer set supportrepid = @supportrepid;
      COMMIT TRANSACTION
    END TRY
    BEGIN CATCH
      ROLLBACK TRANSACTION
    END CATCH
GO;
/



--------------------------------------------------------------------
----------------- 6.0 Triggers -------------------------------------
--------------------------------------------------------------------


----------------- 6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table
create trigger Trigger1
on employee
after insert
as
begin
  print "New record added to EMPLOYEE";
end
go;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table
create trigger Trigger2
on album
after update
as
begin
  print "Record updated in ALBUM";
end
go;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table
create trigger Trigger3
on customer
after delete
as
begin
  print "Record deleted from CUSTOMER";
end
go;
/



--------------------------------------------------------------------
----------------- 7.0 JOINS ----------------------------------------
--------------------------------------------------------------------


----------------- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceid
select c.firstname, c.lastname, i.invoiceid
from customer c
join invoice i
on c.customerid = i.customerid;


----------------- 7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomeriId, firstname, lastname, invoiceid, & total
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c
left outer join invoice i
on c.customerid = i.customerid;


----------------- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title
select a.name, t.title
from artist a
right join track t
on a.name = select name from a where artistid =
  (select artistid from album where albumid =
  (select albumid from t where title = t.title));
select * from album;



----------------- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order
select *
from album al, artist ar
order by ar.name ASC;


----------------- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column
select * from employee e1
join employee e2
on e1.reportsto = e2.reportsto;


----------------- 7.6 Complicated Join Assignment
-- Create an inner join between all tables in the chinook database




--------------------------------------------------------------------
----------------- 9.0 Administration -------------------------------
--------------------------------------------------------------------

-- Create a .bak file for the Chinook database