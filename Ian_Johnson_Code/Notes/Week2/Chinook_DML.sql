-- DML: Data Manipulation Language
-- Includes CRUD functions: INSERT, SELECT, UPDATE, DELETE

INSERT INTO ARTIST (ARTISTID, NAME) VALUES (276, 'Beethoven');

INSERT INTO ARTIST (ARTISTID, NAME) VALUES (
    (SELECT MAX(ARTISTID) + 1 FROM ARTIST),
    'Ian'
);

SAVEPOINT TEST;

DELETE FROM ARTIST WHERE NAME = 'Ian';

ROLLBACK TO TEST;

UPDATE ARTIST
SET NAME = 'Beyonce'
WHERE NAME = 'Ian';

SELECT * FROM ARTIST;

-- TCL intro:
COMMIT; -- Always commit upon successful DB transactions (i.e. any insert, update or delete)!