create table type(
id serial primary key,
name varchar(255)
);

create table product(
id serial primary key,
name varchar(255),
expired_date date,
price float,
type_id int references type(id)
);

insert into type (name) values ('Сыр');
insert into type (name) values ('Мясо');
insert into type (name) values ('Молоко');

insert into product (name, expired_date, price, type_id) 
values ('Сыр плавленный','2022-11-01', 400 ,1);
insert into product (name, expired_date, price, type_id) 
values ('Сыр моцарела','2022-11-12', 500, 1);
insert into product (name, expired_date, price, type_id) 
values ('Курица бройлер', '2022-10-05', 350, 2);
insert into product (name, expired_date, price, type_id) 
values ('Мороженное эскимо', '2022-11-07', 150, 2);

select * from product p
join type t on p.type_id = t.id
where t.name = 'СЫР';

select * from product p
where p.name like '%мороженое%';

select * from product p
join type t on p.type_id = t.id
where p.expired_date < now();

select * from product
where price = (select max(price) from product);

select type.name, count(type_id) from product
join type on product.type_id = type.id
group by type.name;

select * from product
join type on product.type_id = type.id
where type.name = 'СЫР' or type.name = 'МОЛОКО';

select type.name, count(type_id) from product
join type on product.type_id = type.id
group by type.name
having count(type_id) < 10;

select * from product
join type on product.type_id = type.id;
