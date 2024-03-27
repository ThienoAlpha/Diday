package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.DBConnect;
import model.DanhMuc;
import model.SanPham;
import model.TTCN;
import model.TaiKhoan;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {

	@Override
	public boolean kiemTraTaiKhoan(String ten_tai_khoan) {
		Connection cons = DBConnect.getConnection();
		String sql ="SELECT ten_tai_khoan FROM `shop_con_ti_hiu`.`user` where ten_tai_khoan='"+ten_tai_khoan+"'";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
			cons.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void themTaiKhoan(TaiKhoan tk) {
		Connection cons = DBConnect.getConnection();
		String sql = "INSERT INTO `shop_con_ti_hiu`.`user` value(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, tk.getMa_tai_khoan());
			ps.setString(2, tk.getTen_tai_khoan());
			ps.setString(3, tk.getMat_khau());
			ps.setInt(4, tk.getQuyen_truy_cap());
			ps.setBoolean(5, tk.getTinh_trang());
			ps.setString(6, tk.getTen_nguoi_dang_nhap());
			ps.execute();
			cons.close();
			ps.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public boolean kiemTraDangNhap(String ten_tai_khoan, String mat_khau) {
		Connection cons = DBConnect.getConnection();
		String sql = "select * from `shop_con_ti_hiu`.`user` where ten_tai_khoan = '"+ ten_tai_khoan +"' and mat_khau ='"+mat_khau+"'";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object getTaiKhoan(String ten_tai_khoan, String mat_khau) {
		Connection cons = DBConnect.getConnection();
		String sql = "select * from `shop_con_ti_hiu`.`user` where ten_tai_khoan = '"+ ten_tai_khoan +"' and mat_khau ='"+mat_khau+"'";
		TaiKhoan tk = new TaiKhoan();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
				tk.setMa_tai_khoan(rs.getString("ma_tai_khoan"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}

	@Override
	public void taoTTCN(TTCN ttcn) {
		Connection cons = DBConnect.getConnection();
		String sql = "INSERT INTO `shop_con_ti_hiu`.`user_info` value(?,?,?,?,?)";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, ttcn.getId());
			ps.setString(2, ttcn.getHoten());
			ps.setString(3, ttcn.getDiachi());
			ps.setString(4, ttcn.getSdt());
			ps.setString(5, ttcn.getHinh_anh());
			ps.execute();
			cons.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTTCN(String mtk) {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM shop_con_ti_hiu.user_info where iduser = '"+ mtk +"'";
		TTCN ttcn = new TTCN();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ttcn.setId(rs.getString("iduser"));
				ttcn.setHoten(rs.getString("hoten"));
				ttcn.setHinh_anh("images/home/"+rs.getString("hinh_anh"));
				ttcn.setDiachi(rs.getString("diachi"));
				ttcn.setSdt(rs.getString("sdt"));
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ttcn;
	}

	@Override
	public int updateTTCN(String mtk, String ho_ten, String dia_chi, String sdt, String hinh_anh) {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "UPDATE `shop_con_ti_hiu`.`user_info` SET `hoten` = '"+ho_ten+"', `diachi` = '"+dia_chi+"', `sdt` = '"+sdt+"', `hinh_anh` = '"+hinh_anh+"' WHERE (`iduser` = '"+mtk+"');";
		int Result = 0;
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			Result = ps.executeUpdate();
			cons.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}	
		return Result;
	}

	@Override
	public ArrayList<TaiKhoan> getListUser() {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM `shop_con_ti_hiu`.user order by quyen_truy_cap desc limit 12";
		ArrayList<TaiKhoan> arr = new ArrayList<>();
			try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TaiKhoan tk = new TaiKhoan();
				tk.setMa_tai_khoan(rs.getString("ma_tai_khoan"));
				tk.setTen_tai_khoan(rs.getString("ten_tai_khoan"));
				tk.setMat_khau(rs.getString("mat_khau"));
				tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
				tk.setTinh_trang(rs.getBoolean("tinh_trang"));
				tk.setTen_nguoi_dang_nhap(rs.getNString("ten_nguoi_dang_nhap"));
				arr.add(tk);
			}
			cons.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public TaiKhoan getTaiKhoanByMtk(String mtk) {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM `shop_con_ti_hiu`.user where ma_tai_khoan ='"+mtk+"'";
		TaiKhoan tk = new TaiKhoan();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk.setTen_tai_khoan(rs.getString("ten_tai_khoan"));
				tk.setMat_khau(rs.getString("mat_khau"));
				tk.setQuyen_truy_cap(rs.getInt("quyen_truy_cap"));
				tk.setTinh_trang(rs.getBoolean("tinh_trang"));
				tk.setTen_nguoi_dang_nhap(rs.getString("ten_nguoi_dang_nhap"));
			}
			cons.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tk;
	}

	
	
	
}
