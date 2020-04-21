# NewSpringBootProjectConfiguration
帮助快速构建可运行SpringBoot项目

已完成搭建:

## MybatisPlus配置

版本信息：

java:1.8

spring-boot:2.2.4.RELEASE

mybatis-plus-boot-starter:3.3.0

junit:4.12

## MybatisPlus with Redis Lettuce  
版本信息：  
java:1.8  
spring-boot:2.2.4.RELEASE  
mybatis-plus-boot-starter:3.3.0  
junit:4.12  

## MybatisPlus with Redis Jedis  
版本信息：  
java:1.8  
spring-boot:2.2.4.RELEASE  
mybatis-plus-boot-starter:3.3.0  
junit:4.12  
jedis:3.1.0  

## 数据库表 user

 字段|	类型|	大小|	备注
 --|-- | ----- | ------  
id	|int	|11|	用户标识id
username|	varchar|	255	|用户名
password|	varchar|	255	|密码
nickname|	varchar|	255	|昵称
email|	varchar|	255	|邮箱
create_time|	varchar|	30	|昵称

CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_time` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
