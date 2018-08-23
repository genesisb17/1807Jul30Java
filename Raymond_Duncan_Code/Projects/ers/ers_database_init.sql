/****************************************************************************
    DROP AND CREATE DATABASE
****************************************************************************/

DROP USER ers_database CASCADE;

CREATE USER ers_database
IDENTIFIED BY admin;

GRANT CONNECT TO ers_database;
GRANT RESOURCE TO ers_database;

CONNECT ers_database/admin;
/****************************************************************************
    CREATE TABLES
****************************************************************************/

CREATE TABLE ers_user (
    ers_user_id NUMBER,
    ers_username VARCHAR2(16),
    ers_password VARCHAR2(32),
    ers_firstname VARCHAR2(32),
    ers_lastname VARCHAR2(32),
    ers_email VARCHAR(64),
    ers_company_role NUMBER
);

CREATE TABLE ers_reimbursement (
    reimb_id NUMBER,
    reimb_amount NUMBER(15,2),
    reimb_submitted TIMESTAMP,
    reimb_resolved TIMESTAMP,
    reimb_description VARCHAR(512),
    reimb_receipt BLOB,
    reimb_author NUMBER,
    reimb_resolver NUMBER,
    reimb_status_id NUMBER,
    reimb_type_id NUMBER
);

CREATE TABLE ers_reimbursement_status (
    reimb_status_id NUMBER,
    reimb_status VARCHAR2(16)
);

CREATE TABLE ers_reimbursement_type (
    reimb_type_id NUMBER,
    reimb_type VARCHAR2(16)
);

CREATE TABLE ers_user_role (
    ers_user_role_id NUMBER,
    user_role VARCHAR2(32)
);

/****************************************************************************
    SEQUENCES
****************************************************************************/

CREATE SEQUENCE ers_user_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ers_reimb_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ers_status_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ers_reimb_type_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ers_user_role_id_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

/****************************************************************************
    TRIGGERS
****************************************************************************/

CREATE OR REPLACE TRIGGER ers_user_id_trig
BEFORE INSERT ON ers_user
FOR EACH ROW
BEGIN
    SELECT ers_user_id_seq.nextVal INTO :new.ers_user_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ers_reimb_id_trig
BEFORE INSERT ON ers_reimbursement
FOR EACH ROW
BEGIN
    SELECT ers_reimb_id_seq.nextVal INTO :new.reimb_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ers_status_id_trig
BEFORE INSERT ON ers_reimbursement_status
FOR EACH ROW
BEGIN
    SELECT ers_status_id_seq.nextVal INTO :new.reimb_status_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ers_reimb_type_id_trig
BEFORE INSERT ON ers_reimbursement_type
FOR EACH ROW
BEGIN
    SELECT ers_reimb_type_id_seq.nextVal INTO :new.reimb_type_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ers_user_role_id_trig
BEFORE INSERT ON ers_user_role
FOR EACH ROW
BEGIN
    SELECT ers_user_role_id_seq.nextVal INTO :new.ers_user_role_id FROM DUAL;
END;
/


/****************************************************************************
    TABLE CONSTRAINTS
****************************************************************************/



/****************************************************************************
    FUNCTIONS
****************************************************************************/



/****************************************************************************
    PROCEDURES
****************************************************************************/

CREATE OR REPLACE PROCEDURE quick_populate_ers_users
AS
BEGIN
    INSERT INTO ers_user VALUES(NULL,'rayd123','password','Raymond','Duncan','raydunc@gmail.com',1);
    INSERT INTO ers_user VALUES(NULL,'mrt123','pitydafoo','Laurence','Tureaud','mrt@ateam.go',4);
    INSERT INTO ers_user VALUES(NULL,'notoriousb','bigpoppa','Chris','Wallace','biggie@uptown.com',2);
    INSERT INTO ers_user VALUES(NULL,'elonthemusky1','grimes','Elon','Musk','emusk@tsla.wow',3);
    INSERT INTO ers_user VALUES(NULL,'lennyd44','finallygotthatoscar','Leonardo','DiCaprio','actuallycares@world.us',2);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE quick_populate_reimbs
AS
BEGIN
    INSERT INTO ers_reimbursement VALUES(NULL,40,CURRENT_TIMESTAMP,NULL,'Its cause Im dead homie',NULL,3,NULL,1,6);
    INSERT INTO ers_reimbursement VALUES(NULL,5,CURRENT_TIMESTAMP,NULL,'High five!',NULL,1,NULL,2,6);
    INSERT INTO ers_reimbursement VALUES(NULL,10,CURRENT_TIMESTAMP,NULL,'For each of the commandments',NULL,3,NULL,1,6);
    INSERT INTO ers_reimbursement VALUES(NULL,1000000000,CURRENT_TIMESTAMP,NULL,'Im sending us to Mars. Need some funds though',NULL,4,1,2,6);
    INSERT INTO ers_reimbursement VALUES(NULL,50,CURRENT_TIMESTAMP,NULL,'For the movies',NULL,5,1,3,6);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE quick_populate_reimb_statuses
AS
BEGIN
    INSERT INTO ers_reimbursement_status VALUES(NULL,'PENDING');
    INSERT INTO ers_reimbursement_status VALUES(NULL,'REJECTED');
    INSERT INTO ers_reimbursement_status VALUES(NULL,'APPROVED');
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE quick_populate_reimb_types
AS
BEGIN
    INSERT INTO ers_reimbursement_type VALUES(NULL,'LODGING');
    INSERT INTO ers_reimbursement_type VALUES(NULL,'TRAVEL');
    INSERT INTO ers_reimbursement_type VALUES(NULL,'FOOD');
    INSERT INTO ers_reimbursement_type VALUES(NULL,'SUPPLIES');
    INSERT INTO ers_reimbursement_type VALUES(NULL,'EDUCATION');
    INSERT INTO ers_reimbursement_type VALUES(NULL,'OTHER');
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE quick_populate_user_roles
AS
BEGIN
    INSERT INTO ers_user_role VALUES(NULL,'CEO');
    INSERT INTO ers_user_role VALUES(NULL,'CHIEF ENTERTAINER');
    INSERT INTO ers_user_role VALUES(NULL,'VISIONARY ENGINEER');
    INSERT INTO ers_user_role VALUES(NULL,'HEAD OF SECURITY');
    COMMIT;
END;
/

/****************************************************************************
    POPULATE TABLES
****************************************************************************/


/****************************************************************************
    DISCONNECT
****************************************************************************/

COMMIT;
EXIT;

