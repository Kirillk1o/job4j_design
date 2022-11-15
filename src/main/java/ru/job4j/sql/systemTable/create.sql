create table users(
id serial primary key,
names varchar(255)
);

create table role(
id serial primary key,
names varchar(255)
);

create table rules(
id serial primary key,
names varchar(255)
);

create table item(
id serial primary key,
names text
);

create table comments(
id serial primary key,
names varchar(255)
);

create table attachs(
id serial primary key,
names varchar(255)
);

create table state(
id serial primary key,
names varchar(255)
);

create table category(
id serial primary key,
names varchar(255)
);

create table item_attachs(
id serial primary key,
names varchar(255),
item_attachs_id int references attachs(id)
);

create table item_category(
id serial primary key,
names varchar(255),
item_category int references item(id)
);

create table item_comments(
id serial primary key,
names varchar(255),
item_comments_id int references comments(id)
);

create table item_state(
id serial primary key,
names varchar(255),
item_state int references item(id)
);

create table item_users(
id serial primary key,
names varchar(255),
item_users_id int references users(id)
);

create table role_rules(
id serial primary key,
role_id int references role(id),
rules_id int references rules(id)
);

create table users_role(
id serial primary key,
names varchar(255),
users_role_id int references users(id)
);