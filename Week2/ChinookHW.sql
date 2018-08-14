--vi2.1
--select all records from employee table
select * from employee;

--select all records from empl table where last name is king
select * from employee where lastname = 'King';

--select all records from the employee table where fn is Andrew and reporsto Null
select * from employee where firstname = 'Andrew' and reportsto is null;

--2.2
--select all albums in album table and sort result set in desc order by title
SELECT * FROM album order by title desc;

-- select fn from customer and sort result set in asc order by city
select firstname, city from customer order by city;

--2.3
--insert two new records into genre table
insert into genre (genreid, name) values(26,'Bachata');
insert into genre (genreid, name) values(27,'Ranchera');

--insert two new records into employee table
insert into employee (employeeid,lastname,firstname,title,reportsto) 
values(9, 'Doe', 'John', 'IT Staff', 6);
insert into employee (employeeid,lastname,firstname,title,reportsto) 
values(10, 'Doe', 'Jane', 'Sales Support Agent', 2);

--insert two new records into customer table
--customerid firstname lastname company address city state country postalcode 
--phone fax email supportrepid 
insert into customer (customerid,firstname,lastname,company,country,email) 
values(60, 'John', 'Doe', 'Revature', 'USA','john@doe.com');
insert into customer (customerid,firstname,lastname,company,country,email) 
values(61, 'Jane', 'Doe', 'Revature', 'USA','jane@doe.com');

--2.4 order by
-- update aaron mitchell in customer table to robert walter
update customer set firstname='Robert', lastname = 'Walter' 
where firstname = 'Aaron' and lastname= 'Mitchell';

select * from customer where firstname= 'Robert';

--update name of artist in the artist table "creedence clearwater revival
--to "ccr"
update artist set name='CCR' where name = 'Creedence Clearwater Revival';

--2.5 like
--select all invoices with a billing address like "T%"
select * from invoice where billingaddress like 'T%';

--2.6 between
--select all invoices that have a total b/w 15 and 50
select * from invoice where total between 15 and 50;

--select all empl hired b/w 1st of june 2003 and 1st march 2004
select * from employee where hiredate between '01-JUN-03' and  '01-MAR-04';

--2.7 delete
--delete a record in customer table where name is Robert Walter (There may
-- be constraines that rely on this, find out how to resolve them)
alter table invoice drop constraint fk_invoicecustomerid;
delete from customer where firstname = 'Robert' and lastname = 'Walter';

rollback;

--7.0 JOINS
--7.1 INNER
--create inner join that joins customers and orders and specifies the name
--of the customer and the invoiceid
select customer.firstname, customer.lastname, invoice.invoiceid 
from customer
inner join invoice
on customer.customerid = invoice.CUSTOMERID;

--7.2
--create an outer join that joins the customer and invoice table, specifying
--the customerid, firstname, lastname, invoiceid, and total
select customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
left join invoice
on customer.customerid = invoice.CUSTOMERID;

--7.3
--create a right join that joins album and artist specifying artist name and
--title
select artist.NAME, album.TITLE
from album
right join artist
on artist.ARTISTID = album.ARTISTID;

--7.4
--Cross
--create a cross join that joins album and artist and sorts by artist name in asc
select artist.NAME, album.TITLE
from album, artist order by artist.name asc;

--7.5 self
--perform a self-join on the employee table, joining on the reportsto column
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1
inner join employee e2
on e1.employeeid = e2.reportsto;

--7.6 complicated join assignment
--create an inner join between all tables in the chinook database
select count(*)
from employee
inner join customer
on employee.EMPLOYEEID = customer.SUPPORTREPID
inner join invoice
on customer.customerid = invoice.CUSTOMERID
inner join invoiceline
on invoice.invoiceid = invoiceline.invoiceid
inner join track
on track.trackid = invoiceline.trackid
inner join MEDIATYPE
on TRACK.MEDIATYPEID = mediatype.mediatypeid
inner join genre
on genre.genreid = track.GENREID
inner join album
on album.ALBUMID = track.ALBUMID
inner join playlisttrack
on playlisttrack.TRACKID = track.trackid
inner join playlist
on playlist.PLAYLISTID = playlisttrack.PLAYLISTID
inner join artist
on artist.ARTISTID = album.ARTISTID;

--3.1 System defined functions
--create a function that returns the current time
create or replace function current_time_func
return time
is thyme time;
begin
SELECT current_time() into thyme from dual;
return thyme;
end;
/

--create a function that returns the length of a mediatype from the
--mediatype table
create or replace function length_mediatype(type_id number, mt_name varchar2)
return number is len_mediatype number(10);

begin
select length(mt_name) into len_mediatype from dual;
end;
/

--3.2
--Create a function that returns the average total of all invoices
create or replace function avg_invoices
return number
is 
avg_inv number;

begin

select avg(total) into avg_inv from invoice;
return avg_inv;
end;
/
--create function tat returns most expensive track
create or replace function exponsive
return number
is 
max_track number;

begin
select MAX(unitprice) into max_track from invoiceline;
return max_track;
end;
/

--3.3
--create a function tat returns te average price of 
--invoiceline items in the invoiceline tab
create or replace function avg_price
return number
is 
avg_sale number;

begin

select avg(unitprice) into avg_sale from invoiceline;
return avg_sale;
end;
/

--3.4
--create a funciton that returns all employees who are born after ------------------------
--1968

create or replace function born(cursorParam out sys_refcursor)
return varchar2
is 
result2 varchar2;
begin

open cursorParam for select * into result2 from employee where birthdate > '31-DEC-1968';
end;
/


--4.1
--create a stored procedure that selects the first and last names
--of all the employees
create or replace procedure fName_lName
is 
--create a dummy table
employee_temp employee.FirstName%TYPE;
--create cursor
CURSOR emp_cursor
is
--bring first name with space and then add first name with space to last name
  select concat(concat(FirstName,' '), LastName) FROM employee;
begin  
open emp_cursor;
  LOOP
    fetch emp_cursor into employee_temp;
    exit when emp_cursor%notfound;
    dbms_output.put_line(employee_temp);
  end loop;
close emp_cursor;
end;
/
execute fname_lname;
--4.2
--create a stored procedure that updates the personal info of an
--employee
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE 
(
  THE_EMPLOYEEID IN NUMBER,
  NEW_LASTNAME IN VARCHAR2,
  NEW_FIRSTNAME IN VARCHAR2,
  NEW_TITLE IN VARCHAR2,
  NEW_REPORTSTO IN NUMBER,
  NEW_BIRTHDATE IN DATE,
  NEW_HIREDATE IN DATE,
  NEW_ADDRESS IN VARCHAR2,
  NEW_CITY IN VARCHAR2,
  NEW_STATE IN VARCHAR2,
  NEW_COUNTRY VARCHAR2,
  NEW_POSTALCODE VARCHAR2,
  NEW_PHONE VARCHAR2,
  NEW_FAX VARCHAR2,
  NEW_EMAIL VARCHAR2
)
AS 
BEGIN
  UPDATE EMPLOYEE
  SET LASTNAME = 
        CASE when NEW_LASTNAME is null
        THEN 
          LASTNAME
        ELSE NEW_LASTNAME
        END,
      FIRSTNAME =
        CASE when NEW_FIRSTNAME is null 
        THEN 
          FIRSTNAME
        ELSE NEW_FIRSTNAME
        END,
      TITLE = NEW_TITLE,
      REPORTSTO = NEW_REPORTSTO,
      BIRTHDATE = NEW_BIRTHDATE,
      HIREDATE = NEW_HIREDATE,
      ADDRESS = NEW_ADDRESS,
      CITY = NEW_CITY,
      STATE = NEW_STATE,
      COUNTRY = NEW_COUNTRY,
      POSTALCODE = NEW_POSTALCODE,
      PHONE = NEW_PHONE,
      FAX = NEW_FAX,
      EMAIL = NEW_EMAIL
    WHERE EMPLOYEEID = THE_EMPLOYEEID;
END UPDATE_EMPLOYEE;
/
--create a stored procedure that returns the managers of an
--employee
create or replace PROCEDURE MANAGER_OF_EMPLOYEE 
(
  THE_EMPLOYEEID IN NUMBER
)
AS 
  TEMP VARCHAR2(20);
  TEMP2 VARCHAR2(20);
  TEMP3 VARCHAR2(20);
  TEMP4 VARCHAR2(20);
BEGIN
  SELECT MGR.FIRSTNAME, MGR.LASTNAME, EMP.FIRSTNAME, EMP.LASTNAME INTO TEMP, TEMP2, TEMP3, TEMP4
  FROM EMPLOYEE EMP
  left outer JOIN EMPLOYEE MGR 
  ON mgr.EMPLOYEEID = emp.REPORTSTO
  WHERE EMP.EMPLOYEEID = THE_EMPLOYEEID;
  DBMS_OUTPUT.PUT_LINE(TEMP || ' ' || TEMP2 || ' IS THE MANAGER OF ' || TEMP3 || ' ' || TEMP4);
END MANAGER_OF_EMPLOYEE;
/
--4.3
--create a stored procedure that returns the name and company
--of a customer
create or replace PROCEDURE name_and_company 
(
  THE_EMPLOYEEID IN NUMBER
)
AS 
  TEMP VARCHAR2(20);
  TEMP2 VARCHAR2(20);
  TEMP3 VARCHAR2(20);
BEGIN
  SELECT EMP.FIRSTNAME, EMP.LASTNAME, emp.COMPANY INTO TEMP, TEMP2, TEMP3
  FROM Customer EMP;
  DBMS_OUTPUT.PUT_LINE(TEMP || ' ' || TEMP2 || ' works at ' || TEMP3);
END name_and_company;
/

--5.0
--create a transaction that given an invoiceid will delete that
--invoice (there may be constraints that rely on this, find out 
--how to resolve them)

DELETE FROM INVOICE WHERE INVOICEID ='invoiceid'; --needs an id 
COMMIT;

--create a transaction nested within a stored procedure that 
--inserts a new record in the customer table
create or replace function new_customer --may need a lot of work
return number
is 
num_inserted number;

begin

Insert into customer(firstname, lastname) values('Tiff','Mac');
commit;
return num_inserted;
end;
/

--6.1
--create an after insert trigger on the employee table fired after
--a new record is inserted into the table
CREATE OR REPLACE TRIGGER c_trig
after insert on employee
for each row 
begin 
   DBMS_output.put_line('Employee Added');
end;
/
--create an after update trigger on the album table that fires after
--a row is inserted in the table
create or replace trigger a_trig
after update on album
for each row
begin
  DBMS_output.put_line('Album Updated!');
end;
/

--create an after delete trigger on the customer table that fires after
--a row is deleted from the table.
create or replace trigger del_trig
after delete on customer
for each row
begin
  DBMS_output.put_line('Customer Deleted!');
end;
/

