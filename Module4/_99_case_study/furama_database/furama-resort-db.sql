-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: furama-resort
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `app_role`
--

DROP TABLE IF EXISTS `app_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_role`
--

LOCK TABLES `app_role` WRITE;
/*!40000 ALTER TABLE `app_role` DISABLE KEYS */;
INSERT INTO `app_role` VALUES (1,'ROLE_GIAMDOC'),(2,'ROLE_QUANLY'),(3,'ROLE_NHANVIEN');
/*!40000 ALTER TABLE `app_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES ('admin','$2a$10$52nJhv6TJlbwbzhl.ip0v.QRoafPZPVv97cdhkyHemq7WpWgBXXVS'),('anpham','$2a$10$IymI2rka/9Fq3PUa/xASgOcVdGswS349U2aDZ4c.ovQacjoiQCnYm'),('cuonghoang','$2a$10$b/frA4cY0yuz4G5oJjrbMO7HJegUUbg9Z0C4Qfb8K1oQPO3ZzmviC'),('diemhuong','$2a$10$9BTkroOGGF.8M5oJl35XsuTFCQGDryQgLhfDE91fiF7LqWvczFZz6'),('giang123','$2a$10$MF0UoBzTY0V2xh9LhMsgZ.kasmy/h.SwSZ1byJiahEJz0JKbN1tFm'),('hangnguyen','$2a$10$qGM7bL9wHXbH1riueXz.l.JUb.fIpJWTrxdVCQRTrxWA2COyuzh/S'),('hoangviet','$2a$10$B74YFGmFuvZPvJD0tnI39uP67YcrCiXssSQ0tshai5ZeR3R5jUNiC'),('hongocminh','$2a$10$zWT0imqTTunC.8hFkafoY.3S6DiYSQcxBqvyH7OKw5j3FVbQFQWxW'),('huongnguyen','$2a$10$21XSmxg/jBjV0EXfJsji0.54dChvtHUjjIHcEgv3MJx1NvthW0TRK'),('huongnguyen123','$2a$10$8WZ8lX8FuiO3LQUmy7yp.eKyRFPGG5RknG4Ks8KAxvSE6Rbd3qylS'),('linhhoang','$2a$10$tsOqwS6xqFd.kZGeaJey9uro5hkYE1lCkIhtGcM3FYA/QWXv9kNVa'),('linhnguyen','$2a$10$mOiOxBeNIOhsixM5Eg/Kb.zbWKiKBUMgYXAPrTd0RR/0K2zGIZxxS'),('minhhn','$2a$10$plhl9DRszZUX7zyqURmWGO6Mjf8lHHHLMO5KmcYgp7jrWMX1xMFI.'),('namnguyen','$2a$10$YRGCB4QlVucwyu2Pp8.QWuY9jVDuIp4bNB4AI4i46Uz6/6n/tEEcm'),('namnguyen2','$2a$10$/3R3wdC5PxHj4/qjPfMbHOZOTDTXxHih47Z.9CuvUmQ57x0VYK6S2'),('namthanh','$2a$10$6XgGunTn0xp2GoWQi0crNOgnP9H0Cq0s6cxwIvMKgLLrJBfa2aIr.'),('namtran','$2a$10$gZVaDj3gL1c.EZy6kIlg3Okg8IePRRi5YgPkrP1w.YrwIgJJx9ffu'),('nhungphan','$2a$10$16WvhKaErvXdBhhZwIaoturSMoEGFXxiDtpeoh/FbVbB4I8kFj0dW'),('quocdon','$2a$10$50uwmKtpb6YbAkWLA0/Nzux4uMucQu2P48L0wpFAM9MsfyXE6q78i'),('quocdon11991','$2a$10$aHUyoOAKkXYvKHu9L8w/perluVEPlFTeJSnZVLepqaa10fOEKiweO'),('quocdon1312','$2a$10$YUbBY0PyYePvWtnWjXL8yOaCey9qhENu3Cdx7q5iZaGprgjLTpSQe'),('quocdon2001','$2a$10$o/0lOdiz4FPM3QSXjmnQUuDYGor5rnfwXR1D3RnfYJcZ0n7trTz56'),('quocdon212131','$2a$10$922FjojVBC/j8QmPtP6eFe4PIBCMLeR8muarB2FK9hnI4xjxeGG3i'),('quocdon8888','$2a$10$6qvCrOXuqb./5QwECM0dD.IRgCRiNWqxuCN.f5JTiDwyrG4WKHKAW'),('quochoang','$2a$10$IvPi7zFxxLM59Yo6kJHmS.mfhoRsZWoyW9hxKwgJQY0SJCcIlTpDG'),('quochoang222q','$2a$10$XuNBdf5gwtfRaDW5ot02nO5IOq6ww6yGd0eLd69w94FY5/ymWraRi'),('quocodn2991','$2a$10$6zOL2EQ6I3CCf1KFGx0VAuMkCaOQrrUBAqlTLbcvee87h85dBoUdW'),('quynguyen','$2a$10$c.gnXC8K31aGilX1ifnNTuLS/pLNHh/ynRs.ws4gfUYMVZxV./5f6'),('thanhha','$2a$10$2tdwUSt5AHFd4QKavzsnXO9G0z9YJU.IWsnf3VprXAJQDVbAjktsC'),('thanhhuong','$2a$10$kcAVO7mpDqyxBkOYaUDArei1ED82bi2mOw/wJ7x6b8h0heoEE0nJC'),('thuha','$2a$10$1QDrO3QpdIpUbjYtIhXKy.bC/l5D37DgW/DSQQLfV6D4GNLr341y2');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cost` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (1,1000000,'Massage','available','Lần'),(2,300000,'Karaoke','Khả dụng','Giờ'),(3,300000,'Thức ăn','Khả dụng','Khách'),(4,20000,'Nước uống','Khả dụng','Khách'),(5,150000,'Thuê xe','Khả dụng','Khách');
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL,
  `amount` double NOT NULL,
  `deposit` double NOT NULL,
  `end_date` date NOT NULL,
  `start_date` date NOT NULL,
  `customer_id` varchar(255) NOT NULL,
  `employee_id` int DEFAULT NULL,
  `service_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq28qogy68douoc4gkgcy3ow9p` (`customer_id`),
  KEY `FKr2iw6grixlkbx43q2svdrhbb9` (`employee_id`),
  KEY `FK19581iyfbe0bln65k7j2rf26u` (`service_id`),
  CONSTRAINT `FK19581iyfbe0bln65k7j2rf26u` FOREIGN KEY (`service_id`) REFERENCES `resort_service` (`id`),
  CONSTRAINT `FKq28qogy68douoc4gkgcy3ow9p` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKr2iw6grixlkbx43q2svdrhbb9` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (2,0,0,'2021-09-04','2021-09-02','KH-0003',1,'DV-0001'),(3,0,0,'2021-05-09','2021-05-05','KH-0002',1,'DV-0001'),(4,0,0,'2022-01-09','2022-01-01','KH-0002',1,'DV-0006'),(5,0,0,'2021-04-26','2021-04-25','KH-0001',1,'DV-0003'),(6,0,0,'2021-08-05','2021-08-02','KH-0001',1,'DV-0003'),(8,0,0,'2021-09-04','2021-09-02','KH-0003',1,'DV-0001'),(9,0,0,'2021-09-05','2021-09-02','KH-0003',1,'DV-0001'),(11,0,0,'2021-09-05','2021-09-02','KH-0003',1,'DV-0001'),(13,0,0,'2021-09-09','2021-09-02','KH-0002',1,'DV-0001'),(14,0,0,'2022-01-09','2022-01-05','KH-0001',1,'DV-0003'),(15,0,0,'2021-04-29','2021-04-19','KH-0001',2,'DV-0001'),(16,0,0,'2022-01-05','2022-01-01','KH-0001',1,'DV-0001'),(17,0,0,'2021-04-30','2021-04-21','KH-0001',1,'DV-0001'),(18,0,0,'2021-04-06','2021-04-05','KH-0004',1,'DV-0001'),(19,0,0,'2021-05-08','2021-05-04','KH-0001',1,'DV-0001'),(20,0,0,'2021-03-05','2021-03-03','KH-0002',1,'DV-0007'),(21,0,0,'2021-05-07','2021-05-04','KH-0001',1,'DV-0001'),(22,0,0,'2021-05-09','2021-05-08','KH-0002',1,'DV-0001'),(23,0,0,'2021-06-05','2021-04-05','KH-0004',1,'DV-0001'),(24,0,0,'2022-02-01','2022-01-01','KH-0006',1,'DV-0001'),(25,0,0,'2021-05-07','2021-05-04','KH-0006',2,'DV-0002'),(26,0,0,'2021-04-09','2021-04-08','KH-0006',1,'DV-0004'),(27,0,0,'2021-04-05','2021-04-05','KH-0002',1,'DV-0001'),(28,0,0,'2021-04-07','2021-04-05','KH-0004',1,'DV-0001'),(29,0,0,'2021-05-05','2021-05-04','KH-0001',1,'DV-0001'),(30,0,0,'2021-05-09','2021-05-05','KH-0004',1,'DV-0001'),(31,0,0,'2021-05-05','2021-05-04','KH-0001',1,'DV-0002');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `attach_service_id` int NOT NULL,
  `contract_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`attach_service_id`,`contract_id`),
  KEY `FKh3a73928bh54b95v82kwthjrk` (`contract_id`),
  CONSTRAINT `FK7cbwupicl8f762x3kulehjhf8` FOREIGN KEY (`attach_service_id`) REFERENCES `attach_service` (`id`),
  CONSTRAINT `FKh3a73928bh54b95v82kwthjrk` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
INSERT INTO `contract_detail` VALUES (1,2,2),(1,3,1),(1,4,11),(1,6,1),(1,14,3),(1,15,3),(1,17,3),(1,18,1),(1,19,3),(1,23,3),(1,24,3),(1,25,3),(2,3,1),(2,4,3),(2,8,1),(2,14,3),(2,15,3),(2,17,3),(2,18,1),(2,19,3),(2,21,3),(2,23,3),(2,25,3),(2,27,3),(2,31,3),(3,4,3),(3,9,2),(3,11,3),(3,13,3),(3,16,3),(3,20,4),(3,24,2),(3,26,3),(3,27,3),(3,28,3),(3,30,3),(3,31,3),(4,5,1),(4,11,3),(4,13,1),(4,22,2),(4,26,3),(5,5,1),(5,22,2);
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `customer_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn8vf9jf3m29plqn6rx45p2pl7` (`customer_type_id`),
  CONSTRAINT `FKn8vf9jf3m29plqn6rx45p2pl7` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('KH-0001','Quảng Nam','1998-01-01','haitruong@gmail.com','Nam','169636325312','Trương Hải','0915255255',3),('KH-0002','Hà Tĩnh','2002-05-05','hoaithuongnguyen@gmail.com','Nữ','193366655','Nguyễn Hoài Thương','0905444555',2),('KH-0003','Huế','1991-05-02','minhhongoc@gmail.com','Nam','198855633255','Hồ Ngọc Minh','0912333655',5),('KH-0004','BÌnh định','2001-01-01','namthanh@gmaicx.com','Nam','125363666','Nguyễn Thanh Nam','0903255255',4),('KH-0005','Hồ Chí Minh','1998-01-01','maiphuongthuy@gmail.com','Nữ','447858896696','Mai Phương Thúy','0914448585',3),('KH-0006','Gia Lai','1995-01-01','congphuongvn@gmail.com','Nam','778585969','Nguyễn Công Phượng','0915585558',2);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Diamond'),(2,'Platinum'),(3,'Gold'),(4,'Silver'),(5,'Member');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Sales-Marketing'),(2,'Hành chính'),(3,'Quản lý'),(4,'Phục vụ');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_degree`
--

DROP TABLE IF EXISTS `education_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education_degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_degree`
--

LOCK TABLES `education_degree` WRITE;
/*!40000 ALTER TABLE `education_degree` DISABLE KEYS */;
INSERT INTO `education_degree` VALUES (1,'Trung cấp'),(2,'Cao Đẳng'),(3,'Đại học'),(4,'Sau Đại học');
/*!40000 ALTER TABLE `education_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `salary` double NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `department_id` int NOT NULL,
  `education_degree_id` int NOT NULL,
  `position_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKngshymyxtfw86p83ohbp0svg1` (`username`),
  KEY `FKbejtwvg9bxus2mffsm3swj3u9` (`department_id`),
  KEY `FKs4qy1cue6wal9e4pq9wjuau5w` (`education_degree_id`),
  KEY `FKbc8rdko9o9n1ri9bpdyxv3x7i` (`position_id`),
  CONSTRAINT `FKbc8rdko9o9n1ri9bpdyxv3x7i` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `FKbejtwvg9bxus2mffsm3swj3u9` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKngshymyxtfw86p83ohbp0svg1` FOREIGN KEY (`username`) REFERENCES `app_user` (`username`),
  CONSTRAINT `FKs4qy1cue6wal9e4pq9wjuau5w` FOREIGN KEY (`education_degree_id`) REFERENCES `education_degree` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Quảng Trị','1991-09-02','quocdon2991@gmail.com','197255499','Phạm Quốc Đôn','0915225252',15000000,'quocdon',3,3,6),(2,'Quảng Trị','1993-12-15','hoangpham2@gmail.com','444555666','Phạm Quốc Hoàng','0913666555',6000000,'quochoang',3,4,1),(3,'Quảng Nam','1997-01-01','thuha97@gmail.com','195625536','Nguyễn Thu Hà','0905444555',7000000,'thuha',1,4,4),(4,'Quảng Nam','1993-09-05','hoangviet@gmail.com','195625536','Trần Hoàng Việt','0918556336',7000000,'hoangviet',3,3,2),(5,'Đà Nẵng','1992-01-01','diemhuong@gmail.com','555444777','Trần Diễm Hương','0915122336',8000000,'diemhuong',4,3,1),(6,'Đà Nẵng','1995-01-01','thanhhuong@gmail.com','144485663','Trần Thanh Hương','0912334586',8000000,'thanhhuong',4,2,1),(7,'Quảng Nam','1995-05-01','quyaa95@gmail.com','569362652221','Nguyễn Thị Quý','0914444555',6000000,'quynguyen',1,1,1),(8,'Bình Định','2001-01-02','thanhnam@gmail.com','123555888','Nguyễn Thanh Nam','0915336225',4500000,'namthanh',1,1,1),(9,'Quảng Trị','1993-05-05','giangthanh2gmai@gmail.com','558669445','Nguyễn Thanh Giang','0905336336',14000000,'giang123',2,4,2),(11,'Hà Tĩnh','1997-01-01','nhungphan@gmail.com','123555666','Nguyễn Thị Nhung','0902123666',6000000,'nhungphan',3,3,2),(12,'Đà Nẵng','1992-05-02','thanhhuong1234@gmail.com','193655699','Nguyễn Thanh Hương','0901154669',8000000,'huongnguyen',2,1,1),(13,'BÌnh định','1995-05-05','hangnguen@gmail.com','888777999','Nguyễn Bích Hằng','0904789456',50000000,'hangnguyen',2,2,3),(14,'Quảng N','1995-12-11','annguyne@gmail.com','555777888','Phạm An','0905336366',15000000,'anpham',1,1,1),(15,'Quảng Trị','2005-05-04','tranvannam@gmail.com','194452566','Trần Văn Nam','0901112555',4000000,'namtran',1,1,2),(16,'Huế','1991-01-01','minhhongoc@gmail.com','444555666','Hồ Ngọc Minh','0902145145',7000000,'hongocminh',1,1,1),(17,'Quảng Trị','1991-01-01','thanhha@gmail.com','122556556','Nguyễn Thanh Hà','0904115445',7000000,'thanhha',4,3,3),(21,'Đà Nẵng','1955-01-01','linhnguyen2g@gmail.com','555477899','Nguyễn Hoài Linh','0904145445',10000000,'linhnguyen',1,1,1),(23,'Huế','1988-01-01','linhoang@gmail.com','444555888','Hoang Linh','0912333655',50000000,'linhhoang',1,2,1),(24,'Đà Nẵng','1988-01-01','diemhuong@gmail.com','555447896','Hoàng Cường','0915122336',50000000,'cuonghoang',1,3,1),(25,'Huế','1991-01-01','minhhongoc@gmail.com','555888999','Hồ Ngọc Minh','0912333655',7000000,'minhhn',3,2,3),(26,'BÌnh định','1989-01-01','naaaaam@gmaicx.com','666255222','Nguyễn Thanh Nam','0903255255',50000000,'namnguyen',1,1,1),(27,'Đà Nẵng','2001-01-01','linhnguyen2g@gmail.com','195625536','Nguyễn Thanh Nam','0904145445',7000000,'namnguyen2',1,1,1),(28,'Quảng Trị','1995-05-01','hoangpham2@gmail.com','555778899','Phạm Quốc Hoàng','0913666555',50000000,'quochoang222q',1,1,1),(30,'Đà Nẵng','1991-01-01','thanhhuong@gmail.com','569362652221','Phạm Quốc Đôn','0912334586',50000000,'quocodn2991',1,1,1),(31,'Quảng Trị','1999-01-01','quocdon2991@gmail.com','555888999','Phạm Quốc Đôn','0915225252',50000000,'quocdon11991',1,1,1),(32,'Quảng Trị','1998-01-01','quocdon2991@gmail.com','555588884444','Phạm Quốc Đôn','0915225252',50000000,'quocdon212131',1,1,1),(33,'Quảng Trị','1998-01-01','quocdon2991@gmail.com','555588884444','Phạm Quốc Đôn','0915225252',7000000,'quocdon2001',1,1,1),(34,'Quảng Trị','2002-05-05','donpham@gmail.com','199855888','Phạm Quốc Đôn','0914447858',50000000,'quocdon8888',2,3,1),(35,'Bình Định','1991-01-01','huongnguyne@gmail.com','555899969','Hồ Diệu Hương','0914447558',4000000,'huongnguyen123',1,1,1),(37,'Quảng Trị','1991-05-04','quocdon2991@gmail.com','555888999','Phạm Quốc Đôn','0915225252',50000000,'quocdon1312',2,3,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (32);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Lễ tân'),(2,'Chuyên viên'),(3,'Phục vụ'),(4,'Giám sát'),(5,'Quản lý'),(6,'Giám đốc');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cost` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,100,'Năm'),(2,100,'Tháng'),(3,100,'Ngày'),(4,100,'Giờ');
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resort_service`
--

DROP TABLE IF EXISTS `resort_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resort_service` (
  `id` varchar(255) NOT NULL,
  `area` int NOT NULL,
  `cost` double NOT NULL,
  `max_people` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rent_type_id` int NOT NULL,
  `service_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkhnogmpkhaa5gts57vppcbxie` (`rent_type_id`),
  KEY `FKq21trst72wfvqwtwslbir0lih` (`service_type_id`),
  CONSTRAINT `FKkhnogmpkhaa5gts57vppcbxie` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`id`),
  CONSTRAINT `FKq21trst72wfvqwtwslbir0lih` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resort_service`
--

LOCK TABLES `resort_service` WRITE;
/*!40000 ALTER TABLE `resort_service` DISABLE KEYS */;
INSERT INTO `resort_service` VALUES ('DV-0001',150,2500000,4,'Happy House',3,2),('DV-0002',200,15000000,8,'Art Villa',2,1),('DV-0003',45,3000000,3,'Happy House',1,2),('DV-0004',120,9000000,6,'An Villa',1,1),('DV-0005',63,1200000,2,'Funny Room',1,3),('DV-0006',100,5000000,4,'Dana House',4,2),('DV-0007',100,1500000,4,'Its My House',1,2);
/*!40000 ALTER TABLE `resort_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'Villa'),(2,'House'),(3,'Room');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `role_id` int NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`,`username`),
  KEY `FKtcdhlmjy42y6a90l6qtavd20t` (`username`),
  CONSTRAINT `FKp6m37g6n6c288s096400uw8fw` FOREIGN KEY (`role_id`) REFERENCES `app_role` (`id`),
  CONSTRAINT `FKtcdhlmjy42y6a90l6qtavd20t` FOREIGN KEY (`username`) REFERENCES `app_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'admin'),(2,'cuonghoang'),(3,'cuonghoang'),(3,'diemhuong'),(3,'giang123'),(1,'hoangviet'),(2,'hoangviet'),(3,'hoangviet'),(2,'hongocminh'),(3,'huongnguyen'),(3,'huongnguyen123'),(1,'linhhoang'),(3,'linhhoang'),(2,'minhhn'),(3,'minhhn'),(2,'namnguyen'),(3,'namthanh'),(2,'namtran'),(1,'nhungphan'),(2,'nhungphan'),(3,'nhungphan'),(1,'quocdon'),(3,'quocdon'),(3,'quocdon11991'),(3,'quocdon1312'),(1,'quocdon2001'),(2,'quocdon2001'),(3,'quocdon212131'),(3,'quocdon8888'),(2,'quochoang'),(1,'quocodn2991'),(2,'quocodn2991'),(3,'quocodn2991'),(3,'quynguyen'),(2,'thanhhuong'),(3,'thuha');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-24 17:49:07
