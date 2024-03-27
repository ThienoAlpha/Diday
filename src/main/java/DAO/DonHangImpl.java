package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import connect.DBConnect;
import model.DonHang;

public class DonHangImpl implements DonHangDAO {

	@Override
	public int themDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "INSERT INTO `shop_con_ti_hiu`.`danh_sach_don_dat_hang` (`ma_don_hang`, `ma_san_pham`, `ma_tai_khoan`, `dia_chi_giao_hang`, `so_luong`, `don_gia`, `don_vi_van_chuyen`,`thoi_gian_tao`,`trang_thai`,`so_dien_thoai`,`ho_ten_nguoi_nhan`,`phuong_thuc_thanh_toan`) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?);";
		int Result=0;
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, donHang.getMa_don_hang());
			ps.setString(2, donHang.getMa_san_pham());
			ps.setString(3, donHang.getMa_tai_khoan());
			ps.setString(4, donHang.getDia_chi_giao_hang());
			ps.setInt(5, donHang.getSo_luong());
			ps.setDouble(6, donHang.getDon_gia());
			ps.setString(7, donHang.getDon_vi_van_chuyen());
			ps.setString(8,  donHang.getThoi_gian_tao());
			ps.setBoolean(9, donHang.isTrang_thai());
			ps.setString(10, donHang.getSo_dien_thoai());
			ps.setString(11, donHang.getHo_ten_nguoi_nhan());
			ps.setString(12, donHang.getPhuong_thuc_thanh_toan());
			 
			//Thực thi sql
			Result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Result;
	}
	
}
