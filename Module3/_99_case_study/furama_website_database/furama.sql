-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: furama
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
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `attach_service_id` int NOT NULL,
  `attach_service_name` varchar(45) NOT NULL,
  `attach_service_cost` double DEFAULT '0',
  `attach_service_unit` varchar(45) DEFAULT 'Lần',
  `attach_service_status` varchar(45) DEFAULT 'Khả dụng',
  PRIMARY KEY (`attach_service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (1,'Massage',100,'Lần','Khả dụng'),(2,'Karaoke',20,'Giờ','Khả dụng'),(3,'Thức ăn',50,'Ngày','Khả dụng'),(4,'Nước uống',10,'Ngày','Khả dụng'),(5,'Thuê xe',200,'Lần','Khả dụng');
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contract_id` varchar(45) NOT NULL,
  `contract_start_date` date DEFAULT NULL,
  `contract_end_date` date DEFAULT NULL,
  `contract_deposit` double DEFAULT '0',
  `contract_amount` double DEFAULT '0',
  `employee_id` int DEFAULT NULL,
  `customer_id` varchar(45) DEFAULT NULL,
  `service_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `employee_fk_idx` (`employee_id`),
  KEY `customer_fk_idx` (`customer_id`),
  CONSTRAINT `customer_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `employee_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `contract_detail_id` int NOT NULL AUTO_INCREMENT,
  `contract_id` varchar(45) DEFAULT NULL,
  `attach_service_id` int DEFAULT NULL,
  `quantity` int DEFAULT '0',
  PRIMARY KEY (`contract_detail_id`),
  KEY `contract_id_idx` (`contract_id`),
  KEY `attach_service_fk_idx` (`attach_service_id`),
  CONSTRAINT `attach_service_fk` FOREIGN KEY (`attach_service_id`) REFERENCES `attach_service` (`attach_service_id`),
  CONSTRAINT `contract_fk` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` varchar(45) NOT NULL,
  `customer_type_id` int DEFAULT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `customer_birthday` date DEFAULT NULL,
  `customer_gender` varchar(45) DEFAULT NULL,
  `customer_idCard` varchar(45) DEFAULT NULL,
  `customer_phone` varchar(45) DEFAULT NULL,
  `customer_email` varchar(45) DEFAULT NULL,
  `customer_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `customer_type_fk_idx` (`customer_type_id`),
  CONSTRAINT `customer_type_fk` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`customer_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('KH-0001',1,'Phạm Quốc Đôn','1991-09-02','Nam','1212352525','0123456789','quocdon2991@gmail.com','Quang Tri'),('KH-0002',2,'Trần Hoàng Việt','1997-03-05','Nam','123456789012','(84)+915234567','viet2fa@gmail.com','Quang Nam'),('KH-0003',5,'Nguyễn Thu Hà','1997-12-15','Nữ','012345678','0905333145','thuha@gmail.com','Quang Tri'),('KH-0004',2,'Tô Thanh Nam','2001-05-02','Nam','123321123','0905222145','tothanhnam@gmail.com','Bình Định');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `customer_type_id` int NOT NULL,
  `customer_type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `department_id` int NOT NULL,
  `department_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Sales-Marketing'),(2,'Hành chính'),(3,'Phục vụ'),(4,'Quản lý');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_degree`
--

DROP TABLE IF EXISTS `education_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education_degree` (
  `education_degree_id` int NOT NULL,
  `education_degree_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`education_degree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_degree`
--

LOCK TABLES `education_degree` WRITE;
/*!40000 ALTER TABLE `education_degree` DISABLE KEYS */;
INSERT INTO `education_degree` VALUES (1,'Trung cấp'),(2,'Cao đẳng'),(3,'Đại học'),(4,'Sau đại học');
/*!40000 ALTER TABLE `education_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `employee_birthday` date DEFAULT NULL,
  `employee_idcard` varchar(45) DEFAULT NULL,
  `employee_salary` double DEFAULT '0',
  `employee_phone` varchar(45) DEFAULT NULL,
  `employee_email` varchar(45) DEFAULT NULL,
  `employee_address` varchar(45) DEFAULT NULL,
  `position_id` int NOT NULL,
  `education_degree_id` int NOT NULL,
  `department_id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `position_fk` (`position_id`),
  KEY `education_fk` (`education_degree_id`),
  KEY `department_fk` (`department_id`),
  KEY `user_fk` (`username`),
  CONSTRAINT `department_fk` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `education_fk` FOREIGN KEY (`education_degree_id`) REFERENCES `education_degree` (`education_degree_id`),
  CONSTRAINT `position_fk` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (6,'Phạm Quốc Đôn','2020-12-28','123122',5000,'0352222111','quocdon2991@gmail.com','Quang Tri',4,3,2,'abc'),(8,'Nam','2002-01-18','123456789',250,'0123456789','nam@gmail.com','Binh Dinh',1,4,3,'nam'),(9,'Nguyễn Hồng Sáng','1999-05-02','1235582563',2000,'0952326221','sangidol@gmail.com','Hà Tĩnh',4,3,4,'sang');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` int NOT NULL,
  `position_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Lễ Tân'),(2,'Phục vụ'),(3,'Chuyên Viên'),(4,'Giám sát'),(5,'Quản lý'),(6,'Giám đốc');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `rent_type_id` int NOT NULL,
  `rent_type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rent_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,'Năm'),(2,'Tháng'),(3,'Ngày'),(4,'Giờ');
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_id` varchar(15) NOT NULL,
  `service_name` varchar(45) DEFAULT NULL,
  `service_area` int DEFAULT '0',
  `service_cost` double DEFAULT NULL,
  `service_max_people` int DEFAULT NULL,
  `rent_type_id` int DEFAULT NULL,
  `service_type_id` int DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `rent_type_id_fk_idx` (`rent_type_id`),
  KEY `service_type_fk_idx` (`service_type_id`),
  CONSTRAINT `rent_type_fk` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`rent_type_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `service_type_fk` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES ('DV-0001','Happy Villa',50,2000,50,3,1),('DV-0002','Couple Room',25,200,25,4,3),('DV-0003','Funny house',70,250,70,4,2),('DV-0004','Danang Villa',250,3000,250,2,1),('DV-0005','Danang Villa',250,3000,250,2,1),('DV-0006','Small Room',32,40,32,1,3),('DV-0007','Maia House',100,100,100,2,2),('DV-0008','Papa Villa',234,1500,234,2,1);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `service_type_id` int NOT NULL,
  `service_type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`service_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('abc','123'),('nam','123'),('sang','123');
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

-- Dump completed on 2021-02-01  2:22:19
