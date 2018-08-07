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