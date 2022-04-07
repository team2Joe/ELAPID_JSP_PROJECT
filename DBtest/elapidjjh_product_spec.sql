-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: elapidjjh
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `product_spec`
--

DROP TABLE IF EXISTS `product_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_spec` (
  `ps_id` int(11) NOT NULL,
  `ps_material` varchar(20) DEFAULT NULL,
  `ps_color` varchar(20) DEFAULT NULL,
  `ps_size` int(11) DEFAULT NULL,
  `ps_height` int(11) DEFAULT NULL,
  `ps_depth` int(11) DEFAULT NULL,
  `ps_width` int(11) DEFAULT NULL,
  `ps_volume` int(11) DEFAULT NULL,
  `ps_weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`ps_id`),
  UNIQUE KEY `ps_id_UNIQUE` (`ps_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_spec`
--

LOCK TABLES `product_spec` WRITE;
/*!40000 ALTER TABLE `product_spec` DISABLE KEYS */;
INSERT INTO `product_spec` VALUES (1,'hard','black',55,55,20,45,36,2),(2,'soft','grey',55,55,24,36,43,2),(3,'soft','black',55,55,26,36,34,3),(4,'soft','black',67,67,29,42,63,3),(5,'hard','red',77,77,27,46,74,3),(6,NULL,'black',41,41,12,31,NULL,1),(7,NULL,'black',44,44,17,31,NULL,1),(8,NULL,'black',43,43,17,30,NULL,1),(9,NULL,'blue',46,46,12,31,NULL,1),(10,NULL,'yellow',37,37,17,30,NULL,1),(11,NULL,'yellow',37,37,17,30,NULL,1),(12,NULL,'black',77,77,27,46,75,3),(13,NULL,'grey',49,79,28,48,77,3),(14,NULL,'grey',44,44,15,31,NULL,1),(15,NULL,'white',76,76,31,54,95,4);
/*!40000 ALTER TABLE `product_spec` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 19:10:39
