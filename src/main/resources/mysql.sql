create table users
(
    id       int(10) auto_increment primary key,
    name     varchar(45) not null,
    password varchar(20) not null
) engine = innodb
  charset = 'utf-8';