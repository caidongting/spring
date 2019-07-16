create table if not exists users
(
    id       int(10) auto_increment primary key,
    name     varchar(45) not null,
    password varchar(20) not null
) engine = innodb
  charset = 'utf8';

create table if not exists player
(
    id   INT(10)      not null primary key,
    name varchar(255) not null
) engine = innodb
  charset = 'utf8';

create table if not exists space
(
    user_id  INT(10) not null primary key,
    space_id int(10) not null,
    context  blob default null,
    unique index i_space_id (space_id)
) engine = innodb
  charset = 'utf8';