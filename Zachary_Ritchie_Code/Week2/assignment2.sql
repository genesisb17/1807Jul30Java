/* 
Zachary Ritchie Week 2 Assignment
*/

-- JOIN All 11 Tables in chinook DB 
-- select one column from each column table
select album.artistid, artist.artistid, track.albumid, 
playlisttrack.trackid, playlist.playlistid, mediatype.mediatypeid,
genre.genreid, invoiceline.trackid, invoice.invoiceid,
customer.customerid, employee.city
from album
join artist on album.artistid = artist.artistid
join track on album.albumid = track.albumid
join playlisttrack on track.trackid = playlisttrack.trackid
join playlist on playlisttrack.playlistid = playlist.playlistid
join mediatype on track.mediatypeid =  mediatype.mediatypeid
join genre on track.genreid = genre.genreid
join invoiceline on track.trackid = invoiceline.trackid
join invoice on invoiceline.invoiceid = invoice.invoiceid
join customer on invoice.customerid = customer.customerid
join employee on customer.city = employee.city;




/* 2.1 SELECT*/
select * from employee;

select * from employee where lastname = 'King';

select * from Employee where firstname =  'Andrew' and reportsto IS null;


/*2.2 ORDER BY*/
select a.title as album
from album a
order by a.title DESC;

select c.firstname as customer 
from customer c
order by city asc;


/*2.3 INSERT INTO*/
select * from genre;
insert into genre (genreid, name)
values(26, 'Funny TV Bits');

select * from genre;
insert into genre (genreid, name)
values(27, 'Other Stuff');

select * from employee;
insert into employee (employeeid, firstname, lastname)
values(9, 'John', 'Smith');

select * from employee;
insert into employee (employeeid, firstname, lastname)
values(10, 'Jane', 'Dosomething');

select * from customer;
insert into customer (customerid, firstname, lastname, email)
values(60, 'Jane', 'Dosomething', 'email@email.com');

select * from customer;
insert into customer (customerid, firstname, lastname, email)
values(61, 'John', 'Smith', 'email@email.com');

/* 2.4 UPDATE */
select * from customer;
update customer
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

select * from artist;
update artist
set name = 'Creedence Clearwater Revival'
where artistid = 76;

/* 2.5 LIKE */
select * from invoice;
select * from invoice where billingaddress like 'T%';

/* 2.6 BETWEEN */
select * from invoice where total 
between 15 and 50;

select * from employee;
select * from employee where hiredate 
between '01-JUN-03' and '01-MAR-04';

/* 2.7 DELETE */
select * from customer;
alter table invoice
drop constraint fk_invoicecustomerid;
delete from customer 
where firstname = 'Robert' and lastname = 'Walter';

/*3.1 System define fucntions*/
/*select Current_Timestamp;*/

/*3.2 System define aggregate functions*/
select avg(total) from invoice;
select max(unitprice) from track;

/*3.3 User define functions*/
select avg(unitprice) from invoiceline;

/*3.4 User define table valued functions*/
/*create or replace function get_all_birthdates(cursorParam out sys_refcursor)
is 
begin
open cursorParam for select * from employee where brithday > 01-JAN-1968;
end;*/


/*4.1 Basic stored procedures*/
create or replace procedure get_employee(cursorr out sys_refcursor)
as
begin
open cursorr
for select firstname, lastname
from employee;
end;
/
variable rc refcursor;
execute get_employee(:rc);
print rc;
/*4.2 Store procedure input parameters*/
create or replace procedure update_employee(
zemployeeid number,
Zlastname varchar2,
Zfirstname varchar2,
Ztitle varchar2, 
Zreportsto number,
Zbirthdate date,
Zhiredate date,
Zaddress varchar2,
Zcity varchar2,
Zstate varchar2,
Zcountry varchar2,
Zpostalcode varchar2,
Zphone varchar2,
Zfax varchar2,
Zemail varchar2) 
as
begin
  update employee set
  employeeid = Zemployeeid,
  lastname = zlastname,
  firstname = zfirstname,
  title = ztitle,
  reportsto = zreportsto,
  birthdate = zbirthdate,
  hiredate = zhiredate,
  address = zaddress,
  city = zcity,
  state = zstate,
  country = zcountry,
  postalcode = zpostalcode,
  phone = zphone,
  fax = zfax,
  email = zemail
  where Zemployeeid = employeeid;
end;
/

create or replace procedure get_company(zemployeeid number, 
cursorr out sys_refcursor)
as
begin
open cursorr for 
select employeeid from employee where employeeid = (
select firstname from employee where employeeid = zemployeeid); 
end;
/

/*4.3 Store procedure output parameters*/
create or replace procedure get_manager(
zcustomerid number,
cursorr out sys_refcursor)
as
begin
open cursorr for
select firstname, company from customer 
where customerid = zcustomerid;
end;
/

/*5.0 transactions*/
create or replace procedure remove_invoice(
Zinvoiceid number)
as
begin
delete from invoice where invoiceid = Zinvoiceid;
end;
/


/*6.1 After/for*/
CREATE OR REPLACE TRIGGER c_trig
after insert on employee
for each row 
begin 
   DBMS_output.put_line('Employee inserted');
end;
/

CREATE OR REPLACE TRIGGER u_trig
after update on album
for each row 
begin 
   DBMS_output.put_line('Album updated');
end;
/


CREATE OR REPLACE TRIGGER u_trig
after delete on customer
for each row 
begin 
   DBMS_output.put_line('customer deleted');
end;
/
/* 7.1 Joins */ 
select customer.customerid, invoice.customerid, 
customer.firstname, customer.lastname
from customer 
inner join invoice
on customer.customerid = invoice.customerid;


/* 7.2 OUTER */
select customer.customerid, invoice.customerid, 
customer.firstname, customer.lastname
from customer
full outer join invoice
on customer.customerid = invoice.customerid;


/* 7.3 RIGHT */
select album.artistid, artist.artistid, album.title, artist.name
from album 
right join artist
on album.artistid = artist.artistid;


/* 7.4 CROSS */
select album.title, artist.name
from album
cross join artist
order by artist.name asc;


/* 7.5 SELF */
select employee1.reportsto, employee2.reportsto,
employee1.firstname, employee1.lastname,
employee2.firstname, employee2.lastname
from employee employee1, employee employee2
where employee1.reportsto = employee2.reportsto;




