use file_list7;

CREATE TABLE `Account` (
  `username` varchar(100) NOT NULL,
  `encodedPassword` char(32) DEFAULT NULL,
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

insert into file_list7.Account (username, encodedPassword)
values ("klimovich", "ac8c5a0daed34361cb9783e6fbc3b5a6");

insert into file_list7.Account (username, encodedPassword)
values ("makarevich", "cc1de2d8157a0f70c1cb9262059e6215");

--TODO add script for ceating and filling files