SELECT * FROM artist;

--select [columns] from [table] where [condition]
-- names of artists that begin with capital A
SELECT * FROM artist where NAME like 'A%e';

/*
Functions
System-defined finctions
  Scalar functions - functions that operate on single values ie upper() lower()
  aggregate functions - functions that operate on multiple rows of data - max() min() count()
*/
--scalar
select * from artist where length(name) < 15;

--aggregate
select avg(total)from invoice where invoiceid < 10;

/*
Nested queries
  queries inside of queries. also called subqueries
  used for various types of dynamic queries

IN
*/

--find albums of all artists whose name starts with F
select * from album where artistid in (
select artistid from artist where name like 'F%');

--select num of ppl per company in customer table and alphabetize
select count(*), company 
from customer
group by company
order by company ASC;

/* 
these bring your rows together
SET OPS- used to combine result sets and see overlap of data
union- results are all unique rows from both queries
union all- results are ALL rows from both queries regardless of dups
intersect- rows from result set of both queries- where A + B overlap
minus- all rows from first subset MINUS all rows in both sets. A-AB
*/

select * from customer;
select * from customer where firstname like 'L%';
select * from customer where country = 'Brazil';

select * from customer where firstname like 'L%' UNION 
select * from customer where country = 'Brazil';

/*
JOINS

CROSS JOIN - cartesian product of two tables

Natural Join - where oracle attempts to match columns based on names
*/

select t.name as trackname, album.title
from track t--t writing this will give a new alias
join album 
on t.ALBUMID = album.ALBUMID;

select * from employee;
--self join, with left and right and full outer
select e1.lastname as manager, e2.lastname as employee
from employee e1
full outer join employee e2
on e1.employeeid = e2.REPORTSTO;

--songs in each genre by genre name
select g.name as genre, count(t.trackid) as tracks
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name
order by g.name;



