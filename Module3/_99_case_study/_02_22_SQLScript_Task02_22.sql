use furama_resort;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự --  

select * from Nhanvien
where (substring_index(HoTen, ' ', -1) like 'h%' or substring_index(HoTen, ' ', -1) like 't%' or substring_index(HoTen, ' ', -1) like 'k%') 
and length(HoTen) <= 15;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.--  

select *, year(curdate()) - year(NgaySinh) as Tuoi from KhachHang
having (DiaChi = 'Da Nang' or DiaChi = 'Quang Tri') and Tuoi between 18 and 50;

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
HopDong.NgayKetThuc, sum(DichVu.ChiPhiThue + ifnull(DichVuDiKem.Gia, 0) * ifnull(HopDongChiTiet.SoLuong, 0)) as TongTien 
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

select month(HopDong2019.NgayLamHopDong) as Thang, 
Sum(DichVu.ChiPhiThue + ifnull(DichVuDiKem.Gia, 0)*ifnull(HopDongChiTiet.SoLuong, 0)) as DoanhThu, 
count(HopDong2019.IDKhachHang) as SLKhachHang
from (select * from HopDong where year(HopDong.NgayLamHopDong) = 2019) as HopDong2019
left join DichVu on DichVu.IDDichVu = HopDong2019.IDDichVU 
left join  HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong2019.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by Thang order by Thang;  

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm 
-- IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select HopDong.IDHopDong, HopDong.NgayLamHopDong, HopDong.NgayKetthuc, HopDong.TienDatCoc, count(HopDongChiTiet.IDDichVuDiKem) as SoLuongDichVu
from HopDong left join HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by HopDong.IDHopDong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select DichVuDiKem.IDDichVuDiKem, DichVuDiKem.TenDichVuDiKem from HopDong 
inner join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
inner join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
left join KhachHang on HopDong.IDKhachHang = KhachHang.IDKhachHang
left join  LoaiKhach on LoaiKhach.IDLoaiKhach = KhachHang.IDLoaiKhach
where LoaiKhach.IDLoaiKhach = 1 and KhachHang.DiaChi in ('Quang Ngai', 'Vinh')
group by DichVuDiKem.IDDichVuDiKem order by DichVuDiKem.IDDichVuDiKem;

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

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select DichVuDiKem.IDDichVuDiKem, DichVuDiKem.TenDichVuDiKem, count(DichVuDiKem.IDDichVuDiKem) as SoLanSuDung
from HopDong inner join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
left join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by DichVuDiKem.IDDichVuDiKem
having SoLanSuDung = (select max(SoLanSuDung) from (select DichVuDiKem.IDDichVuDiKem, DichVuDiKem.TenDichVuDiKem, count(DichVuDiKem.IDDichVuDiKem) as SoLanSuDung
from HopDong inner join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
left join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by DichVuDiKem.IDDichVuDiKem) as TongHopDichVu) order by IDDichVuDiKem;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select HopDong.IDHopDong, DichVuDiKem.IDDichVuDiKem, DichVuDiKem.TenDichVuDiKem, count(HopDong.IDHopDong) as SoLanSuDung
from HopDong inner join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
inner join DichVuDiKem on DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
group by DichVuDiKem.IDDichVuDiKem
having SoLanSuDung = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019

select NhanVien.IDNhanVien, NhanVien.HoTen, TrinhDo.TrinhDo, BoPhan.TenBoPhan, NhanVien.SDT, NhanVien.DiaChi from
nhanvien left join (select IDNhanVien from HopDong where year(NgayLamHopDong) between 2018 and 2019) as HopDong20182019 
on NhanVien.IDNhanVien = HopDong20182019.IDNhanVien
left join TrinhDo on NhanVien.IDTrinhDo = TrinhDo.IDTrinhDo
left join BoPhan on NhanVien.IDBoPhan = BoPhan.IDBoPhan
group by NhanVien.IDNhanVien
having count(HopDong20182019.IDNhanVien) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

-- Tạo lại khóa ngoại có actions 'on update cascade' và 'on delete cascade'
-- Trường hợp các nhân viên bị xóa có lập hợp đồng không ngoài gian đoạn 2017 và 2019 thì các hợp đồng này sẽ xóa luôn
-- nếu đã set on update/delete trong lúc tạo bảng thì không cần chạy lệnh này.
alter table hopdongchitiet
drop foreign key hopdongchitiet_ibfk_1,
add foreign key (IDHopDong) references HopDong(IDHopDong) on update cascade on delete cascade;

alter table hopdong
drop foreign key hopdong_ibfk_1,
add foreign key (IDNhanVien) references NhanVien(IDNhanVien) on update cascade on delete cascade;

-- Lệnh xóa nhân viên

delete nhanvien
from nhanvien left join
(select distinct IDNhanVien from hopdongchitiet left join hopdong on hopdongchitiet.idhopdong = hopdong.idhopdong
where year(hopdong.ngaylamhopdong) between 2017 and 2019
group by hopdong.idnhanvien) as hopdong20172019 on nhanvien.IDNhanVien = hopdong20172019.idnhanvien
where nhanvien.IDNhanVien is not null and hopdong20172019.IDNhanVien is null;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ

update khachhang,
loaikhach,
(select HopDong.IDKhachhang, 
sum(Dichvu.ChiPhiThue + ifnull(HopDongChiTiet.SoLuong * DichVuDiKem.Gia, 0)) as TongTien
from HopDong left join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
left join DichVuDiKem on DichVUDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
left join DichVu on DichVu.IDDichVU = HopDong.IDDichVu
where year(HopDong.ngaylamhopdong) = 2019
group by HopDong.IDKhachhang
) as HopDong2019
set khachhang.IDLoaiKhach = 1
where khachhang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
and khachhang.IDkhachhang = HopDong2019.IDKhachHang
and LoaiKhach.IDLoaiKhach = 2
and HopDong2019.TongTien > 10000000;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
-- Tạo lại khóa ngoại có 'on update cascade' và 'on delete cascade'
-- Xóa tất cả các hợp đồng liên quan đến khách hàng bị xóa

alter table hopdong
drop foreign key hopdong_ibfk_2,
add foreign key (IDKhachHang) references KhachHang(IDKhachHang) on update cascade on delete cascade;

delete khachhang
from 
khachhang inner join
(select hopdong.IDHopDong, hopdong.NgayLamHopDong, hopdong.IDKhachHang from hopdong left join
hopdongchitiet on hopdong.idhopdong = hopdongchitiet.idhopdong
where year(hopdong.ngaylamhopdong) < 2016) as hopdongtruoc2016
on khachhang.idkhachhang = hopdongtruoc2016.idkhachhang
where khachhang.IDkhachhang = hopdongtruoc2016.idkhachhang;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

update dichvudikem as dvdk,
(select hopdongchitiet.IDDichVuDiKem, count(hopdongchitiet.IDHopDongChiTiet) as SoLanSuDung 
from HopDong inner join HopDongChiTiet on HopDong.IDHopDong = HopDongChiTiet.IDHopDong
where Year(HopDong.NgaylamHOpDong) = 2019
group by HopDongChiTiet.IDDichVuDiKem) as DichVuDiKem2019
set dvdk.gia = dvdk.gia * 2
where dvdk.IDDichVuDiKem = DichVuDiKem2019.IDdichvuDiKem
and DichVuDiKem2019.SolanSuDung > 10;

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select concat('NV - ',IDNhanVien), hoten, email, sdt, ngaysinh, DiaChi from nhanvien 
union all
select concat('KH - ',IDKhachHang), hoten, email, sdt, ngaysinh, DiaChi from khachhang;

-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view V_NHANVIEN as
select nhanvien.* from nhanvien inner join
(select distinct hopdong.IDNhanVien from hopdong where ngaylamhopdong = '2019-12-12') as hopdong12122019
on nhanvien.idnhanvien = hopdong12122019.idnhanvien
where nhanvien.DiaChi = 'Hai Chau';

-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.

update v_nhanvien
set v_nhanvien.diachi = 'Lien Chieu';
