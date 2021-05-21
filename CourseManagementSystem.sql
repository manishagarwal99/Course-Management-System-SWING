CREATE DATABASE  IF NOT EXISTS `course_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `course_management`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: course_management
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `course_info`
--

DROP TABLE IF EXISTS `course_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_info` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) DEFAULT NULL,
  `instructor_id` int DEFAULT NULL,
  `textbook_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_info`
--

LOCK TABLES `course_info` WRITE;
/*!40000 ALTER TABLE `course_info` DISABLE KEYS */;
INSERT INTO `course_info` VALUES (56,'Computer(XII-E)',55,25),(57,'Computer(X)',54,22),(58,'Mathematics(X-F)',57,23),(59,'Physics(JEE)',56,26),(63,'Spoken English',53,24),(64,'Computer(XII-F)',58,25);
/*!40000 ALTER TABLE `course_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_info`
--

DROP TABLE IF EXISTS `instructor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_info` (
  `instructor_id` int NOT NULL AUTO_INCREMENT,
  `instructor_name` varchar(45) DEFAULT NULL,
  `instructor_phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`instructor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_info`
--

LOCK TABLES `instructor_info` WRITE;
/*!40000 ALTER TABLE `instructor_info` DISABLE KEYS */;
INSERT INTO `instructor_info` VALUES (53,'Ladly Rout','9876543210'),(54,'Debanjali Jyoti Chattopadhyay','8976543210'),(55,'Manish Agarwal','7896543210'),(56,'Kevin Juthani','6789543210'),(57,'Harsh Verma(id:57)','7885544321'),(58,'Harsh Verma(id:58)','8877665544');
/*!40000 ALTER TABLE `instructor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `textbook_info`
--

DROP TABLE IF EXISTS `textbook_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `textbook_info` (
  `textbook_id` int NOT NULL AUTO_INCREMENT,
  `textbook_title` varchar(45) DEFAULT NULL,
  `textbook_author` varchar(45) DEFAULT NULL,
  `textbook_publisher` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`textbook_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `textbook_info`
--

LOCK TABLES `textbook_info` WRITE;
/*!40000 ALTER TABLE `textbook_info` DISABLE KEYS */;
INSERT INTO `textbook_info` VALUES (22,'Understanding Computer Science','Dilip Kumar Dey','APC'),(23,'Mathematics','M. L. Agarwal','APC'),(24,'English Language','J. Basak','APCC'),(25,'Computer Science with JAVA','Sumita Arora','Dhanpat Rai & Co.'),(26,'Concepts of Physics','H. C. Verma','Bharati Bhavan');
/*!40000 ALTER TABLE `textbook_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'course_management'
--

--
-- Dumping routines for database 'course_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-21 18:14:22
