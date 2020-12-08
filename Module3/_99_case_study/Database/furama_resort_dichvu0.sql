-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: furama_resort
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
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `IDDichVu` int NOT NULL AUTO_INCREMENT,
  `TenDichVu` varchar(45) NOT NULL,
  `DienTich` int NOT NULL,
  `SoTang` int NOT NULL,
  `SoNguoiToiDa` int NOT NULL,
  `ChiPhiThue` int NOT NULL,
  `IDKieuThue` int NOT NULL,
  `IDLoaiDichVu` int NOT NULL,
  `TrangThai` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDDichVu`),
  UNIQUE KEY `TenDichVu` (`TenDichVu`),
  KEY `IDKieuThue` (`IDKieuThue`),
  KEY `IDLoaiDichVu` (`IDLoaiDichVu`),
  CONSTRAINT `dichvu_ibfk_1` FOREIGN KEY (`IDKieuThue`) REFERENCES `kieuthue` (`IDKieuThue`),
  CONSTRAINT `dichvu_ibfk_2` FOREIGN KEY (`IDLoaiDichVu`) REFERENCES `loaidichvu` (`IDLoaiDichVu`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,'Codegym Villa',234,3,12,25000000,3,1,'Kha dung'),(2,'Fusion Villa',150,1,6,14000000,1,1,'Kha dung'),(3,'Open Villa',150,2,7,25000000,2,1,'Khong kha dung'),(4,'Funny House',100,2,4,15000000,3,2,'Kha dung'),(5,'Nightmare House',110,1,3,8000000,2,2,'Kha dung'),(6,'Rose House',100,2,4,400000,3,2,'Kha dung'),(7,'Happy Room',78,1,3,200000,4,3,'Kha dung'),(8,'Crazy Room',50,1,2,1000000,3,3,'Kha dung');
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09  1:38:54
