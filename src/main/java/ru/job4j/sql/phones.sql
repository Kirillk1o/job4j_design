create table phones(
id serial primary key,
names varchar(200),
model text,
amount integer,
color char (10));
delete from phones;
select * from phones;
insert into phones(name, model, amount, color)
values('Iphone', 'X', 356, 'Black');
select * from phones;
update phones set amount = 140;
select * from phones;