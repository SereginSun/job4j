CREATE DATABASE car_storage;

CREATE TABLE car_body (
	id serial primary key,
	name varchar(30)
);

CREATE TABLE engine (
	id serial primary key,
	name varchar(20)
);

CREATE TABLE transmission (
	id serial primary key,
	name varchar(25)
);

CREATE TABLE car (
	id serial primary key,
	name varchar(25),
	car_body_id int references car_body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into car_body (name)
VALUES ('sedan'), ('hatchback'), ('station wagon'), ('liftback'), ('Sport Utility Vehicle'), ('Crossover Utility Vehicle');
insert into engine (name)
VALUES ('petrol'), ('diesel'), ('gas'), ('hybrid'), ('electric motor');
insert into transmission (name)
VALUES ('manual'), ('automatic'), ('robotic'), ('variable');
insert into car (name, car_body_id, engine_id, transmission_id)
VALUES ('LADA', 3, 3, 3), ('Tesla', 4, 5, 2), ('BMW', 5, 1, 1), ('Volvo', 2, 2, 2);

--1. Display a list of all machines and all parts attached to them.
SELECT c.name, cb.name, e.name, t.name
FROM car AS c
INNER JOIN car_body AS cb ON cb.id = c.car_body_id
INNER JOIN engine AS e ON e.id = c.engine_id
INNER JOIN transmission AS t ON t.id = c.transmission_id;

--2. Display a list separate parts that are not used in the car, bodies, engines, gearboxes separately.
SELECT name FROM
(SELECT cb.name
FROM car AS c 
RIGHT OUTER JOIN car_body AS cb ON cb.id = c.car_body_id
WHERE c.id IS NULL) AS foo
UNION
(SELECT e.name
FROM car AS c 
RIGHT OUTER JOIN engine AS e ON e.id = c.engine_id
WHERE c.id IS NULL)
UNION
(SELECT t.name
FROM car AS c 
RIGHT OUTER JOIN transmission AS t ON t.id = c.transmission_id
WHERE c.id IS NULL);