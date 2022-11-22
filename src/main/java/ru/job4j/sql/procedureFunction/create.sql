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
    	where name price < i_price or price is null;
    END;
$$;

create replace function delete_data(i_price integer)
returns integer
language 'plpgsql'
as $$
    declare
        result integer;
    begin
        delete from products
    	where name price < i_price or price is null;
    	return result;
    end;
$$;


Добавьте процедуру и функцию, которая будет удалять записи.
Условия выбирайте сами – удаление по id, удалить если количество товара равно 0 и т.п.