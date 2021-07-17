
SET GLOBAL time_zone = '+3:00';
create database if not exists TodoApp;

use TodoApp;

create table if not exists todos(
id int not null auto_increment,
description text not null,
dueDate date not null, 
dueTime time,
status varchar(20),
created_at timestamp default current_timestamp,
last_updated timestamp default current_timestamp,
primary key(id)
);

SELECT * FROM todos;

