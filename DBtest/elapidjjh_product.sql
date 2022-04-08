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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(45) DEFAULT NULL,
  `p_price` int(11) DEFAULT NULL,
  `p_colorimg` varchar(50) DEFAULT NULL,
  `p_colorname` varchar(10) DEFAULT NULL,
  `p_mainf` varchar(20) DEFAULT NULL,
  `p_desc` text,
  `p_date` datetime DEFAULT NULL,
  `p_stock` int(11) DEFAULT NULL,
  `p_clickcount` int(11) DEFAULT NULL,
  `p_discountprice` int(11) DEFAULT NULL,
  `p_size` int(11) DEFAULT NULL,
  `p_imgpath` text,
  `p_ctgmain` varchar(10) DEFAULT NULL,
  `p_ctgmiddle` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `p_id_UNIQUE` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'CLITE',638000,NULL,'black','서스펜션휠','CURV® 테크놀로지와 아이코닉한 디자인으로 많은 사랑을 받은 쌤소나이트 베스트 셀러 Cosmolite 라인이 업그레이드 된 버전인 C-Lite로 돌아 왔습니다. \n\n놀랄만큼 가벼운 무게는 그대로 유지하면서, 더블 튜브 핸들과 더블 휠을 적용하여 기동성과 편리함을 더하였습니다. \n기내형은 확장이 가능하며 USB 포트도 내장되어 있습니다. \n안감은 100% 재활용 PET 플라스틱 페트병을 활용한 Recyclex™ 원단으로 제작되어 지속가능한 발전을 추구하고 있으며 높은 내구성을 자랑합니다. \n• 자체 강화 & 충격 흡수 디자인 \n• 쌤소나이트만의 기술력으로 제작된 초경량 Curv® 소재로, 놀랍도록 가벼운 무게를 자랑함 \n• 100% 재활용 PET 플라스틱 페트병을 활용한 Recyclex™ 원단으로 제작되어 지속가능한 발전을 추구 \n• 길게 확장이 되는 더블 튜브 스틱 핸들 \n• 부드러운 주행이 가능한 더블 휠 \n• 바디컬러와 트림컬러를 매칭하여 고급스러움 \n• 매립형 TSA 잠금장치 적용하여 매끈한 디자인 강조 \n• 기내형 사이즈는 확장할 수 있어서 넉넉한 수납이 가능 \n• 내부에 보조배터리용 포켓과 캐리어 외부/내부를 연결해주는 USB 케이블이 있어서, 전자기기를 충전할 때 편리함. (※ 보조배터리, 연결잭은 별도 구매 필요) \nTSA 잠금장치\n더블 휠\n재활용 페트병을 재가공하여 직조한 원단\nUSB 포트\n종류: 여행가방\n색상: BLACK\n제품소재: HS Curv\n크기: 55.0 x 45.0 x 20.0cm\n확장형: 23.0cm\n용량: 36L\n무게: 2.1kg\n**본 사이트에 게재된 제품 치수는 참고용으로 측정 방법과 조건에 따라 실제와 약간의 차이가 발생할 수 있습니다.\nSKU\nCS2*09007','2022-04-04 00:00:00',99,NULL,638000,55,'elapid_img/luggage/clite_main.jpg','luggage','small'),(2,'BLITE',448000,NULL,'grey','자동제어장치',NULL,NULL,99,NULL,448000,55,'elapid_img/luggage/blite_main.jpg','luggage','small'),(3,'SEFTON',428000,NULL,'black','rfid',NULL,NULL,99,NULL,342000,66,'elapid_img/luggage/sefton_main.jpg','luggage','middle'),(4,'ZIRA',411000,NULL,NULL,'지문인식',NULL,NULL,99,NULL,288000,66,'elapid_img/luggage/zira_main.jpg','luggage','middle'),(5,'ASPERO',294000,NULL,'red','서스펜션휠',NULL,NULL,99,NULL,294000,77,'elapid_img/luggage/aspero_main.jpg','luggage','large'),(6,'TRAVIS',484000,NULL,NULL,'지문인식',NULL,NULL,99,NULL,339000,NULL,'elapid_img/backpack/travis_main.jpeg','backpack','business'),(7,'MILLER',519000,NULL,NULL,'rfid',NULL,NULL,99,NULL,519000,NULL,'elapid_img/backpack/miller_main.jpeg','backpack','business'),(8,'GARDE',268000,NULL,'black','지문인식',NULL,NULL,99,NULL,268000,NULL,'elapid_img/backpack/garde_main.jpeg','backpack','casual'),(9,'HAEIL',129000,NULL,NULL,'rfid',NULL,NULL,99,NULL,99000,NULL,'elapid_img/backpack/haeil_main.jpeg','backpack','casual'),(10,'LIONS',97000,NULL,NULL,'',NULL,NULL,99,NULL,68000,NULL,'elapid_img/backpack/lions_main.jpeg','backpack','other'),(11,'SAMMIES',97000,NULL,NULL,'',NULL,NULL,99,NULL,68000,NULL,'elapid_img/backpack/sammies_main.jpeg','backpack','other'),(12,'CLITE',738000,NULL,NULL,'서스펜션휠',NULL,NULL,NULL,NULL,738000,66,NULL,'luggage','middle'),(13,'ZIRA',511000,NULL,NULL,'지문인식',NULL,NULL,0,NULL,388000,77,NULL,'luggage','large'),(14,'GARDE',268000,NULL,'grey','지문인식',NULL,NULL,NULL,NULL,268000,NULL,NULL,'backpack','casual'),(15,'DENOVO',890000,NULL,'white','rfid',NULL,NULL,5,NULL,890000,77,'elapid_img/luggage/denovo_main.jpg','luggage','large');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 19:10:31
