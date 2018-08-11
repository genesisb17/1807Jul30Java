--BOOKSTORE DDL SCRIPT

CREATE TABLE Genre
(
    -- Table name, data type(number of digits it holds), optional constraints
    Genre_ID number(10) PRIMARY KEY,
    Name varchar2(256) UNIQUE NOT NULL
);

CREATE TABLE Book
(
  Book_ID number(10) PRIMARY KEY,
  ISBN varchar2(10) UNIQUE NOT NULL,
  Title varchar2(256) NOT NULL,
  -- 6 total digits, and 2 decimal places
  Price number(6,2)NOT NULL,
  Genre_ID number(10),
  CONSTRAINT FK_Book_Genre FOREIGN KEY(Genre_ID)
    REFERENCES genre(genre_id)
);

CREATE TABLE Author
(
  Author_ID number(10) UNIQUE NOT NULL,
  first_name varchar2(50) NOT NULL,
  last_name varchar(50),
  Biography varchar2(1000)
);

-- JUNCTION TABLE. Columns are both FK and PK
CREATE TABLE Book_Author
(
  Book_ID number(10),
  Author_ID number(10),
  PRIMARY KEY (Book_ID, Author_ID),
  FOREIGN KEY (Book_ID) REFERENCES Book(Book_ID),
  FOREIGN KEY (Author_ID) REFERENCES Author(Author_ID)
);

---------Sequences-------------
CREATE SEQUENCE book_seq;
CREATE SEQUENCE author_seq
minvalue 1
start with 1
increment by 1
cache 5; --how many values will be stored in memory for faster access

CREATE SEQUENCE genre_seq
minvalue 1
start with 1
increment by 1
cache 5; 

--------TRIGGERS--------
CREATE OR REPLACE TRIGGER b_seq_trig -- Declare and name trigger
BEFORE INSERT ON book -- When trigger will execute
FOR EACH ROW -- Necessary to change value of table
BEGIN -- What to do when trigger is fired
  SELECT book_seq.nextVal into :new.book_id from dual;
end;
/ --End of trigger
  
CREATE OR REPLACE TRIGGER a_seq_trig 
BEFORE INSERT ON author 
FOR EACH ROW
BEGIN
  SELECT author_seq.nextVal into :new.author_id from dual;
end;
/

CREATE OR REPLACE TRIGGER g_seq_trig 
BEFORE INSERT ON genre 
FOR EACH ROW
BEGIN
  SELECT genre_seq.nextVal into :new.genre_id from dual;
end;
/

-- ABOUT DUAL (dummy table that exists so you cannot break something)
select * from DUAL;
select SYSDATE from DUAL;

select * from book;
insert into genre(name) values('Fantasy');

insert into book(BOOK_ID, GENRE_ID, isbn, title, price) values (1, 16, '10', 'Taren Breathing', 9.99);
commit;