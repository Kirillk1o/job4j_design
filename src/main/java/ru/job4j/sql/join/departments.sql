create table departments(
id serial primary key,
name varchar(255)
);

create table employees(
id serial primary key,
name varchar(255),
departments_id int references departments(id)
);

insert into departments (name) values ('Отдел разработки');
insert into departments (name) values ('Отдел тестирования');
insert into departments (name) values ('Отдел HR');
insert into departments (name) values ('Отдел менеджмента');
insert into departments (name) values ('Отдел рекрутинга');

insert into employees (name, departments_id) values ('Сергей', 1);
insert into employees (name, departments_id) values ('Антон', 1);
insert into employees (name, departments_id) values ('Алексей', 5);
insert into employees (name, departments_id) values ('Владимир', 4);
insert into employees (name, departments_id) values ('Оксана', 3);
insert into employees (name, departments_id) values ('Саша', null);
insert into employees (name, departments_id) values ('Валентин', null);

select * from employees e
left join departments d 
on e.departments_id = d.id;

select * from departments d
right join employees e 
on e.departments_id = d.id;

select * from employees e 
full join departments d 
on e.departments_id = d.id;

select * from employees e 
cross join departments d;

select d.id, d.name 
from departments as d
left join employees AS e
on d.id = e.departments_id
where e.id is null;

select * from employees e
left join departments d 
on e.departments_id = d.id
union
select * from employees e
right join departments d 
on e.departments_id = d.id;