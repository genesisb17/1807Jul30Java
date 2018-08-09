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
--customerid firstname lastname company address city state country postalcode phone fax email supportrepid 
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


