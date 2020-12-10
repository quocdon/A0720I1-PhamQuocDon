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
-- Table structure for table `bophan`
--

DROP TABLE IF EXISTS `bophan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bophan` (
  `IDBoPhan` int NOT NULL AUTO_INCREMENT,
  `TenBoPhan` varchar(45) NOT NULL,
  PRIMARY KEY (`IDBoPhan`),
  UNIQUE KEY `TenBoPhan` (`TenBoPhan`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bophan`
--

LOCK TABLES `bophan` WRITE;
/*!40000 ALTER TABLE `bophan` DISABLE KEYS */;
INSERT INTO `bophan` VALUES (2,'Hanh chinh'),(3,'Phuc vu'),(4,'Quan ly'),(1,'Sale-Marketing');
/*!40000 ALTER TABLE `bophan` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `dichvudikem`
--

DROP TABLE IF EXISTS `dichvudikem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvudikem` (
  `IDDichVuDiKem` int NOT NULL AUTO_INCREMENT,
  `TenDichVuDiKem` varchar(45) NOT NULL,
  `Gia` int NOT NULL DEFAULT '0',
  `DonVi` varchar(45) NOT NULL,
  `TrangThaiKhaDung` varchar(45) NOT NULL,
  PRIMARY KEY (`IDDichVuDiKem`),
  UNIQUE KEY `TenDichVuDiKem` (`TenDichVuDiKem`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvudikem`
--

LOCK TABLES `dichvudikem` WRITE;
/*!40000 ALTER TABLE `dichvudikem` DISABLE KEYS */;
INSERT INTO `dichvudikem` VALUES (1,'Massage',2000000,'Luot','Co'),(2,'Karaoke',500000,'Gio','Co'),(3,'Thuc an',300000,'Khach','Co'),(4,'Nuoc uong',200000,'Khach','Co'),(5,'Xe tham quan',1000000,'Luot','Co');
/*!40000 ALTER TABLE `dichvudikem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdong`
--

DROP TABLE IF EXISTS `hopdong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopdong` (
  `IDHopDong` int NOT NULL AUTO_INCREMENT,
  `IDNhanVien` int NOT NULL,
  `IDKhachHang` int NOT NULL,
  `IDDichVu` int NOT NULL,
  `NgayLamHopDong` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `TienDatCoc` int NOT NULL,
  `TongTien` int DEFAULT NULL,
  PRIMARY KEY (`IDHopDong`),
  KEY `IDNhanVien` (`IDNhanVien`),
  KEY `IDKhachHang` (`IDKhachHang`),
  KEY `IDDichVu` (`IDDichVu`),
  CONSTRAINT `hopdong_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`IDNhanVien`),
  CONSTRAINT `hopdong_ibfk_2` FOREIGN KEY (`IDKhachHang`) REFERENCES `khachhang` (`IDKhachHang`),
  CONSTRAINT `hopdong_ibfk_3` FOREIGN KEY (`IDDichVu`) REFERENCES `dichvu` (`IDDichVu`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdong`
--

LOCK TABLES `hopdong` WRITE;
/*!40000 ALTER TABLE `hopdong` DISABLE KEYS */;
INSERT INTO `hopdong` VALUES (1,1,2,2,'2019-12-06','2019-12-05',1000000,NULL),(2,2,4,1,'2019-10-12','2019-10-16',500000,NULL),(3,5,3,4,'2019-11-01','2021-01-13',1500000,NULL),(4,4,6,3,'2020-12-10','2020-12-30',2000000,NULL),(5,5,3,4,'2019-01-01','2019-03-31',1000000,NULL),(6,5,6,3,'2019-01-10','2019-01-30',3000000,NULL),(7,2,1,7,'2018-05-25','2018-06-11',2300000,NULL),(8,2,2,1,'2018-12-11','2018-12-15',1200000,NULL),(9,5,6,8,'2019-09-02','2019-09-05',2500000,NULL),(10,2,1,8,'2019-11-11','2019-11-20',2100000,NULL);
/*!40000 ALTER TABLE `hopdong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdongchitiet`
--

DROP TABLE IF EXISTS `hopdongchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopdongchitiet` (
  `IDHopDongChiTiet` int NOT NULL AUTO_INCREMENT,
  `IDHopDong` int NOT NULL,
  `IDDichVuDiKem` int NOT NULL,
  `SoLuong` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDHopDongChiTiet`),
  KEY `IDHopDong` (`IDHopDong`),
  KEY `IDDichVuDiKem` (`IDDichVuDiKem`),
  CONSTRAINT `hopdongchitiet_ibfk_1` FOREIGN KEY (`IDHopDong`) REFERENCES `hopdong` (`IDHopDong`),
  CONSTRAINT `hopdongchitiet_ibfk_2` FOREIGN KEY (`IDDichVuDiKem`) REFERENCES `dichvudikem` (`IDDichVuDiKem`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdongchitiet`
--

LOCK TABLES `hopdongchitiet` WRITE;
/*!40000 ALTER TABLE `hopdongchitiet` DISABLE KEYS */;
INSERT INTO `hopdongchitiet` VALUES (1,1,2,3),(2,2,1,2),(3,3,4,1),(4,4,5,4),(5,4,2,2),(6,1,3,3),(7,2,3,3),(8,5,2,1),(9,6,1,1),(10,7,3,2),(11,8,1,2);
/*!40000 ALTER TABLE `hopdongchitiet` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `kieuthue`
--

DROP TABLE IF EXISTS `kieuthue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kieuthue` (
  `IDKieuThue` int NOT NULL AUTO_INCREMENT,
  `TenKieuThue` varchar(45) NOT NULL,
  PRIMARY KEY (`IDKieuThue`),
  UNIQUE KEY `TenKieuThue` (`TenKieuThue`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kieuthue`
--

LOCK TABLES `kieuthue` WRITE;
/*!40000 ALTER TABLE `kieuthue` DISABLE KEYS */;
INSERT INTO `kieuthue` VALUES (4,'Gio'),(1,'Nam'),(3,'Ngay'),(2,'Thang');
/*!40000 ALTER TABLE `kieuthue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaidichvu`
--

DROP TABLE IF EXISTS `loaidichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaidichvu` (
  `IDLoaiDichVu` int NOT NULL AUTO_INCREMENT,
  `TenLoaiDichVu` varchar(45) NOT NULL,
  PRIMARY KEY (`IDLoaiDichVu`),
  UNIQUE KEY `TenLoaiDichVu` (`TenLoaiDichVu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaidichvu`
--

LOCK TABLES `loaidichvu` WRITE;
/*!40000 ALTER TABLE `loaidichvu` DISABLE KEYS */;
INSERT INTO `loaidichvu` VALUES (2,'House'),(3,'Room'),(1,'Villa');
/*!40000 ALTER TABLE `loaidichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaikhach`
--

DROP TABLE IF EXISTS `loaikhach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaikhach` (
  `IDLoaiKhach` int NOT NULL AUTO_INCREMENT,
  `TenLoaiKhach` varchar(45) NOT NULL,
  PRIMARY KEY (`IDLoaiKhach`),
  UNIQUE KEY `TenLoaiKhach` (`TenLoaiKhach`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaikhach`
--

LOCK TABLES `loaikhach` WRITE;
/*!40000 ALTER TABLE `loaikhach` DISABLE KEYS */;
INSERT INTO `loaikhach` VALUES (1,'Diamond'),(3,'Gold'),(5,'Member'),(2,'Platinum'),(4,'Silver');
/*!40000 ALTER TABLE `loaikhach` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `trinhdo`
--

DROP TABLE IF EXISTS `trinhdo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trinhdo` (
  `IDTrinhDo` int NOT NULL AUTO_INCREMENT,
  `TrinhDo` varchar(45) NOT NULL,
  PRIMARY KEY (`IDTrinhDo`),
  UNIQUE KEY `TrinhDo` (`TrinhDo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trinhdo`
--

LOCK TABLES `trinhdo` WRITE;
/*!40000 ALTER TABLE `trinhdo` DISABLE KEYS */;
INSERT INTO `trinhdo` VALUES (2,'Cao dang'),(3,'Dai hoc'),(4,'Sau dai hoc'),(1,'Trung cap');
/*!40000 ALTER TABLE `trinhdo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vitri`
--

DROP TABLE IF EXISTS `vitri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vitri` (
  `IDViTri` int NOT NULL AUTO_INCREMENT,
  `TenViTri` varchar(45) NOT NULL,
  PRIMARY KEY (`IDViTri`),
  UNIQUE KEY `TenViTri` (`TenViTri`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vitri`
--

LOCK TABLES `vitri` WRITE;
/*!40000 ALTER TABLE `vitri` DISABLE KEYS */;
INSERT INTO `vitri` VALUES (3,'Chuyen vien'),(6,'Giam doc'),(4,'Giam sat'),(1,'Le tan'),(2,'Phuc vu'),(5,'Quan ly');
/*!40000 ALTER TABLE `vitri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-10 18:01:28
