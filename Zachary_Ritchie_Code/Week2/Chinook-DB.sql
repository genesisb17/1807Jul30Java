SELECT * FROM artist;
/*SELECT [columns] FROM [table] where [condition]*/

select name from artist;
select * from artist where name like 'A%e';

select * from artist where name like 'A%M%';

/*System-define functions
scalar functions - functions that operate lon single values
aggregate functions - operate on multiple rows of data
*/

select * from artist where lower(name) like 'A%M%';
select * from artist where length(name) < 15;

select count(name) from artist;
select max(milliseconds) from track;
select avg(total) from invoice;

/*
NESTED QUERIES
queries inside of queries. also called subqueries
used for various types of dynmaic queries
*/


select * from artist;

/*find foo fighters albums*/
select * from album where artistid =(
select artistid from artist where name = 'Foo Fighters');

/*changed =(  ) to in*/
/*find albums of all artists whose name starts with f*/
select * from album where artistid IN (
select artistid from artist where name like 'F%');

/*select number of people per company in scustomer table and alphabatize*/
select count(customerid), company from customer group by company
order by company ASC;

/*
SET OPERATIONS - used to combine result sets and see overlap of data
-> must have the same # and type of columns
UNION - results are all unique rows from both queries -> A + B -AB
UNION ALL- all rows, including duplicates -> A + B
INTERSECT - rows from results set of both queiries -> AB
MINUS- all rows from first subset MINUS all rows from both sets -> A + B
*/

select * from customer;
select * from customer where firstname like 'L%';
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' UNION
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' UNION ALL
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' INTERSECT
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' MINUS
select * from customer where country = 'Brazil';

/*JOINS*/

select track.name as "Track Name", album.TITLE 
from track 
join album
on track.ALBUMID = album.ALBUMID;

/*JOIN, with left and right and full outer*/
select * from employee;
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE 
from employee e1
full join employee e2
on e1.employeeid = e2.reportsto;

select * from employee;
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE 
from employee e1
full join employee e2
on e1.employeeid = e2.reportsto
where e1.employeeid IS null;

/*cross join, cartisian product of two tables*/
select e1.lastname as manager, e2.lastname as employee
from employee e1, employee e2;

/*Natural joins - where oracle attempts to match columns based on names*/
select album.title, artist.name
from album 
inner join artist
on album.artistid = artist.artistid;

select * from artist natural join album;

select * from genre; 

select genreid, count(trackid) 
from track
group by genreid;

/*find # of tracks of each genre. alphabetize by genre*/
select * from genre;
select g.name as genre, count(t.trackid) as tracks
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name
order by g.name;

-- JOIN All 11 Tables in chinook DB 
-- select on column from each column table






