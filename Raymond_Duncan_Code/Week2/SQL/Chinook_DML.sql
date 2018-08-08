/*
DATA MANIPULATION LANGUAGE
INSERT, SELECT, UPDATE, DELETE
*/

select * from artist;

insert into artist(artistid, name)
values(276, 'Beyonce');

delete from artist;
delete from artist where artistid = 1;
delete from artist where artistid BETWEEN 1 AND 10;

select * from artist;
delete from artist where artistid > 275;
SAVEPOINT sp1;

rollback to sp1; --You cannot rollback to a savepoint after a commit

--TCL [brief] intro
commit;
--always commit after successful db transactions
----meaning after a commit

update artist
set name = 'Outcast'
where name = 'Beyonce';


