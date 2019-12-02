CREATE DATABASE tracker;

CREATE TABLE role (
	id serial primary key,
	name varchar(15)
);

CREATE TABLE rule (
	id serial primary key,
	name varchar(20)
);

CREATE TABLE role_rule (
	id_role int references role(id),
	id_rule int references rule(id)
);

CREATE TABLE users (
	id serial primary key,
	name varchar(20),
	id_role int references role(id)
);

CREATE TABLE status (
	id serial primary key,
	name varchar(15)
);

CREATE TABLE request_categories (
	id serial primary key,
	name varchar(15)
);

CREATE TABLE request (
	id serial primary key
	item varchar(100),
	id_user int references users(id),
	id_category int references request_categories(id),
	id_status int references status(id)
);

CREATE TABLE attachments (
	id serial primary key,
	attachment text,
	id_request int references request(id)
);

CREATE TABLE comments (
	id serial primary key,
	comment text,
	id_request int references request(id)
);

INSERT INTO role (name) VALUES ('administrator'), ('guest');

INSERT INTO rule (name) VALUES ('change'), ('read only');

INSERT INTO role_rule (id_role, id_rule) VALUES (1, 1), (2, 2);

INSERT INTO users (name, id_role) VALUES ('Petr', 1), ('Oleg', 2), ('Alena', 2);

INSERT INTO status (name) VALUES ('in progress'), ('done');

INSERT INTO request_categories (name) VALUES ('urgent'), ('not urgent');

INSERT INTO request (item, id_user, id_category, id_status)
VALUES ('The first item', 2, 1, 2), ('The second item', 1, 2, 1), ('The third item', 3, 1, 1);

INSERT INTO attachments (attachment, id_request)
VALUES ('The first file', 1), ('The second file', 3);

INSERT INTO comments (comment, id_request)
VALUES ('The first comment', 1), ('The second comment', 2);