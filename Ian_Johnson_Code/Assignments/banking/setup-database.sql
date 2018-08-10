-- This is the script to set up the ITJBank database.
-- Be warned that running this script as-is will delete any existing data!

-- Drop the itjbank user if it exists, and recreate it.
DROP USER itjbank CASCADE;

CREATE USER itjbank
IDENTIFIED BY VerySecurePassword;
GRANT CONNECT TO itjbank;
GRANT RESOURCE TO itjbank;

-- Connect to the database as itjbank.
CONN itjbank/VerySecurePassword;

-- Now we can create our tables.
CREATE TABLE bank_user (
    user_id NUMBER(6) PRIMARY KEY,
    username VARCHAR2(32) NOT NULL UNIQUE,
    password_salt RAW(16) NOT NULL,
    password_hash RAW(16) NOT NULL,
    first_name VARCHAR2(32) NOT NULL,
    last_name VARCHAR2(32) NOT NULL
);

CREATE TABLE account (
    account_id NUMBER(6) PRIMARY KEY,
    name VARCHAR2(32) NOT NULL,
    balance NUMBER(16, 2) NOT NULL
);

-- A junction table associating users and accounts.
CREATE TABLE user_account (
    user_id NUMBER(6),
    account_id NUMBER(6),
    PRIMARY KEY (user_id, account_id),
    FOREIGN KEY (user_id) REFERENCES bank_user(user_id),
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- Let's create sequences for the account IDs and triggers to generate them automatically.
CREATE SEQUENCE seq_user_id;
CREATE SEQUENCE seq_account_id;

CREATE OR REPLACE TRIGGER trig_user_id
BEFORE INSERT ON bank_user
FOR EACH ROW
BEGIN
    SELECT seq_user_id.NEXTVAL INTO :NEW.user_id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER trig_account_id
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    SELECT seq_account_id.NEXTVAL INTO :NEW.account_id FROM dual;
END;
/

SELECT * FROM bank_user;
