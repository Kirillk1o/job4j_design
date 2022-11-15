create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('Tiger', 20, date '2022-02-25');
insert into fauna(name, avg_age, discovery_date)
values ('Wolf', 25, date '2020-05-14');
insert into fauna(name, avg_age, discovery_date)
values ('Fox', 17, date '2021-05-19');
insert into fauna(name, avg_age, discovery_date)
values ('Rabit', 15, date '2022-07-02');