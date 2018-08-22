/****************************************************************************
    DROP AND CREATE DATABASE
****************************************************************************/

DROP USER ers_database CASCADE;

CREATE USER ers_database
IDENTIFIED BY admin;

GRANT CONNECT TO ers_database;
GRANT RESOURCE TO ers_database;

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
    reimb_amount NUMBER,
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

CREATE TABLE ers_user_roles (
    ers_user_role_id NUMBER,
    user_role VARCHAR2(32)
);

/****************************************************************************
    SEQUENCES
****************************************************************************/

/****************************************************************************
    TRIGGERS
****************************************************************************/

/****************************************************************************
    TABLE CONSTRAINTS
****************************************************************************/



/****************************************************************************
    FUNCTIONS
****************************************************************************/



/****************************************************************************
    PROCEDURES
****************************************************************************/



/****************************************************************************
    POPULATE TABLES
****************************************************************************/