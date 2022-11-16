insert into car_bodies(name) values ('sedan'), ('minivan'), ('crossover'), ('off-road'), ('cabriolet'), ('truck');
insert into car_engines(name) values ('petrol engine'), ('gas engine'), ('diesel engine'), ('hybrid engine'), ('electric engine');
insert into car_transmissions(name) values ('manual'), ('automatic'), ('semi-automatic'), ('cvt'), ('robot');
insert into cars(name, body_id, engine_id, transmission_id) values  ('Audi', 1, 1, 2);

insert into cars(name, body_id) values  ('Fodr', 3);
insert into cars(name, engine_id) values  ('Mazda', 1);
insert into cars(name, transmission_id) values  ('CITROEN', 1);