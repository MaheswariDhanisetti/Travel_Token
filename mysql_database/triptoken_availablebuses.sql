-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: triptoken
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `availablebuses`
--

DROP TABLE IF EXISTS `availablebuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `availablebuses` (
  `busId` int NOT NULL,
  `TravelersName` varchar(40) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `origin_city` varchar(40) DEFAULT NULL,
  `Destination_city` varchar(40) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`busId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availablebuses`
--

LOCK TABLES `availablebuses` WRITE;
/*!40000 ALTER TABLE `availablebuses` DISABLE KEYS */;
INSERT INTO `availablebuses` VALUES (1,'Blue Star Travels',4.5,'AC','Hyderabad','Vizag',800.00),(2,'Orange Tours',4.2,'Semi-Sleeper','Hyderabad','Vizag',600.00),(3,'APSRTC',4,'Non-AC','Hyderabad','Vizag',500.00),(4,'Greenline',3.8,'Sleeper','Hyderabad','Vizag',700.00),(5,'KSRTC',4.1,'AC','Hyderabad','Vizag',850.00),(6,'VRL Travels',4.3,'Semi-Sleeper','Hyderabad','Vizag',650.00),(7,'SRS Travels',4.2,'Non-AC','Hyderabad','Vizag',550.00),(8,'Neeta Travels',4.6,'Sleeper','Hyderabad','Vizag',750.00),(9,'APSRTC',4.7,'AC','Vijayawada','Tirupati',700.00),(10,'Andhra Pradesh Travels',4.4,'Semi-Sleeper','Vijayawada','Tirupati',650.00),(11,'Greenline Travels',3.9,'Non-AC','Vijayawada','Tirupati',550.00),(12,'SRS Travels',4.1,'Sleeper','Vijayawada','Tirupati',600.00),(13,'Orange Tours',4.5,'AC','Vijayawada','Tirupati',750.00),(14,'KSRTC',4.2,'Semi-Sleeper','Vijayawada','Tirupati',700.00),(15,'VRL Travels',4,'Non-AC','Vijayawada','Tirupati',550.00),(16,'National Express',4.3,'Sleeper','Vijayawada','Tirupati',600.00),(17,'Yellow Bus',4.6,'AC','Visakhapatnam','Guntur',900.00),(18,'Kakatiya Travels',3.9,'Semi-Sleeper','Visakhapatnam','Guntur',750.00),(19,'APSRTC',4.2,'Non-AC','Visakhapatnam','Guntur',650.00),(20,'Kaveri Travels',4.4,'Sleeper','Visakhapatnam','Guntur',800.00),(21,'Andhra Pradesh Travels',3.8,'AC','Visakhapatnam','Guntur',950.00),(22,'Shree Kaleshwari',4.3,'Semi-Sleeper','Visakhapatnam','Guntur',700.00),(23,'Vizag Travels',4.1,'Non-AC','Visakhapatnam','Guntur',600.00),(24,'APSRTC',4.7,'Sleeper','Visakhapatnam','Guntur',850.00),(25,'APSRTC',4.5,'AC','Vijayawada','Rajahmundry',700.00),(26,'Andhra Pradesh Travels',4.2,'Semi-Sleeper','Vijayawada','Rajahmundry',650.00),(27,'Greenline Travels',3.9,'Non-AC','Vijayawada','Rajahmundry',550.00),(28,'SRS Travels',4.1,'Sleeper','Vijayawada','Rajahmundry',600.00),(29,'Orange Tours',4.5,'AC','Vijayawada','Rajahmundry',750.00),(30,'KSRTC',4.2,'Semi-Sleeper','Vijayawada','Rajahmundry',700.00),(31,'VRL Travels',4,'Non-AC','Vijayawada','Rajahmundry',550.00),(32,'National Express',4.3,'Sleeper','Vijayawada','Rajahmundry',600.00),(41,'APSRTC',4.5,'AC','Kakinada','Nellore',750.00),(42,'Andhra Pradesh Travels',4.2,'Semi-Sleeper','Kakinada','Nellore',700.00),(43,'Greenline Travels',3.9,'Non-AC','Kakinada','Nellore',600.00),(44,'SRS Travels',4.1,'Sleeper','Kakinada','Nellore',650.00),(45,'Orange Tours',4.5,'AC','Kakinada','Nellore',800.00),(46,'KSRTC',4.2,'Semi-Sleeper','Kakinada','Nellore',750.00),(47,'VRL Travels',4,'Non-AC','Kakinada','Nellore',600.00),(48,'National Express',4.3,'Sleeper','Kakinada','Nellore',650.00),(49,'APSRTC',4.5,'AC','Vijayawada','Ongole',750.00),(50,'Andhra Pradesh Travels',4.2,'Semi-Sleeper','Vijayawada','Ongole',700.00),(51,'Greenline Travels',3.9,'Non-AC','Vijayawada','Ongole',600.00),(52,'SRS Travels',4.1,'Sleeper','Vijayawada','Ongole',650.00),(53,'Orange Tours',4.5,'AC','Vijayawada','Ongole',800.00),(54,'KSRTC',4.2,'Semi-Sleeper','Vijayawada','Ongole',750.00),(55,'VRL Travels',4,'Non-AC','Vijayawada','Ongole',600.00),(56,'National Express',4.3,'Sleeper','Vijayawada','Ongole',650.00);
/*!40000 ALTER TABLE `availablebuses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-17  9:08:52
