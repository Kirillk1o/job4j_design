create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace procedure delete_data(i_price integer)
language 'plpgsql'
as $$
    BEGIN
    	delete from products
    	where price < i_price or price is null;
    END;
$$;

create or replace function delete_data(i_count integer)
returns void
language 'plpgsql'
as $$
    declare
        result integer;
    begin
        delete from products
    	where  count < i_count or count is null;
    end;
$$;


Добавьте процедуру и функцию, которая будет удалять записи.
Условия выбирайте сами – удаление по id, удалить если количество товара равно 0 и т.п.