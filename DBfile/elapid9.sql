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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `add_id` int NOT NULL AUTO_INCREMENT,
  `add_address` varchar(45) DEFAULT NULL,
  `add_postnumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`add_id`),
  UNIQUE KEY `add_id_UNIQUE` (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'서울특별시 강남구 도곡동 972 도곡 한라비발디 아파트','6269'),(2,'부산광역시 부산진구 전포동 362-64 한라비발디','47306'),(3,'부산광역시 부산진구 범천동 1000-24 범내골역 한라비발디 STUDIO 422','47280'),(4,'',''),(5,'서울특별시 강남구 도곡동 972 도곡 한라비발디 아파트','06269'),(6,'서울특별시 서초구 서초동 1363-25 한라비발디 스튜디오193','06735'),(7,'경기도 용인시 기흥구 동백동 596 백현마을한라비발디아파트','17003'),(8,'경기도 의정부시 민락동 756-7 한라비발디아파트','11810'),(9,'경기도 하남시 감이동 530 감일 한라비발디','13004'),(10,'경기도 남양주시 별내동 808 별내별가람역 한라비발디','12097'),(11,'경기도 수원시 권선구 당수동 742 한라비발디아파트 2단지','16377'),(12,'서울특별시 강남구 논현동 188-3 아이파크','06118'),(13,'경기도 수원시 권선구 당수동 742 한라비발디아파트 2단지',''),(14,'경기도 남양주시 호평동 678 호평마을한라비발디 상가','12146');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancelcategory`
--

DROP TABLE IF EXISTS `cancelcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancelcategory` (
  `cc_name` int NOT NULL,
  PRIMARY KEY (`cc_name`),
  UNIQUE KEY `cc_name_UNIQUE` (`cc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancelcategory`
--

LOCK TABLES `cancelcategory` WRITE;
/*!40000 ALTER TABLE `cancelcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `cancelcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `u_id` varchar(20) NOT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `cart_id_UNIQUE` (`cart_id`),
  KEY `fk_cart_user1_idx` (`u_id`),
  CONSTRAINT `fk_cart_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (2,'rlaxodjs11'),(1,'siri123');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_detail`
--

DROP TABLE IF EXISTS `cart_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_detail` (
  `cd_id` int NOT NULL AUTO_INCREMENT,
  `p_id` int NOT NULL,
  `cart_id` int NOT NULL,
  PRIMARY KEY (`cd_id`,`p_id`,`cart_id`),
  UNIQUE KEY `cd_id_UNIQUE` (`cd_id`),
  KEY `fk_product_has_cart_cart1_idx` (`cart_id`),
  KEY `fk_product_has_cart_product1_idx` (`p_id`),
  CONSTRAINT `fk_product_has_cart_cart1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`),
  CONSTRAINT `fk_product_has_cart_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_detail`
--

LOCK TABLES `cart_detail` WRITE;
/*!40000 ALTER TABLE `cart_detail` DISABLE KEYS */;
INSERT INTO `cart_detail` VALUES (1,1,1),(2,1,1),(3,2,1),(4,2,2),(5,1,2),(6,1,2);
/*!40000 ALTER TABLE `cart_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `ctg_id` int NOT NULL,
  `ctg_main` varchar(10) DEFAULT NULL,
  `ctg_middle` varchar(15) DEFAULT NULL,
  `ctg_sub` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ctg_id`),
  UNIQUE KEY `ctg_id_UNIQUE` (`ctg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'luggage','small',NULL),(2,'luggage','small',NULL),(3,'luggage','middle',NULL),(4,'luggage','middle',NULL),(5,'luggage','large',NULL),(6,'backpack','business',NULL),(7,'backpack','business',NULL),(8,'backpack','casual',NULL),(9,'backpack','casual',NULL),(10,'backpack','other',NULL),(11,'backpack','other',NULL),(12,'luggage','middle',NULL),(13,'luggage','large',NULL),(14,'backpack','casual',NULL),(15,'luggage','large',NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_detail`
--

DROP TABLE IF EXISTS `category_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_detail` (
  `ctg_id` int NOT NULL,
  `p_id` int NOT NULL,
  KEY `fk_category_has_product_product1_idx` (`p_id`),
  KEY `fk_category_has_product_category1_idx` (`ctg_id`),
  CONSTRAINT `fk_category_has_product_category1` FOREIGN KEY (`ctg_id`) REFERENCES `category` (`ctg_id`),
  CONSTRAINT `fk_category_has_product_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_detail`
--

LOCK TABLES `category_detail` WRITE;
/*!40000 ALTER TABLE `category_detail` DISABLE KEYS */;
INSERT INTO `category_detail` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15);
/*!40000 ALTER TABLE `category_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupon` (
  `c_id` int NOT NULL,
  `c_name` varchar(45) DEFAULT NULL,
  `c-atleastprice` int DEFAULT NULL,
  `c_termofusedesc` varchar(45) DEFAULT NULL,
  `c_value` int DEFAULT NULL,
  `c_period` datetime DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_id_UNIQUE` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_detail`
--

DROP TABLE IF EXISTS `image_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_detail` (
  `img_id` int NOT NULL,
  `p_id` int NOT NULL,
  KEY `fk_image_detail_product_image1_idx` (`img_id`),
  KEY `fk_image_detail_product1_idx` (`p_id`),
  CONSTRAINT `fk_image_detail_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_image_detail_product_image1` FOREIGN KEY (`img_id`) REFERENCES `product_image` (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_detail`
--

LOCK TABLES `image_detail` WRITE;
/*!40000 ALTER TABLE `image_detail` DISABLE KEYS */;
INSERT INTO `image_detail` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15);
/*!40000 ALTER TABLE `image_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_log`
--

DROP TABLE IF EXISTS `login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_log` (
  `lo_id` int NOT NULL,
  `lo_date` datetime DEFAULT NULL,
  `user_u_id` varchar(20) NOT NULL,
  PRIMARY KEY (`lo_id`),
  UNIQUE KEY `lo_id_UNIQUE` (`lo_id`),
  KEY `fk_login_log_user1_idx` (`user_u_id`),
  CONSTRAINT `fk_login_log_user1` FOREIGN KEY (`user_u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_log`
--

LOCK TABLES `login_log` WRITE;
/*!40000 ALTER TABLE `login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `non_user_order`
--

DROP TABLE IF EXISTS `non_user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `non_user_order` (
  `nu_id` int NOT NULL AUTO_INCREMENT,
  `nu_orderdate` datetime DEFAULT NULL,
  `nu_name` varchar(10) DEFAULT NULL,
  `nu_tel` varchar(13) DEFAULT NULL,
  `nu_email` varchar(45) DEFAULT NULL,
  `nu_address` varchar(50) DEFAULT NULL,
  `nuo_amount` int DEFAULT NULL,
  `nuo_discountedamount` int DEFAULT NULL,
  `uo_shippingfee` int DEFAULT NULL,
  `uo_paymentmethod` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nu_id`),
  UNIQUE KEY `nu_id_UNIQUE` (`nu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `non_user_order`
--

LOCK TABLES `non_user_order` WRITE;
/*!40000 ALTER TABLE `non_user_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `non_user_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `non_user_order_detail`
--

DROP TABLE IF EXISTS `non_user_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `non_user_order_detail` (
  `nuod_id` int NOT NULL AUTO_INCREMENT,
  `p_count` int DEFAULT NULL,
  `nu_id` int NOT NULL,
  `nrf_id` int NOT NULL,
  PRIMARY KEY (`nuod_id`),
  UNIQUE KEY `nuod_id_UNIQUE` (`nuod_id`),
  KEY `fk_non_user_order_detail_non_user_order1_idx` (`nu_id`),
  KEY `fk_non_user_order_detail_nu_refund1_idx` (`nrf_id`),
  CONSTRAINT `fk_non_user_order_detail_non_user_order1` FOREIGN KEY (`nu_id`) REFERENCES `non_user_order` (`nu_id`),
  CONSTRAINT `fk_non_user_order_detail_nu_refund1` FOREIGN KEY (`nrf_id`) REFERENCES `nu_refund` (`nrf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `non_user_order_detail`
--

LOCK TABLES `non_user_order_detail` WRITE;
/*!40000 ALTER TABLE `non_user_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `non_user_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nu_cancel`
--

DROP TABLE IF EXISTS `nu_cancel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nu_cancel` (
  `can_id` int NOT NULL,
  `canp_id` int DEFAULT NULL,
  `can_category` varchar(20) DEFAULT NULL,
  `can_reason` varchar(20) DEFAULT NULL,
  `nuod_id` int NOT NULL,
  `cc_name` int NOT NULL,
  PRIMARY KEY (`can_id`),
  KEY `fk_nu_cancel_non_user_order_detail1_idx` (`nuod_id`),
  KEY `fk_nu_cancel_cancelcategory1_idx` (`cc_name`),
  CONSTRAINT `fk_nu_cancel_cancelcategory1` FOREIGN KEY (`cc_name`) REFERENCES `cancelcategory` (`cc_name`),
  CONSTRAINT `fk_nu_cancel_non_user_order_detail1` FOREIGN KEY (`nuod_id`) REFERENCES `non_user_order_detail` (`nuod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nu_cancel`
--

LOCK TABLES `nu_cancel` WRITE;
/*!40000 ALTER TABLE `nu_cancel` DISABLE KEYS */;
/*!40000 ALTER TABLE `nu_cancel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nu_refund`
--

DROP TABLE IF EXISTS `nu_refund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nu_refund` (
  `nrf_id` int NOT NULL AUTO_INCREMENT,
  `nrf_reason` varchar(20) DEFAULT NULL,
  `nrf_img` varchar(100) DEFAULT NULL,
  `nrf_status` varchar(45) DEFAULT NULL,
  `rc_name` varchar(20) NOT NULL,
  PRIMARY KEY (`nrf_id`),
  UNIQUE KEY `nrf_id_UNIQUE` (`nrf_id`),
  KEY `fk_nu_refund_refund_category1_idx` (`rc_name`),
  CONSTRAINT `fk_nu_refund_refund_category1` FOREIGN KEY (`rc_name`) REFERENCES `refund_category` (`rc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nu_refund`
--

LOCK TABLES `nu_refund` WRITE;
/*!40000 ALTER TABLE `nu_refund` DISABLE KEYS */;
/*!40000 ALTER TABLE `nu_refund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `p_name` varchar(45) DEFAULT NULL,
  `p_price` int DEFAULT NULL,
  `p_colorimg` varchar(50) DEFAULT NULL,
  `p_colorname` varchar(10) DEFAULT NULL,
  `p_mainf` varchar(20) DEFAULT NULL,
  `p_desc` text,
  `p_date` datetime DEFAULT NULL,
  `p_stock` int DEFAULT NULL,
  `p_clickcount` int DEFAULT NULL,
  `p_discountprice` int DEFAULT NULL,
  `p_size` int DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `p_id_UNIQUE` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'CLITE',638000,NULL,'black','서스펜션휠','CURV® 테크놀로지와 아이코닉한 디자인으로 많은 사랑을 받은 쌤소나이트 베스트 셀러 Cosmolite 라인이 업그레이드 된 버전인 C-Lite로 돌아 왔습니다. \n\n놀랄만큼 가벼운 무게는 그대로 유지하면서, 더블 튜브 핸들과 더블 휠을 적용하여 기동성과 편리함을 더하였습니다. \n기내형은 확장이 가능하며 USB 포트도 내장되어 있습니다. \n안감은 100% 재활용 PET 플라스틱 페트병을 활용한 Recyclex™ 원단으로 제작되어 지속가능한 발전을 추구하고 있으며 높은 내구성을 자랑합니다. \n• 자체 강화 & 충격 흡수 디자인 \n• 쌤소나이트만의 기술력으로 제작된 초경량 Curv® 소재로, 놀랍도록 가벼운 무게를 자랑함 \n• 100% 재활용 PET 플라스틱 페트병을 활용한 Recyclex™ 원단으로 제작되어 지속가능한 발전을 추구 \n• 길게 확장이 되는 더블 튜브 스틱 핸들 \n• 부드러운 주행이 가능한 더블 휠 \n• 바디컬러와 트림컬러를 매칭하여 고급스러움 \n• 매립형 TSA 잠금장치 적용하여 매끈한 디자인 강조 \n• 기내형 사이즈는 확장할 수 있어서 넉넉한 수납이 가능 \n• 내부에 보조배터리용 포켓과 캐리어 외부/내부를 연결해주는 USB 케이블이 있어서, 전자기기를 충전할 때 편리함. (※ 보조배터리, 연결잭은 별도 구매 필요) \nTSA 잠금장치\n더블 휠\n재활용 페트병을 재가공하여 직조한 원단\nUSB 포트\n종류: 여행가방\n색상: BLACK\n제품소재: HS Curv\n크기: 55.0 x 45.0 x 20.0cm\n확장형: 23.0cm\n용량: 36L\n무게: 2.1kg\n**본 사이트에 게재된 제품 치수는 참고용으로 측정 방법과 조건에 따라 실제와 약간의 차이가 발생할 수 있습니다.\nSKU\nCS2*09007','2022-04-04 00:00:00',99,NULL,638000,55),(2,'BLITE',448000,NULL,'grey','자동제어장치',NULL,NULL,99,NULL,448000,55),(3,'SEFTON',428000,NULL,'black','rfid',NULL,NULL,99,NULL,342000,66),(4,'ZIRA',411000,NULL,NULL,'지문인식',NULL,NULL,99,NULL,288000,66),(5,'ASPERO',294000,NULL,'red','서스펜션휠',NULL,NULL,99,NULL,294000,77),(6,'TRAVIS',484000,NULL,NULL,'지문인식',NULL,NULL,99,NULL,339000,NULL),(7,'MILLER',519000,NULL,NULL,'rfid',NULL,NULL,99,NULL,519000,NULL),(8,'GARDE',268000,NULL,'black','지문인식',NULL,NULL,99,NULL,268000,NULL),(9,'HAEIL',129000,NULL,NULL,'rfid',NULL,NULL,99,NULL,99000,NULL),(10,'LIONS',97000,NULL,NULL,'',NULL,NULL,99,NULL,68000,NULL),(11,'SAMMIES',97000,NULL,NULL,'',NULL,NULL,99,NULL,68000,NULL),(12,'CLITE',738000,NULL,NULL,'서스펜션휠',NULL,NULL,NULL,NULL,738000,66),(13,'ZIRA',511000,NULL,NULL,'지문인식',NULL,NULL,0,NULL,388000,77),(14,'GARDE',268000,NULL,'grey','지문인식',NULL,NULL,NULL,NULL,268000,NULL),(15,'DENOVO',890000,NULL,'white','rfid',NULL,NULL,5,NULL,890000,77);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_detail` (
  `ps_id` int NOT NULL,
  `p_id` int NOT NULL,
  KEY `fk_product_detail_product_spec1_idx` (`ps_id`),
  KEY `fk_product_detail_product1_idx` (`p_id`),
  CONSTRAINT `fk_product_detail_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_product_detail_product_spec1` FOREIGN KEY (`ps_id`) REFERENCES `product_spec` (`ps_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
INSERT INTO `product_detail` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15);
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `product_image` VALUES (1,'elapid_img/luggage/blite_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(2,'elapid_img/luggage/blite_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(3,'elapid_img/luggage/sefton_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(4,'elapid_img/luggage/zira_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(5,'elapid_img/luggage/aspero_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL),(6,'elapid_img/backpack/travis_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(7,'elapid_img/backpack/miller_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(8,'elapid_img/backpack/garde_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(9,'elapid_img/backpack/haeil_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(10,'elapid_img/backpack/lions_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(11,'elapid_img/backpack/sammies_main.jpeg',NULL,NULL,NULL,NULL,NULL,NULL),(12,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'elapid_img/luggage/denovo_main.jpg',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_question`
--

DROP TABLE IF EXISTS `product_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_question` (
  `qc_name` varchar(10) NOT NULL,
  `u_id` varchar(20) NOT NULL,
  `pq_id` int NOT NULL,
  `pq_title` varchar(45) DEFAULT NULL,
  `pq_content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pq_id`),
  UNIQUE KEY `pq_id_UNIQUE` (`pq_id`),
  KEY `fk_question_category_has_user_user1_idx` (`u_id`),
  KEY `fk_question_category_has_user_question_category1_idx` (`qc_name`),
  CONSTRAINT `fk_question_category_has_user_question_category1` FOREIGN KEY (`qc_name`) REFERENCES `question_category` (`qc_name`),
  CONSTRAINT `fk_question_category_has_user_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_question`
--

LOCK TABLES `product_question` WRITE;
/*!40000 ALTER TABLE `product_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_spec`
--

DROP TABLE IF EXISTS `product_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_spec` (
  `ps_id` int NOT NULL,
  `ps_material` varchar(20) DEFAULT NULL,
  `ps_color` varchar(20) DEFAULT NULL,
  `ps_size` int DEFAULT NULL,
  `ps_height` int DEFAULT NULL,
  `ps_depth` int DEFAULT NULL,
  `ps_width` int DEFAULT NULL,
  `ps_volume` int DEFAULT NULL,
  `ps_weight` int DEFAULT NULL,
  PRIMARY KEY (`ps_id`),
  UNIQUE KEY `ps_id_UNIQUE` (`ps_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_spec`
--

LOCK TABLES `product_spec` WRITE;
/*!40000 ALTER TABLE `product_spec` DISABLE KEYS */;
INSERT INTO `product_spec` VALUES (1,'hard','black',55,55,20,45,36,2),(2,'soft','grey',55,55,24,36,43,2),(3,'soft','black',55,55,26,36,34,3),(4,'soft','black',67,67,29,42,63,3),(5,'hard','red',77,77,27,46,74,3),(6,NULL,'black',41,41,12,31,NULL,1),(7,NULL,'black',44,44,17,31,NULL,1),(8,NULL,'black',43,43,17,30,NULL,1),(9,NULL,'blue',46,46,12,31,NULL,1),(10,NULL,'yellow',37,37,17,30,NULL,1),(11,NULL,'yellow',37,37,17,30,NULL,1),(12,NULL,'black',77,77,27,46,75,3),(13,NULL,'grey',49,79,28,48,77,3),(14,NULL,'grey',44,44,15,31,NULL,1),(15,NULL,'white',76,76,31,54,95,4);
/*!40000 ALTER TABLE `product_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_category`
--

DROP TABLE IF EXISTS `question_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_category` (
  `qc_name` varchar(10) NOT NULL,
  PRIMARY KEY (`qc_name`),
  UNIQUE KEY `qc_name_UNIQUE` (`qc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_category`
--

LOCK TABLES `question_category` WRITE;
/*!40000 ALTER TABLE `question_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receive`
--

DROP TABLE IF EXISTS `receive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receive` (
  `u_id` varchar(20) NOT NULL,
  `c_id` int NOT NULL,
  KEY `fk_user_has_coupon_coupon1_idx` (`c_id`),
  KEY `fk_user_has_coupon_user_idx` (`u_id`),
  CONSTRAINT `fk_user_has_coupon_coupon1` FOREIGN KEY (`c_id`) REFERENCES `coupon` (`c_id`),
  CONSTRAINT `fk_user_has_coupon_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receive`
--

LOCK TABLES `receive` WRITE;
/*!40000 ALTER TABLE `receive` DISABLE KEYS */;
/*!40000 ALTER TABLE `receive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refund_category`
--

DROP TABLE IF EXISTS `refund_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refund_category` (
  `rc_name` varchar(20) NOT NULL,
  `refund_categorycol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rc_name`),
  UNIQUE KEY `rc_name_UNIQUE` (`rc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refund_category`
--

LOCK TABLES `refund_category` WRITE;
/*!40000 ALTER TABLE `refund_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `refund_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `u_id` varchar(20) NOT NULL,
  `add_id` int NOT NULL AUTO_INCREMENT,
  `reg_specificaddress` varchar(45) DEFAULT NULL,
  `reg_name` varchar(10) DEFAULT NULL,
  `reg_tel` varchar(13) DEFAULT NULL,
  `reg_defaultaddress` int DEFAULT '0',
  KEY `fk_user_has_address_user1_idx` (`u_id`),
  KEY `fk_user_has_address_address1_idx` (`add_id`),
  CONSTRAINT `fk_user_has_address_address1` FOREIGN KEY (`add_id`) REFERENCES `address` (`add_id`),
  CONSTRAINT `fk_user_has_address_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('rlaxodjs7',2,'1234',NULL,NULL,1),('rlaxodjs10',2,'1234',NULL,NULL,1),('rlaxodjs11',3,'1234','송가인','010-1234-1234',1),('rlaxodjs11',10,'1234','김시','010-4567-4567',0),('rlaxodjs12',14,'12341234','전중훈','010-1234-1142',1),('siri123',5,'1234','전종후','010-1234-1234',1);
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `re_id` int NOT NULL AUTO_INCREMENT,
  `re_title` varchar(20) DEFAULT NULL,
  `re_content` text,
  `re_date` datetime DEFAULT NULL,
  `re_star` varchar(45) DEFAULT NULL,
  `re_image` varchar(100) DEFAULT NULL,
  `u_id` varchar(20) NOT NULL,
  PRIMARY KEY (`re_id`),
  UNIQUE KEY `re_id_UNIQUE` (`re_id`),
  KEY `fk_review_user1_idx` (`u_id`),
  CONSTRAINT `fk_review_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `u_cancel`
--

DROP TABLE IF EXISTS `u_cancel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `u_cancel` (
  `can_id` int NOT NULL,
  `can_category` varchar(10) DEFAULT NULL,
  `can_reason` varchar(45) DEFAULT NULL,
  `canp_id` int DEFAULT NULL,
  `uod_id` int NOT NULL,
  PRIMARY KEY (`can_id`),
  UNIQUE KEY `can_id_UNIQUE` (`can_id`),
  KEY `fk_u_cancel_user_order_detail1_idx` (`uod_id`),
  CONSTRAINT `fk_u_cancel_user_order_detail1` FOREIGN KEY (`uod_id`) REFERENCES `user_order_detail` (`uod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `u_cancel`
--

LOCK TABLES `u_cancel` WRITE;
/*!40000 ALTER TABLE `u_cancel` DISABLE KEYS */;
/*!40000 ALTER TABLE `u_cancel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `u_refund`
--

DROP TABLE IF EXISTS `u_refund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `u_refund` (
  `urf_id` int NOT NULL AUTO_INCREMENT,
  `urf_reason` varchar(45) DEFAULT NULL,
  `urf_img` varchar(100) DEFAULT NULL,
  `urf_status` varchar(20) DEFAULT NULL,
  `rc_name` varchar(20) NOT NULL,
  PRIMARY KEY (`urf_id`),
  UNIQUE KEY `urf_id_UNIQUE` (`urf_id`),
  KEY `fk_u_refund_refund_category1_idx` (`rc_name`),
  CONSTRAINT `fk_u_refund_refund_category1` FOREIGN KEY (`rc_name`) REFERENCES `refund_category` (`rc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `u_refund`
--

LOCK TABLES `u_refund` WRITE;
/*!40000 ALTER TABLE `u_refund` DISABLE KEYS */;
/*!40000 ALTER TABLE `u_refund` ENABLE KEYS */;
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
  `u_point` int DEFAULT NULL,
  `u_resignationdate` date DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_id_UNIQUE` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('jennie12','qwer1234!@','jennie','010-1234-1243','jennie12@naver.com','female','1991-10-23',NULL,'골드',800,NULL),('rlaxodjs10','qwer1234!@','두먼','010-4321-4321','efwjhiwef@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs11','qwer1234!@','송가인','010-1234-1234','efwhuk@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs12','qwer1234!@','전중훈','010-1234-1142','qdwqdw@gamil.com','male','2022-08-11','2022-04-07','브론즈',0,NULL),('rlaxodjs2','qwer1234!@','김태언','010-1234-1234','qwer@qwer.com','male','2010-08-12','2022-04-05','브론즈',0,NULL),('rlaxodjs3','qwer1234!@','강백호','010-1234-1234','rlaxodjs3@gmail.com','male','2020-02-16','2022-04-06','브론즈',0,NULL),('rlaxodjs4','qwer1234!@','강태공','010-1234-1234','adnjasd@gmail.com','male','2020-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs5','qwer1234!@','최치수','010-1234-1234','dqwjiodqw@gmail.com','male','2017-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs6','qwer1234!@','김국자','010-1234-1234','qdwdqw@gmail.com','male','2022-10-31','2022-04-06','브론즈',0,NULL),('rlaxodjs7','qwer1234!@','초초초','010-1234-1234','qwenk@gami.com','male','2021-11-11','2022-04-06','브론즈',0,NULL),('rlaxodjs8','qwer1234!@','초초초','010-1234-1234','fwekjnf@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL),('rlaxodjs9','qwer1234!@','최최최','010-4321-4321','rldwqnj@gmail.com','male','2022-01-12','2022-04-06','브론즈',0,NULL),('siri123','qwer1234!@','전종후','010-1234-1234','fewfwe@gamil.com','male','2022-02-11','2022-04-08','브론즈',0,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order`
--

DROP TABLE IF EXISTS `user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_order` (
  `uo_id` int NOT NULL AUTO_INCREMENT,
  `uo_name` varchar(45) DEFAULT NULL,
  `uo_tel` varchar(13) DEFAULT NULL,
  `uo_point` int DEFAULT NULL,
  `uo_discountedamount` int DEFAULT NULL,
  `uo_date` datetime DEFAULT NULL,
  `uo_coupon` varchar(45) DEFAULT NULL,
  `uo_address` varchar(45) DEFAULT NULL,
  `uo_shippingfee` int DEFAULT NULL,
  `uo_paymentmethod` varchar(10) DEFAULT NULL,
  `u_id` varchar(20) NOT NULL,
  PRIMARY KEY (`uo_id`),
  UNIQUE KEY `uo_id_UNIQUE` (`uo_id`),
  KEY `fk_user_order_user1_idx` (`u_id`),
  CONSTRAINT `fk_user_order_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order`
--

LOCK TABLES `user_order` WRITE;
/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order_detail`
--

DROP TABLE IF EXISTS `user_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_order_detail` (
  `uod_id` int NOT NULL,
  `uod_coupon` varchar(45) DEFAULT NULL,
  `re_id` int NOT NULL,
  `uo_id` int NOT NULL,
  `urf_id` int NOT NULL,
  `p_id` int NOT NULL,
  PRIMARY KEY (`uod_id`),
  KEY `fk_user_order_detail_review1_idx` (`re_id`),
  KEY `fk_user_order_detail_user_order1_idx` (`uo_id`),
  KEY `fk_user_order_detail_u_refund1_idx` (`urf_id`),
  KEY `fk_user_order_detail_product1_idx` (`p_id`),
  CONSTRAINT `fk_user_order_detail_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_user_order_detail_review1` FOREIGN KEY (`re_id`) REFERENCES `review` (`re_id`),
  CONSTRAINT `fk_user_order_detail_u_refund1` FOREIGN KEY (`urf_id`) REFERENCES `u_refund` (`urf_id`),
  CONSTRAINT `fk_user_order_detail_user_order1` FOREIGN KEY (`uo_id`) REFERENCES `user_order` (`uo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order_detail`
--

LOCK TABLES `user_order_detail` WRITE;
/*!40000 ALTER TABLE `user_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_order_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-09 14:33:21
