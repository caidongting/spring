SET CHARSET utf8;

CREATE TABLE IF NOT EXISTS users (
    id       INT(10) AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(45) NOT NULL,
    password VARCHAR(20) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS player (
    id   INT(10) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS space (
    user_id  INT(10) NOT NULL,
    space_id INT(10) NOT NULL,
    context  BLOB DEFAULT NULL,
    PRIMARY KEY (user_id, space_id),
    UNIQUE INDEX i_user_id (user_id),
    UNIQUE INDEX i_space_id (space_id)
) ENGINE = InnoDB COMMENT ='用户空间';