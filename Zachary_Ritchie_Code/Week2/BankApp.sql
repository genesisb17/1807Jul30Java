
---------------Create Tables------------------
create table customer 
(
  user_id number(10) primary key,
  first_name varchar2(50) not null,
  last_name varchar2(50),
  user_username varchar2(50) not null unique,
  user_password varchar2(50) not null
);

create table accounts
(
  account_id number(10) primary key,
  account_name varchar2(256) not null, 
  account_type varchar2(25) not null,
  balance number(9, 2) not null,
  user_id number(10),
  constraint accounts_customer foreign key (user_id) references customer(user_id)
);


-------------Sequence--------------

create sequence customer_seq;
create sequence account_seq;

-------------Triggers--------------

CREATE OR REPLACE TRIGGER c_seq_trig
before insert on customer
for each row 
begin 
    select customer_seq.nextVal into :new.user_id from dual;
end;
/

CREATE OR REPLACE TRIGGER a_seq_trig
before insert on accounts
for each row 
begin 
    select account_seq.nextVal into :new.account_id from dual;
end;
/

------------PLSQL------------

create or replace procedure get_all_customers(cursorParam out sys_refcursor)
is 
begin
open cursorParam for select * from customer;
end;
/

create or replace procedure get_all_accounts(cursorParam out sys_refcursor)
is 
begin
open cursorParam for select * from accounts;
end;
/


---------------EXTRA-------------

select * from customer;
select * from accounts;

insert into customer(first_name, last_name, user_username, user_password) 
values('zack', 'ritchie', 'username', 'password');

insert into accounts(account_name, account_type, balance, user_id) 
values('zacsaccount', 'checking', 1.23, 1);

delete from customer where first_name = 'zac';
commit;

