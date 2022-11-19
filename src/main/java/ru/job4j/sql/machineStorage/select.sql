select c.name Авто, cb.name Кузов, ce.name Двигатель, ct.name Трансмиссия
from cars c
left join car_bodies cb ON cb.id = c.body_id
left join car_engines ce ON ce.id = c.engine_id
left join car_transmissions ct ON ct.id = c.transmission_id

select c.name Авто, cb.name Кузов
from car_bodies cb
left join cars c on cb.id = c.body_id
left join car_engines ce on ce.id = c.engine_id
where c.body_id is null;

select c.name Авто, ce.name Двигатель
from car_engines ce
left join cars c on ce.id = c.engine_id
left join car_bodies cb on cb.id = c.body_id
where c.engine_id is null;

select c.name Авто, ct.name Трансмиссия
from car_transmissions ct
left join cars c on ct.id = c.transmission_id
left join car_engines ce on ce.id = c.engine_id
where c.transmission_id is null;