--This is a single line comment
/*
This is a multiline comment
*/

--The syntax for queries is SELECT [columns] FROM [table] WHERE [condition]
select * from artist; -- identical to SELECT * FROM ARTIST;

select * from artist where name like 'A%e'; --Names that start with 'A' and end with 'e'
select * from artist where name like 'A_e%'; --Names that start with 'A', skip a letter, have an 'e' next, and then any following characters
select * from artist where name like 'A%M%'; -- Names that start with 'A', skip some letters, have an 'M', and then any following characters
--Lookup SQL Regex statements

/* System-defined fuctions
Scalar Functions - functions that operate on single values (i.e. upper(), lower(), length(), etc.)
Aggregate functions - functions that operate on multiple rows of data (i.e. max(), min(), etc.)
*/
select * from artist where lower(name) like 'A&M%';
select * from asrtist where length(name) < 15;

select count(name) from artist; --The number of artists
select max(milliseconds) from track;
select avg(total) from invoice where invoiceid < 10;

/*
NESTED QUERIES
queries inside queries inside queries. (AKA subqueries)
used for various types of dynamic queries
---IN
*/
select * from artist;
select * from album;
select artistid from artist where name = 'Foo Fighters';

--Using nexted queries
select * from album where artistid = (
select artistid from artist where name = 'Foo Fighters'); --All Foo Fighters albums

select * from album where artistid in (
select artistid from artist where name like 'F%'); --All albums from artists whose name begins with "F"

select count(*), company from customer group by company order by company asc; --Count of employees at each company, ascending alphabetical order by company

/*
SET OPERATIONS - used to combine result sets and see overlap of data
--> must have the same # and type of columns
UNION - results are all unique rows from (A + B - AB)
UNION ALL - resultf from all rows, including duplicates (A + B)
INTERSECT - rows from the result set of both queries (AB)
MINUS - all rows from first subset minus all rows in both sets (A - AB)
*/

select * from customer;
select * from customer where firstname like 'L%';
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' UNION
select * from customer where country = 'Brazil';


/* 
JOINS
*/
select name, albumid from track;
select albumid, title from album;
select t.name as trackname, al.title
from track t
join album al
on t.ALBUMID = al.albumid;

--SELF JOIN
select * from employee;
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1
inner join employee e2
on e1.employeeid = e2.reportsto;

--CROSS JOIN - Cartesian product of two tables (all possible combiations)
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1, employee e2;

--Natural join - where Oracle attempts to match columns based on names
select album.title, artist.name
from album
inner join artist
on album.artistid = artist.artistid;

select * from artist natural join album;

--JOIN ALL 11 TABLES IN CHINOOK DB
----select 1 col from each table
--create view FULL_JOIN as
select album.title,artist.name,customer.firstname,employee.lastname,genre.name,invoice.total,invoiceline.quantity,mediatype.name,playlist.name,playlisttrack.trackid,track.name
from album natural join artist,customer,employee,genre,invoice,invoiceline,mediatype,playlist,playlisttrack,track;



--------FUN QUERIES

--find the number of track of each genre. alphabetize by genre
select g.name, count(t.trackid) as count
from genre g
inner join track t 
on g.genreid = t.genreid
group by g.name 
order by g.name asc;

--get the longest song by genre in seconds
select g.name, max(t.milliseconds)/1000 as "Song Length(s)"
from genre g
inner join track t 
on g.genreid = t.genreid
group by g.name 
order by g.name asc;

--VIEWS - virtual tables
--essentially saved queries. cannot update table via views
--Creating a view
create view Album_Artist_View as 
select album.albumid, artist.artistid, artist.name
from album
join artist
on album.artistid = artist.artistid;

select * from album_artist_view;

