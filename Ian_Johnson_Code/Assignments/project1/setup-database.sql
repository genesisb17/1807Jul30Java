-- To completely set up an empty database for the project, run the commands in
-- this file as your database's admin.

DROP USER ers CASCADE;

CREATE USER ers IDENTIFIED BY password;
GRANT CONNECT TO ers;
GRANT RESOURCE TO ers;

CONN ers/password;

-- This ends the user setup; the commands from here on out are run as the ers
-- user.

CREATE TABLE reimbursement_status (
    id NUMBER(10, 0) PRIMARY KEY,
    status VARCHAR2(16) UNIQUE NOT NULL
);

-- These values are meant to be constants, and the status strings descriptions
-- of the constants which are effectively documentation.
INSERT INTO reimbursement_status VALUES(1, 'Pending');
INSERT INTO reimbursement_status VALUES(2, 'Approved');
INSERT INTO reimbursement_status VALUES(3, 'Denied');

CREATE TABLE reimbursement_type (
    id NUMBER(10, 0) PRIMARY KEY,
    type VARCHAR2(16) UNIQUE NOT NULL
);

INSERT INTO reimbursement_type VALUES(1, 'Lodging');
INSERT INTO reimbursement_type VALUES(2, 'Travel');
INSERT INTO reimbursement_type VALUES(3, 'Food');
INSERT INTO reimbursement_type VALUES(4, 'Other');

CREATE TABLE user_role (
    id NUMBER(10, 0) PRIMARY KEY,
    role VARCHAR2(16) UNIQUE NOT NULL
);

INSERT INTO user_role VALUES(1, 'Employee');
INSERT INTO user_role VALUES(2, 'Manager');

-- The awkward name of this table is because we can't call a table "user".
CREATE TABLE ers_user (
    id NUMBER(10, 0) PRIMARY KEY,
    role NUMBER(10, 0) NOT NULL REFERENCES user_role(id),
    username VARCHAR2(50) UNIQUE NOT NULL,
    first_name VARCHAR2(100) NOT NULL,
    last_name VARCHAR2(100) NOT NULL,
    email VARCHAR2(150) NOT NULL,
    password_salt RAW(16) NOT NULL,
    password_hash RAW(16) NOT NULL
);

-- User IDs are generated from a sequence.
CREATE SEQUENCE seq_user_id;

-- This trigger is what actually generates the user ID.
CREATE OR REPLACE TRIGGER trig_gen_user_id
BEFORE INSERT ON ers_user
FOR EACH ROW
BEGIN
    SELECT seq_user_id.NEXTVAL INTO :NEW.id FROM dual;
END;
/

CREATE TABLE reimbursement (
    id NUMBER(10, 0) PRIMARY KEY,
    type NUMBER(10, 0) NOT NULL REFERENCES reimbursement_type(id),
    status NUMBER(10, 0) NOT NULL REFERENCES reimbursement_status(id),
    amount NUMBER(10, 2) NOT NULL CHECK (amount > 0),
    description VARCHAR2(500),
    receipt BLOB,
    author NUMBER(10, 0) NOT NULL REFERENCES ers_user(id),
    resolver NUMBER(10, 0) REFERENCES ers_user(id),
    submitted TIMESTAMP WITH TIME ZONE NOT NULL,
    resolved TIMESTAMP WITH TIME ZONE,
    -- The resolver and resolved date must either both be null or both be not
    -- null.
    CHECK ((resolver IS NULL AND resolved IS NULL) OR
           (resolver IS NOT NULL AND resolved IS NOT NULL))
);

CREATE SEQUENCE seq_reimbursement_id;

CREATE OR REPLACE TRIGGER trig_gen_reimbursement_id
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
    SELECT seq_reimbursement_id.NEXTVAL INTO :NEW.id FROM dual;
END;
/

-- Submits a new reimbursement with the given information.
CREATE OR REPLACE PROCEDURE proc_submit_reimbursement(
    type IN NUMBER,
    amount IN NUMBER,
    description IN VARCHAR2,
    author IN NUMBER,
    submitted_timestamp OUT TIMESTAMP WITH TIME ZONE,
    new_id OUT NUMBER,
    num_affected OUT NUMBER
) AS
BEGIN
    submitted_timestamp := SYSTIMESTAMP;
    INSERT INTO reimbursement (
        type,
        status,
        amount,
        description,
        author,
        submitted
    ) VALUES (
        type,
        1, -- Pending
        amount,
        description,
        author,
        submitted_timestamp
    ) RETURNING id INTO new_id;
    num_affected := SQL%ROWCOUNT;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/

-- Resolves the reimbursement request with the given ID, giving it the given
-- status and resolver.
CREATE OR REPLACE PROCEDURE proc_resolve_reimbursement(
    reimbursement_id IN NUMBER,
    new_status IN NUMBER,
    resolver_id IN NUMBER,
    resolved_timestamp OUT TIMESTAMP WITH TIME ZONE,
    num_affected OUT NUMBER
) AS
BEGIN
    resolved_timestamp := SYSTIMESTAMP;
    UPDATE reimbursement SET
        status = new_status,
        resolver = resolver_id,
        resolved = resolved_timestamp
    WHERE id = reimbursement_id;
    num_affected := SQL%ROWCOUNT;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/
