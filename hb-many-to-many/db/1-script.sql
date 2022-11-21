CREATE DATABASE  IF NOT EXISTS `tp_academy_db_mtm`;

USE `tp_academy_db_mtm`;

CREATE USER if not exists 'tp_academy_user_mtm'@'localhost' IDENTIFIED BY 'tp_academy_password_mtm';
GRANT ALL PRIVILEGES ON tp_academy_db_mtm.* TO 'tp_academy_user_mtm'@'localhost';

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

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `budget` int(11) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `project_employee`;

CREATE TABLE `project_employee` (
  `employee_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY ( `employee_id`, `project_id`),
  CONSTRAINT `FK_employee_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FK_project_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
);

INSERT INTO `employee_detail` VALUES (1,'elon.musk@aesys.tech','23234234',20);
INSERT INTO `employee` VALUES (1,'Tesla','Elon','Musk',1);

INSERT INTO `skill` VALUES (1,10,'html',1);
INSERT INTO `skill` VALUES (2,10,'css',1);

INSERT INTO `project` VALUES (1,100000,'Intesa San Paolo','Investimenti');
INSERT INTO `project_employee` VALUES (1,1);
