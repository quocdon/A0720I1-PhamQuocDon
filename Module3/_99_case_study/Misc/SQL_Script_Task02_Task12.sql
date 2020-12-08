use furama_resort;
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