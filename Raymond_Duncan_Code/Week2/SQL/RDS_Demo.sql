--BOOKSTORE DDL SCRIPT

CREATE TABLE Genre(
    --[colName] [datatype] [Optional Constraints]
    Genre_ID number(10) PRIMARY KEY,
    Name varchar2(256) UNIQUE NOT NULL
);

CREATE TABLE Book
(
    Book_ID number(10) PRIMARY KEY,
    ISBN varchar2(10) UNIQUE NOT NULL,
    Title varchar2(256) NOT NULL,
    Price number(8,2) NOT NULL,
    Genre_ID number(10),
    
    CONSTRAINT fk_book_genre FOREIGN KEY(Genre_ID)
        REFERENCES genre(genre_id)
);

--needs authorid, firstname, lastname, bio
CREATE TABLE Author
(
    Author_ID number(10) PRIMARY KEY,
    First_Name varchar2(256) NOT NULL,
    Last_Name varchar2(256),
    Biography varchar2(2048)
);

--Junction table for Book-Author N:N relationship
CREATE TABLE Book_Author
(
    Book_ID number(10),
    Author_ID number(10),
    Primary Key(Book_ID,Author_ID),
    Foreign Key(Book_ID) REFERENCES book(Book_ID),
    Foreign Key(Author_ID) REFERENCES author(author_id)
);

------------ Sequences ------------
CREATE SEQUENCE book_seq;
CREATE SEQUENCE genre_seq;

-- This is what happens benind the scenes when a sequences is generated
CREATE SEQUENCE author_seq
minvalue 1
start with 5
increment by 5
cache 5; --How many values will be stored in memory


--------- TRIGGERS ---------
CREATE OR REPLACE TRIGGER b_seq_trig -- declare and name trigger
before insert on book --when trigger will execute
for each row -- necessary to change value of table
begin
    --What to do when trigger is fired
    select book_seq.nextVal into :new.book_id from dual;
end;
/ --Indicates that an expression with multiple semicolons is done

CREATE OR REPLACE TRIGGER a_seq_trig -- declare and name trigger
before insert on author --when trigger will execute
for each row -- necessary to change value of table
begin
    --What to do when trigger is fired
    select author_seq.nextVal into :new.author_id from dual;
end;
/

CREATE OR REPLACE TRIGGER g_seq_trig -- declare and name trigger
before insert on genre --when trigger will execute
for each row -- necessary to change value of table
begin
    --What to do when trigger is fired
    select genre_seq.nextVal into :new.genre_id from dual;
end;
/

--------- ABOUT DUAL ---------
select * from DUAL;
select SYSDATE from DUAL;


------------ DML Stuff ------------

--Add some genres
select * from genre;
insert into genre(name) values('Sci-Fi');
insert into genre(name) values('Romance');
insert into genre(name) values('Fantasy');
insert into genre(name) values('Action');
insert into genre(name) values('Non-Fiction');
insert into genre(name) values('Fiction');
insert into genre(name) values('Mystery');
insert into genre(name) values('History');
insert into genre(name) values('history'); -- Things in quotes are case sensitive. We don't need two history values
delete from genre where name = 'history'; --So let's delete it
insert into genre(name) values('Horror'); 
insert into genre(name) values('Horror');
insert into genre(name) values('Cooking'); -- Notice how the id for this skips the next element. That's because we need to handle it as well

commit;


--Add some books
--Book_ID number(10) PRIMARY KEY, ISBN varchar2(10) UNIQUE NOT NULL, Title varchar2(256) NOT NULL, Price number(8,2) NOT NULL, Genre_ID number(10),



------------------ PL/SQL
/*
    -Oracle creates a context area with all information necessary for processing an SQL statement
    -A cursor is a pointer to the context area
    - the "active set" is the row(s) returned by a statement and is held by the cursor
    - there are two types: implicit and explicit
        + Implicit: created by oracle whenever when we execute a DML statemetn( and no explicit cursor on the set exists)
        + Explicit: programmer defined, as seen below, and is used for obtaining more control over the context area. One must:
            DECLARE  cursor to initialize memory
            OPEN cursor to allocate memory
            FETCH cursor to retrieve data
            CLOSE cursor to release memory
            
*/

-- create a process to return all books
CREATE OR REPLACE PROCEDURE get_all_books(cursorParam OUT SYS_REFCURSOR)IS
BEGIN
    OPEN cursorParam FOR SELECT * INTO cursorParam FROM book;
    
END;
/

-- Create a process to return all genres
CREATE OR REPLACE PROCEDURE get_all_genres(cursorParam OUT SYS_REFCURSOR) AS
BEGIN
    OPEN cursorParam FOR SELECT * FROM genre;
END;
/
--DECLARE my_cursor SYS_REFCURSOR;

--EXECUTE get_all_genres(my_cursor);
--SELECT * FROM my_cursor;
--
--
--EXECUTE get_all_books();

INSERT INTO book VALUES(NULL,1234567890,'The Best Book', 9.99, 1);
INSERT INTO book VALUES(NULL,9876554345,'Jhonnnys Wonderful World', 9.99, 5);
INSERT INTO book VALUES(NULL,4567898765,'Pizza Land', 9.99, 1);
INSERT INTO book VALUES(NULL,2934769473,'The Kendrick Lamar Anthology', 99.99, 7);
INSERT INTO book VALUES(NULL,1919367593,'Which which', 15, 1);
INSERT INTO book VALUES(NULL,5879342809,'Something from Nothing', 90, 8);

COMMIT;


select * from book;

