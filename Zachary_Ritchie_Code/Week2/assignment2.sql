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




