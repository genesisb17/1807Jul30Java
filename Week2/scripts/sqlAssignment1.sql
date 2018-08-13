-----2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;


/*2.2----------------------------------------
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/

Select album.title as "Titles of albums" from album
group by title
order by title asc;

select customer.firstname,customer.city from customer
--group by city
order by city asc;
/*2.3----------------------------------------
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/

/-- inserting the genres
select*from genre;
insert into Genre(Genreid,name) values(26,'DVA');
insert into Genre(Genreid,name) values(27,'MikesG');
/-- Adding in the Employees
select * from employee;
Insert into Employee(EmployeeID,LastName,firstname,title,reportsto,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
values(9,'Pollard','Pollock','IT Staff',1,'18-FEB-81','12-MAR-05','110 pligh Ave','Miami','FL','US','29803','+1(843) 444-5558','+1 (675) 333-1111','jhap@gmail.com');

Insert into Employee(EmployeeID,LastName,firstname,title,reportsto,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
values(10,'Davis','Mike','IT Staff',1,'18-FEB-87','12-JAN-06','1900 cesec Drive','columbia','SC','US','29115','+1(803) 464-4458','+1 (690) 311-1981','davisap@gmail.com');
/-- adding in the new custoemrs
select*from customer;
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
VALUES (60, 'Lonnie', 'Walker', '1234 Pile Dr.', 'Sacremento', 'US', '90240', '+1 (744) 984-2422', 'walktall@gmail.com', 5);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
VALUES (61, 'Angel', 'Metson', '134 Frosted Dr.', 'Phoenix', 'US', '23444', '+1 (702) 980-2422', 'metson@gmail.com', 5);

/--2.4 UPDATE Task – Update Aaron Mitchell in Customer table to Robert Walter 
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 

select*from customer where firstname='robert';
update customer set Firstname='Robert',Lastname='Walter' where customerid=32;

select*from artist;
update artist set name='CCR' where artistid=76;
/-- 2.5 Like select all invoices with a billing address like 

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
/--2.6 BETWEEN STATEMENTS
SELECT * FROM invoice WHERE TOTAL BETWEEN 15 AND 50;

SELECT*FROM Employee WHERE Hiredate BETWEEN '01-MAR-03' AND '01-MAR-04';

/--2.7 DELETE(will come back)
select*from customer;
DELETE FROM Invoice WHERE customerid = 32;
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


/--3.1 time function
CREATE OR REPLACE FUNCTION my_time RETURN VARCHAR2 AS
BEGIN
    RETURN TO_CHAR(LOCALTIMESTAMP, 'HH24:MI:SS');
END;
SELECT my_time FROM dual;

/--3.2 Aggregate functions
create or replace function invoice_avgs RETURN NUMBER AS  total_av NUMBER(10, 2);
BEGIN select AVG(total) INTO total_av FROM invoice;
    RETURN total_av;
END;
select invoice_avgs from dual;
--most expensive track
--Select max(UNITPRICE) from TRACK;
create or replace function expensiveaf_track RETURN NUMBER AS 
t_id NUMBER(10); highest_P NUMBER(10, 2);
BEGIN
    SELECT MAX(unitprice) INTO highest_P FROM track;
    SELECT trackid INTO t_id FROM track WHERE unitprice = highest_P AND ROWNUM = 1; 
    RETURN t_id;
END;
--returns to many results
SELECT * FROM track WHERE trackid = expensiveaf_track;




/--3.3

create or replace function avginv_price RETURN NUMBER AS output NUMBER(3,2);
BEGIN
select AVG(UNITPRICE) into output FROM invoiceline;
END;



-- SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
-- 3.4(Not working )
--create or replace function employee_sixEight RETURN NUMBER as 
--holder Number;

 --SELECT employeeid FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68' into Number ;
   -- Select employeeid from Employee where BIRTHDATE > '31-DEC-68' into holder;
  --  RETURN holder;
--END;

-- 4.1
--CREATE PROCEDURE FandL_names(out(fname varchar2(20)))
  --lname(String)
  --RETURNS
  --Select  FIRSTNAME, LASTNAME FROM EMPLOYEE
  --GO;
  --4.2
  --4.3
       
       
--6 Triggers

--6.1 the triggers for adding updataing and deleting
commit;
CREATE OR REPLACE TRIGGER employee_trigger
AFTER INSERT ON employee FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('Sucess!');
END;
--INSERT INTO employee(employeeid, lastname, firstname) VALUES(999, 'pj', 'arole');

CREATE OR REPLACE TRIGGER album_trigger
AFTER Update ON employee FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('new album added');
END;

CREATE OR REPLACE TRIGGER custDelete_trigger
AFTER Delete ON customer FOR EACH ROW
BEGIN
    DBMS_OUTPUT.put_line('Customer succesfully deleted');
END;
--7.0 Joins inner outer and right

--7.1 inner join

SELECT customer.firstname, customer.lastname AS Customer, invoice.invoiceid FROM customer
JOIN invoice ON invoice.customerid = customer.customerid;

--7.2 outer join
SELECT CustomerA.CUSTOMERID AS CUSID,
CustomerA.FIRSTNAME AS Fname, 
CustomerA.LASTNAME AS Lname, 
Inv.INVOICEID AS InvoiceID, 
Inv.TOTAL AS Total
FROM CUSTOMER CustomerA
FULL OUTER JOIN INVOICE Inv
ON customera.customerid = inv.customerid;

--7.3 Right join
SELECT artist.NAME, album.TITLE FROM album
RIGHT JOIN ARTIST ON album.ARTISTID = artist.ARTISTID;

--7.4

SELECT artist.NAME, album.TITLE FROM artist, album
WHERE artist.ARTISTID = album.ARTISTID
ORDER BY artist.NAME ASC;

--7.5

SELECT manager.FIRSTNAME as ManagerFirstName,manager.LASTNAME AS ManagerLastName, worker.FIRSTNAME AS WORKER
FROM EMPLOYEE MANAGER
FULL OUTER JOIN employee worker ON worker.REPORTSTO = manager.EMPLOYEEID;


--7.6
SELECT
    track.NAME AS "Track Title",invoiceline.UNITPRICE AS TRACK_PRICE, artist.NAME AS "Creating ARTIST",album.TITLE AS "Originating Album",genre.NAME AS GENRE,
    playlist.NAME AS PLAYLIST,playlisttrack.PLAYLISTID AS PLAYLIST_ID,customer.FIRSTNAME AS CUSTOMER_NAME, invoice.INVOICEDATE AS "Invoice Date",employee.FIRSTNAME AS "Support Rep", mediatype.NAME AS FileFormat
FROM track JOIN album ON track.ALBUMID = album.ALBUMID
JOIN artist ON album.ARTISTID = artist.ARTISTID
JOIN mediatype ON track.MEDIATYPEID = mediatype.MEDIATYPEID
JOIN genre ON track.GENREID = genre.GENREID
JOIN invoice ON invoice.INVOICEID = invoice.INVOICEID
JOIN playlisttrack ON playlisttrack.TRACKID = track.TRACKID
JOIN playlist ON playlist.PLAYLISTID = playlisttrack.PLAYLISTID
JOIN invoiceline ON invoiceline.TRACKID = track.TRACKID
JOIN customer ON customer.CUSTOMERID = invoice.CUSTOMERID
JOIN employee ON employee.EMPLOYEEID = customer.SUPPORTREPID;


--9.0 making a backup file
BACKUP DATABASE MyDatabase TO DISK='E:\MyDatabase.bak'
commit;