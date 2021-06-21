create table country
(
    id        int primary key auto_increment,
    name      varchar(128) not null,
    code      varchar(2)   not null,
    continent varchar(100) not null
);