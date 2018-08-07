/*
DATA MANIPULATION LANGUAGE
INSERT, SELECT, UPDATE, DELETE
*/

select max(artistid) from artist;

insert into artist (artistid, name)
values(276,'Bombay Bicycle Club');

insert into artist (name)
values('Outkast');

update artist
set name = 'Beyonce'
where artistid = 277;

delete from artist;
delete from artist where artistid = 1;
delete from artist where artistid BETWEEN 1 AND 10;

select * from artist;

delete from artist where artistid > 275;
SAVEPOINT sp1;

rollback to sp1;


--TCL [brief] info
commit;
-- always commit upon successful db transaction
--meaning, insert update delete