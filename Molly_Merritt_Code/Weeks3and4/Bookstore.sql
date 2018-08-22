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


