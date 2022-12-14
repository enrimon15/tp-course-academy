CREATE DATABASE  IF NOT EXISTS `tp_academy_db_hb`;

USE `tp_academy_db_hb`;

CREATE USER 'tp_academy_user_hb'@'localhost' IDENTIFIED BY 'tp_academy_password_hb';
GRANT ALL PRIVILEGES ON tp_academy_db_hb.* TO 'tp_academy_user_hb'@'localhost';

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Data for table `employee`
--

INSERT INTO `employee`(id,first_name,last_name,company) VALUES
	(1,'Sundar','Pichai','Google'),
	(2,'Tim','Cook','Apple'),
	(3,'Mark','Zuckerberg','Meta'),
	(4,'Larry','Ellison','Oracle'),
	(5,'Elon','Musk','Tesla');