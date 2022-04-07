-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: elapid
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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `add_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_address` varchar(45) DEFAULT NULL,
  `add_postnumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`add_id`),
  UNIQUE KEY `add_id_UNIQUE` (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'서울특별시 강남구 도곡동 972 도곡 한라비발디 아파트','6269'),(2,'부산광역시 부산진구 전포동 362-64 한라비발디','47306'),(3,'부산광역시 부산진구 범천동 1000-24 범내골역 한라비발디 STUDIO 422','47280'),(4,'',''),(5,'서울특별시 강남구 도곡동 972 도곡 한라비발디 아파트','06269'),(6,'서울특별시 서초구 서초동 1363-25 한라비발디 스튜디오193','06735'),(7,'경기도 용인시 기흥구 동백동 596 백현마을한라비발디아파트','17003'),(8,'경기도 의정부시 민락동 756-7 한라비발디아파트','11810'),(9,'경기도 하남시 감이동 530 감일 한라비발디','13004'),(10,'경기도 남양주시 별내동 808 별내별가람역 한라비발디','12097'),(11,'경기도 수원시 권선구 당수동 742 한라비발디아파트 2단지','16377'),(12,'서울특별시 강남구 논현동 188-3 아이파크','06118'),(13,'경기도 수원시 권선구 당수동 742 한라비발디아파트 2단지','');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `u_id` varchar(20) NOT NULL,
  `add_id` int(11) NOT NULL AUTO_INCREMENT,
  `reg_specificaddress` varchar(45) DEFAULT NULL,
  `reg_name` varchar(10) DEFAULT NULL,
  `reg_tel` varchar(13) DEFAULT NULL,
  `reg_defaultaddress` int(11) DEFAULT '0',
  KEY `fk_user_has_address_user1_idx` (`u_id`),
  KEY `fk_user_has_address_address1_idx` (`add_id`),
  CONSTRAINT `fk_user_has_address_address1` FOREIGN KEY (`add_id`) REFERENCES `address` (`add_id`),
  CONSTRAINT `fk_user_has_address_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('rlaxodjs7',2,'1234',NULL,NULL,1),('rlaxodjs10',2,'1234',NULL,NULL,1),('rlaxodjs11',3,'1234','송가인','010-1234-1234',1),('rlaxodjs11',10,'1234','김시','010-4567-4567',0);
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `u_id` varchar(20) NOT NULL,
  `u_pwd` varchar(50) DEFAULT NULL,
  `u_name` varchar(45) DEFAULT NULL,
  `u_tel` varchar(13) DEFAULT NULL,
  `u_email` varchar(45) DEFAULT NULL,
  `u_gender` varchar(10) NOT NULL,
  `u_birthdate` date DEFAULT NULL,
  `u_registerdate` date DEFAULT NULL,
  `u_grade` varchar(45) DEFAULT NULL,
  `u_point` int(11) DEFAULT NULL,
  `u_resignationdate` date DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_id_UNIQUE` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('jennie12','qwer1234!@','jennie','010-1234-1243','jennie12@naver.com','female','1991-10-23',NULL,'골드',800,NULL),('rlaxodjs10','qwer1234!@','두먼','010-4321-4321','efwjhiwef@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs11','qwer1234!@','송가인','010-1234-1234','efwhuk@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs2','qwer1234!@','김태언','010-1234-1234','qwer@qwer.com','male','2010-08-12','2022-04-05','브론즈',0,NULL),('rlaxodjs3','qwer1234!@','강백호','010-1234-1234','rlaxodjs3@gmail.com','male','2020-02-16','2022-04-06','브론즈',0,NULL),('rlaxodjs4','qwer1234!@','강태공','010-1234-1234','adnjasd@gmail.com','male','2020-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs5','qwer1234!@','최치수','010-1234-1234','dqwjiodqw@gmail.com','male','2017-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs6','qwer1234!@','김국자','010-1234-1234','qdwdqw@gmail.com','male','2022-10-31','2022-04-06','브론즈',0,NULL),('rlaxodjs7','qwer1234!@','초초초','010-1234-1234','qwenk@gami.com','male','2021-11-11','2022-04-06','브론즈',0,NULL),('rlaxodjs8','qwer1234!@','초초초','010-1234-1234','fwekjnf@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs9','qwer1234!@','최최최','010-4321-4321','rldwqnj@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 19:39:29
