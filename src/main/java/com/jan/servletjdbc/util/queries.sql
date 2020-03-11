create database jdbc_servlet;

use jdbc_servlet;

create table user (id bigint(10) primary key auto_increment,
					user_name varchar(30) not null,
                    password varchar(255) not null,
                    email varchar(50) not null,
                    first_name varchar(50) not null,
                    last_name varchar(50) not null,
                    created_date varchar(50) not null,
                    profile_image varchar(255) null,
                    gender varchar(10) not null);
