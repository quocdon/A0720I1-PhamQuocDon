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
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `IDKhachHang` int NOT NULL AUTO_INCREMENT,
  `IDLoaiKhach` int NOT NULL,
  `HoTen` varchar(45) NOT NULL,
  `NgaySinh` date NOT NULL,
  `SoCMND` varchar(45) NOT NULL,
  `SDT` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `DiaChi` varchar(45) NOT NULL,
  PRIMARY KEY (`IDKhachHang`),
  UNIQUE KEY `Email` (`Email`),
  KEY `IDLoaiKhach` (`IDLoaiKhach`),
  CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`IDLoaiKhach`) REFERENCES `loaikhach` (`IDLoaiKhach`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,2,'Nguyen Van An','1991-11-22','111222333','0931552555','nguyenan1991@gmail.com','Da Nang'),(2,1,'Pham Van Cuong','1999-12-22','123255999','0934333555','phamcuong1999@gmail.com','Quang Ngai'),(3,3,'Nguyen Hoang Yen','1994-05-22','111312444','0375111555','nguyenyen1994@gmail.com','Quang Nam'),(4,2,'Nguyen Thuy Van','1995-01-26','111123656','0364666999','nguyenvan1995@gmail.com','Da Nang'),(5,4,'Hoang Van Binh','1994-04-24','123000333','0934696969','hoangbinh1994@gmail.com','Da Nang'),(6,5,'Trinh Thanh Giang','1992-01-12','100055523','0934255255','trinhgiang1992@gmail.com','Hue'),(7,2,'Nguyen Hoang Nam','1943-10-22','111635333','0931552123','nguyennam1943@gmail.com','Da Nang'),(8,4,'Pham Quoc Khanh','2009-12-22','123125999','0985252252','phamkhanh2009@gmail.com','Quang Tri'),(9,3,'Nguyen Bich Thuy','1984-06-12','111000444','0948248248','nguyenthuy1984@gmail.com','Quang Tri');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09 11:04:41
