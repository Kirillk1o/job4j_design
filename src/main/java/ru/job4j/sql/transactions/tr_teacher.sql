create table teachers(
id serial primary key,
name varchar(50),
age int,
subject varchar (50)
);

insert into teachers (name, age, subject) VALUES ('Анна Васильевна', 45, 'Алгебра');
insert into teachers (name, age, subject) VALUES ('Надежда Константиновна', 34, 'Русский');
insert into teachers (name, age, subject) VALUES ('Вадим Георгиевич', 51, 'Физика');
insert into teachers (name, age, subject) VALUES ('Заур Треуголов', 35, 'Информатика');

---начало транзакции---
begin transaction;
---добавление новой строки---
insert into teachers (name, age, subject) VALUES ('Вадим Генадьевич', 61, 'Музыка');
---добавление первой точки---
savepoint first;
---изменения данных в таблице---
delete from teachers where name = 'Анна Васильевна';
update teachers set age = 62 where name = 'Вадим Генадьевич';
---отображение данных в таблице---
select * from teachers;
---вернуться до точки сохранения---
rollback to first;
---отображение данных в таблице---
select * from teachers;
---фиксируем изменения---
commit transaction;

---начало cледующей транзакции---
begin transaction;
---добавление новой строки---
insert into teachers (name, age, subject) VALUES ('Федор Викторович', 29, 'Физ-ра');
---изменения данных в таблице---
update teachers set age = 35 where name = 'Федор Викторович';
---добавление второй точки---
savepoint second;
---изменения данных в таблице---
delete from teachers where name = 'Федор Викторович';
---отображение данных в таблице---
select * from teachers;
---вернуться до точки сохранения---
rollback to second;
---отображение данных в таблице---
select * from teachers;
---добавление новой строки---
insert into teachers (name, age, subject) VALUES ('Валерий Сидоров', 54, 'Геометрия');
savepoint thrid;
---удаление таблицы---
drop table teachers;
---вернуться до точки сохранения---
rollback to third;
---отображение данных в таблице---
select * from teachers;
---фиксируем изменения---
commit transaction;




