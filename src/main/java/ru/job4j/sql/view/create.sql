create table employees (
id serial primary key,
name varchar(100),
gender varchar(2),
age int
);

create table companies (
id serial primary key,
name varchar (50)
);

create table vacancy (
id serial primary key,
name varchar(50),
companies_id int references companies(id)
);

create table info (
id serial primary key,
active boolean default true,
vacancy_id int references vacancy(id),
employee_id int references employees(id)
);