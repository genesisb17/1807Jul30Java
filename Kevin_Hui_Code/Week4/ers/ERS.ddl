DROP USER c##projectone CASCADE;

CREATE USER c##projectone
IDENTIFIED BY B4Dp4ssw0rd4641N
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to c##projectone;
GRANT resource to c##projectone;
GRANT create session TO c##projectone;
GRANT create table TO c##projectone;
GRANT create view TO c##projectone;

conn c##projectone/B4Dp4ssw0rd4641N

CREATE TABLE ers_reimbursement (
    reimb_id           NUMBER NOT NULL,
    reimb_amount        NUMBER NOT NULL,
    reimb_submitted     TIMESTAMP NOT NULL,
    reimb_resolved      TIMESTAMP,
    reimb_description   VARCHAR2(250),
    reimb_recipt        BLOB,
    reimb_author        NUMBER NOT NULL,
    reimb_resolver      NUMBER,
    reimb_status_id     NUMBER NOT NULL,
    reimb_type_id       NUMBER NOT NULL
);

ALTER TABLE ers_reimbursement ADD CONSTRAINT ers_reimbursement_pk PRIMARY KEY ( reimb__id );

CREATE TABLE ers_reimbursement_status (
        reimb_status_id   NUMBER NOT NULL,
    reimb_status      VARCHAR2(10) NOT NULL
);

ALTER TABLE ers_reimbursement_status ADD CONSTRAINT reimb_status_pk PRIMARY KEY ( reimb_status_id );

CREATE TABLE ers_reimbursement_type (
    reimb_type_id   NUMBER NOT NULL,
    reimb_type      VARCHAR2(10) NOT NULL
);

ALTER TABLE ers_reimbursement_type ADD CONSTRAINT reimb_type_pk PRIMARY KEY ( reimb_type_id );

CREATE TABLE ers_user_roles (
    ers_user_role_id   NUMBER NOT NULL,
    user_role          VARCHAR2(20) NOT NULL
);

ALTER TABLE ers_user_roles ADD CONSTRAINT ers_user_roles_pk PRIMARY KEY ( ers_user_role_id );

CREATE TABLE ers_users (
    ers_user_id       NUMBER NOT NULL,
    ers_username      VARCHAR2(50) NOT NULL,
    ers_password      VARCHAR2(50) NOT NULL,
    user_first_name   VARCHAR2(100) NOT NULL,
    user_last_name    VARCHAR2(100) NOT NULL,
    user_email        VARCHAR2(150) NOT NULL,
    user_role_id      NUMBER NOT NULL
);

ALTER TABLE ers_users ADD CONSTRAINT ers_users_pk PRIMARY KEY ( ers_user_id );

ALTER TABLE ers_users ADD CONSTRAINT ers_users__unv1 UNIQUE ( ers_username,
                                                              user_email );

ALTER TABLE ers_reimbursement
    ADD CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY ( reimb_type_id )
        REFERENCES ers_reimbursement_status ( reimb_status_id );

ALTER TABLE ers_reimbursement
    ADD CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY ( reimb_status_id )
        REFERENCES ers_reimbursement_type ( reimb_type_id );

ALTER TABLE ers_reimbursement
    ADD CONSTRAINT ers_users_fk_auth FOREIGN KEY ( reimb_author )
        REFERENCES ers_users ( ers_user_id );

ALTER TABLE ers_reimbursement
    ADD CONSTRAINT ers_users_fk_reslvr FOREIGN KEY ( reimb_resolver )
        REFERENCES ers_users ( ers_user_id );

ALTER TABLE ers_users
    ADD CONSTRAINT user_roles_fk FOREIGN KEY ( user_role_id )
        REFERENCES ers_user_roles ( ers_user_role_id );

CREATE SEQUENCE ers_reimbursement_status_reimb START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER ers_reimbursement_status_reimb BEFORE
    INSERT ON ers_reimbursement_status
    FOR EACH ROW
    WHEN ( new.reimb_status_id IS NULL )
BEGIN
    :new.reimb_status_id := ers_reimbursement_status_reimb.nextval;
END;
/

CREATE SEQUENCE ers_reimbursement_type_reimb_t START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER ers_reimbursement_type_reimb_t BEFORE
    INSERT ON ers_reimbursement_type
    FOR EACH ROW
    WHEN ( new.reimb_type_id IS NULL )
BEGIN
    :new.reimb_type_id := ers_reimbursement_type_reimb_t.nextval;
END;
/

CREATE SEQUENCE ers_user_roles_ers_user_role_i START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER ers_user_roles_ers_user_role_i BEFORE
    INSERT ON ers_user_roles
    FOR EACH ROW
    WHEN ( new.ers_user_role_id IS NULL )
BEGIN
    :new.ers_user_role_id := ers_user_roles_ers_user_role_i.nextval;
END;
/

CREATE SEQUENCE ers_users_ers_user_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER ers_users_ers_user_id_trg BEFORE
    INSERT ON ers_users
    FOR EACH ROW
    WHEN ( new.ers_user_id IS NULL )
BEGIN
    :new.ers_user_id := ers_users_ers_user_id_seq.nextval;
END;
/

-- Populating certain data

INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) VALUES ('Pending');
INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) VALUES ('Approved');
INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) VALUES ('Denied');

INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE) VALUES ('Lodging');
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE) VALUES ('Travel');
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE) VALUES ('Food');
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE) VALUES ('Equipment');
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE) VALUES ('Other');

INSERT INTO ERS_USER_ROLES (USER_ROLE) VALUES ('System Admin');
INSERT INTO ERS_USER_ROLES (USER_ROLE) VALUES ('Finance Manager');
INSERT INTO ERS_USER_ROLES (USER_ROLE) VALUES ('Employee');

INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
    VALUES ('admin', 'bigboiadmin', 'SYSTEM', 'ADMIN', 'no@email.com', 1);

COMMIT;
EXIT;
