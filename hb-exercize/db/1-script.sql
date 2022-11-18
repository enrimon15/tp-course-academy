CREATE DATABASE  IF NOT EXISTS `tp_academy_db`;

USE `tp_academy_db`;

CREATE USER 'tp_academy_user'@'localhost' IDENTIFIED BY 'tp_academy_password';
GRANT ALL PRIVILEGES ON tp_academy_db.* TO 'tp_academy_user'@'localhost';