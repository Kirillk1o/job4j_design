insert into companies (name) values ('ООО Рога и копыта');
insert into companies (name) values ('ООО Тепло и Уют');
insert into companies (name) values ('ООО Васильки');


insert into employees (name, gender, age) values ('Оксана', 'Ж', 25);
insert into employees (name, gender, age) values ('Даниил', 'М', 44);
insert into employees (name, gender, age) values ('Мария', 'Ж', 39);
insert into employees (name, gender, age) values ('Игорь', 'М', 30);
insert into employees (name, gender, age) values ('Кирилл', 'М', 27);

insert into vacancy (name, companies_id) values ('Менеджер по продажам', 1);
insert into vacancy (name, companies_id) values ('Бухгалтер', 1);
insert into vacancy (name, companies_id) values ('Директор по развитию', 2);
insert into vacancy (name, companies_id) values ('Логист', 3);

insert into info (vacancy_id, employee_id) values (1, 2);
insert into info (vacancy_id, employee_id) values (2, 1);
insert into info (vacancy_id, employee_id) values (2, 4);
insert into info (vacancy_id, employee_id) values (3, 3);
insert into info (vacancy_id, employee_id) values (1, 5);