create table phoneNumber(
id serial primary key,
number int
);

create table people(
id serial primary key,
names varchar(255)
);

create table phoneNumber_people(
id serial primary key,
phoneNumber_id int references phoneNumber(id) unique,
people_id int references people(id) unique
);
