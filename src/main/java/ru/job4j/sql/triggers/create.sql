create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);


create or replace function tax_after_insert()
     returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_product_trigger_after_insert
after insert on product
referencing new table as inserted
for each statement
execute procedure tax_after_insert();

create or replace function tax_before_insert()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_product_trigger_befor_insert
before insert on product
for each row
execute procedure tax_before_insert();

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function history_insert()
    returns trigger as
$$
    begin
        insert into history_of_price (name, price, date) values(new.name, new.price, current_timestamp);
        return new;
    end;
$$
LANGUAGE 'plpgsql';

create trigger history_trigger_price_insert_date
bafore insert
on products
for each row execute procedure history_insert();