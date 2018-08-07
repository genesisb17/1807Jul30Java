select * from artist;
-- this is a comment
/* This is a multi line comment */

-- SELECT [columns] FROM [table] where [condition]
SELECT * FROM ARTIST;

select name from artist;

select * from artist where name like 'A%e';
select * from artist where name upper(name) like 'A_a%';

/*
System-defined functions
Scalar functions - functions that operate on single values, i.e. upper() lower() 
Aggregate functions - functions that operate on multiple rows of data - max()
*/

select * from artist where lower(name) like 'A%M%';
select * from artist where length(name) < 15;

select count(name) from artist;
select max(milliseconds) from track;
select avg(total) from invoice;


/*
NESTED QQUERIES
queries inside of queries. also called subqueries
used for various types of dynamic queries
--- IN
*/

-- Find Foo Fighter's albums:
select * from album;
select * from album;
select artistid from artist where name = 'Foo Fighters';


-- subquery (find Foo Fighter's albums):
select * from album where artistid = (
select artistid from artist where name like 'Foo Fighters');

/* if you have a subquery that returns more than one row, you would have to
change it to this: */
-- find albums of all artists whose name starts with F:
select * from album where artistid IN (
select artistid from artist where name like 'F%');


-- count number of customers from each company (in alphabetical order):
SELECT count(*), company
FROM customer
GROUP BY company
ORDER BY company ASC;

select * from track;


/*
SET OPERATIONS - used to combine result sets and see overlap of data
--> must have the same # and type of columns

UNION - results are all unique rows from both queries = A + B - AB
UNION ALL - all rows, including duplicates = A + B
INTERSECT - rows from result set of both queries = AB
MINUS - results from first ubset that are not in second set = A - AB
*/

select * from customer;
select * from customer where firstname like 'L%'; -- first name starts w/ 'L'
select * from customer where country = 'Brazil';

-- union of the 2 queries but no duplicates (ordered by customer id)
select * from customer where firstname like 'L%' UNION
select * from customer where country = 'Brazil';

-- same but includes duplicates (anyone who was in both sets is included twice)
-- basically runs the first query then appends the results of the second one
select * from customer where firstname like 'L%' UNION ALL
select * from customer where country = 'Brazil';

-- intersection of 2 queries
select * from customer where firstname like 'L%' INTERSECT
select * from customer where country = 'Brazil';

-- minus
select * from customer where firstname like 'L%' MINUS
select * from customer where country = 'Brazil';




/*
JOINS
*/

select name as "Track Name", albumid from track;  -- can select name as an alias ("Track Name")
select name as trackname, albumid from track; -- same thing but alias will be "TRACKNAME"
    -- don't have to use quotes if it's a single word (another option: TRACK_NAME)

-- INNER JOIN
select t.name as trackname, al.title
from track t  -- assigning nickname
join album al
on t.ALBUMID = al.albumid;

-- SELF JOIN, with left and right and full outer
select * from employee;
select e1.lastname as MANAGER,  e2.lastname as EMPLOYEE
from employee e1
full outer join employee e2   -- "full outer" and "full" join are the same thing
on e1.employeeid = e2.reportsto;

-- CROSS JOIN - cartesian product of two tables
select e1.lastname as MANAGER, e2.lastname as EMPLOYEE
from employee e1, employee e2;

-- Natural join - where Oracle attempts to match columns based on names
select album.title, artist.name
from album
inner join artist
on album.artistid = artist.artistid;

select * from artist natural join album;

select * from genre;
select * from track;
select genreid, count(trackid) from track group by genreid;

-- find # of tracks of each genre. alphabetize by genre
select g.name as genre, count(t.trackid) as num_tracks  -- "as" alias
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name   -- you'll only see group by with these sorts of aggregate functions
order by g.name;

-- find longest song in each genre
select g.name, max(t.milliseconds)/1000 as "Longest Song (s)"
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name
order by g.name;