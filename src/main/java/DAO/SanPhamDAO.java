package DAO;

import java.util.ArrayList;

import model.SanPham;

public interface SanPhamDAO {
	ArrayList<SanPham> getListProductByCategory(String ma_danh_muc);
	
	//Hien thi thong tin chi tiet san pham
	SanPham getChiTietSanPham(String ma_san_pham);
	
	//Them san pham
	int setSanPham(SanPham sanPham);
	
	//Hiển thị list sản phẩm của shop
	ArrayList<SanPham> getListProductByCateGoryForShop();
	
	//Get số lượng sản phẩm trong kho
	ArrayList<SanPham> getSoLuongSanPham();
	
	ArrayList<SanPham> getListProduct();
	
	double nhan2so(double a, Integer b);
	
	int updateSanPham(String msp ,String ten_san_pham, String hinh_anh, double don_gia, String mo_ta, int so_luong);
	
	int deleteSanPham(String msp);
}
