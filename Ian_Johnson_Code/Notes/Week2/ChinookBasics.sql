-- Some basic SQL queries, using the Chinook database.

SELECT * FROM ARTIST;
SELECT NAME FROM ARTIST;
-- Use the LIKE operator to match string patterns. String use single quotes.
SELECT * FROM ARTIST WHERE NAME LIKE 'A%e';
-- Use the UPPER function to convert a string to uppercase.
SELECT * FROM ARTIST WHERE UPPER(NAME) LIKE 'A%M%';
-- There are two types of functions in SQL:
-- Scalar functions: functions that operate on single values (e.g. UPPER, LOWER, LENGTH)
SELECT * FROM ARTIST WHERE LENGTH(NAME) < 15;
SELECT LENGTH(NAME) FROM ARTIST;
-- Aggregate functions: functions that operate on multiple rows of data (e.g. MAX, MIN, COUNT, AVG)
SELECT COUNT(NAME) FROM ARTIST;
SELECT MAX(MILLISECONDS) FROM TRACK;
SELECT AVG(TOTAL) FROM INVOICE;

-- Nested queries: queries inside of queries (also called subqueries). These are useful for various types of dynamic queries.
-- You can just use = if the subquery only returns one match.
SELECT * FROM ALBUM WHERE ARTISTID = (
    SELECT ARTISTID FROM ARTIST WHERE NAME = 'Foo Fighters'
);
-- Or you can use IN if the subquery returns more than one match.
SELECT * FROM ALBUM WHERE ARTISTID IN (
    SELECT ARTISTID FROM ARTIST WHERE NAME LIKE 'F%'
);

-- You can group the results of using aggregate functions, as well as display other column values alongside them.
-- You can also sort the results using ORDER BY.
SELECT COMPANY, COUNT(*) FROM CUSTOMER GROUP BY COMPANY ORDER BY COMPANY DESC;

-- Set operations: used to combine result sets and see overlap of data. Results must have the same number and types of columns.
-- These are: UNION, UNION ALL, INTERSECT, MINUS.
SELECT * FROM CUSTOMER WHERE FIRSTNAME LIKE 'L%'
UNION -- Combines result sets, removing duplicates.
SELECT * FROM CUSTOMER WHERE COUNTRY = 'Brazil';

SELECT * FROM CUSTOMER WHERE FIRSTNAME LIKE 'L%'
UNION ALL -- Combines result sets, keeping duplicates.
SELECT * FROM CUSTOMER WHERE COUNTRY = 'Brazil';

SELECT * FROM CUSTOMER WHERE FIRSTNAME LIKE 'L%'
INTERSECT -- Selects only the rows that appear in both result sets.
SELECT * FROM CUSTOMER WHERE COUNTRY = 'Brazil';

SELECT * FROM CUSTOMER WHERE FIRSTNAME LIKE 'L%'
MINUS -- Selects the rows that appear in the first result set but not in the second.
SELECT * FROM CUSTOMER WHERE COUNTRY = 'Brazil';

-- Joins
-- Display all tracks along with the album they're from:
SELECT T.NAME AS TRACK_NAME, AL.TITLE AS ALBUM_TITLE
FROM TRACK T
/* INNER */ JOIN ALBUM AL
ON T.ALBUMID = AL.ALBUMID;

-- Use left, right and full outer joins to include rows from either the first, second or both tables that have no matches.
-- Note: FULL OUTER JOIN is the same as FULL JOIN (same for LEFT OUTER JOIN and RIGHT OUTER JOIN).
SELECT E1.LASTNAME AS MANAGER, E2.LASTNAME AS EMPLOYEE
FROM EMPLOYEE E1
LEFT JOIN EMPLOYEE E2
ON E1.EMPLOYEEID = E2.REPORTSTO;

-- We can also see only people who have no managers:
SELECT E2.LASTNAME
FROM EMPLOYEE E1
RIGHT JOIN EMPLOYEE E2
ON E1.EMPLOYEEID = E2.REPORTSTO
WHERE E2.REPORTSTO IS NULL;

-- Or people who have no subordinates:
SELECT E1.LASTNAME
FROM EMPLOYEE E1
LEFT JOIN EMPLOYEE E2
ON E1.EMPLOYEEID = E2.REPORTSTO
WHERE E2.EMPLOYEEID IS NULL;

-- Cross joins (Cartesian product):
SELECT E1.LASTNAME AS MANAGER, E2.LASTNAME AS EMPLOYEE
FROM EMPLOYEE E1, EMPLOYEE E2;

-- Natural joins, where Oracle attempts to match columns based on names:
SELECT ALBUM.TITLE AS ALBUM, ARTIST.NAME AS ARTIST
FROM ALBUM
NATURAL JOIN ARTIST;

-- Get the number of tracks in each genre and order by genre name.
SELECT GENRE.NAME AS GENRE, COUNT(TRACKID) AS TRACKS
FROM GENRE
JOIN TRACK
ON TRACK.GENREID = GENRE.GENREID
GROUP BY GENRE.NAME
ORDER BY GENRE.NAME;

-- Get the length of the longest song in each genre.
SELECT GENRE.NAME AS GENRE, ROUND(MAX(TRACK.MILLISECONDS) / 60000, 2) AS LONGEST_MINUTES
FROM GENRE
JOIN TRACK
ON TRACK.GENREID = GENRE.GENREID
GROUP BY GENRE.NAME
ORDER BY GENRE.NAME;

-- To use a condition on a GROUP BY, use HAVING:
SELECT GENRE.NAME AS GENRE, COUNT(TRACKID) AS TRACKS
FROM GENRE
JOIN TRACK
ON TRACK.GENREID = GENRE.GENREID
GROUP BY GENRE.NAME
HAVING COUNT(TRACKID) > 100 -- Show only genres with over 100 tracks.
ORDER BY GENRE.NAME;

-- Views: a "window" or a "view" into a particular subset of data. They behave like tables, but they're not actually new tables.
-- Views always stay up-to-date with the base data.
CREATE VIEW AL_ART_VIEW AS
SELECT ALBUM.ALBUMID, ARTIST.ARTISTID, ARTIST.NAME AS ARTIST
FROM ALBUM
JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

SELECT ARTIST FROM AL_ART_VIEW;

-- We can get rid of a view like this:
DROP VIEW AL_ART_VIEW;