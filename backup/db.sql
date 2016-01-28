DROP database db_ms;
CREATE database db_ms;

USE db_ms;

CREATE TABLE ms_tb_student (
    id INT(4) NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(40) NOT NULL,
    age INT(4)
);

INSERT INTO ms_tb_student(name, age) VALUES ('test', 22);