create table speciality(
id serial primary key,
position varchar(255),
rank varchar(255)
);

create table programmer(
id serial primary key,
name varchar(255),
speciality_id int references speciality(id)
);

insert into speciality(position, rank) values ('Back end developer', 'Junior');
insert into speciality(position, rank) values ('Data sciens analyst', 'Senior');
insert into speciality(position, rank) values ('Front end developer', 'Middle');

insert into programmer(name, speciality_id) values ('Kirill', 1);
insert into programmer(name, speciality_id) values ('Semen', 2);
insert into programmer(name, speciality_id) values ('Alexander', 3);

select pr.name, sp.position, sp.rank 
from programmer as pr
join speciality as sp
on pr.speciality_id = sp.id;

select pr.name as Имя, sp.position as Направление, sp.rank as Позиция
from programmer as pr
join speciality as sp
on pr.speciality_id = sp.id;

select pr. name as "Имя программиста",
sp.position as Направление, sp.rank as Позиция
from programmer as pr
join speciality as sp
on pr.speciality_id= sp.id;





