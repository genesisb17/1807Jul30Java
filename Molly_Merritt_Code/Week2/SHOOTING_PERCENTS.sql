
create table player_stats(
  pid number(10),
  name varchar2(200),
  attempts number(10),  -- how many shots attempted
  made number(10),   -- how many shots made
  shooting_percentage number(10)   -- not a good column b/c it depends on 2 others (function; not normalized)
)

insert into player_stats values(0, 'Mean Mike', 1000, 300, 30);
insert into player_stats values(34, 'Steph Curry', 10000, 9000, 90);
insert into player_stats values(19, 'Dunking Adams', 100, 99, 99);
insert into player_stats values(10, 'Bugs Bunny', 8742, 5637, 99);

select * from player_stats;

create or replace function calc_shoot_avg(att number, made number) 
  return number is percentage number(10);

begin  
  -- code
  percentage := made/att*100;
return percentage;
end;

-- we have to update the table ourselves b/c functions don't do that
update player_stats set shooting_percentage = calc_shoot_avg(8742,5637)
  where PID = 10;
  
create sequence pid_generator
  minvalue 0
  start with 100
  increment by 1;

-- make a player using a procedure
create or replace procedure insert_player(
  name varchar2,
  attempts number,
  made number)
  
  is
  
  begin
    insert into PLAYER_STATS values(
      pid_generator.nextval,
      name,
      attempts,
      made,
      calc_shoot_avg(attempts, made));
  end;

exec insert_player('Kobe', 1999, 400);
exec insert_player('Michael Jordan', 1420, 764);

select * from player_stats;