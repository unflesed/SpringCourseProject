create database subscription;

use subscription;

create table profile(
id int auto_increment not null,
first_name varchar(30) not null,
last_name varchar(30) not null,
email varchar(30) not null,
phone varchar(30) not null,
primary key (id)
);

CREATE  TABLE users (
username VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
enabled TINYINT DEFAULT 1,
profile_id int,
foreign key (profile_id) references profile(id),
PRIMARY KEY (username)
);

CREATE TABLE user_roles (
user_role_id int NOT NULL AUTO_INCREMENT,
username varchar(30) NOT NULL,
role varchar(30) NOT NULL,
PRIMARY KEY (user_role_id),
FOREIGN KEY (username) REFERENCES users (username)
);

create table journal(
id int auto_increment not null,
journal_name varchar(30) not null,
genre varchar(30) not null,
periodicity varchar(30) not null,
cost int not null,
primary key(id)
);

create table users_journal(
username VARCHAR(30) NOT NULL,
journal_id int not null,
primary key (username, journal_id),
foreign key (username) references users(username),
foreign key (journal_id) references journal(id)
);

insert into profile(first_name, last_name, email, phone)
values ('Ivan', 'Petrov', 'petrov@mail.ru', '+12345678'),
	   ('Petr', 'Ivanov', 'ivanov@gmail.com', '+87654321');
       
insert into users(username, password, profile_id, enabled)
values ('Admin', '{noop}123', '1', true),
	   ('User1', '{noop}123', '2', true);
       
insert into user_roles(username, role)
values  ('admin', 'ROLE_ADMIN'),
		('user1', 'ROLE_USER');

insert into journal(journal_name, genre, periodicity, cost)
values ('Driver', 'Auto', 'Once a week', '3'),
	   ('Garden', 'Gardening', 'Once a week', '2'),
	   ('Gamer', 'Video games', 'Once a month', '5');
       
insert into users_journal(username, journal_id)
values ('Admin', '1'),
	   ('Admin','3'),
	   ('User1','2');
       