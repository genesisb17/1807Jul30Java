/*
* Genesis Bonds Week 2 Assignment
*/


------------------------2.1 SELECT
--Task � Select all records from the Employee table. 
SELECT * from Employee;

--Task � Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task � Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;