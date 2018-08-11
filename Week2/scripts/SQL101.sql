-- This is a single line comment

/*
This is a multiline comment
*/

-- The syntax for queries is SELECT [column] FROM [table] WHERE [condition]
select * from artist; -- Can be all caps. is case insensitive

select * from artist where name like 'A%e'; -- You can use the % as a filler for text that isn't there. I.e.
--A% selects anything that begins with A and A%e select anything that begins with A and ends with e

-- Highlighting certain portions of code can let you run just that code

select * from artist where name like 'A_a%';
--This just makes it so the first and third letter has to be a but the second letter can be anything, then you have the % selector afterwards

select * from artist where upper(name) like 'A%M%%';
-- Selects anything that has an A and an M, regardless of case

/* System designed functions
Scalaar Functions - functions that operate on single values - i.e. upper, lower
Aggregate Values 0 functions that opereate on multiple rows of data - i.e. max, count
*/

select * from artist where lower(name) like 'A%M%';
select * from artist where length(name) < 15;

select count(name) from artist;
select max(milliseconds) from track;
select avg(total) from invoice;

/* Nested Queries
Queries inside of queries, aka subqueries.
Used for various types of dynamic queries.
-- IN
*/

--finds albums of all artists whose name starts with F
select * from album where artistid in (
select artistid from artist where name like 'F%');

--Find foo fighters albums
select * from album where artistid = (
select artistid from artist where name = 'Foo Fighters');

-- select number of people per company in custmer table and alphabetize
select count(customerid), company 
from customer 
group by company
order by company ASC;

/*
SET OPERATIONS - used to combine result sets and see overlap of data
--> must have the same # and type of columns
UNION - results are all unique rows from both queries. A + B - AB
UNION ALL - returns rows from both queries, even if there are repeats. A + B
INTERSECT - only gives you where the sets overlap for both queries AB
MINUS - everything from first set minus everything in both sets. A - AB
*/

select * from customer where firstname like 'L%';
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' UNION
select * from customer where country = 'Brazil';


/* JOINS

*/

-- INNER JOIN
select t.name as track_name, album.title
from track t
join album
on t.ALBUMID = album.albumid;


-- SELF JOIN
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1
inner join employee e2
on e1.employeeid = e2.reportsto;

--CROSS JOIN - cartesian product of two tables
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1, employee e2;

-- Natural join - where Oracle attempts to match documents based on name
select album.title, artist.name
from album
inner join artist
on album.artistid = artist.artistid;

select * from artist natural join album;

select * from genre;


select enreid, count(trackid)
from track
group by genreid;

--grouping and counting by genre
select genre.name as GENRE, count(track.name) as TRACKS
from track
join genre
on track.GENREID = genre.GENREID
group by genre.name
order by genre.name;

--Views - virtual tables
--essentially saved queries. cannot update table via views
create view Al_Art_View as
  select album.albumid as album, artist.artistid as artist, artist.name
  from album
  join artist
  on album.artistid = artist.artistid;
  
select * from al_art_view;

select album from al_art_view;
drop view al_art_view;

-- JOIN ALL 11 TABLES IN CHINOOK DB
---- select 1 col

select employee.firstname as Emp_FN, employee.lastname as Emp_LN, customer.firstname as Cus_FN, 
customer.lastname as Cus_LN, invoice.invoiceid, invoiceline.invoicelineid, track.name as track_name, 
mediatype.name as media_type, artist.name as artist, album.title as album, genre.name as genre, 
playlist.name as playlist
from employee
  join customer
  on employee.employeeid = customer.supportrepid
  join invoice
  on invoice.customerid = customer.customerid
  join invoiceline 
  on invoice.invoiceid = invoiceline.invoiceid
  join track
    join mediatype
    on track.mediatypeid = track.mediatypeid
    join album
      join artist
      on album.artistid = artist.artistid
    on album.albumid = track.albumid
    join genre
    on genre.genreid = track.genreid
    join playlisttrack
      join playlist
      on playlist.playlistid = playlisttrack.playlistid
    on playlisttrack.trackid = track.trackid
  on invoiceline.trackid = track.trackid;

