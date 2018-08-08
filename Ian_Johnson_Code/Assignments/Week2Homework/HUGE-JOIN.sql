-- Join all 11 tables in the Chinook DB!
-- Select one column per table.
/*
 * Basically, this collects all the tracks on everyone's invoices and gives all
 * the information we can find for each track (album, artist, genre, media type),
 * then we get the customer name, track price and invoice date from the invoice.
 * Finally, since the employees table doesn't really match up in a natural way,
 * we join with all the employees who are based in the same country as the
 * customer. These are all inner joins so that we don't get a bunch of NULLs.
 * You can pretend that this is some sort of "music friend finder" application,
 * for people who listen to the same tracks and want to meet up :)
 *
 * EDIT: I found SUPPORTREPID in the CUSTOMER table, linking EMPLOYEE into the
 * rest of the tables, but I'll keep the join the way it is :)
 *
 * Also, I included only tracks less than $1 and in the classical genre, just
 * for fun.
 */
SELECT
    TRACK.NAME AS TRACK,
    ALBUM.TITLE AS ALBUM,
    ARTIST.NAME AS ARTIST,
    GENRE.NAME AS GENRE,
    MEDIATYPE.NAME AS MEDIATYPE,
    PLAYLISTTRACK.PLAYLISTID AS PLAYLIST_ID,
    PLAYLIST.NAME AS PLAYLIST,
    INVOICELINE.UNITPRICE AS TRACK_PRICE,
    CUSTOMER.FIRSTNAME AS CUSTOMER_NAME,
    INVOICE.INVOICEDATE AS INVOICEDATE,
    EMPLOYEE.FIRSTNAME AS EMPLOYEE_COUNTRY_BUDDY
FROM TRACK
JOIN ALBUM ON TRACK.ALBUMID = ALBUM.ALBUMID
JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
JOIN GENRE ON TRACK.GENREID = GENRE.GENREID
JOIN MEDIATYPE ON TRACK.MEDIATYPEID = MEDIATYPE.MEDIATYPEID
JOIN PLAYLISTTRACK ON PLAYLISTTRACK.TRACKID = TRACK.TRACKID
JOIN PLAYLIST ON PLAYLIST.PLAYLISTID = PLAYLISTTRACK.PLAYLISTID
JOIN INVOICELINE ON INVOICELINE.TRACKID = TRACK.TRACKID
JOIN INVOICE ON INVOICE.INVOICEID = INVOICELINE.INVOICEID
JOIN CUSTOMER ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
JOIN EMPLOYEE ON EMPLOYEE.COUNTRY = CUSTOMER.COUNTRY
WHERE INVOICELINE.UNITPRICE < 1.00 AND GENRE.NAME = 'Classical';