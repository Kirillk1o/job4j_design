create table breed(
id serial primary key,
names varchar(255)
);

create table owners(
id serial primary key,
names varchar(255),
breed_id int references breed(id)
);

insert into breed(names) values ('Мальтипу');
insert into owners(names, breed_id) VALUES ('Kirill', 1);

select * from owners;

select * from breed where id in (select breed_id from owners);