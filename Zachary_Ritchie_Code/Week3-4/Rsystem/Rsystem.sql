
-----------------------Permissions-----------------------
CREATE USER rsystem
IDENTIFIED BY rsystem;

GRANT connect to rsystem;
GRANT resource to rsystem;


---------------------Table Creation-----------------------
create table ers_reimbursement
(
  reimb_id number primary key,
  reimb_amount number(9, 2) not null,
  reimb_submitted timestamp not null,
  reimb_resolved timestamp,
  reimb_description varchar2(250),
  reimb_receipt blob,
  reimb_author number not null,
  reimb_resolver number,
  reimb_status_id number not null,
  reimb_type_id number not null,
  constraint ers_users_fk_auth foreign key (reimb_author) references ers_users(ers_users_id),
  constraint ers_users_fk_reslvr foreign key (reimb_resolver) references ers_users(ers_users_id),  
  constraint ers_reimbursement_status_fk foreign key (reimb_status_id) references ers_reimbursement_status(reimb_status_id),
  constraint ers_reimbursement_type_fk foreign key (reimb_type_id) references ers_reimbursement_type(reimb_type_id)
);

create table ers_users
(
  ers_users_id number primary key,
  ers_username varchar2(50) unique not null,
  ers_password varchar2(50) not null,
  user_first_name varchar2(100) not null,
  user_last_name varchar2(100) not null,
  user_email varchar2(150) unique not null,
  user_role_id number not null,
  constraint user_roles_fk foreign key (user_role_id) references ers_user_roles(ers_user_role_id)
);

create table ers_user_roles
(
  ers_user_role_id number primary key,
  user_role varchar2(10) not null
);

create table ers_reimbursement_status
(
  reimb_status_id number primary key,
  reimb_status varchar2(10) not null
);

create table ers_reimbursement_type
(
  reimb_type_id number primary key,
  reimb_type varchar2(10) not null
);

-----------------Sequences-------------------

create sequence ers_reimbursement_seq;
create sequence ers_reimbursement_status_seq;
create sequence ers_user_roles_seq;
create sequence ers_users_seq;
create sequence ers_reimbursement_type_seq;

------------------Triggers------------------

CREATE OR REPLACE TRIGGER ers_reimbursement_seq_trig
before insert on ers_reimbursement
for each row 
begin 
    select ers_reimbursement_seq.nextVal into :new.reimb_id from dual;
end;
/

CREATE OR REPLACE TRIGGER ers_status_seq_trig
before insert on ers_reimbursement_status
for each row 
begin 
    select ers_reimbursement_status_seq.nextVal into :new.reimb_status_id from dual;
end;
/

CREATE OR REPLACE TRIGGER ers_seq_trig
before insert on ers_reimbursement_type
for each row 
begin 
    select ers_reimbursement_type_seq.nextVal into :new.reimb_type_id from dual;
end;
/

CREATE OR REPLACE TRIGGER ers_user_roles_seq_trig
before insert on ers_user_roles
for each row 
begin 
    select ers_user_roles_seq.nextVal into :new.ers_user_role_id from dual;
end;
/

CREATE OR REPLACE TRIGGER ers_users_seq_trig
before insert on ers_users
for each row 
begin 
    select ers_users_seq.nextVal into :new.ers_users_id from dual;
end;
/

--Set timestamp after reimburemnet is entered
create or replace trigger ers_reimbursement_time_trig
before insert on ers_reimbursement
for each row
begin
  :new.reimb_submitted := current_timestamp();
end;
/

create or replace trigger ers_reimbursment_initial
before insert on ers_reimbursement
for each row
begin
  :new.reimb_status_id := 2;
end;
/

--Set timestamp of reimbursement if its been approved or denied
create or replace trigger ers_reimbursment_resolved
before update of reimb_status_id on ers_reimbursement
for each row
begin
  :new.reimb_resolved := current_timestamp();
end;
/

-----------------------PLSQL-------------------

create or replace procedure get_all_ers_reimbursement(cursorParam out sys_refcursor)
is 
begin
open cursorParam for select * from ers_reimbursement;
end;
/


-------------------Extra--------------------
select * from ers_reimbursement_type;
select * from ers_reimbursement_status;
select * from ers_user_roles;
select * from ers_users;
select * from ers_reimbursement;

select * from ers_users where ers_username = 'username';

--Default user
insert into ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values('username', 'password', 'zack', 'ritchie', 'test@email.com', 2);

--TESTING STATUS TARIGGERS
insert into ERS_REIMBURSEMENT(reimb_amount, reimb_author, reimb_type_id) values(10, 1, 1);
update ERS_REIMBURSEMENT set reimb_status_id = 4 where reimb_id = 2;

--Pre set status
insert into ers_reimbursement_status(reimb_status) 
values('Pending');

insert into ers_reimbursement_status(reimb_status) 
values('Approved');

insert into ers_reimbursement_status(reimb_status) 
values('Denied');


--Pre set types
insert into ers_reimbursement_type(reimb_type) 
values('Lodging');

insert into ers_reimbursement_type(reimb_type) 
values('Travel');

insert into ers_reimbursement_type(reimb_type) 
values('Food');

insert into ers_reimbursement_type(reimb_type) 
values('Other');


--Pre set roles
insert into ers_user_roles(user_role) 
values('Employee');

insert into ers_user_roles(user_role) 
values('Finance_Manager');











