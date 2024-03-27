package DAO;

import java.util.ArrayList;

import model.SanPham;
import model.TTCN;
import model.TaiKhoan;

public interface TaiKhoanDAO {
	//Kiểm tra tài khoản đã có trong Database hay chưa
	boolean kiemTraTaiKhoan(String ten_tai_khoan);
	
	//Thêm mới một tài khoản
	void themTaiKhoan(TaiKhoan tk);
	
	//Kiểm tra đăng nhập
	boolean kiemTraDangNhap(String ten_tai_khoan,String mat_khau);
	
	//Lấy thông tin tài khoản đăng nhập
	Object getTaiKhoan(String ten_tai_khoan, String mat_khau);
	
	//Tạo thông tin cá nhân cho tài khoản
	void taoTTCN(TTCN ttcn);
	
	//Lấy thông tin cá nhân bằng mtk
	Object getTTCN(String mtk);
	
	//Lấy thông tin tài khoản bằng mtk
	TaiKhoan getTaiKhoanByMtk(String mtk);
	
	//update thông tin cá nhân cho tài khoản
	int updateTTCN(String mtk, String ho_ten, String dia_chi, String sdt, String hinh_anh);
	
	//Chọn toàn bộ tài khoản
	ArrayList<TaiKhoan> getListUser();
}
