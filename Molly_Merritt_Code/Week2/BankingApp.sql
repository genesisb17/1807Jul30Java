CREATE TABLE users(
  userID NUMBER NOT NULL,
  firstName varchar2(50) NOT NULL,
  lastName varchar2(50) NOT NULL,
  username varchar2(50) UNIQUE NOT NULL,
  password varchar2(50) NOT NULL,
  PRIMARY KEY (userID));
  
CREATE TABLE accounts(
  accountID number NOT NULL,
  accountNumber number UNIQUE NOT NULL,
  userID number NOT NULL,
  accountType varchar2(50) NOT NULL,
  balance number NOT NULL,
  PRIMARY KEY (accountID));

CREATE TABLE transactions(
  transactionID number NOT NULL,
  accountID number NOT NULL,
  action varchar2(50) NOT NULL,
  balance number,
  PRIMARY KEY (transactionID),
  FOREIGN KEY (accountID) REFERENCES accounts(accountID));

select * from users;


-------------------------------- Sequences-----------------------
CREATE SEQUENCE user_seq
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999
   START WITH 1
   INCREMENT BY 1 
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;

CREATE SEQUENCE account_seq
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999
   START WITH 1
   INCREMENT BY 1
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION;

CREATE SEQUENCE transaction_seq
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999
   START WITH 1
   INCREMENT BY 1
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION;
  
  
  ------------- TRIGGERS
CREATE OR REPLACE TRIGGER user_seq_trig
before insert on users
for each row
begin
    select user_seq.nextVal into :new.userID from dual;
end;
/

CREATE OR REPLACE TRIGGER account_seq_trig
before insert on accounts
for each row
begin
    select account_seq.nextVal into :new.accountID from dual;
end;
/

CREATE OR REPLACE TRIGGER transaction_seq_trig
before insert on transactions
for each row
begin
    select transaction_seq.nextVal into :new.transactionID from dual;
end;
/



------------ PROCEDURES ------------
create or replace PROCEDURE get_all_users(
  c_users OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN c_users for SELECT * FROM users;
END;
/


delete from users;
select * from accounts;
select balance from accounts where accountnumber = 1012349;
commit;
rollback;