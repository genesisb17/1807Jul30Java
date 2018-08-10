-- Let's create a bookstore database to explore the DDL.
CREATE TABLE genre (
    -- [column name] [data type] [optional constraints]
    genre_id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(256) UNIQUE NOT NULL
);

CREATE TABLE book (
    book_id NUMBER(10) PRIMARY KEY,
    isbn VARCHAR2(10) UNIQUE NOT NULL, -- No commas between constraints.
    title VARCHAR2(256) NOT NULL,
    price NUMBER(6, 2) NOT NULL,
    genre_id NUMBER(10),
    -- This is how we create a foreign key relationship using a named constraint.
    CONSTRAINT fk_book_genre FOREIGN KEY(genre_id) REFERENCES genre(genre_id)
);

CREATE TABLE author (
    author_id NUMBER(10) PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50),
    bio VARCHAR2(1000)
);

-- Junction table. The columns are both primary keys (as a composite key) and foreign keys.
CREATE TABLE book_author (
    book_id NUMBER(10),
    author_id NUMBER(10),
    -- We need to create a composite key here. In this case, we don't name the constraint.
    PRIMARY KEY(book_id, author_id),
    -- And here are the foreign key specifications.
    FOREIGN KEY(book_id) REFERENCES book(book_id),
    FOREIGN KEY(author_id) REFERENCES author(author_id)
);

-- We will use sequences to automate primary keys.
CREATE SEQUENCE book_seq;
-- There are some other options you can use when creating a sequence:
CREATE SEQUENCE author_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 20; -- How many values will be stored in memory for faster access.

CREATE SEQUENCE genre_seq;
-- Note that you can't CREATE OR REPLACE a sequence; you must DROP and then CREATE.

-- The sequences above can be used alongside triggers.
CREATE OR REPLACE TRIGGER b_seq_trig -- Name of trigger
BEFORE INSERT ON book -- When trigger will execute
FOR EACH ROW -- Necessary to change value of table
BEGIN
    -- What to do when trigger is fired
    SELECT book_seq.NEXTVAL INTO :NEW.book_id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER a_seq_trig
BEFORE INSERT ON author
FOR EACH ROW
BEGIN
    SELECT author_seq.NEXTVAL INTO :NEW.author_id FROM dual;
END;
/

CREATE OR REPLACE TRIGGER g_seq_trig
BEFORE INSERT ON genre
FOR EACH ROW
BEGIN
    SELECT genre_seq.NEXTVAL INTO :NEW.genre_id FROM dual;
END;
/

-- About DUAL: DUAL is a dummy table that exists so that you don't break syntax when selecting something that doesn't
-- come from a table (such as getting the next value of a sequence).
SELECT * FROM dual;
SELECT sysdate FROM dual;

-- Add some data to the tables.
INSERT INTO genre (name) VALUES ('Fantasy');
INSERT INTO author (first_name, last_name) VALUES ('John', 'Tolkien');
INSERT INTO book (isbn, title, price, genre_id) VALUES (
    '0261102354',
    'The Fellowship of the Ring',
    9.99,
    (SELECT genre_id FROM genre WHERE name = 'Fantasy')
);
INSERT INTO book_author (book_id, author_id) VALUES (
    (SELECT book_id FROM book WHERE title = 'The Fellowship of the Ring'),
    (SELECT author_id FROM author WHERE last_name = 'Tolkien')
);

INSERT INTO book (isbn, title, price, genre_id) VALUES (
    '0618002235',
    'The Two Towers',
    9.99,
    (SELECT genre_id FROM genre WHERE name = 'Fantasy')
);
INSERT INTO book_author (book_id, author_id) VALUES (
    (SELECT book_id FROM book WHERE title = 'The Two Towers'),
    (SELECT author_id FROM author WHERE last_name = 'Tolkien')
);
INSERT INTO book (isbn, title, price, genre_id) VALUES (
    '0345339738',
    'The Return of the King',
    9.99,
    (SELECT genre_id FROM genre WHERE name = 'Fantasy')
);
INSERT INTO book_author (book_id, author_id) VALUES (
    (SELECT book_id FROM book WHERE title = 'The Return of the King'),
    (SELECT author_id FROM author WHERE last_name = 'Tolkien')
);

SELECT author.last_name, book.title
FROM author
JOIN book
ON EXISTS
    (SELECT * FROM book_author WHERE book_author.author_id = author.author_id AND book_author.book_id = book.book_id);

-- PL/SQL stuff

-- Oracle creates a context area with all information necessary for processing an SQL statement.
-- A cursor is a pointer to this context area.
-- The "active set" is the row(s) returned by a statement and is held by the cursor.
-- There are two types of cursor: implicit and explicit.
-- Implicit cursors are created by Oracle whenever we execute a DML statement and no explicit cursor on the set exists.
-- Explicit cursors are programmer-defined, and are used for obtaining more control over the context area.
-- -- We must DECLARE a cursor to initialize the memory, OPEN cursor to allocate memory, FETCH cursor to retrive data and then CLOSE it.

-- Create a procedure to return all books.
CREATE OR REPLACE PROCEDURE get_all_books(
    cursor_param OUT SYS_REFCURSOR -- We have a cursor as an output parameter.
) IS
BEGIN
    OPEN cursor_param FOR
    SELECT * FROM book;
END;
/