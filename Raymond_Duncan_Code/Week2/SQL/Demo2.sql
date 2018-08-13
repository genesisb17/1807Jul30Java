create table player_stats(
pid number(10),
name varchar2(200),
attempts number(10),
made number(10),
shooting_percentage number(10)
);

insert into player_stats values(0,'Mean Mike',1000,300,20);
insert into player_stats values(34,'Steph Curry',10000,900,90);
insert into player_stats values(19,'Dunkin Adams',100,99,99);
insert into player_stats values(10,'Bugs Bunny',8742,5637,99);

select * from player_stats;


----- Function to calculate shooring percentage!
create or replace function calc_shoot_avg(att number, made number)
return number is percentage number(10);

begin

percentage := made/att*100;

return percentage;
end;
/


----- Bugs Bunny's percentage is wrong here's a line to update his player_stats
update player_stats set shooting_percentage = calc_shoot_avg(8742,5637) where name = 'Bugs Bunny';


create sequence pid_generator
minvalue 0
start with 100
increment by 1;


---- Procedure to add a new player
create or replace procedure insert_player(name varchar2, attempts number, made number)

is
begin

insert into player_stats(pid,name,attempts,made,shooting_percentage)
values(pid_generator.nextval,name,attempts,made,calc_shoot_avg(attempts,made));

end;
/


exec insert_player('Kobe',1999,400);
exec insert_player('Wrong Player',-12120,-7640);


-- Trigger practice
create table retired_player(
pid number(10),
name varchar2(200),
attempts number(10),
made number(10),
shooting_percentage number(10)
);

create or replace trigger retiring_player
before delete on player_stats
for each row
begin
insert into retired_player values(:old.pid,:old.name,:old.attempts,:old.made,:old.shooting_percentage);
end;
/

savepoint pre_wrongplayer_delete;
select * from player_stats;
delete from player_stats where name = 'Wrong Player';
select * from player_stats;
select * from retired_player;
rollback to pre_wrongplayer_delete;
