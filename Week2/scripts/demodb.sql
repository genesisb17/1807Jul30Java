
Create Table Genre (
Genre_ID number(10) PRIMARY KEY,
NAME varchar2(256) unique not null);

Create table Book(
Book_ID number(10) Primary Key,ISBN varchar2(10) Unique not null,
title varchar(256) Not null,
-- this means 6 digits 2 being decimals
Price number(6,2) not null,
genre_id number(10),
-- this creates a foreign key relationship saying where the books genre id is a reference to being the genres genre id
Constraint fk_book_genre Foreign Key(Genre_id) references genre(genre_id)

);

Create Table Author(

Author_ID number(10) Primary Key,
author_fname varchar(50) not null,
author_lname varchar(50),
author_biography varchar2(1000)

);


Create table Book_Author(
Book_ID number(10),
Author_ID number(10),
Primary Key(Book_ID,Author_ID),
foreign key(Book_ID) references Book(Book_ID),
foreign key(Author_ID) references Author(Author_ID)
);

insert into author(Author_ID,author_fname,author_lname,author_biography) values(3,'jhon','meyers','born in oklahoma');

insert into book(Book_ID,title,price,genre) values(3,'jhon','meyers','born in oklahoma');

insert into Genre(Genre_id,name) values(3,'kids');


select * from Genre;


select * from author;

-- Sequences------------
Create sequence genre_seq;
Create Sequence author_seq minvalue 1 start with 1 increment by 5 cache 5;--the cache is how many values will be stored in memory
--for faster acess
--what happens when sequence is made without params max min 
/*
min value will be 1
max will be 99999999999999999999
it will increment by 1
it will start with 1
and the cash will be
cache 20 noorder no cycle no partition
*/

-------Triggers
Create or replace trigger b_seq_trig --declare name of trigger
before insert on book --when the triger will execute
for each row--necesary to change value of table
begin select book_seq.nextVal into: new.book_id from dual;
end;

-------Triggers
Create or replace trigger b_seq_trig --declare name of trigger
before insert on book --when the triger will execute
for each row--necesary to change value of table
begin select book_seq.nextVal into:new.book_id from dual;
end;

---dml stuff

select*from genre;

insert into genre(NAME) values('history');






select * from dual;
select Sysdate from dual;
--colon indicates assignment
--dual is a dummy table used to select information
--what to do when trigger is fired




