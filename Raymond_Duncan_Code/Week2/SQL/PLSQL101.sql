
-- Procedure example
CREATE OR REPLACE PROCEDURE helloWorld
    AS --can also be IS
    BEGIN
        dbms_output.put_line('HELLO DATABASE WORLD');
    END;
/

EXECUTE helloWorld;

-- FUNCTION
--get total number of artists
CREATE OR REPLACE FUNCTION get_num_artists
return number -- functions must return something. Declare the return type here
is total number;
begin
    select distinct count(*) into total from artist;
    return total;
end;
/

SELECT get_num_artists() from dual;

/*
An index is a performance tuning method of allowing faster retrieval of records. It creates an entry for each value that 
appears in the indexed columns
*/

CREATE INDEX art_name_index
on artist(name);