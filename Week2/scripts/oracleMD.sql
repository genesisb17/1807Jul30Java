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

insert into author(Author_ID,author_fname,author_lname,author_biography) values(1,'jhon','meyers','born in oklahoma');

insert into book(Book_ID,ISBN,title,price,genre_id) values(1,5098,'Humpty Dumpty',45,1);

insert into Genre(Genre_id,name) values(2,'horror');

select * from book;

commit;

select * from genre;