--2.1--------
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2------------------
SELECT * FROM ALBUM ORDER BY TITLE;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;
--2.3------------
INSERT INTO GENRE (GENREID, NAME)
Values (27, 'Genre1');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (9, 'Corbus', 'Dylan', 'Junior DBA', 2, TO_DATE('1995-4-23 05:26:30','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-7-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), '4741 Canela Way', 'San Jose', 'CA', 'USA', 'T2P 5M5', '+1 (408) 722-7387', '+1 (408) 722-7381', 'Dylan@chinookcorp.com');
INSERT INTO CUSTOMER (CustomerID, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepID)
VALUES (63, 'Jon', 'Smithson', 'Google', '72 Canela Way', 'San Jose', 'CA', 'USA', '95136', '+420 2 4472 5555', '+420 2 7172 5555', 'Jonsmi22th@gmail.com', 4);
--2.4----------------------------------------------------
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
--2.5----------------------------------------------------------
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
--2.6--------------------------------------------
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '13-JUN-03' AND '01-MAR-04';
--2.7-----------------------------------------------
--DELETE ALL INVOICELINES. 
DELETE FROM (SELECT *
FROM CUSTOMER INNER JOIN
INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID INNER JOIN
INVOICELINE ON INVOICE.INVOICEID=INVOICELINE.INVOICEID
WHERE CUSTOMER.customerid = 32);
--DELETE ALL THE THE INVOICES WITHOUT INVOICELINES
DELETE FROM (SELECT *
FROM CUSTOMER INNER JOIN
INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID
WHERE CUSTOMER.customerid = 32);
--DELETE FINAL PARENT RECORD IN CUSTMER
DELETE FROM (SELECT * FROM CUSTOMER WHERE CUSTOMERID = '32');
--3.1---------------------------------------------
--return the sysdate
CREATE OR REPLACE FUNCTION getTIME
RETURN DATE IS 
  THETIME DATE;
BEGIN
    SELECT SYSDATE INTO THETIME FROM DUAL;
    RETURN THETIME;
END;
/
select GETTIME() from dual;
--return the length of the current media type
CREATE OR REPLACE FUNCTION mediaTypeLength(MLID NUMBER)
RETURN NUMBER IS ML NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO ML FROM MEDIATYPE WHERE MEDIATYPE.MEDIATYPEID = MLID;
    RETURN ML;
END;
/
SELECT MEDIATYPELENGTH(1) FROM DUAL;
--3.2--------------------------------------------------------
--FUNCTION TO SELECT THE AVG TOTAL FROM THE INVOICE TABLE
CREATE OR REPLACE FUNCTION avgTOTAL
RETURN NUMBER IS AVG_TOTAL NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO AVG_TOTAL FROM INVOICE;
    RETURN AVG_TOTAL;
END;
/
SELECT AVGTOTAL FROM DUAL;
--FUNCTION TO FIND THE MOST EXPENSIVE TRACK
CREATE OR REPLACE FUNCTION expensiveTRACK
RETURN VARCHAR2 IS ET VARCHAR2(100);
BEGIN
    SELECT NAME INTO ET FROM (SELECT NAME FROM TRACK ORDER BY UNITPRICE DESC) WHERE ROWNUM = 1;
    RETURN ET;
END;
/
SELECT EXPENSIVETRACK from dual;
--3.3---------------------------------
--find the avg invoice lince price
CREATE OR REPLACE FUNCTION avgPRICE
RETURN NUMBER IS AP NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AP FROM INVOICELINE;
    RETURN AP;
END;
/
SELECT AVGPRICE FROM DUAL;
--3.4-----------------------------------
--FUNCTION TO RETURN EMPLOYEES AFTER DATE
CREATE OR REPLACE FUNCTION bornAFTER
RETURN SYS_REFCURSOR IS BA SYS_REFCURSOR;
BEGIN
    OPEN BA
    FOR
    SELECT CONCAT(CONCAT(FIRSTNAME, ' '), LASTNAME) AS NAME FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68';
    RETURN BA;
END;
/
SELECT BORNAFTER FROM DUAL;
--4.1----------------------------------
--SELECT ALL THE NAMES OF EMPLOYEES
CREATE OR REPLACE PROCEDURE selectEmployees
IS
Emp_Temp EMPLOYEE.FirstName%TYPE;
CURSOR Emp_cur
IS
   Select CONCAT(CONCAT(FirstName,' '), LastName) FROM EMPLOYEE;
BEGIN
OPEN Emp_cur;
   LOOP
       FETCH Emp_cur INTO Emp_Temp;
       EXIT WHEN Emp_cur%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE(Emp_Temp);
   END LOOP;
CLOSE Emp_cur;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
Create or replace Procedure updateEmpHD(empID Number)
IS
Begin
update Employee set HireDate = sysdate where employeeID = empID;
end;
/
--Task – Create a stored procedure that returns the managers of an employee.
create or replace Procedure get_Manager(empID NUMBER)
IS
Emp_Temp EMPLOYEE.FirstName%TYPE;
CURSOR Emp_c
IS
  Select Concat(Concat(manager.FirstName,' '),manager.LastName) as Manager
  From Employee manager Inner join Employee emp ON manager.employeeid = emp.reportsto WHERE emp.EmployeeID = empID;
BEGIN
OPEN Emp_c;
   LOOP
       FETCH Emp_c INTO Emp_Temp;
       EXIT WHEN Emp_c%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE(Emp_Temp);
   END LOOP;
CLOSE Emp_c;
END;
/
--4.3 Stored Procedure Output Parameters Task – Create a stored procedure that returns the name and company of a customer.
create or replace Procedure getCustNameComp
AS
Cust_Temp_Name CUSTOMER.FirstName%TYPE;
Cust_Temp_Comp  CUSTOMER.company%TYPE;
CURSOR Cust_n
IS
   Select CONCAT(CONCAT(FirstName,' '), LastName) FROM Customer;
CURSOR Cust_c
IS
   Select COMPANY FROM CUSTOMER;
BEGIN
OPEN Cust_n;
OPEN Cust_c;
   LOOP
       FETCH Cust_n INTO Cust_Temp_Name;
       FETCH Cust_C INTO Cust_Temp_Comp;
       EXIT WHEN Cust_n%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE('Name: ' || Cust_Temp_Name ||' Company: ' || Cust_Temp_Comp);
   END LOOP;
CLOSE Cust_n;
CLOSE Cust_c;
END;
/
--5.0 TRANSACTIONS--------------------
--6.1 TRIGGERS-------------------------
--7.1 INNER JOIN--
SELECT CUSTOMER.FIRSTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;
----------7.2 OUTER JOIN ------------------
SELECT C.FIRSTNAME, C.LASTNAME, C.CUSTOMERID, I.INVOICEID, I.TOTAL
FROM INVOICE I  FULL OUTER JOIN CUSTOMER C
ON I.CUSTOMERID=C.CUSTOMERID;
------------7.3 RIGHT JOIN--------------------------------
SELECT AT.NAME, A.TITLE
FROM ARTIST AT RIGHT JOIN ALBUM A
ON AT.ARTISTID=A.ARTISTID;
------------7.4 CROSS JOIN ----------------------
SELECT AT.NAME, A.TITLE
FROM ARTIST AT, ALBUM A
ORDER BY AT.NAME;
----------7.5 SELF JOIN-----------
SELECT E.FIRSTNAME, M.FIRSTNAME
FROM EMPLOYEE E INNER JOIN EMPLOYEE M
ON E.EMPLOYEEID=M.REPORTSTO;
------7.6 COMPLICATED JOIN----------------------------------
SELECT *
FROM EMPLOYEE E INNER JOIN
CUSTOMER C ON E.EMPLOYEEID= C.SUPPORTREPID INNER JOIN
INVOICE I ON C.CUSTOMERID= I.CUSTOMERID INNER JOIN
INVOICELINE IL ON I.INVOICEID=IL.INVOICEID INNER JOIN
TRACK T ON IL.TRACKID= T.TRACKID INNER JOIN
MEDIATYPE M ON T.MEDIATYPEID=M.MEDIATYPEID INNER JOIN
GENRE G ON T.GENREID = G.GENREID INNER JOIN 
ALBUM A ON T.ALBUMID=A.ALBUMID INNER JOIN
ARTIST AR ON A.ARTISTID= AR.ARTISTID INNER JOIN
PLAYLISTTRACK PT ON T.TRACKID= PT.TRACKID INNER JOIN
PLAYLIST P ON PT.PLAYLISTID=P.PLAYLISTID;
/
