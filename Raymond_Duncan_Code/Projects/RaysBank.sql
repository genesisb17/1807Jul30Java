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

CREATE TABLE BankAccount (
    account_number NUMBER(16) NOT NULL PRIMARY KEY,
    account_type VARCHAR(20) NOT NULL,
    primary_uid NUMBER(12) NOT NULL,
    secondary_uid NUMBER(12),
    balance NUMBER NOT NULL,
    open_date TIMESTAMP NOT NULL,
    close_date TIMESTAMP    
);

CREATE TABLE Transaction (
    transaction_id NUMBER NOT NULL PRIMARY KEY,
    from_account NUMBER(12) NOT NULL,
    to_account NUMBER(12) NOT NULL,
    balance NUMBER NOT NULL,
    time TIMESTAMP NOT NULL
);

CREATE TABLE BankUser (
    user_id NUMBER(12) NOT NULL PRIMARY KEY,
    title VARCHAR2(10),
    firstname VARCHAR(25) NOT NULL,
    lastname VARCHAR(25) NOT NULL,
    total_balance NUMBER NOT NULL,
    time_joined TIMESTAMP NOT NULL
);

CREATE TABLE UserCredentials (
    username VARCHAR2(20) NOT NULL PRIMARY KEY,
    password VARCHAR2(32) NOT NULL,
    user_id NUMBER(12) NOT NULL
);

/*******************************************************************************
   Foreign Keys
********************************************************************************/

ALTER TABLE BankAccount
   ADD FOREIGN KEY (primary_uid) REFERENCES BankUser(user_id);
   
ALTER TABLE UserCredentials
    ADD     FOREIGN KEY (user_id) REFERENCES BankUser(user_id);



/*******************************************************************************
   Triggers
********************************************************************************/
CREATE SEQUENCE account_number_seq
MINVALUE 1000000000000000
START WITH 1000000000000000
MAXVALUE 9999999999999999
INCREMENT BY 1;

CREATE SEQUENCE new_transaction_seq
MINVALUE 0
START WITH 0
INCREMENT BY 1;

CREATE SEQUENCE new_user_seq
MINVALUE 0
START WITH 0
INCREMENT BY 1;

/*******************************************************************************
   Triggers
********************************************************************************/

CREATE OR REPLACE TRIGGER new_account_trigger
BEFORE INSERT ON BankAccount
FOR EACH ROW
BEGIN
    SELECT account_number_seq.nextval INTO :new.account_number FROM DUAL;
    SELECT CURRENT_TIMESTAMP INTO :new.open_date FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER new_transaction_trigger
BEFORE INSERT ON Transaction
FOR EACH ROW
BEGIN
    SELECT new_transaction_seq.nextval into :new.transaction_id FROM DUAL;
    SELECT CURRENT_TIMESTAMP INTO :new.time FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER new_user_trigger
BEFORE INSERT ON BankUser
FOR EACH ROW
BEGIN
    SELECT new_user_seq.nextval into :new.user_id FROM DUAL;
    SELECT CURRENT_TIMESTAMP INTO :new.time_joined FROM DUAL;
END;
/

/*******************************************************************************
   Functions
********************************************************************************/

/*******************************************************************************
   Procedures
********************************************************************************/

/*******************************************************************************
   Populate Database
********************************************************************************/

COMMIT;
EXIT;