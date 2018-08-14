/*******************************************************************************
   Chinook Database - Version 1.4
   Script: Chinook_Oracle.sql
   Description: Creates and populates the Chinook database.
   DB Server: Oracle
   Author: Luis Rocha
   License: http://www.codeplex.com/ChinookDatabase/license
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER raysbankAdmin CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER raysbankAdmin
IDENTIFIED BY admin
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to raysbankAdmin;
GRANT resource to raysbankAdmin;
GRANT create session TO raysbankAdmin;
GRANT create table TO raysbankAdmin;
GRANT create view TO raysbankAdmin;

conn raysbankAdmin/admin
/*******************************************************************************
   Create Tables
********************************************************************************/

CREATE TABLE Account (
    account_number NUMBER(12) NOT NULL PRIMARY KEY,
    account_type VARCHAR(20) NOT NULL,
    primary_uid NUMBER(12) NOT NULL,
    secondary_uid NUMBER(12),
    balance NUMBER NOT NULL,
    open_date TIMESTAMP NOT NULL,
    close_date TIMESTAMP,
    
    FOREIGN KEY (primary_uid) REFERENCES User(uid) ON DELETE CASCADE
);

CREATE TABLE Transaction (
    transaction_id NUMBER NOT NULL PRIMARY KEY,
    from_account NUMBER(12) NOT NULL,
    to_account NUMBER(12) NOT NULL,
    balance NUMBER NOT NULL,
    time TIMESTAMP NOT NULL
);

/*******************************************************************************
   Sqeuences
********************************************************************************/

CREATE SEQUENCE account_number_seq
MINVALUE 100000000000
START WITH 100000000000
MAXVALUE 999999999999
INCREMENT BY 1;

CREATE SEQUENCE new_transaction_seq
MINVALUE 0
START WITH 0
INCREMENT BY 1;

/*******************************************************************************
   Triggers
********************************************************************************/

CREATE OR REPLACE TRIGGER new_account_trigger
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
    SELECT account_number_seq INTO :new.account_number FROM DUAL;
    SELECT CURRENT_TIME INTO :new.open_date FROM DUAL;
END;
/