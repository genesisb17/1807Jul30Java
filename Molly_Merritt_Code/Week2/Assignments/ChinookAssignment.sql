/*
Molly Merritt Week 2 Assignment
*/


-----------------2.1 SELECT
-- Select all records from the Employee table.
SELECT* from Employee;

-- Select all records from the Employee table where the last name is King.
SELECT * from Employee where lastname = 'King';

-- Select all records from the Employee table where first name is Andrew
SELECT * from Employee where firstname = 'Andrew' AND resportsto IS null;


-----------------2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.


-- Select first name from Customer and sort result set in ascending order by city.



-----------------2.3 INSERT INTO
-- Insert two new records into Genre table


-- Insert two new records into Employee table


-- Insert two new records into Customer table



-----------------2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter


-- Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"



-----------------2.5 LIKE
-- Select all invoices with a billing address like "T%"



-----------------2.6 BETWEEN
-- Select all invoices that have a total between 15 and 30


-- Select all employees hired between 1st of June 2003 and 1st of March 2004