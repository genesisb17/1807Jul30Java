CREATE TABLE bGenre
(
      --  colName  dataType  Optional Constraints
          bGenre_Id number(10) PRIMARY KEY,
          Name varchar2(256) unique not null
);

CREATE TABLE Book
(
        Book_Id number(10) PRIMARY KEY,
        ISBN varchar2(10) UNIQUE NOT NULL,
        Title varchar2(256) NOT NULL,
        Price number(6,2) NOT NULL,
        bGenre_Id number(10),
        CONSTRAINT fk_book_genre FOREIGN KEY(bGenre_id)
               REFERENCES bgenre(bgenre_id)
);

CREATE TABLE Author
( -- authorid, fn, lastname, biography
        Author_Id number(10) PRIMARY KEY,
        First_Name varchar2(50) NOT NULL,
        Last_Name varchar2(50),
        Bio varchar2(1000)
);

CREATE SEQUENCE bgenre_seq
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999
   START WITH 1
   INCREMENT BY 1 
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;

CREATE OR REPLACE TRIGGER genre_seq_trig
before insert on bgenre
for each row
begin
    select bgenre_seq.nextVal into :new.bGenre_ID from dual;
end;
/

CREATE SEQUENCE book_seq
   MINVALUE 1 
   MAXVALUE 9999999999999999999999999999
   START WITH 1
   INCREMENT BY 1 
   CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;

CREATE OR REPLACE TRIGGER book_seq_trig
before insert on book
for each row
begin
    select book_seq.nextVal into :new.book_ID from dual;
end;
/

create or replace PROCEDURE get_all_genres(
  c_genres OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN c_genres for SELECT * FROM bgenre;
END;
/

create or replace PROCEDURE get_all_books(
  c_books OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN c_books for SELECT * FROM book;
END;
/


insert into bgenre(name) values('Fiction');
insert into bgenre(name) values('Classics');
insert into bgenre(name) values('Nonfiction');
select * from bgenre;

insert into book values(1, 1234567890, 'Harry Potter', 10, 1);
select * from book;