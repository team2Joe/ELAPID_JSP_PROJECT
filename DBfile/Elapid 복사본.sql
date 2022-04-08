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
  `add_id` int(11) NOT NULL,
  `add_address` varchar(45) DEFAULT NULL,
  `add_specificaddress` varchar(45) DEFAULT NULL,
  `add_postnumber` int(11) DEFAULT NULL,
  `add_defaultaddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`add_id`),
  UNIQUE KEY `add_id_UNIQUE` (`add_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancelcategory`
--

DROP TABLE IF EXISTS `cancelcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancelcategory` (
  `cc_name` int(11) NOT NULL,
  PRIMARY KEY (`cc_name`),
  UNIQUE KEY `cc_name_UNIQUE` (`cc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_discountedamount` int(11) DEFAULT NULL,
  `cart_amount` int(11) DEFAULT NULL,
  `user_u_id` varchar(20) NOT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `cart_id_UNIQUE` (`cart_id`),
  KEY `fk_cart_user1_idx` (`user_u_id`),
  CONSTRAINT `fk_cart_user1` FOREIGN KEY (`user_u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_detail`
--

DROP TABLE IF EXISTS `cart_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_detail` (
  `product_p_id` int(11) NOT NULL,
  `cart_cart_id` int(11) NOT NULL,
  `cd_id` int(11) NOT NULL,
  `cdp_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_p_id`,`cart_cart_id`,`cd_id`),
  UNIQUE KEY `cd_id_UNIQUE` (`cd_id`),
  KEY `fk_product_has_cart_cart1_idx` (`cart_cart_id`),
  KEY `fk_product_has_cart_product1_idx` (`product_p_id`),
  CONSTRAINT `fk_product_has_cart_cart1` FOREIGN KEY (`cart_cart_id`) REFERENCES `cart` (`cart_id`),
  CONSTRAINT `fk_product_has_cart_product1` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_detail`
--

LOCK TABLES `cart_detail` WRITE;
/*!40000 ALTER TABLE `cart_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `ctg_id` int(11) NOT NULL,
  `ctg_main` varchar(10) DEFAULT NULL,
  `ctg_middle` varchar(15) DEFAULT NULL,
  `ctg_sub` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ctg_id`),
  UNIQUE KEY `ctg_id_UNIQUE` (`ctg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_detail`
--

DROP TABLE IF EXISTS `category_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_detail` (
  `ctg_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  KEY `fk_category_has_product_product1_idx` (`p_id`),
  KEY `fk_category_has_product_category1_idx` (`ctg_id`),
  CONSTRAINT `fk_category_has_product_category1` FOREIGN KEY (`ctg_id`) REFERENCES `category` (`ctg_id`),
  CONSTRAINT `fk_category_has_product_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_detail`
--

LOCK TABLES `category_detail` WRITE;
/*!40000 ALTER TABLE `category_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupon` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(45) DEFAULT NULL,
  `c-atleastprice` int(11) DEFAULT NULL,
  `c_termofusedesc` varchar(45) DEFAULT NULL,
  `c_value` int(11) DEFAULT NULL,
  `c_period` datetime DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_id_UNIQUE` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `img_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  KEY `fk_image_detail_product_image1_idx` (`img_id`),
  KEY `fk_image_detail_product1_idx` (`p_id`),
  CONSTRAINT `fk_image_detail_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_image_detail_product_image1` FOREIGN KEY (`img_id`) REFERENCES `product_image` (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_detail`
--

LOCK TABLES `image_detail` WRITE;
/*!40000 ALTER TABLE `image_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_log`
--

DROP TABLE IF EXISTS `login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_log` (
  `lo_id` int(11) NOT NULL,
  `lo_date` datetime DEFAULT NULL,
  `user_u_id` varchar(20) NOT NULL,
  PRIMARY KEY (`lo_id`),
  UNIQUE KEY `lo_id_UNIQUE` (`lo_id`),
  KEY `fk_login_log_user1_idx` (`user_u_id`),
  CONSTRAINT `fk_login_log_user1` FOREIGN KEY (`user_u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `nu_id` int(11) NOT NULL AUTO_INCREMENT,
  `nu_orderdate` datetime DEFAULT NULL,
  `nu_name` varchar(10) DEFAULT NULL,
  `nu_tel` varchar(13) DEFAULT NULL,
  `nu_email` varchar(45) DEFAULT NULL,
  `nu_address` varchar(50) DEFAULT NULL,
  `nuo_amount` int(11) DEFAULT NULL,
  `nuo_discountedamount` int(11) DEFAULT NULL,
  `uo_shippingfee` int(11) DEFAULT NULL,
  `uo_paymentmethod` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nu_id`),
  UNIQUE KEY `nu_id_UNIQUE` (`nu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `nuod_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_count` int(11) DEFAULT NULL,
  `nu_id` int(11) NOT NULL,
  `nrf_id` int(11) NOT NULL,
  PRIMARY KEY (`nuod_id`),
  UNIQUE KEY `nuod_id_UNIQUE` (`nuod_id`),
  KEY `fk_non_user_order_detail_non_user_order1_idx` (`nu_id`),
  KEY `fk_non_user_order_detail_nu_refund1_idx` (`nrf_id`),
  CONSTRAINT `fk_non_user_order_detail_non_user_order1` FOREIGN KEY (`nu_id`) REFERENCES `non_user_order` (`nu_id`),
  CONSTRAINT `fk_non_user_order_detail_nu_refund1` FOREIGN KEY (`nrf_id`) REFERENCES `nu_refund` (`nrf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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

--
-- Table structure for table `nu_refund`
--

DROP TABLE IF EXISTS `nu_refund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nu_refund` (
  `nrf_id` int(11) NOT NULL AUTO_INCREMENT,
  `nrf_reason` varchar(20) DEFAULT NULL,
  `nrf_img` varchar(100) DEFAULT NULL,
  `nrf_status` varchar(45) DEFAULT NULL,
  `rc_name` varchar(20) NOT NULL,
  PRIMARY KEY (`nrf_id`),
  UNIQUE KEY `nrf_id_UNIQUE` (`nrf_id`),
  KEY `fk_nu_refund_refund_category1_idx` (`rc_name`),
  CONSTRAINT `fk_nu_refund_refund_category1` FOREIGN KEY (`rc_name`) REFERENCES `refund_category` (`rc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(45) DEFAULT NULL,
  `p_price` int(11) DEFAULT NULL,
  `p_colorimg` varchar(50) DEFAULT NULL,
  `p_colorname` varchar(10) DEFAULT NULL,
  `p_mainf` varchar(20) DEFAULT NULL,
  `p_desc` varchar(45) DEFAULT NULL,
  `p_date` datetime DEFAULT NULL,
  `p_stock` varchar(45) DEFAULT NULL,
  `p_clickcount` int(11) DEFAULT NULL,
  `p_discountprice` int(11) DEFAULT NULL,
  `p_size` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `p_id_UNIQUE` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_detail` (
  `ps_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  KEY `fk_product_detail_product_spec1_idx` (`ps_id`),
  KEY `fk_product_detail_product1_idx` (`p_id`),
  CONSTRAINT `fk_product_detail_product1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `fk_product_detail_product_spec1` FOREIGN KEY (`ps_id`) REFERENCES `product_spec` (`ps_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `img_id` int(11) NOT NULL,
  `del_check` varchar(45) DEFAULT NULL,
  `img_create_date` datetime DEFAULT NULL,
  `ofile_name` varchar(45) DEFAULT NULL,
  `th_img` varchar(45) DEFAULT NULL,
  `wh_main_th` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  UNIQUE KEY `img_id_UNIQUE` (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
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
  `pq_id` int(11) NOT NULL,
  `pq_title` varchar(45) DEFAULT NULL,
  `pq_content` varchar(45) DEFAULT NULL,
  `product_questioncol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pq_id`),
  UNIQUE KEY `pq_id_UNIQUE` (`pq_id`),
  KEY `fk_question_category_has_user_user1_idx` (`u_id`),
  KEY `fk_question_category_has_user_question_category1_idx` (`qc_name`),
  CONSTRAINT `fk_question_category_has_user_question_category1` FOREIGN KEY (`qc_name`) REFERENCES `question_category` (`qc_name`),
  CONSTRAINT `fk_question_category_has_user_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `c_id` int(11) NOT NULL,
  KEY `fk_user_has_coupon_coupon1_idx` (`c_id`),
  KEY `fk_user_has_coupon_user_idx` (`u_id`),
  CONSTRAINT `fk_user_has_coupon_coupon1` FOREIGN KEY (`c_id`) REFERENCES `coupon` (`c_id`),
  CONSTRAINT `fk_user_has_coupon_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `add_id` int(11) NOT NULL,
  KEY `fk_user_has_address_address1_idx` (`add_id`),
  KEY `fk_user_has_address_user1_idx` (`u_id`),
  CONSTRAINT `fk_user_has_address_address1` FOREIGN KEY (`add_id`) REFERENCES `address` (`add_id`),
  CONSTRAINT `fk_user_has_address_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `re_id` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `can_id` int(11) NOT NULL,
  `can_category` varchar(10) DEFAULT NULL,
  `can_reason` varchar(45) DEFAULT NULL,
  `canp_id` int(11) DEFAULT NULL,
  `uod_id` int(11) NOT NULL,
  PRIMARY KEY (`can_id`),
  UNIQUE KEY `can_id_UNIQUE` (`can_id`),
  KEY `fk_u_cancel_user_order_detail1_idx` (`uod_id`),
  CONSTRAINT `fk_u_cancel_user_order_detail1` FOREIGN KEY (`uod_id`) REFERENCES `user_order_detail` (`uod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `urf_id` int(11) NOT NULL AUTO_INCREMENT,
  `urf_reason` varchar(45) DEFAULT NULL,
  `urf_img` varchar(100) DEFAULT NULL,
  `urf_status` varchar(20) DEFAULT NULL,
  `rc_name` varchar(20) NOT NULL,
  PRIMARY KEY (`urf_id`),
  UNIQUE KEY `urf_id_UNIQUE` (`urf_id`),
  KEY `fk_u_refund_refund_category1_idx` (`rc_name`),
  CONSTRAINT `fk_u_refund_refund_category1` FOREIGN KEY (`rc_name`) REFERENCES `refund_category` (`rc_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `u_address` varchar(50) DEFAULT NULL,
  `u_nickname` varchar(45) DEFAULT NULL,
  `u_email` varchar(45) DEFAULT NULL,
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
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order`
--

DROP TABLE IF EXISTS `user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_order` (
  `uo_id` int(11) NOT NULL AUTO_INCREMENT,
  `uo_name` varchar(45) DEFAULT NULL,
  `uo_tel` varchar(13) DEFAULT NULL,
  `uo_point` int(11) DEFAULT NULL,
  `uo_discountedamount` int(11) DEFAULT NULL,
  `uo_date` datetime DEFAULT NULL,
  `uo_coupon` varchar(45) DEFAULT NULL,
  `uo_address` varchar(45) DEFAULT NULL,
  `uo_shippingfee` int(11) DEFAULT NULL,
  `uo_paymentmethod` varchar(10) DEFAULT NULL,
  `u_id` varchar(20) NOT NULL,
  PRIMARY KEY (`uo_id`),
  UNIQUE KEY `uo_id_UNIQUE` (`uo_id`),
  KEY `fk_user_order_user1_idx` (`u_id`),
  CONSTRAINT `fk_user_order_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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

-- Dump completed on 2022-04-04 12:16:06
