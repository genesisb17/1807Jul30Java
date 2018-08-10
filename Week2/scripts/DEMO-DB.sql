--Bookstore DDL script

CREATE TABLE Genre
(
  Genre_id number(10)PRIMARY KEY,
  NAME varchar2(256) UNIQUE NOT NULL
);

CREATE TABLE Books
(
  Book_id number(10) PRIMARY KEY,
  ISB varchar2(10) UNIQUE NOT NULL,
  Title varchar2(256) NOT NULL,
  Price number(6, 2), -- 6 digit 2 are decimals
  Genre_id number(10),
  constraint fk_book_genre foreign key (Genre_id) references genre(genre_id)
);

Create Table Author 
( --authorid, firstname, lastname, bio
  Author_id number(10) primary key,
  Firstname varchar2(50) not null,
  Lastname varchar2(50),
  Bio varchar2(1000) 
);

--junction table columns are both pk and fk
select * from book_author;
create table Book_Author
(
  Book_id number(10),
  Author_id number(10),
  primary key (Book_id, Author_id),
  foreign key (Book_id) references books(Book_id),
  foreign key (Author_id) references author(author_id)
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
before insert on books -- when will trigger execute
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
select * from books;
insert into books (isb, title, price) values(9, 'Funny Book', 1000.00);
commit;

select * from genre where name = 'classics';
select * from author;


---------------PL/SQL--------------------------

--create procedure to return all books
create or replace procedure get_all_books(cursorParam out sys_refcursor)
is 
begin
open cursorParam for select * from books;
end;
/



