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
INSERT INTO `app_user` VALUES ('admin','$2a$10$52nJhv6TJlbwbzhl.ip0v.QRoafPZPVv97cdhkyHemq7WpWgBXXVS'),('quocdon','$2a$10$50uwmKtpb6YbAkWLA0/Nzux4uMucQu2P48L0wpFAM9MsfyXE6q78i'),('quochoang','$2a$10$IvPi7zFxxLM59Yo6kJHmS.mfhoRsZWoyW9hxKwgJQY0SJCcIlTpDG'),('thuha','$2a$10$1QDrO3QpdIpUbjYtIhXKy.bC/l5D37DgW/DSQQLfV6D4GNLr341y2');
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
INSERT INTO `contract` VALUES (2,0,0,'2021-09-04','2021-09-02','KH-0003',1,'DV-0001'),(3,0,0,'2021-05-09','2021-05-05','KH-0003',2,'DV-0002'),(4,0,0,'2022-01-09','2022-01-01','KH-0002',3,'DV-0006'),(5,0,0,'2021-04-29','2021-04-25','KH-0001',3,'DV-0002'),(6,0,0,'2021-08-08','2021-08-02','KH-0001',2,'DV-0003'),(8,0,0,'2021-09-04','2021-09-02','KH-0003',1,'DV-0001'),(9,0,0,'2021-09-05','2021-09-02','KH-0003',1,'DV-0001'),(10,0,0,'2021-09-04','2021-09-02','KH-0003',1,'DV-0001'),(11,0,0,'2021-09-05','2021-09-02','KH-0003',1,'DV-0001'),(12,0,0,'2021-09-05','2021-09-02','KH-0003',1,'DV-0001'),(13,0,0,'2021-09-09','2021-09-02','KH-0002',1,'DV-0001'),(14,0,0,'2022-01-09','2022-01-05','KH-0001',1,'DV-0003'),(15,0,0,'2021-04-29','2021-04-19','KH-0001',2,'DV-0001'),(16,0,0,'2022-01-05','2022-01-01','KH-0001',1,'DV-0001'),(17,0,0,'2021-04-30','2021-04-21','KH-0001',1,'DV-0001');
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
INSERT INTO `contract_detail` VALUES (1,2,2),(1,3,1),(1,14,3),(1,15,3),(1,17,3),(2,4,3),(2,6,3),(2,14,3),(2,15,3),(2,17,3),(3,4,3),(3,6,1),(3,9,2),(3,16,3),(4,5,1),(4,6,1),(5,5,1);
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
INSERT INTO `customer` VALUES ('KH-0001','Quảng Nam','1998-01-01','haitruong@gmail.com','Nam','169636325','Trương Hải','0915255255',3),('KH-0002','Hà Tĩnh','2002-05-05','hoaithuongnguyen@gmail.com','Nữ','193366655','Nguyễn Hoài Thương','0905444555',2),('KH-0003','Huế','1991-05-02','minhhongoc@gmail.com','Nam','198855633255','Hồ Ngọc Minh','0912333655',5),('KH-0004','BÌnh định','2001-01-01','namthanh@gmaicx.com','Nam','125363666','Nguyễn Thanh Nam','0903255255',4);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Quảng Trị','1991-09-02','quocdon2991@gmail.com','197255499','Phạm Quốc Đôn','0915225252',15000000,'quocdon',3,3,6),(2,'Quảng Trị','1993-12-15','hoangpham2@gmail.com','444555666','Phạm Quốc Hoàng','0913666555',10000000,'quochoang',4,3,1),(3,'Quảng Nam','1997-01-01','thuha97@gmail.com','195625536','Nguyễn Thu Hà','0905444555',7000000,'thuha',1,4,4);
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
INSERT INTO `hibernate_sequence` VALUES (18);
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
INSERT INTO `resort_service` VALUES ('DV-0001',150,2500000,4,'Happy House',3,2),('DV-0002',200,15000000,8,'Art Villa',2,1),('DV-0003',45,3000000,3,'Happy House',1,2),('DV-0004',120,9000000,6,'An Villa',1,1),('DV-0005',63,1200000,2,'Funny Room',1,3),('DV-0006',100,5000000,4,'Dana House',4,2);
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
INSERT INTO `user_role` VALUES (1,'admin'),(1,'quocdon'),(3,'quochoang'),(2,'thuha'),(3,'thuha');
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

-- Dump completed on 2021-04-19  1:28:29
