create table teens(
id serial primary key,
name varchar(255),
gender varchar(255)
);

insert into teens(name, gender) values ('Kirill', 'М');
insert into teens(name, gender) values ('Nika', 'Ж');
insert into teens(name, gender) values ('Alexander', 'M');
insert into teens(name, gender) values ('Alexandra', 'Ж');

select g1.name, g2.gender
from teens as g1
cross join teens g2;