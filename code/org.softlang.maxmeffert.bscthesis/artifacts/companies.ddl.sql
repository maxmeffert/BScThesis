create table Company (id integer not null, name varchar(255), primary key (id)) engine=InnoDB
create table Department (id integer not null, name varchar(255), company_id integer, manager_id integer, superDepartment_id integer, primary key (id)) engine=InnoDB
create table Employee (id integer not null, age integer not null, name varchar(255), salary double precision not null, department_id integer, primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
alter table Department add constraint FK574somh2okhg2lwdahfdw9hq0 foreign key (company_id) references Company (id)
alter table Department add constraint FK4376fbuulxj5ovpxrvb32l9d1 foreign key (manager_id) references Employee (id)
alter table Department add constraint FK6td2bn6t9d1emtl28485r2ph4 foreign key (superDepartment_id) references Department (id)
alter table Employee add constraint FK14tijxqry9ml17nk86sqfp561 foreign key (department_id) references Department (id)
