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
    type VARCHAR2(32) NOT NULL CHECK (type = 'Savings' OR type = 'Checking'),
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

-- Since several things could go wrong when trying to associate a user and
-- an account (either the user or account could not exist, or both), it is
-- useful to make this a procedure that can set an output parameter with
-- a description of what went wrong.
-- Error code values:
-- 0 = no error
-- 1 = user does not exist
-- 2 = account does not exist
-- 3 = association has already been made
CREATE OR REPLACE PROCEDURE associate_user_account(owner_id NUMBER, owned_account_id NUMBER, error_code OUT NUMBER) AS
    -- We can't do IF EXISTS for whatever reason, so let's just count the number
    -- of matching users and accounts.
    match_users NUMBER;
    match_accounts NUMBER;
    -- We also check to see if the association already exists.
    match_user_accounts NUMBER;
BEGIN
    -- Get the matching numbers of users and accounts (either 0 or 1 in any case).
    SELECT COUNT(*) INTO match_users FROM bank_user WHERE user_id = owner_id;
    SELECT COUNT(*) INTO match_accounts FROM account WHERE account_id = owned_account_id;
    SELECT COUNT(*) INTO match_user_accounts FROM user_account WHERE user_id = owner_id AND account_id = owned_account_id;

    IF match_users = 0 THEN
        error_code := 1;
    ELSIF match_accounts = 0 THEN
        error_code := 2;
    ELSIF match_user_accounts = 1 THEN
        error_code := 3;
    ELSE
        INSERT INTO user_account(user_id, account_id) VALUES(owner_id, owned_account_id);
        error_code := 0;
    END IF;
END;
/
