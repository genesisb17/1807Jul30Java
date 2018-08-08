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
insert into genre (name) values('history');







