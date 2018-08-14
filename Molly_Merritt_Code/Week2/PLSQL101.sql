CREATE OR REPLACE PROCEDURE helloWorld
  AS -- can also be IS
  BEGIN
   dbms_output.put_line('HELLO DATABASE WORLD');
  END;
/
execute helloWorld;

-- FUNCTION
-- get total number of artists
create or replace function get_num_artists
  return number -- functions must return something. declare return type here
is
  total number;
BEGIN
  select count(*) into total from artist;
  return total;
END;
/
select get_num_artists() from dual;

select count(*) from artist;


/*
  An index is a performance-tuning method of allowing faster retrieval of
  records. An index creates an entry for each value that appears in the indexed
  column(s).
*/

create index art_name_index
on artist(name);