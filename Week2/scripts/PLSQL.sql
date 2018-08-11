CREATE OR REPLACE PROCEDURE helloWorld
  AS -- can also be IS
  BEGIN
    dbms_output.put_line('Hello Database World');
  END;
/
execute helloWorld;

-- FUNCTION
-- get total number of artists
create or replace function get_num_artists
  return number -- functions must return something. declare return type here
is
  total number;
begin
  select count(*) into total from artist;
  return total;
end;
/
select count(*) from artist;
select get_num_artists() from dual;

/*
An index is a performance tuning method of allowing faster retrieval of records.
It creates an entry for each value that appears in the indexed column(s).
*/

create index art_name_index
on artist(name);

-------------------- PLSQL

/*
- Oracle creates a context area with all information necessary for processing an SQL statement
- A Cursor is a pointer to the context area
- The "active set" is the row(s) returned by a stmt and is held by the cursor
- There are two types: implicit and explicit
--> Implicit - created by oracle whenever we execute a DML statement (and no explicit cursor on the set exists)
--> Explicit - programmer defined, as seen below, and is used for obtaining more control over context area
--> DECLARE cursor to initialize memory
--> OPEN curosr to allocate memory
--> FETCH cursor to retrieve data
--> Close cursor to release memory
*/
-- create a procedure to return all books
create or replace procedure get_all_books(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR select * from book;
END;
/

execute get_all_books();