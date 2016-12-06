create database points26;

use points26;

CREATE TABLE `points` (
  `x` double NOT NULL,
  `y` double NOT NULL
) ENGINE=InnoDB;

insert into points (x, y) values (0, 0);
insert into points (x, y) values (1, 1);
insert into points (x, y) values (2, 2);
insert into points (x, y) values (3, 3);
insert into points (x, y) values (4, 4);
insert into points (x, y) values (5, 5);
insert into points (x, y) values (6, 6);
insert into points (x, y) values (7, 7);
insert into points (x, y) values (8, 8);
insert into points (x, y) values (9, 9);

CREATE USER 'points26'@'localhost' IDENTIFIED BY 'points26';
GRANT ALL PRIVILEGES ON `points26`.* TO 'points26'@'localhost';
