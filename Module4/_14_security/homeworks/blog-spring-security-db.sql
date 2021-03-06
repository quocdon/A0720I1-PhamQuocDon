-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: blog-security-2
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
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_role`
--

LOCK TABLES `app_role` WRITE;
/*!40000 ALTER TABLE `app_role` DISABLE KEYS */;
INSERT INTO `app_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
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
INSERT INTO `app_user` VALUES ('admin','$2a$10$52nJhv6TJlbwbzhl.ip0v.QRoafPZPVv97cdhkyHemq7WpWgBXXVS'),('user1','$2a$10$EaySZYjSHD47lTDDH.1Nxea6V6ubCoWGsPp8TWhm8O4MAtYgWmwGC'),('user2','$2a$10$EaySZYjSHD47lTDDH.1Nxea6V6ubCoWGsPp8TWhm8O4MAtYgWmwGC'),('user3','$2a$10$EaySZYjSHD47lTDDH.1Nxea6V6ubCoWGsPp8TWhm8O4MAtYgWmwGC');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `created_time` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `app_user_username` varchar(255) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn07qodonhgqsvnri2b4pbcj3g` (`app_user_username`),
  KEY `FKqyvjif1i2geaeuvkh3n1jrnn4` (`category_id`),
  CONSTRAINT `FKn07qodonhgqsvnri2b4pbcj3g` FOREIGN KEY (`app_user_username`) REFERENCES `app_user` (`username`),
  CONSTRAINT `FKqyvjif1i2geaeuvkh3n1jrnn4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'Bộ Y tế sáng nay không ghi nhận ca dương tính nCoV. Tổng số ca nhiễm cộng đồng hơn một tháng qua là 895.\r\n\r\nNhư vậy, 24 giờ qua thêm 3 ca nhiễm, gồm một ca ở Hải Duơng và hai người nhập cảnh được cách ly ngay. Tổng số ca nhiễm cộng đồng hơn một tháng qua là 895, ghi nhận ở 13 tỉnh thành gồm Hải Dương (711), Quảng Ninh (61), TP HCM (36), Hà Nội (35), Gia Lai (27), Bình Dương (6), Bắc Ninh (5), Hải Phòng (4), Điện Biên (3), Hòa Bình, Hưng Yên và Bắc Giang mỗi nơi 2 ca, Hà Giang một ca.','2020-05-25','Sáng 11/3 Vietnam không thêm ca Covid-19','user1',2),(3,'Quy hoạch phân khu đô thị sông Hồng dự kiến được TP Hà Nội ban hành vào tháng 6 tới, với chức năng chính là công trình công cộng, công viên cây xanh.\r\n\r\nChiều 10/3, Thường vụ Thành ủy Hà Nội cho ý kiến về chủ trương hoàn thiện Đồ án quy hoạch phân khu đô thị sông Hồng, tỷ lệ 1/5.000.\r\n\r\nĐồ án được nghiên cứu trên không gian đoạn sông Hồng dài khoảng 40 km từ cầu Hồng Hà đến cầu Mễ Sở, bao phủ diện tích khoảng 11.000 ha; thuộc địa bàn 55 phường, xã và 13 quận, huyện; dân số tính toán theo quy hoạch từ 280.000 - 320.000 người.\r\n\r\nTheo đại diện UBND thành phố, đồ án nhằm hình thành trục không gian văn hóa - cảnh quan sinh thái Hồ Tây - Cổ Loa; cải tạo, chỉnh trang, tái thiết hệ thống dân cư hiện hữu, bảo tồn các công trình di tích, kiến trúc có giá trị lịch sử, kết hợp khai thác quỹ đất phát triển mới tạo lập diện mạo đô thị hai bên sông Hồng.\r\n\r\nKhông gian nghiên cứu đồ án rất khác biệt vì đây là khu vực dành cho thoát lũ ngoài đê sông Hồng, có quy mô, tính chất phức tạp với nhiều yếu tố đan xen.','2021-02-21','Hà Nội sắp phê duyệt quy hoạch phân khu đô thị sông Hồng','admin',1),(5,'Lực lượng chức năng lắp lại 8 điểm hộ lan bị phá trên cao tốc Hà Nội - Lào Cai, đoạn qua huyện Văn Yên, chiều 10/3/2019.\r\n\r\nĐoàn công tác của Tổng cục Đường bộ phối hợp với Tổng công ty Đầu tư phát triển đường cao tốc VN (VEC) và UBND huyện Văn Yên đã đến hiện trường để xử lý các vi phạm hành lang an toàn giao thông trên tuyến cao tốc Hà Nội - Lào Cai, trong đó có vị trí Km172+500, nơi hộ lan (rào chắn) tuyến cao tốc bị người dân tháo dỡ để đi lại và kinh doanh hàng quán.','2019-03-18','Lắp lại rào chắn trên cao tốc Hà Nội - Lào Cai','user1',1),(7,'Thời tiết thuận lợi trở lại ở thủy điện Rào Trăng 3, tỉnh lên kế hoạch tiếp tục tìm kiếm thi thể 11 công nhân còn mất tích tại đây.\r\n\r\nNgày 10/3, ông Nguyễn Văn Phương - Phó chủ tịch tỉnh Thừa Thiên Huế, họp với lực lượng chức năng để bàn phương án khả thi tìm kiếm các công nhân mất tích.\r\n\r\nTheo ông, từ nay đến tháng 5/2021 thời tiết thuận lợi, còn sang tháng 6 thì bão và áp thấp nhiệt đới khả năng xuất hiện trên biển Đông. Do vậy các lực lượng cần \"chạy đua từng ngày\". Việc tìm kiếm sẽ chia làm ba khu vực, trong đó Công ty cổ phần thủy điện Rào Trăng 3 phụ trách hai bên dòng sông.\r\n\r\nLực lượng chức năng tìm kiếm ở hai bãi bồi, đoạn từ hiện trường xuôi về ngã ba Tam Dần, dài khoảng 2,5 km. \"Việc đào bới đất đai ở đây phải dựa vào máy móc nên đoàn khảo sát cần tính toán việc mở đường cho thiết bị lên xuống thuận lợi\" ông Phương nói.\r\n\r\nKhu vực còn lại là lòng sông, lưu vực sông sẽ được tìm kiếm khi chủ đầu tư hoàn tất việc xây dựng đập dâng thủy điện Rào Trăng, dự kiến cuối tháng 6 (khi xây xong đập thì mới làm cạn được dòng sông, phục vụ việc tìm kiếm).','2020-01-01','Tiếp tục tìm kiếm 11 công nhân mất tích ở Rào Trăng','user2',1),(8,'Tỉnh đoàn Khánh Hòa xây dựng đề án phố ẩm thực sát biển với 20 xe lưu động, tổng mức đầu tư 30 tỷ đồng, để thu hút khách du lịch, giúp thanh niên khởi nghiệp.\r\n\r\nChiều 10/3, Bí thư Tỉnh đoàn Khánh Hòa Bùi Hoài Nam cho biết Đề án xây phố ẩm thực bằng xe bán hàng lưu động \"Food Truck\" đã được UBND tỉnh đồng ý. \"Food Truck\" là mô hình kinh doanh ẩm thực trên ôtô tải được thiết kế độc đáo, bắt mắt, có nhiều đồ ăn, hàng lưu niệm phục vụ khách. Mô hình này phát triển ở một số nước, song tại Việt Nam chưa có nhiều.','2019-03-15','Xây phố ẩm thực đêm ven biển Nha Trang','user2',3),(9,'Tổng cục Du lịch đang tích cực nghiên cứu và làm việc với các đơn vị liên quan về vấn đề mở cửa cho khách du lịch nước ngoài đã có chứng chỉ tiêm vaccine Covid-19.\r\n\r\nChiều 11/3, ông Nguyễn Trùng Khánh, Tổng cục trưởng Du lịch cho biết sau khi Tổng cục làm việc với các bộ, ngành liên quan, sẽ tham mưu lãnh đạo Bộ Văn hóa Thể thao và Du lịch để báo cáo Chính phủ về vấn đề hộ chiếu (visa) vaccine Covid-19 trong lĩnh vực du lịch.\r\n\r\nCùng ngày, Bộ trưởng, Chủ nhiệm Văn phòng Chính phủ Mai Tiến Dũng cho biết, tại thời điểm hiện nay, \"Chính phủ chưa bàn đến vấn đề nới lỏng việc áp dụng các biện pháp phòng, chống dịch bệnh cho những người đã có chứng chỉ tiêm vaccine Covid-19\".\r\n\r\nDo chưa có chủ trương và quy định mới từ Chính phủ cũng như Ban chỉ đạo Quốc gia về phòng, chống Covid-19, \"nên người nhập cảnh Việt Nam hiện nay vẫn phải cách ly đủ 14 ngày\", theo Thứ trưởng Y tế Đỗ Xuân Tuyên.\r\n\r\nTổng cục Du lịch đang tích cực nghiên cứu và làm việc với các đơn vị liên quan về vấn đề mở cửa cho khách du lịch nước ngoài đã có chứng chỉ tiêm vaccine Covid-19.\r\n\r\nChiều 11/3, ông Nguyễn Trùng Khánh, Tổng cục trưởng Du lịch cho biết sau khi Tổng cục làm việc với các bộ, ngành liên quan, sẽ tham mưu lãnh đạo Bộ Văn hóa Thể thao và Du lịch để báo cáo Chính phủ về vấn đề hộ chiếu (visa) vaccine Covid-19 trong lĩnh vực du lịch.\r\n\r\nCùng ngày, Bộ trưởng, Chủ nhiệm Văn phòng Chính phủ Mai Tiến Dũng cho biết, tại thời điểm hiện nay, \"Chính phủ chưa bàn đến vấn đề nới lỏng việc áp dụng các biện pháp phòng, chống dịch bệnh cho những người đã có chứng chỉ tiêm vaccine Covid-19\".\r\n\r\nDo chưa có chủ trương và quy định mới từ Chính phủ cũng như Ban chỉ đạo Quốc gia về phòng, chống Covid-19, \"nên người nhập cảnh Việt Nam hiện nay vẫn phải cách ly đủ 14 ngày\", theo Thứ trưởng Y tế Đỗ Xuân Tuyên.\r\n\r\nNhững người tham gia chống dịch được tiêm vaccine Covid-19, tại Bệnh viện Nhiệt đới Trung ương cơ sở 2, ngày 8/3. Ảnh: Giang Huy\r\nNhững người tham gia chống dịch được tiêm vaccine Covid-19 đợt đầu tiên, tại Bệnh viện Nhiệt đới Trung ương cơ sở 2, ngày 8/3. Ảnh: Giang Huy\r\n\r\nTrước đó ngày 5/3, Văn phòng Chính phủ truyền đạt ý kiến của Thủ tướng Nguyễn Xuân Phúc giao Bộ Văn hóa, Thể thao và Du lịch chủ trì, phối hợp với các bộ, ngành liên quan nghiên cứu, đánh giá và đề xuất biện pháp xử lý phù hợp kiến nghị liên quan đến \"hộ chiếu vaccine\".\r\n\r\nTheo đó, Việt Nam không nên đợi hết dịch mới đón du khách quốc tế, mà cần thiết xem xét việc mở cửa cho khách du lịch có chứng chỉ tiêm vaccine Covid-19. Điều này sẽ giúp nâng cao vị thế của du lịch Việt Nam. Tuy nhiên, việc đưa tấm hộ chiếu này vào thực tiễn còn khá nhiều trở ngại, đặc biệt là về cơ sở pháp lý và công nghệ.\r\n\r\nHôm 4/3, Phó thủ tướng, Bộ trưởng Ngoại giao Phạm Bình Minh điện đàm với Bộ trưởng Ngoại giao Singapore Vivian Balakrishnan, đã thảo luận các biện pháp đẩy mạnh giao thương, thúc đẩy hồi phục kinh tế sau đại dịch, mở cửa và tạo điều kiện thuận lợi cho đi lại; kế hoạch tiêm chủng vaccine và khả năng áp dụng hộ chiếu vaccine.\r\n\r\nHộ chiếu vaccine là một loại tài liệu kỹ thuật số chứng minh một cá nhân đã được tiêm phòng virus, trong trường hợp này là Covid-19 (còn được gọi là thẻ sức khỏe kỹ thuật số). Tài liệu này được lưu trữ trên điện thoại hoặc ví kỹ thuật số, dữ liệu hiển thị dưới dạng mã QR, còn có thể cung cấp thông tin liệu một người đã xét nghiệm âm tính với virus hay chưa.\r\n\r\nTheo Tổ chức Du lịch thế giới (UNWTO), áp dụng chứng nhận tiêm phòng sẽ là công cụ quan trọng để ứng phó với đại dịch, thúc đẩy tái khởi động hoạt động du lịch quốc tế một cách an toàn. Một số nước trên thế giới đã phát hành hộ chiếu vaccine Covid-19, như Trung Quốc. Thái Lan cũng đã công bố kế hoạch cấp hộ chiếu vaccine và giảm thời gian cách ly bắt buộc những người đã tiêm chủng.\r\n\r\nTuy nhiên, Tổ chức Y tế Thế giới (WHO) kêu gọi thận trọng với các loại hộ chiếu y tế, yêu cầu các nhà chức trách và nhà điều hành du lịch không coi bằng chứng về việc tiêm chủng là điều kiện để đi du lịch quốc tế.\r\n\r\nNgày 10/3, ông Calvin Q Trịnh, Việt kiều Mỹ, trên 40 tuổi, nhập cảnh tại Tân Sơn Nhất, đã trình hộ chiếu đính kèm chứng nhận đã tiêm hai mũi vaccine Covid-19. Ông này vẫn bị cách ly 14 ngày theo quy định.','2018-04-22','Nghiên cứu đề xuất \'hộ chiếu vaccine\' Covid-19','user2',1),(10,'Quán bar phải đóng cửa, và đại diện cho biết sẽ xem xét lại phong cách trang trí theo chủ đề chiến tranh Việt Nam.\r\n\r\nRickshaw Bar, một quán bar trang trí theo chủ đề chiến tranh Việt Nam, nằm ở khu Richmond của thành phố Melbourne. Quán sử dụng thẻ bài quân nhân, vỏ đạn, và những vật dụng khác liên quan đến chiến tranh.\r\n\r\nNội thất của quán dùng tone chủ đạo là cam. Nhiều người cho rằng màu sắc này gợi nhớ tới chất độc màu da cam - một loại vũ khí hóa học từng được quân đội Mỹ sử dụng trong thời kỳ chiến tranh Việt Nam.\r\n\r\nNhiều người dùng Internet cho biết chủ quán đang thể hiện sự thiếu nhạy cảm khi trang trí quán theo chủ đề chiến tranh. \"Họ đang khơi gợi chủ đề chiến tranh Việt Nam trên mạng xã hội khi nạn phân biệt chủng tộc chống người châu Á đang gia tăng. Và quán bar này mở cửa ở Richmond, nơi có nhiều người Việt Nam sinh sống\", một người bày tỏ.\r\n\r\n\"Hãy tưởng tượng bạn đang nhắc nhớ về một cuộc chiến khiến hàng triệu người chết, và dựa vào nó để bán những ly cocktail chứa đầy vỏ đạn cùng chủ đề chất độc màu da cam\", tạp chí văn hóa nghệ thuật Liminal bình luận.\r\n\r\nBình luận về tin tức liên quan đến quán bar này, người phát ngôn của Sở Cựu chiến binh Australia nói rằng họ khuyến khích các cá nhân và tổ chức nhắc đến các cuộc chiến tranh với thái độ tôn trọng, trang nghiêm.\r\n\r\nRickshaw Bar đã đóng cửa và đang xem xét lại phong cách trang trí và hình ảnh quảng cáo trực tuyến. Bài đăng duy nhất còn hiển thị trên fanpage là lời xin lỗi. \"Chúng tôi đã gỡ bài đăng và xin lỗi bất kỳ ai cảm thấy bị xúc phạm, hay thấy nội dung nhạy cảm. Chúng tôi đã thay đổi nội dung và đang làm việc chăm chỉ để sửa lỗi. Xin lỗi vì bất kỳ đau đớn, tổn thương nào mà chúng tôi gây ra, và chúng tôi thật lòng không có ý đó\".','2020-12-01','Quán bar chủ đề chiến tranh Việt Nam bị chỉ trích dữ dội','user3',1),(11,'Blogger ẩm thực Tieghan Gerard đã sửa lại cách gọi tên món ăn, nhưng mọi người vẫn chỉ trích vì cho rằng cô thực sự không hiểu được vấn đề.\r\n\r\nĐầu tháng 2, blogger ẩm thực có 2,7 triệu lượt theo dõi Tieghan Gerard chia sẻ công thức nấu phở gà trên blog Half Baked Harvest. Cô giới thiệu thời gian hoàn thành món ăn là một giờ, nguyên liệu gồm gà kho tàu cùng nước sốt mè ngọt, cay, thơm.','2021-01-31','Blogger hứng chỉ trích vì nấu phở sai công thức','admin',3),(13,'Lãnh đạo Toyota Motor Akio Toyoda cho biết việc kinh doanh xe cần nhiều thứ hơn là công nghệ để sản xuất ra chúng.\r\n\r\nTrong một cuộc họp do Hiệp hội Các hãng Xe Nhật Bản tổ chức hôm nay, Toyoda cho biết ngành xe hơi luôn hoan nghênh những người chơi mới như Apple, nhưng Táo Khuyết sẽ phải sẵn sàng gắn kết với khách hàng trong nhiều thập kỷ. \"Ai cũng có thể làm xe nếu có công nghệ. Tuy nhiên, sau khi tạo ra một chiếc xe, tôi muốn họ phải chuẩn bị cho sự thay đổi của khách hàng và nhiều thay đổi khác trong 40 năm\", ông nói.\r\n\r\nDù Apple có thể mất ít nhất 5 năm mới ra mắt được xe điện tự lái như kế hoạch, đại gia công nghệ này đang tạo sóng trong ngành xe hơi khi tiếp cận nhiều hãng xe để hợp tác sản xuất. Việc Táo Khuyết tham gia thị trường xe hơi khiến nhiều tên tuổi lo ngại. Đây có thể là một trong những lý do các cuộc nói chuyện giữa Apple và một số công ty thất bại trong vài tháng gần đây. Hyundai Motor và một số hãng khác đã rút lại tuyên bố trước đó rằng hai bên đang đàm phán.','2019-04-14','Toyota cảnh báo Apple về tham vọng xe hơi','user3',2),(14,'Song Joong Ki tái xuất màn ảnh nhỏ trong phim \"Vincenzo\". Hóa thân Vincenzo Cassano - một chiến lược gia, luật sư và trùm mafia ở Italy, anh gây ấn tượng với vẻ ngoài điển trai, lịch lãm. Korean Drama Fashion (KDF) - trang chuyên bóc giá hàng hiệu của sao Hàn - cùng nhiều khán giả nói bất ngờ về loạt phụ kiện xa xỉ của Song Joong Ki trong phim. Tài tử chọn trang phục, cặp xách của các thương hiệu trong nước với mức giá tầm trung nhưng đeo nhiều mẫu đồng hồ cao cấp. Tài khoản Jaz viết: \"Ngoài tình tiết phim, diễn xuất của các nhân vật thì bộ sưu tập đồng hồ của Song Joong Ki khiến tôi thích thú hơn\".\r\nTheo KDF, mở màn tập một, tài tử đeo chiếc Navitimer B01 Chronograph 46 mm vỏ thép và vàng đỏ của thương hiệu Breitling (Thụy Sĩ) giá 11.460 USD (hơn 264 triệu đồng).','2020-01-18','Đồng hồ hàng hiệu của Song Joong Ki trong phim mới','admin',3);
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Tin tức'),(2,'Công nghệ'),(3,'Giải trí'),(4,'Kinh tế');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
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
INSERT INTO `user_role` VALUES (1,'admin'),(2,'user1'),(2,'user2'),(2,'user3');
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

-- Dump completed on 2021-04-10 18:31:32
