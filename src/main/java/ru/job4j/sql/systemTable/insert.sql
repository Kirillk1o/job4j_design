insert into users(names) values ('Kirill');
insert into users(names) values ('Petr');

insert into role(names) values('admin');
insert into role(names) values('user');

insert into rules(names) values('read');
insert into rules(names) values('write');
insert into rules(names) values('delete');

insert into role_rules(role_id, rules_id) values(1, 1);
insert into role_rules(role_id, rules_id) values(1, 2);
insert into role_rules(role_id, rules_id) values(1, 3);
insert into role_rules(role_id, rules_id) values(2, 1);

insert into category(names) values('simple');
insert into category(names) values('important');

insert into state(names) values('created');
insert into state(names) values('completed');

insert into item(names, users_id, category_id, state_id)
values('install windows', 1, 1, 2);
insert into item(names, users_id, category_id, state_id)
values('learn java', 2, 2, 1);

insert into comments(names, item_id) values('windows has been installed', 1);
insert into comments(names, item_id) values('one grain at a time', 2);
insert into comments(names, item_id) values('i love java', 2);

insert into attachs(names, item_id) values('windows.jpg', 1);
insert into attachs(names, item_id) values('java.jpg', 2);
insert into attachs(names, item_id) values('Effective Java.pdf', 2);