
CREATE DATABASE `yunkongdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL DEFAULT '"aaa"',
  `email` varchar(255) NOT NULL,
  `create_time` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


INSERT INTO `user` (`id`,`username`,`password`,`nickname`,`email`,`create_time`) VALUES (1,'user','11111','aaaa','sssss','safdafsvgfd');
INSERT INTO `user` (`id`,`username`,`password`,`nickname`,`email`,`create_time`) VALUES (2,'user2','22222','bb','sssss','uhmjmhm');
INSERT INTO `user` (`id`,`username`,`password`,`nickname`,`email`,`create_time`) VALUES (3,'user3','33333','cc','ddddddd','ttvsfvsfv');
INSERT INTO `user` (`id`,`username`,`password`,`nickname`,`email`,`create_time`) VALUES (4,'user4','11111','aaaa','sssss','aaaa');
