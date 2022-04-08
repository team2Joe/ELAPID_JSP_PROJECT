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
-- Table structure for table `user_order_detailfewaqfw`
--

DROP TABLE IF EXISTS `user_order_detailfewaqfw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_order_detailfewaqfw` (
  `uod_id` int(11) NOT NULL,
  `uod_coupon` varchar(45) DEFAULT NULL,
  `re_id` int(11) NOT NULL,
  `uo_id` int(11) NOT NULL,
  `urf_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`uod_id`),
  KEY `fk_user_order_detail_review1_idx` (`re_id`),
  KEY `fk_user_order_detail_user_order1_idx` (`uo_id`),
  KEY `fk_user_order_detail_u_refund1_idx` (`urf_id`),
  KEY `fk_user_order_detail_product1_idx` (`p_id`),
  CONSTRAINT `fk_user_order_detail_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_user_order_detail_review1` FOREIGN KEY (`re_id`) REFERENCES `review` (`re_id`),
  CONSTRAINT `fk_user_order_detail_u_refund1` FOREIGN KEY (`urf_id`) REFERENCES `u_refund` (`urf_id`),
  CONSTRAINT `fk_user_order_detail_user_order1` FOREIGN KEY (`uo_id`) REFERENCES `user_order` (`uo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order_detailfewaqfw`
--

LOCK TABLES `user_order_detailfewaqfw` WRITE;
/*!40000 ALTER TABLE `user_order_detailfewaqfw` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_order_detailfewaqfw` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 19:10:47
