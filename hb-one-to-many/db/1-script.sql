CREATE DATABASE  IF NOT EXISTS `tp_academy_db_otm`;

USE `tp_academy_db_otm`;

CREATE USER if not exists 'tp_academy_user_otm'@'localhost' IDENTIFIED BY 'tp_academy_password_otm';
GRANT ALL PRIVILEGES ON tp_academy_db_otm.* TO 'tp_academy_user_otm'@'localhost';

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

DROP TABLE IF EXISTS `skill`;

CREATE TABLE `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_employee_skill` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
);

INSERT INTO `employee_detail` VALUES (1,'elon.musk@aesys.tech','23234234',20);
INSERT INTO `employee` VALUES (1,'Tesla','Elon','Musk',1);

INSERT INTO `skill` VALUES (1,10,'html',1);
INSERT INTO `skill` VALUES (2,10,'css',1);

