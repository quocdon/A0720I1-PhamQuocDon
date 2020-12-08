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
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `IDNhanVien` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) NOT NULL,
  `IDViTri` int NOT NULL,
  `IDTrinhDo` int NOT NULL,
  `IDBoPhan` int NOT NULL,
  `NgaySinh` date NOT NULL,
  `SoCMND` varchar(45) NOT NULL,
  `Luong` int NOT NULL,
  `SDT` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `DiaChi` varchar(45) NOT NULL,
  PRIMARY KEY (`IDNhanVien`),
  UNIQUE KEY `SoCMND` (`SoCMND`),
  KEY `IDViTri` (`IDViTri`),
  KEY `IDTrinhDo` (`IDTrinhDo`),
  KEY `IDBoPhan` (`IDBoPhan`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`IDViTri`) REFERENCES `vitri` (`IDViTri`),
  CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`IDTrinhDo`) REFERENCES `trinhdo` (`IDTrinhDo`),
  CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`IDBoPhan`) REFERENCES `bophan` (`IDBoPhan`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Hoang Nguyen Thu Thuyen',1,1,2,'2004-12-31','1972525252',5000000,'0375223252','ThuHuyen@furama.com','Quang Binh'),(2,'Hoang Van Kien',6,4,4,'1973-01-30','1114222333',60000000,'0374555333','vankien@furama.vn','Da Nang'),(3,'Pham Thi Thanh',2,1,1,'1994-01-12','1852222333',4000000,'0321112252','thithanh@furama.vn','Da Nang'),(4,'Tran Van An',3,2,2,'1984-12-15','1456111333',8000000,'0395755212','vanan@furama.vn','Hue'),(5,'Khuat Thu Giang',2,1,2,'1993-02-25','1452000333',12000000,'0395123455','thugiang@furama.vn','Binh Dinh'),(6,'Nguyen Van Nam',5,2,4,'2001-04-30','1992111333',25000000,'0394555252','vannam@furama.vn','Hue'),(7,'Duong Thi Thu',4,4,3,'1999-12-31','1972145444',10000000,'0381693222','thithu@furama.vn','Quang Nam');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09  1:27:29
