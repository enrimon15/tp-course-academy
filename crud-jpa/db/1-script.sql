CREATE DATABASE  IF NOT EXISTS `tp_academy_db_jpa`;

USE `tp_academy_db_jpa`;

CREATE USER 'tp_academy_user_jpa'@'localhost' IDENTIFIED BY 'tp_academy_password_jpa';
GRANT ALL PRIVILEGES ON tp_academy_db_jpa.* TO 'tp_academy_user_jpa'@'localhost';

DROP TABLE IF EXISTS `employee_detail`;

CREATE TABLE `employee_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `year_experience` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_email` (`email`)
);

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `employee_detail_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_employee_detail` FOREIGN KEY (`employee_detail_id`) REFERENCES `employee_detail` (`id`)
);

INSERT INTO `employee_detail` VALUES (1,'elon.musk@aesys.tech','23234234',20);
INSERT INTO `employee` VALUES (1,'Tesla','Elon','Musk',1);

INSERT INTO `employee_detail` VALUES (2,'jeff.bezos@aesys.tech','23234234',20);
INSERT INTO `employee` VALUES (2,'Amazon','Jeff','Bezos',2);

