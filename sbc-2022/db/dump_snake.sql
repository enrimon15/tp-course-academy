-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.31

CREATE DATABASE  IF NOT EXISTS `library`;

USE `library`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `street` varchar(30) DEFAULT NULL,
  `civic` varchar(5) DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `home` enum('RESIDENCE','DOMICILE') DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'via le dita dal naso','15a',45136,'DOMICILE'),(2,'via le dita dal naso','15a',45136,'DOMICILE');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documents`
--

DROP TABLE IF EXISTS `documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documents` (
  `id_doc` int NOT NULL AUTO_INCREMENT,
  `name_file` varchar(45) NOT NULL,
  `data_of_input` date NOT NULL,
  `type_of_file` enum('PNG','JPEG','PDF') NOT NULL,
  `type_of_doc` enum('ID_CARD','DRIVER_LICENSE') NOT NULL,
  `file` text NOT NULL,
  `fiscal_code` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documents`
--

LOCK TABLES `documents` WRITE;
/*!40000 ALTER TABLE `documents` DISABLE KEYS */;
INSERT INTO `documents` VALUES (21,'patente','2022-11-17','PNG','DRIVER_LICENSE','iVBORw0KGgoAAAANSUhEUgAAAQAAAAEACAIAAADTED8xAAADrElEQVR4nO3QQQ3AMADEsEIv847DPidLiYwg51RVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVFd+7yX9884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YWlVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV+X09z3yaKscjWQAAAABJRU5ErkJggg==','MLNVLR44R25H501S');
INSERT INTO `documents` VALUES (22,'patente','2021-10-16','PDF','DRIVER_LICENSE','iVBORw0KGgoAAAANSUhEUgAAAQAAAAEACAIAAADTED8xAAADrElEQVR4nO3QQQ3AMADEsEIv847DPidLiYwg51RVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVFd+7yX9884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YGt/8YGh884Oh8c0PhsY3Pxga3/xgaHzzg6HxzQ+Gxjc/GBrf/GBofPODofHND4bGNz8YWlVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV+X09z3yaKscjWQAAAABJRU5ErkJggg==','antscc12g25g456g');
/*!40000 ALTER TABLE `documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `name` varchar(60) DEFAULT NULL,
  `surname` varchar(60) DEFAULT NULL,
  `fiscal_code` varchar(16) NOT NULL,
  `gender` enum('M','F') DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `cell_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`fiscal_code`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('Antonio','Seccia','antscc12g25g456g','M',1,'1888-10-06','3898788552');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `report_ticket_number` int NOT NULL AUTO_INCREMENT,
  `problem_type` enum('NONPAYMENT','PROPERTY_DAMAGED','FAILURE_TO_RETURN','OTHER') DEFAULT NULL,
  `problem_description` varchar(100) DEFAULT NULL,
  `fiscal_code_number` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`report_ticket_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (12,'OTHER','Mi ruba le carameLLE','SCCNTN00L20G141Z'),(13,'OTHER','Mi ruba le carameLLE','SCCNTN00L20G141Z');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-21  9:34:52
