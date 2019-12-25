create table if not exists items(
             id serial primary key,
             name varchar(100) NOT NULL,
             description varchar(200) NOT NULL
);