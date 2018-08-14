/*
-- BOOKSTORE DDL SCRIPT

CREATE TABLE Book_Genre
(
    -- [colName] [dataType] [Optional Constraints]
    Genre_ID number(10) PRIMARY KEY,
    Name varchar2(256) unique not null
);

CREATE TABLE Book
(
    Book_ID number(10) PRIMARY KEY,
    ISBN varchar2(10) UNIQUE NOT NULL,
    Title varchar2(256) NOT NULL,
    Price number(6,2) NOT NULL,    -- number(6,2) means 6 digits (2 of them decimals)
    Genre_ID number(10),
    CONSTRAINT fk_book_genre FOREIGN KEY(Genre_ID)
      REFERENCES genre(genre_id)
);

CREATE TABLE Author
( -- authorid, fn, lastname, biography
    Author_ID number(10) PRIMARY KEY,
    First_name varchar2 (50) NOT NULL,
    Last_name varchar2(50),   -- can be null
    Bio varchar2(1000)
);

-- JUNCTION TABLE. COLUMNS ARE BOTH PK AND FK
CREATE TABLE Book_Author
(
    Book_ID number(10),
    Author_ID number(10),
    PRIMARY KEY (Book_ID, Author_ID),
    foreign key (Book_ID) references book(Book_ID),
    foreign key (Author_ID) references authors(Author_ID)
);



----------Sequences----------
CREATE SEQUENCE book_seq;

-- This is what happens behind the scenes when a sequences is generated with all default values
CREATE SEQUENCE "DEMO1807JUL30JAVA"."BOOK_SEQ"
MINVALUE 1
MAXVALUE 99999999999999999  -- some large value (this isn't it exactly)
INCREMENT BY 1
START WITH 1
CACHE 20 NOORDER NOCYCLE NOPARTITION;

CREATE SEQUENCE author_seq
minvalue 1
start with 1
increment by 5
cache 5;  -- how many values will be stored in memory for faster access


----------TRIGGERS
CREATE OR REPLACE TRIGGER b_seq_trig  -- declare and name trigger
before insert on book -- when will trigger execute
for each row  -- necessary to change value of table;
begin
  -- what to do when trigger is fired
  select book_seq.nextVal into :new.book_id from dual;
end;
/

CREATE OR REPLACE TRIGGER a_seq_trig
before insert on author
for each row
begin
  select author_seq.nextVal into :new.author_id from dual;
end;
/

----------ABOUT DUAL
select * from DUAL;
select SYSDATE from DUAL;




--------------------DML Stuff

select * from book_genre;
insert into book_genre (name) values('Sci-Fi');
insert into book_genre (name) values('History');
insert into book_genre (name) values('Romance');
insert into book_genre (name) values('Action');
insert into book_genre (name) values('Non-Fiction');
insert into book_genre (name) values('Fiction');
insert into book_genre (name) values('Home/Cooking');

rollback;
*/

--BOOKSTORE DDL SCRIPT

CREATE TABLE Genre
(
      --  colName  dataType  Optional Constraints
          Genre_Id number(10) PRIMARY KEY,
          Name varchar2(256) unique not null
);

CREATE TABLE Book
(
        Book_Id number(10) PRIMARY KEY,
        ISBN varchar2(10) UNIQUE NOT NULL,
        Title varchar2(256) NOT NULL,
        Price number(6,2) NOT NULL,
        Genre_Id number(10),
        CONSTRAINT fk_book_genre FOREIGN KEY(Genre_id)
               REFERENCES genre(genre_id)
);

CREATE TABLE Author
( -- authorid, fn, lastname, biography
        Author_Id number(10) PRIMARY KEY,
        First_Name varchar2(50) NOT NULL,
        Last_Name varchar2(50),
        Bio varchar2(1000)
);
---JUNCTION TABLE. COLUMNS ARE BOTH PK AND FK
CREATE TABLE Book_Author
(
      Book_Id number(10),
      Author_Id number(10),
      Primary Key (Book_id, Author_Id),
      foreign key (Book_id) references book(Book_id),
      foreign key (author_id) references author(author_id)
);

-------------------------------- Sequences-----------------------
CREATE SEQUENCE book_seq;

-- This is what happens behind the scenes when a sequence is generated with all default params
   CREATE SEQUENCE  "DEMO1807JUL30JAVA"."BOOK_SEQ" 
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999 
   INCREMENT BY 1 
   START WITH 1 
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;

DROP SEQUENCE a;

CREATE sequence genre_seq;

CREATE SEQUENCE author_seq
minvalue 1
start with 5
increment by 5
cache 5; -- how many values will be stored in memory for faster access

------------- TRIGGERS
CREATE OR REPLACE TRIGGER b_seq_trig -- declare and name trigger
before insert on book -- when will trigger execute
for each row -- necessary to change value of table
begin 
    -- what to do when trigger is fired
    select book_seq.nextVal into :new.book_id from dual;
end;
/

CREATE OR REPLACE TRIGGER a_seq_trig 
before insert on author
for each row 
begin 
    select author_seq.nextVal into :new.author_id from dual;
end;
/

CREATE OR REPLACE TRIGGER g_seq_trig 
before insert on genre
for each row 
begin 
    select genre_seq.nextVal into :new.genre_id from dual;
end;
/

-------- ABOUT DUAL
select * from DUAL;
select SYSDATE from DUAL;


--------------------------------------------- DML Stuff ...

select * from genre;
insert into genre (name) values('Sci-Fi');
insert into genre (name) values('History');
insert into genre (name) values('Romance');
insert into genre (name) values('Action');
insert into genre (name) values('Non-Fiction');
insert into genre (name) values('Fiction');
insert into genre (name) values('Home/Cooking');
commit;

----------------------PL/SQL

/* CURSORS
  - Oracle creates a context area with all information necessary for processing
    an SQL statement
  - a Cursor is a pointer to the context area
  - the "active set" is the row(s) returned by a statement and is held by the
    cursor
  - there are two types: implicit and explicit
  --> Implicit - created by oracle whenever we execute a DML statement (and no
      explicit cursor on the set exists)
  --> Explicit - programmer defined, as seen below, is used for obtaining more
      control over context area
  --> DECLARE cursor to initialize memory
  --> OPEN cursor to allocate memor
  --> FETCH to retrieve data
  --> CLOSE cursor to release memory
*/

-- create a proc to return all books
create or replace procedure get_all_books(cp OUT SYS_REFCURSOR)
IS
BEGIN
  open cp FOR select * from book;
END;
/

