-- Using DBMS output:

CREATE OR REPLACE PROCEDURE hello_world AS
BEGIN
    dbms_output.put_line('hello database world');
END;
/

EXECUTE hello_world;

-- Get total number of artists.
CREATE OR REPLACE FUNCTION get_num_artists RETURN NUMBER IS total NUMBER;
BEGIN
    SELECT COUNT(*) INTO total FROM artist;
    RETURN total;
END;
/

SELECT get_num_artists() FROM dual; -- We use our dummy table "dual" here.

-- An index is a performance-tuning method of allowing faster retrieval of methods.
-- An index creates an entry for each value that appears in the indexed column(s).
CREATE INDEX artist_name_index ON artist(name);