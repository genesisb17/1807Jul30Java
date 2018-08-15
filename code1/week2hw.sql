/*DYLAN CORBUS WEEK 2 SQL ASSIGNMENT
*/
SELECT *
FROM EMPLOYEE
FULL OUTER JOIN CUSTOMER ON EMPLOYEE.EMPLOYEEID=CUSTOMER.SUPPORTREPID FULL OUTER JOIN INVOICE
ON CUSTOMER.SUPPORTREPID=INVOICE.CUSTOMERID FULL OUTER JOIN 
INVOICELINE ON INVOICE.INVOICEID=INVOICELINE.INVOICEID FULL OUTER JOIN
TRACK ON INVOICELINE.TRACKID=TRACK.TRACKID FULL OUTER JOIN
GENRE ON TRACK.GENREID= GENRE.GENREID FULL OUTER JOIN 
MEDIATYPE ON TRACK.MEDIATYPEID=MEDIATYPE.MEDIATYPEID FULL OUTER JOIN
ALBUM ON TRACK.ALBUMID=ALBUM.ALBUMID FULL OUTER JOIN
ARTIST ON ALBUM.ARTISTID=ARTIST.ARTISTID FULL OUTER JOIN 
PLAYLISTTRACK ON TRACK.TRACKID=PLAYLISTTRACK.TRACKID FULL OUTER JOIN
PLAYLIST ON PLAYLISTTRACK.PLAYLISTID=PLAYLIST.PLAYLISTID;
--2.1-----------------------------------------------------------------
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--------------------------------------------------------
--2.2-----------------------------------------------------
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY FIRSTNAME;
----------------------------------------------------------
--2.3----------------------------------------------------
INSERT INTO GENRE (GENREID, NAME)
Values (27, 'Genre1');

INSERT INTO CUSTOMER (CustomerID, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepID)
VALUES (65, 'Jon', 'Welch', 'Google', '472841 Canela Way', 'San Jose', 'CA', 'USA', '95136', '+420 2 4472 5555', '+420 2 7172 5555', 'Jonsmith@44gmail.com', 4);

INSERT INTO EMPLOYEE (EmployeeID, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (11, 'Smith', 'Jen', 'IT Staff', 2, TO_DATE('1995-5-25 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-7-2 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), '14794 Excaliber Driver', 'Morgan Hill', 'CA', 'USA', 'T2P 535', '+1 (408) 722-7322', '+1 (408) 722-7184', 'Jen@chinookcorp.com');
-------------------------------------------------------------------------------------
--2.4------------------------------------------------------------------------------------
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
--2.5-------------------------------------------------------
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
--2.6----------------------------------------------------------
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
--2.7-----------------------------------------------------------
--7.1---------------------------------------
SELECT CUSTOMER.FIRSTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2--------------------------------------------------
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN
INVOICE ON CUSTOMER.CUSTOMERIAD = INVOICE.CUSTOMERID;
--7.3------------------------------------------------------------------------------
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ARTIST RIGHT JOIN
ALBUM ON ALBUM.ARTISTID=ARTIST.ARTISTID;
--7.4-------------------------------------------------------
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST, ALBUM
ORDER BY ARTIST.NAME;
--7.5----------------------------------------------------------
SELECT *
FROM EMPLOYEE E INNER JOIN 
EMPLOYEE M ON E.EMPLOYEEID=M.REPORTSTO
WHERE