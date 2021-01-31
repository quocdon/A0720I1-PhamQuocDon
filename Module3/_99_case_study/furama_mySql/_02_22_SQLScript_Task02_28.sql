use furama;
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
select HoTen from KhachHang
union
select hoten from khachhang;


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

-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó 
-- với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
DELIMITER //
create procedure sp_1(id_kh int)
begin
	delete khachhang
    from khachhang
    where khachhang.IDKhachHang = id_kh;
    end//
DELIMITER ;

call sp_1(11);

-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với 
-- yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

DELIMITER //
create procedure sp_2
(
	IDHopDong_param int,
	IDNhanVien_param int,
	IDKhachHang_param int,
	IDDichVu_param int,
	NgayLamHopDong_param date,
	NgayKetThuc_param date,
	TienDatCoc_param int
)
begin
	-- Khai báo biến kiểm tra khóa chính và khóa ngoại
	declare kt_IDHopDong int;
	declare kt_IDNhanVien int;
	declare kt_IDKhachHang int;
	declare kt_IDDichVu int;
    
    -- Gán giá trị cho biến kiểm tra bằng việc truy vấn tham số truyền vào tương ứng với các bảng trong CSDL
    select IDHopDong into kt_IDHopDong from hopdong where IDHopDong = IDHopDong_param;
    select IDNhanVien into kt_IDNhanVien from nhanvien where IDNhanVien = IDNhanVien_param;
    select IDKhachHang into kt_IDKhachHang from khachhang where IDKhachHang = IDKhachHang_param;
    select IDDichVu into kt_IDDichVu from dichvu where IDDichVu = IDDichVu_param;
    
    -- Kiểm tra tính hợp lệ của tham số truyền vào. 
    -- Tham số truyền vào hợp lệ khi kt_idHopDong = null và các kt_idnhanvien, kt_idkhachhang và kt_iddichvu phải khác null
    if (kt_idHopDong is null and IDHopDong_param > 0 and kt_idnhanvien is not null and kt_idkhachhang is not null and kt_iddichvu is not null) then
		-- Thêm dữ liệu vào bảng hợp đồng
		insert into hopdong(IDHopDong,IDNhanVien,IDKhachHang,IDDichVu,NgayLamHopDong,NgayKetThuc,TienDatCoc) values
        (IDHopDong_param, IDNhanVien_param, IDKhachHang_param, IDDichVu_param, NgayLamHopDong_param, NgayKetThuc_param, TienDatCoc_param);
        elseif kt_idhopdong is not null or IDHopDong_param < 0 then
        -- Tham số không hợp lệ thì thông báo lỗi cho người dùng
			signal sqlstate '23000' 
			set message_text = 'IDHopDong khong hop le',
			mysql_errno = 1264;
		elseif kt_idnhanvien is null then
			signal sqlstate '23000' 
				set message_text = 'IDNhanVien khong ton tai',
                mysql_errno = 1264;
		elseif kt_idkhachhang is null then
			signal sqlstate '23000' 
			set message_text = 'IDKhachHang khong ton tai',
			mysql_errno = 1264;
		elseif kt_iddichvu is null then
			signal sqlstate '23000' 
			set message_text = 'IDDichVu khong ton tai',
			mysql_errno = 1264;
		end if;
end//
DELIMITER ;

call sp_2(12,5,3,1,'2019-10-10','2019-10-15',3000000);

-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị 
-- tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database

create table SL_HopDong(
SLHopDong int default 0
);
drop trigger if exists tr_1 ;
DELIMITER //
create trigger tr_1
after delete on hopdong
for each row
begin
	declare SLHopDong int;
	declare mes varchar(100);
    select count(*) into SLHopDong from hopdong;
    insert into SL_HopDong value (SLHopDong);
end//
delete FROM HOPDONG WHERE IDhopDONG=8;

-- 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật 
-- có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng
--  phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database
drop trigger if exists tr_2 ;
DELIMITER //
create trigger tr_2
before update on hopdong
for each row
begin
if new.ngayketthuc - new.ngaylamhopdong < 2 then
	signal sqlstate '23000'
    set message_text = 'Ngay ket huc hop dong phai lon hon ngay lam hop dong it nhat 2 ngay',
    mysql_errno = 1264;
end if;
end//

-- 27.	Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
DELIMITER //
create function func_1()
returns int
READS SQL DATA
DETERMINISTIC
begin
declare SLDichVu int;
select count(*) into SLDichVu from 
(select DichVu.IDDichVu from hopdong
left join dichvu on hopdong.IdDIchVu = dichvu.IDDichVu
left join  HopDongChiTiet on HopDongChiTiet.IDHopDong = HopDong.IDHopDong
left join DichVuDiKem on HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
group by hopdong.idhopdong
having sum(DichVu.ChiPhiThue + ifnull(DichVuDiKem.Gia, 0) * ifnull(HopDongChiTiet.SoLuong, 0)) > 2000000) as HopDong2Mil;
return SLDichVu;
end//

select func_1()

-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến 
-- lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm.
DELIMITER //
create function func_2()
returns int
READS SQL DATA
DETERMINISTIC
begin
declare thoigianthuedainhat int;

select max(thoigianthue) into thoigianthuedainhat 
from 
(select *, timestampdiff(day,hopdong.ngaylamhopdong,hopdong.ngayketthuc) as thoigianthue from hopdong) as HopDongCoThoiGianThue;

return(thoigianthuedainhat);
end//

select func_2()

-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
-- từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong 
-- bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) 
-- và những bản liên quan khác.

-- Sửa khóa ngoại bảng hợp đồng
alter table hopdong
drop foreign key hopdong_ibfk_3,
add foreign key (IDDichVu) references DichVu(IDDichVu) on update cascade on delete cascade;

drop procedure if exists sp_3;

DELIMITER //
create procedure sp_3()
begin
	delete dichvu
    from dichvu 
    inner join (select distinct hopdong.IDDichVu, hopdong.ngaylamhopdong from hopdong where year(NgayLamHopDong) between 2015 and 2019) as DichVu20152019 
    on dichvu20152019.IDDichVu = dichvu.IDDichVu
    where dichvu.IDLoaiDichVu = 3;
end//

DELIMITER ;
call sp_3();