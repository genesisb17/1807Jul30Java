/*
 * Ian Johnson Week 2 Assignment
 */

-- 2.1 SELECT
-- Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
-- Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
-- Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY /* ASC */;

-- 2.4 INSERT INTO
-- Insert two new records into Genre table.
INSERT INTO GENRE (GENREID, NAME) VALUES (
    -- So I don't have to figure out a proper GENREID myself.
    (SELECT MAX(GENREID) + 1 FROM GENRE),
    'Punk rock'
);
INSERT INTO GENRE (GENREID, NAME) VALUES (
    -- So I don't have to figure out a proper GENREID myself.
    (SELECT MAX(GENREID) + 1 FROM GENRE),
    'Indie'
);
-- Insert two new records into Employee table.
INSERT INTO EMPLOYEE (
    EMPLOYEEID,
    LASTNAME,
    FIRSTNAME,
    TITLE,
    REPORTSTO,
    BIRTHDATE,
    HIREDATE,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    /* FAX, */ -- Who uses fax any more anyways?
    EMAIL
) VALUES (
    (SELECT MAX(EMPLOYEEID) + 1 FROM EMPLOYEE),
    'Johnson',
    'Ian',
    'Developer',
    8,
    '09-MAY-96',
    CURRENT_DATE, -- Use the current date.
    '2925 Rensselaer Ct.',
    'Vienna',
    'USA',
    '22181',
    '7038198495',
    'iantimothyjohnson@gmail.com'
);
INSERT INTO EMPLOYEE (
    EMPLOYEEID,
    LASTNAME,
    FIRSTNAME,
    TITLE,
    REPORTSTO,
    BIRTHDATE,
    HIREDATE,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    /* FAX, */ -- Who uses fax any more anyways?
    EMAIL
) VALUES (
    (SELECT MAX(EMPLOYEEID) + 1 FROM EMPLOYEE),
    'Smith',
    'John',
    'Senior junior senior advisor',
    (SELECT EMPLOYEEID FROM EMPLOYEE WHERE FIRSTNAME = 'Ian'),
    '10-JUL-67',
    CURRENT_DATE,
    '567 Test Street',
    'New York City',
    'New York',
    'USA',
    '55555',
    '7777777777',
    'john.smith@generic.com'
);
-- Insert two new records into Customer table.
INSERT INTO CUSTOMER (
    CUSTOMERID,
    FIRSTNAME,
    LASTNAME,
    COMPANY,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    FAX,
    EMAIL,
    SUPPORTREPID
) VALUES (
    (SELECT MAX(CUSTOMERID) + 1 FROM CUSTOMER),
    'Jane',
    'Doe',
    'Revature',
    '111 Example Street',
    'Seattle',
    'Washington',
    'USA',
    '22222',
    '5555555555',
    '5555555555',
    'janedoe@revature.com',
    (SELECT EMPLOYEEID FROM EMPLOYEE WHERE FIRSTNAME = 'Ian')
);
INSERT INTO CUSTOMER (
    CUSTOMERID,
    FIRSTNAME,
    LASTNAME,
    COMPANY,
    ADDRESS,
    CITY,
    STATE,
    COUNTRY,
    POSTALCODE,
    PHONE,
    FAX,
    EMAIL,
    SUPPORTREPID
) VALUES (
    (SELECT MAX(CUSTOMERID) + 1 FROM CUSTOMER),
    'William',
    'Shakespeare',
    'Self-employed',
    'The Globe Theatre',
    'London',
    'Greater London',
    'United Kingdom',
    '11111', -- I don't know what it actually is :(
    '7038675309',
    '1234567890',
    'bill.shakespeare@gmail.com',
    (SELECT EMPLOYEEID FROM EMPLOYEE WHERE FIRSTNAME = 'Ian')
);

-- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter.
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”.
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Select all invoices with a billing address like “T%”.
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Select all invoices that have a total between 15 and 50.
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
-- Select all employees hired between 1st of June 2003 and 1st of March 2004.
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
-- First, let's delete all the invoices that refer to Robert Walter; in order to
-- do this, we must first delete all the invoice lines that refer to those invoices.
-- The view below will make this easier:
CREATE VIEW RW_INVOICES AS
SELECT INVOICEID FROM INVOICE
WHERE CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID FROM RW_INVOICES);

-- Deleting rows from a view deletes the rows from the underlying table, so it's
-- easy to delete the invoices related to Robert Walter.
DELETE FROM RW_INVOICES;

-- Finally, we can delete Robert Walter, since everything depending on him has been deleted.
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 7.0 JOINS
-- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME || ' ' || CUSTOMER.LASTNAME AS CUSTOMER_NAME, INVOICE.INVOICEID
FROM CUSTOMER
JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

-- 7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID AS CUSTOMERID, C.FIRSTNAME AS FIRSTNAME, C.LASTNAME AS LASTNAME, I.INVOICEID AS INVOICEID, I.TOTAL AS TOTAL
FROM CUSTOMER C
FULL OUTER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST, ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID -- This is really no different from a normal JOIN, just written differently.
ORDER BY ARTIST.NAME;

-- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT MANAGER.FIRSTNAME || ' ' || MANAGER.LASTNAME AS MANAGER,
       SUBORDINATE.FIRSTNAME || ' ' || SUBORDINATE.LASTNAME AS SUBORDINATE
FROM EMPLOYEE MANAGER
FULL OUTER JOIN EMPLOYEE SUBORDINATE
ON SUBORDINATE.REPORTSTO = MANAGER.EMPLOYEEID;

-- 7.6 Complicated Join assignment
-- Create an inner join between all tables in the chinook database.
-- An alternate version of this may be found in the HUGE-JOIN.sql file in this folder.
SELECT
    TRACK.NAME AS TRACK,
    ALBUM.TITLE AS ALBUM,
    ARTIST.NAME AS ARTIST,
    GENRE.NAME AS GENRE,
    MEDIATYPE.NAME AS MEDIATYPE,
    PLAYLISTTRACK.PLAYLISTID AS PLAYLIST_ID,
    PLAYLIST.NAME AS PLAYLIST,
    INVOICELINE.UNITPRICE AS TRACK_PRICE,
    CUSTOMER.FIRSTNAME AS CUSTOMER_NAME,
    INVOICE.INVOICEDATE AS INVOICEDATE,
    EMPLOYEE.FIRSTNAME AS SUPPORTREP_NAME
FROM TRACK
JOIN ALBUM ON TRACK.ALBUMID = ALBUM.ALBUMID
JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
JOIN GENRE ON TRACK.GENREID = GENRE.GENREID
JOIN MEDIATYPE ON TRACK.MEDIATYPEID = MEDIATYPE.MEDIATYPEID
JOIN PLAYLISTTRACK ON PLAYLISTTRACK.TRACKID = TRACK.TRACKID
JOIN PLAYLIST ON PLAYLIST.PLAYLISTID = PLAYLISTTRACK.PLAYLISTID
JOIN INVOICELINE ON INVOICELINE.TRACKID = TRACK.TRACKID
JOIN INVOICE ON INVOICE.INVOICEID = INVOICELINE.INVOICEID
JOIN CUSTOMER ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEEID = CUSTOMER.SUPPORTREPID;