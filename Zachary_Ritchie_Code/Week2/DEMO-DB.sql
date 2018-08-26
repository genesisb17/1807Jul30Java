-- REQUIRED FOR AUTHENTICATION
CREATE TABLE example_users 
(
    username VARCHAR2(40), 
    password VARCHAR2(40) NOT NULL,
    CONSTRAINT pk_example_users_username PRIMARY KEY (username)
);

-- DATA THAT WILL GET RETURNED AFTER AUTHENTICATION
CREATE TABLE example_user_information
(
    username VARCHAR2(40), 
    firstname VARCHAR2(40),
    lastname VARCHAR2(40),
    email VARCHAR2(40),
    CONSTRAINT pk_example_ui_username PRIMARY KEY (username),
    CONSTRAINT fk_example_users_ui FOREIGN KEY (username) 
                                   REFERENCES example_users (username)
                                   ON DELETE CASCADE
);

-- NEVER STORE YOUR PASSWORDS IN PLAIN TEXT
-- HASHING FUNCTION THAT COMBINES USERNAME, PASSWORD AND A SPECIAL WORD 
CREATE OR REPLACE FUNCTION GET_USER_HASH(USERNAME VARCHAR2, PASSWORD VARCHAR2) RETURN VARCHAR2
IS
EXTRA VARCHAR2(10) := 'SALT';
BEGIN
  RETURN TO_CHAR(DBMS_OBFUSCATION_TOOLKIT.MD5(
  INPUT => UTL_I18N.STRING_TO_RAW(DATA => USERNAME || PASSWORD || EXTRA)));
END;
/

-- INSERT USER PROCEDURE
CREATE OR REPLACE PROCEDURE insert_user(
            new_username IN VARCHAR2, 
            new_password IN VARCHAR2,
            new_firstname IN VARCHAR2,
            new_lastname IN VARCHAR2,
            new_email IN VARCHAR2)
AS
BEGIN
    insert into example_users VALUES (new_username, new_password);
    insert into example_user_information VALUES (new_username, new_firstname, new_lastname, new_email);
    COMMIT;
END;
/

-- BEFORE TRIGGER THAT HASHES USER PASSWORD
CREATE OR REPLACE TRIGGER before_insert_user
BEFORE INSERT
ON example_users
FOR EACH ROW 
BEGIN 
    SELECT GET_USER_HASH(:new.username, :new.password) INTO :new.password FROM dual;
END;
/