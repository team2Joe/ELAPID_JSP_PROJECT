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
-- Table structure for table `nu_cancel`
--

DROP TABLE IF EXISTS `nu_cancel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nu_cancel` (
  `can_id` int(11) NOT NULL,
  `canp_id` int(11) DEFAULT NULL,
  `can_category` varchar(20) DEFAULT NULL,
  `can_reason` varchar(20) DEFAULT NULL,
  `nuod_id` int(11) NOT NULL,
  `cc_name` int(11) NOT NULL,
  PRIMARY KEY (`can_id`),
  KEY `fk_nu_cancel_non_user_order_detail1_idx` (`nuod_id`),
  KEY `fk_nu_cancel_cancelcategory1_idx` (`cc_name`),
  CONSTRAINT `fk_nu_cancel_cancelcategory1` FOREIGN KEY (`cc_name`) REFERENCES `cancelcategory` (`cc_name`),
  CONSTRAINT `fk_nu_cancel_non_user_order_detail1` FOREIGN KEY (`nuod_id`) REFERENCES `non_user_order_detail` (`nuod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nu_cancel`
--

LOCK TABLES `nu_cancel` WRITE;
/*!40000 ALTER TABLE `nu_cancel` DISABLE KEYS */;
/*!40000 ALTER TABLE `nu_cancel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 19:10:48
