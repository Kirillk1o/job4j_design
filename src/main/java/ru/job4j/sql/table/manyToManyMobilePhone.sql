create table humans(
id serial primary key,
names varchar(255)
);

create table iphones(
id serial primary key,
names varchar(255)
);

create table humans_iphones(
id serial primary key,
humans_id int references humans(id),
iphones_id int references iphones(id)
);

insert into humans(names) values ('Ivan');
insert into humans(names) values ('Kirill');
insert into humans(names) values ('Roman');

insert into iphones(names) values ('Iphone X');
insert into iphones(names) values ('Iphone Xr');
insert into iphones(names) values ('Iphone SE');

insert into humans_iphones(humans_id, iphones_id) values (1, 1);
insert into humans_iphones(humans_id, iphones_id) values (1, 2);
insert into humans_iphones(humans_id, iphones_id) values (1, 3);
insert into humans_iphones(humans_id, iphones_id) values (2, 1);
insert into humans_iphones(humans_id, iphones_id) values (2, 2);
insert into humans_iphones(humans_id, iphones_id) values (3, 3);