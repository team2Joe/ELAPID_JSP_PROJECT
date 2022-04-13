-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: elapid
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `img_id` int NOT NULL,
  `img_thum` varchar(50) DEFAULT NULL,
  `img_01` varchar(50) DEFAULT NULL,
  `img_02` varchar(50) DEFAULT NULL,
  `img_03` varchar(50) DEFAULT NULL,
  `img_04` varchar(50) DEFAULT NULL,
  `img_05` varchar(50) DEFAULT NULL,
  `img_06` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  UNIQUE KEY `img_id_UNIQUE` (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES (1,'elapid_img/luggage/clite_main.jpg','elapid_img/luggage/clite_01.jpg','elapid_img/luggage/clite_02.jpg','elapid_img/luggage/clite_03.jpg','elapid_img/luggage/clite_04.jpg','elapid_img/luggage/clite_05.jpg','elapid_img/luggage/clite_06.jpg'),(2,'elapid_img/luggage/blite_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(3,'elapid_img/luggage/sefton_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(4,'elapid_img/luggage/zira_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(5,'elapid_img/luggage/aspero_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(6,'elapid_img/backpack/travis_main.jpeg','elapid_img/backpack/travis_01.jpg','elapid_img/backpack/travis_02.jpg','elapid_img/backpack/travis_03.jpg','elapid_img/backpack/travis_04.jpg','elapid_img/backpack/travis_05.jpg','elapid_img/backpack/travis_06.jpg'),(7,'elapid_img/backpack/miller_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(8,'elapid_img/backpack/garde_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(9,'elapid_img/backpack/haeil_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(10,'elapid_img/backpack/lions_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(11,'elapid_img/backpack/sammies_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(12,'elapid_img/luggage/clite_main_02.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(13,'elapid_img/luggage/zira_main_02.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(14,'elapid_img/backpack/garde_main_02.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(15,'elapid_img/luggage/denovo_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-13 11:05:05
