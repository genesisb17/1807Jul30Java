CREATE SEQUENCE client_seq
minvalue 1
start with 1
increment by 1
cache 5;

CREATE SEQUENCE account_seq
minvalue 1
start with 1
increment by 1
cache 5;

CREATE OR REPLACE TRIGGER client_seq_trig 
before insert on client
for each row 
begin 
    select client_seq.nextVal into :new.client_id from dual;
end;
/

CREATE OR REPLACE TRIGGER account_seq_trig 
before insert on account
for each row 
begin 
    select account_seq.nextVal into :new.account_id from dual;
end;
/

insert into account_type (account_type_id, account_type)
  values(1,'Checking');
  
insert into account_type (account_type_id, account_type)
  values(2,'Savings');

commit;


insert into account (account_id, balance, account_type_id) values(1,100,1);
insert into account (account_id, balance, account_type_id) values(1,500,2);

--delete from ACCOUNT where ACCOUNT_ID > 0;
select * from account;

insert into client (first_name, last_name, username, password) 
  values('Sam', 'Smith', 'sam123', 'password');

select * from client;