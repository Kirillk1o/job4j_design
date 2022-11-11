create table owner(
id serial primary key,
names varchar(255)
);

create table dog(
id serial primary key,
names varchar(255),
owner_id int references owner(id)
);

insert into owner(names) VALUES ('Kirill');
insert into dog(names,owner_id) values ('Мальтипу',1);

select * from owner;

select * from owner where id in (select dog_id from owner);