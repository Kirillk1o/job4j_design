create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values ('Iphone', 50000);
insert into devices (name, price) values ('Samsung', 10000);
insert into devices (name, price) values ('Xiaomi', 9000);

insert into people(name) values ('Kirill');
insert into people(name) values ('Alexandr');
insert into people(name) values ('Vladimir');
insert into people(name) values ('Semen');
insert into people(name) values ('Valeriy');
insert into people(name) values ('Stanislav');
insert into people(name) values ('Petr');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (3, 4);
insert into devices_people(device_id, people_id) values (2, 5);
insert into devices_people(device_id, people_id) values (3, 6);
insert into devices_people(device_id, people_id) values (1, 7);

select avg(price) from devices;

select p.name, avg (d.price)
from people as p
join devices_people as dp on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name
having avg(de.price) > 5000;
