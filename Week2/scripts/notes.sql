Select * From ARTIST;
/*
This is a multiline comment just like java
-SELECT[columns] FROM [table] WHERE[condition]
*/

Select * from artist where name like 'A%';

/*

This is essentially saying i dont care about the second  character but the third needs to be e
*/
Select * from artist where name like 'A_e%';

Select * from artist where upper(name) like 'A%M%';
Select * from artist where length(name)<18;


/*
below are aggregate functions
*/

Select count(name) from artist;
Select max(milliseconds) from track;
SELECT avg(total) from invoice;
/*
System defined functions
Scalar Functions-functions that operate on single values(upper()   lower() etc) 
Aggregate functions-functions that operate on multiple rows of data-max,count etc


Nested queues

queries inside of queries also called subqueries
used for various types of dynamic queries

*/

select*from album where artistid=(84);

select*from artist;



/*

This is a nested queue bwlow
In checks if what your searching for is in the result set
*/
select * from album where artistid IN(select artistid from artist where name like 'F%');
select * from album where artistid IN(select artistid from artist where name='Foo Fighters');

/*
select number of people per company in customer table and sort in ascending order
*/
select count(customerid),company 
from customer 
group by company
order by company Asc;

select*from track;

/*
Set operations
-> must have same # and data type of columns
Union- results are all unique rows from both queries
Union all-returns all rows from both queries including the duplicates
Intersect-returns the row that meets both query requirments
Minus- everything from first set minus things in second set
*/
select * from customer;

select * from customer where firstname like 'L%';
select * from customer where country='Brazil';

select * from customer where firstname like 'L%' UNION All select * from customer where country='Brazil';

select * from customer where firstname like 'L%' intersect select * from customer where country='Brazil';

select * from customer where firstname like 'L%' minus select * from customer where country='Brazil';
/*
JOINS-bringing columns together on a foreign key relationship

*/

select track.name as trackname,album.title from track join album on track.albumid=album.albumid;

/*
the statement below uses shorthand
*/
select t.name as trackname,al.title 
from track t 
join album al
on t.albumid=al.albumid;
/*
inner join is the same thing as join without writing inner
*/


/*below is outer join

includes everyone including those who dont have managers and managers not managing anyone
*/
select e1.lastname as Manager, e2.lastname as Employee 
from employee e1
 full outer join employee e2
on e1.employeeid=e2.reportsto;
/*
this below would return all managers wether they are managing anyone or not

*/
select e1.lastname as Manager, e2.lastname as Employee 
from employee e1
 left join employee e2
on e1.employeeid=e2.reportsto;
/*wether they have hamanger or not

shows all employees 
*/
select e1.lastname as Manager, e2.lastname as Employee 
from employee e1
 right join employee e2
on e1.employeeid=e2.reportsto;

/*
below returns all results who do not report to anyone
*/

select e1.lastname as Manager, e2.lastname as Employee 
from employee e1
 full join employee e2
on e1.employeeid=e2.reportsto
where e1.employeeid is null;


/*
Cross Join- cartesion product of two tables

*/

select e1.lastname as Manager,e2.lastname as Employee from employee e1,employee e2;


/*
Natural join- where oracle attempts to match columns based on names

since both tables have the same id it orders based on that
*/
select *from artist natural join album;


select * from genre;
select * from track;

select genreid,name from track;
/*
join the counted number of tracks in each genre with their names
*/

select g.name as genre,count(trackid) as tracks 
from track t
inner join genre g
on g.genreid=t.genreid
group by g.name
order by g.name;

/*
finding the largest song in each genre


*/
select g.name,max(t.milliseconds/1000) as longestSongs 
from track t
inner join genre g
on g.genreid=t.genreid
group by t.milliseconds
order by t.milliseconds;





select * from artist;
-- this is a comment
/* This is a multi line comment*/


-- SELECT [columns] FROM [table] where [condition]
SELECT * FROM ARTIST;

select name from artist;

select * from artist where name like 'A%e';

/* System-defined functions
Scalar Functions - functions that operate on single values ie upper() lower() length()
Aggregate Functions - functions that operate on multiple rows of data - max() min() count()
*/
select * from artist where lower(name) like 'A%M%';
select * from artist where length(name) < 15;

select count(name) from artist;
select max(milliseconds) from track;
select avg(total) from invoice where invoiceid < 10;


/*
NESTED QUERIES 
queries inside of queries. also called subqueries
used for various types of dynamic queries
--- IN
*/
select * from artist;

-- find Foo Fighter's albums
select * from album where artistid = (
select artistid from artist where name = 'Foo Fighters');

-- find albums of all artists whose name starts with F
select * from album where artistid IN (
select artistid from artist where name like 'F%');

--select number of people per company in customer table and alphabetize
SELECT count(customerid), company 
FROM customer 
GROUP BY company
ORDER BY company ASC;

/*
SET OPERATIONS - used to combine result sets and see overlap of data
--> must have the same # and type of columns
UNION - results are all unique rows from both queries ->  A + B - AB
UNION ALL - all rows, including duplicates  -> A +  B
INTERSECT - rows from result set of both queries -> AB
MINUS - all rows from first subset MINUS all rows in both sets -> A - AB
*/

select * from customer;
select * from customer where firstname like 'L%';
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' MINUS
select * from customer where country = 'Brazil';



/* JOINS
*/

select name, albumid from track;
select albumid, title from album;
--INNER JOINS
select t.name as TRACK_NAME, al.title
from track t
join album al
on t.ALBUMID = al.albumid;

--SELF JOIN, with left and right and full outer 
select * from employee;
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1
inner join employee e2
on e1.employeeid = e2.reportsto;

-- see all empl w no subordinates
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1
full join employee e2
on e1.employeeid = e2.reportsto
where e2.employeeid IS null;


--see all empl w no manager
select * from employee;
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1
full join employee e2
on e1.employeeid = e2.reportsto
where e1.employeeid IS null;

-- CROSS JOIN - cartesian product of two tables
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1, employee e2;

-- Natural join - where Oracle attempts to match columns basd on names
select album.title, artist.name
from album
inner join artist
on album.artistid = artist.artistid;

select * from artist natural join album;

select * from genre;

----------------- FUN QUERIES
-- find # of tracks of each genre. alphabetize by genre
select g.name ,  g.genreid, count(t.trackid)
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name, g.genreid
order by g.name;

-- find longest song in each genre
select g.name , max(t.milliseconds)/1000 as "Longest Song(s)"
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name
order by g.name;



--Select from a join
select count(albumid) as "# of Albums", name
from 
      (select album.albumid, artist.artistid, artist.name 
      from album 
      join artist 
      on album.artistid = artist.artistid)
  where artistid > 5
  group by name
  having count(albumid) > 1
  order by "# of Albums";



