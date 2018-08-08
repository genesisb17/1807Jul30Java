/*
Raymond Duncan Week 2 Assignment
*/

/************************************************************************
**                           2.0 SQL Queries                           **
************************************************************************/
--In this section you will be performing various queries against the Oracle Chinook database.

-----------         2.1 SELECT         -----------
--Task – Select all records from the Employee table.
select * from employee;
--Task – Select all records from the Employee table where last name is King.
select * from employee where lower(lastname) = 'king';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where lower(firstname) = 'andrew' and reportsto is null;

-----------         2.2 ORDER BY         -----------
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album
order by title desc;
--Task – Select first name from Customer and sort result set in ascending order by city
select firstname from customer
order by city asc;

-----------         2.3 INSERT INTO         -----------
--Task – Insert two new records into Genre table
select * from genre order by name;
select * from genre order by genreid desc;
--Insert Funk
insert into genre(genreid,name)
values(26,'Funk');
--Insert Noise
insert into genre(genreid,name)
values(27,'Noise');
--Task – Insert two new records into Employee table
select * from employee;
--Insert John Doe
insert into employee(employeeid,firstname,lastname)
values(9,'John','Doe');
--Insert Jane Doe
insert into employee(employeeid,firstname,lastname)
values(10,'Jane','Doe');
--Task – Insert two new records into Customer table
select * from customer;
--Insert Raymond Duncan
insert into customer(customerid,firstname,lastname,email)
values(60,'Raymond','Duncan','raymond.duncan@gmail.com');
--insert Anthony Duncan
insert into customer(customerid,firstname,lastname,email)
values(61,'Anthony','Duncan','anthony.duncan@gmail.com');
-----------         2.4 UPDATE         -----------
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
-----------         2.5 LIKE         -----------
--Task – Select all invoices with a billing address like “T%”
-----------         2.6 BETWEEN         -----------
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
-----------         2.7 DELETE         -----------
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).