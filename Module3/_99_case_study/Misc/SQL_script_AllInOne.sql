create database furama_resort;
use furama_resort;
create table Vitri(
IDViTri int not null auto_increment,
TenViTri varchar(45) not null unique,
constraint ViTri_pk primary key (IDViTri)
);
create table TrinhDo(
IDTrinhDo int not null auto_increment,
TrinhDo varchar(45) not null unique,
constraint TrinhDo_pk primary key (IDTrinhDo)
);
create table BoPhan(
IDBoPhan int not null auto_increment,
TenBoPhan varchar(45) not null unique,
constraint BoPhan_pk primary key (IDBoPhan)
);
create table LoaiKhach(
IDLoaiKhach int not null auto_increment,
TenLoaiKhach varchar(45) not null unique,
constraint LoaiKhach_pk primary key (IDLoaiKhach)
);

create table KieuThue(
IDKieuThue int not null auto_increment,
TenKieuThue varchar(45) not null unique,
constraint KieuThue_pk primary key (IDKieuThue)
);
create table LoaiDichVu(
IDLoaiDichVu int not null auto_increment,
TenLoaiDichVu varchar(45) not null unique,
constraint LoaiDichVu_pk primary key (IDLoaiDichVu)
);
create table DichVuDiKem(
IDDichVuDiKem int not null auto_increment,
TenDichVuDiKem varchar(45) not null unique,
Gia int not null,
DonVi varchar(45) not null,
TrangThaiKhaDung varchar(45) not null,
constraint DichVuDiKem_pk primary key (IDDichVuDiKem)
);
create table NhanVien(
IDNhanVien int not null auto_increment,
HoTen varchar(45) not null,
IDViTri int not null,
IDTrinhDo int not null,
IDBoPhan int not null,
NgaySinh date not null,
SoCMND  varchar(45) not null unique,
Luong varchar(45) not null,
SDT varchar(45) not null,
Email varchar(45) not null,
DiaChi varchar(45) not null,
constraint NhanVien_pk primary key (IDNhanVien),
foreign key (IDViTri) references ViTri(IDViTri),
foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo),
foreign key (IDBoPhan) references BoPhan(IDBoPhan)
);
alter table NhanVien
modify Luong int not null;
create table KhachHang(
IDKhachHang int not null auto_increment,
IDLoaiKhach int not null,
HoTen varchar(45) not null,
NgaySinh varchar(45) not null,
SoCMND varchar(45) not null,
SDT varchar(45) not null,
Email varchar(45) not null unique,
DiaChi varchar(45) not null,
constraint KhachHang_pk primary key (IDKhachHang),
foreign key (IDLoaiKhach) references LoaiKhach(IDLoaiKhach)
);
alter table KhachHang
modify NgaySinh date not null;
create table DichVu(
IDDichVu int not null auto_increment,
TenDichVu varchar(45) not null unique,
DienTich int not null,
SoTang int not null,
SoNguoiToiDa int not null,
ChiPhiThue int not null,
IDKieuThue int not null,
IDLoaiDichVu int not null,
TrangThai varchar(45),
constraint DichVu_pk primary key (IDDichVu),
foreign key (IDKieuThue) references KieuThue(IDKieuThue),
foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu)
);
create table HopDong(
IDHopDong int not null auto_increment,
IDNhanVien int not null,
IDKhachHang int not null,
IDDichVu int not null,
NgayLamHopDong date not null,
NgayKetThuc date not null,
TienDatCoc int not null,
TongTien int not null,
constraint HopDong_pk primary key (IDHopDong),
foreign key (IDNhanVien) references NhanVien(IDNhanVien),
foreign key (IDKhachHang) references KhachHang(IDKhachHang),
foreign key (IDDichVu) references DichVu(IDDichVu)
);
alter table HopDong
modify TongTien int;
create table HopDongChiTiet(
IDHopDongChiTiet int not null auto_increment,
IDHopDong int not null,
IDDichVuDiKem int not null,
SoLuong int not null,
constraint HopDongChiTiet_pk primary key (IDHopDongChiTiet),
foreign key (IDHopDong) references HopDong(IDHopDong),
foreign key (IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem)
);
insert into ViTri (TenViTri) values ('Le tan');
insert into ViTri (TenViTri) values ('Phuc vu');
insert into ViTri (TenViTri) values ('Chuyen vien');
insert into ViTri (TenViTri) values ('Giam sat');
insert into ViTri (TenViTri) values ('Quan ly');
insert into ViTri (TenViTri) values ('Giam doc');
insert into TrinhDo (TrinhDo) values ('Trung cap');
insert into TrinhDo (TrinhDo) values ('Cao dang');
insert into TrinhDo (TrinhDo) values ('Dai hoc');
insert into TrinhDo (TrinhDo) values ('Sau dai hoc');
insert into BoPhan (TenBoPhan) values ('Sale-Marketing');
insert into BoPhan (TenBoPhan) values ('Hanh chinh');
insert into BoPhan (TenBoPhan) values ('Phuc vu');
insert into BoPhan (TenBoPhan) values ('Quan ly');
insert into DichVuDiKem(TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung) values ('Massage', 2000000, 'Luot', 'Co');
insert into DichVuDiKem(TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung) values ('Karaoke', 500000, 'Gio', 'Co');
insert into DichVuDiKem(TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung) values ('Thuc an', 300000, 'Khach', 'Co');
insert into DichVuDiKem(TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung) values ('Nuoc uong', 200000, 'Khach', 'Co');
insert into DichVuDiKem(TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung) values ('Xe tham quan', 1000000, 'Luot', 'Co');
insert into LoaiKhach(TenLoaiKhach) values ('Diamond');
insert into LoaiKhach(TenLoaiKhach) values ('Platinum');
insert into LoaiKhach(TenLoaiKhach) values ('Gold');
insert into LoaiKhach(TenLoaiKhach) values ('Silver');
insert into LoaiKhach(TenLoaiKhach) values ('Member');
insert into KieuThue(TenKieuThue) values ('Nam');
insert into KieuThue(TenKieuThue) values ('Thang');
insert into KieuThue(TenKieuThue) values ('Ngay');
insert into KieuThue(TenKieuThue) values ('Gio');
insert into LoaiDichVu(TenLoaiDichVu) values('Villa');
insert into LoaiDichVu(TenLoaiDichVu) values('House');
insert into LoaiDichVu(TenLoaiDichVu) values('Room');
insert into KhachHang values 
(1, 2, 'Nguyen Van An', '1991-11-22', '111222333', '0931552555', 'nguyenan1991@gmail.com', 'Da Nang'),
(2, 1, 'Pham Van Cuong', '1999-12-22', '123255999', '0934333555', 'phamcuong1999@gmail.com', 'Hue'),
(3, 3, 'Nguyen Hoang Yen', '1994-05-22', '111312444', '0375111555', 'nguyenyen1994@gmail.com', 'Quang Nam'),
(4, 2, 'Nguyen Thuy Van', '1995-01-26', '111123656', '0364666999', 'nguyenvan1995@gmail.com', 'Da Nang'),
(5, 4, 'Hoang Van Binh', '1994-04-24', '123000333', '0934696969', 'hoangbinh1994@gmail.com', 'Da Nang'),
(6, 5, 'Trinh Thanh Giang', '1992-01-12', '100055523', '0934255255', 'trinhgiang1992@gmail.com', 'Hue');
insert into KhachHang values 
(7, 2, 'Nguyen Hoang Nam', '1943-10-22', '111635333', '0931552123', 'nguyennam1943@gmail.com', 'Da Nang'),
(8, 4, 'Pham Quoc Khanh', '2009-12-22', '123125999', '0985252252', 'phamkhanh2009@gmail.com', 'Quang Tri'),
(9, 3, 'Nguyen Bich Thuy', '1984-06-12', '111000444', '0948248248', 'nguyenthuy1984@gmail.com', 'Quang Tri');
insert into NhanVien values
(1, 'Hoang Nguyen Thu Thuyen', 1, 1, 2, '2004-12-31', '1972525252', 5000000, '0375223252','ThuHuyen@furama.com', 'Quang Binh'),
(2, 'Hoang Van Kien', 6, 4, 4, '1973-01-30', '1114222333', 60000000, '0374555333', 'vankien@furama.vn','Da Nang'),
(3, 'Pham Thi Thanh', 2, 1, 1, '1994-01-12', '1852222333', 4000000, '0321112252', 'thithanh@furama.vn','Da Nang'),
(4, 'Tran Van An', 3, 2, 2, '1984-12-15', '1456111333', 8000000, '0395755212', 'vanan@furama.vn','Hue'),
(5, 'Khuat Thu Giang', 2, 1, 2, '1993-02-25', '1452000333', 12000000, '0395123455', 'thugiang@furama.vn','Binh Dinh'),
(6, 'Nguyen Van Nam', 5, 2, 4, '2001-04-30', '1992111333', 25000000, '0394555252', 'vannam@furama.vn','Hue'),
(7, 'Duong Thi Thu', 4, 4, 3, '1999-12-31', '1972145444', 10000000, '0381693222', 'thithu@furama.vn','Quang Nam');
insert into DichVu values
(1, 'Codegym Villa', 234, 3, 12, 25000000, 3, 1, 'Kha dung'),
(2, 'Fusion Villa', 234, 1, 6, 14000000, 1, 1, 'Kha dung'),
(3, 'Open Villa', 234, 2, 7, 25000000, 2, 1, 'Khong kha dung'),
(4, 'Funny House', 100, 2, 4, 15000000, 3, 2, 'Kha dung'),
(5, 'Nightmare House', 110, 1, 3, 8000000, 2, 2, 'Kha dung'),
(6, 'Rose House', 100, 2, 4, 400000, 3, 2, 'Kha dung'),
(7, 'Happy Room', 78, 1, 3, 200000, 4, 2, 'Kha dung'),
(8, 'Crazy Room', 50, 1, 2, 1000000, 3, 2, 'Kha dung');
update DichVu set IDLoaiDichVu = 3 where IDDichVu >= 7;
update DichVu set DienTich = 150 where IDDichVu in (2,3);
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('1', '1', '2', '2', '2020-12-06', '2020-12-05', '1000000');
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('2', '2', '4', '1', '2021-01-12', '2021-01-16', '500000');
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('3', '5', '3', '4', '2021-01-01', '2021-01-13', '1500000');
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('4', '4', '6', '3', '2020-12-10', '2020-12-30', '2000000');
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('5', '5', '3', '4', '2019-01-01', '2019-03-31', '1000000');
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('6', '5', '6', '3', '2019-01-10', '2019-01-30', '3000000');
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('7', '2', '1', '8', '2018-05-25', '2018-06-11', '2300000');
INSERT INTO `furama_resort`.`hopdong` (`IDHopDong`, `IDNhanVien`, `IDKhachHang`, `IDDichVu`, `NgayLamHopDong`, `NgayKetThuc`, `TienDatCoc`) 
VALUES ('8', '2', '2', '1', '2018-12-11', '2018-12-15', '1200000');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('1', '1', '2', '3');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('2', '2', '1', '2');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('3', '3', '4', '1');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('4', '4', '5', '4');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('5', '4', '2', '2');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('6', '1', '3', '3');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('7', '2', '3', '3');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('8', '5', '2', '1');
INSERT INTO `furama_resort`.`hopdongchitiet` (`IDHopDongChiTiet`, `IDHopDong`, `IDDichVuDiKem`, `SoLuong`) VALUES ('9', '6', '1', '1');


-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự --  
select *, substring_index(HoTen, ' ', -1) as TenNV from Nhanvien 
having (TenNV like 'h%' or TenNV like 't%' or TenNV like 'k%') and length(HoTen) <= 15;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.--  
select *, year(curdate()) - year(NgaySinh) as Tuoi from KhachHang
having (DiaChi = 'Da Nang' or DiaChi = 'Quang Tri') and Tuoi > 18;

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị 
-- được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”. --
select KhachHang.IDKhachHang, KhachHang.HoTen, count(HopDong.IDKhachHang) as SoLanDatPhong 
from KhachHang left join hopdong on KhachHang.IDKhachHang = HopDong.IDKhachHang where KhachHang.IDLoaiKhach = 1 
group by KhachHang.IDKhachHang order by SoLanDatPhong;

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select KhachHang.IDKhachHang, KhachHang.HoTen, LoaiKhach.TenLoaiKhach, HopDong.IDHopDong, DichVu.TenDichVu, HopDong.NgayLamHopDong, 
HopDong.NgayKetThuc, sum(DichVu.ChiPhiThue + DichVuDiKem.Gia*HopDongChiTiet.SoLuong) as TongTien 
from KhachHang left join HopDong on KhachHang.IDKhachHang = HopDong.IDKhachHang
left join LoaiKhach on KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
left join DichVu on DichVu.IDDichVu = HopDong.IDDichVU
left join  HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by HopDong.IDHopDong, KhachHang.HoTen;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select DichVu.IDDichVu, DichVu.TenDichVu, DichVu.DienTich, DichVu.ChiPhiThue, LoaiDichVu.TenLoaiDichVu, HopDongQuyMot.NgayLamHopDong
from DichVu left join ( select * from HopDong where NgayLamHopDong between '2019-01-01' and '2019-03-31') as HopDongQuyMot 
on DichVu.IDDichVu = HopDongQuyMot.IDDichVu 
left join LoaiDichVu on DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
group by DichVu.IDDichVu
having HopDongQuyMot.NgayLamHopDong is null;
-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select DichVu.IDDichVu, DichVu.TenDichVu, DichVu.DienTich, Dichvu.SoNguoiToiDa, DichVu.ChiPhiThue, LoaiDichVu.TenLoaiDichVu
from DichVu inner join (select * from HopDong where year(NgayLamHopDong) = 2018) as HopDong2018 on DichVu.IDDichVu = HopDong2018.IDDichVu
left join (select * from HopDong where year(NgayLamHopDong) = 2019) as HopDong2019 on DichVu.IDDichVu = HopDong2019.IDDichVu
left join LoaiDichVu on LoaiDichVu.IDLoaiDichVu = DichVu.IDLoaiDichVu
where HopDong2019.IDDichVu is null
group by DichVu.IDDichVu;
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
select distinct HoTen from KhachHang;
select HoTen from KhachHang group by HoTen;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(HopDong2019.NgayLamHopDong) as Thang, Sum(DichVu.ChiPhiThue + DichVuDiKem.Gia*HopDongChiTiet.SoLuong) as DoanhThu
from (select * from HopDong where year(HopDong.NgayLamHopDong) = 2019) as HopDong2019
left join DichVu on DichVu.IDDichVu = HopDong2019.IDDichVU 
left join  HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong2019.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by Thang;  

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm 
-- IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select HopDong.IDHopDong, HopDong.NgayLamHopDong, HopDong.NgayKetthuc, HopDong.TienDatCoc, count(HopDongChiTiet.IDDichVuDiKem) as SoLuongDichVu
from HopDong left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select LoaiDichVu.IDLoaiDichVu, LoaiDichVu.TenLoaiDichVu from HopDong 
left join DichVu on HopDong.IDDichVu = Dichvu.IDDichVu
left join LoaiDichVu on LoaiDichVu.IDLoaiDichVu = DichVu.IDLoaiDichVu
left join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join  LoaiKhach on LoaiKhach.IDLoaiKhach = KhachHang.IDLoaiKhach
where LoaiKhach.IDLoaiKhach = 1 and KhachHang.DiaChi in ('Quang Ngai', 'Vinh')
group by LoaiDichVu.IDLoaiDichVu;

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
-- SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ 
-- đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select HopDong10122019.IDHopDong, NhanVien.HoTen as HoTenNhanVien, KhachHang.HoTen as HoTenKhachHang, KhachHang.SDT, DichVu.TenDichVu, 
count(DichVuDiKem.IDDichVuDiKem) as SL_DichVuDiKem, HopDong10122019.TienDatCoc from
(select * from HopDong where NgayLamHopDong between '2019-10-01' and '2019-12-31') as HopDong10122019
left join (select * from HopDong where NgayLamHopDong between '2019-01-01' and '2019-06-30') as HopDong01062019
on HopDong10122019.IDDichVu = HopDong01062019.IDDichVu
left join NhanVien on NhanVien.IDNhanVien = HopDong10122019.IDNhanVien
left join KhachHang on KhachHang.IDKhachHang = HopDong10122019.IDKhachHang
left join DichVu on HopDong10122019.IDDichVu = DichVu.IDDichVu
left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong10122019.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
where HopDong01062019.IDDichVu is null
group by HopDong10122019.IDHopDong;
