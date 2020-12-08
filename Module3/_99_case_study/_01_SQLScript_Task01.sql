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

-- Chỉ nhập các bảng rìa ERD bằng lệnh, các bảng khác nhập bằng tool

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