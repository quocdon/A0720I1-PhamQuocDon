-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL,
  `image_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1001,'https://cdn.tgdd.vn/Products/Images/42/213033/iphone-12-pro-max-xanh-duong-new-600x600-600x600.jpg','iPhone 12 Pro Max 128GB',31990000),(1002,'https://cdn.tgdd.vn/Products/Images/42/226316/samsung-galaxy-s21-ultra-bac-600x600-1-600x600.jpg','Samsung Galaxy S21 Ultra 5G 128GB',30500000),(1003,'https://cdn.tgdd.vn/Products/Images/42/228950/vivo-y51-bac-600x600-600x600.jpg','Vivo Y51 (2020)',5590000),(1004,'https://cdn.tgdd.vn/Products/Images/42/229885/oppo-a15-black-600x600-2-600x600.jpg','OPPO A15',3490000),(1005,'https://cdn.tgdd.vn/Products/Images/42/221926/huawei-y6p-xanh-new-600x600-600x600.jpg','Huawei Y6p',3090000),(1006,'https://cdn.tgdd.vn/Products/Images/42/225063/sam-sung-note-20-ultra-vang-dong-600x600.jpg','Samsung Galaxy Note 20 Ultra 5G',23990000),(1007,'https://cdn.tgdd.vn/Products/Images/42/222758/xiaomi-redmi-note-10-thumb-green-600x600-1-600x600.jpg','Xiaomi Redmi Note 10 (6GB/128GB)',5500000),(1008,'https://cdn.tgdd.vn/Products/Images/42/229228/xiaomi-redmi-note-10-pro-thumb-xam-600x600-600x600.jpg','Xiaomi Redmi Note 10 Pro (8GB/128GB)',7500000),(1009,'https://cdn.tgdd.vn/Products/Images/42/218355/samsung-galaxy-note-20-062220-122200-fix-600x600.jpg','Điện thoại Samsung Galaxy Note 20',17000000),(1010,'https://cdn.tgdd.vn/Products/Images/42/217536/samsung-galaxy-m51-trang-new-600x600-600x600.jpg','Samsung Galaxy M51',8300000),(1011,'https://cdn.tgdd.vn/Products/Images/42/235440/samsung-galaxy-a52-5g-thumb-600x600-600x600.jpg','Samsung Galaxy A52 5G',11000000),(1012,'https://cdn.tgdd.vn/Products/Images/42/225380/iphone-mini-do-new-600x600-600x600.jpg','iPhone 12 mini 64GB',18800000);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-27 21:14:22
