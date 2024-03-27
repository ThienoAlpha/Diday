package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.DBConnect;
import model.DanhMuc;
import model.SanPham;

public class SanPhamDaoImpl implements SanPhamDAO {

	@Override
	public ArrayList<SanPham> getListProductByCategory(String ma_danh_muc) {
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM `shop_con_ti_hiu`.product where ma_danh_muc = '"+ ma_danh_muc +"'";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getString("ma_san_pham"));
				DanhMuc dm = new DanhMuc(rs.getString("ma_danh_muc"), "", "");
				sp.setDanh_muc(dm);
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				arr.add(sp);
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
	public SanPham getChiTietSanPham(String ma_san_pham) {
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM `shop_con_ti_hiu`.product where ma_san_pham ='"+ma_san_pham+"'";
		SanPham sp = new SanPham();
		
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sp.setMa_san_pham(rs.getString("ma_san_pham"));
				DanhMuc dm = new DanhMuc(rs.getString("ma_danh_muc"), "", "");
				sp.setDanh_muc(dm);
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setAudio(rs.getString("audio"));
				
			}
			cons.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}

	@Override
	public int setSanPham(SanPham sanPham) {
		Connection cons = DBConnect.getConnection();
		String sql = "INSERT INTO `shop_con_ti_hiu`.`product`" + " (ma_san_pham,ma_danh_muc,ten_san_pham,hinh_anh,so_luong,mo_ta,don_gia) VALUES " +"(?,?,?,?,?,?,?);";
		int Result =0;
		
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, sanPham.getMa_san_pham());
			ps.setString(2, sanPham.getMa_danh_muc());
			ps.setString(3, sanPham.getTen_san_pham());
			ps.setString(4, sanPham.getHinh_anh());
			ps.setInt(5, sanPham.getSo_luong());
			ps.setString(6, sanPham.getMo_ta());
			ps.setDouble(7, sanPham.getDon_gia());
			
			Result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				cons.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return Result;
		
	}

	@Override
	public ArrayList<SanPham> getListProductByCateGoryForShop() {
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM `shop_con_ti_hiu`.product order by don_gia desc limit 12";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getString("ma_san_pham"));
				DanhMuc dm = new DanhMuc(rs.getString("ma_danh_muc"), "", "");
				sp.setDanh_muc(dm);
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setMa_danh_muc(rs.getString("ma_danh_muc"));
				arr.add(sp);
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
	public ArrayList<SanPham> getSoLuongSanPham() {
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM `shop_con_ti_hiu`.product";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham();
				arr.add(sp);
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
	public ArrayList<SanPham> getListProduct() {
		Connection cons = DBConnect.getConnection();
		String sql = "SELECT * FROM `shop_con_ti_hiu`.product ";
		ArrayList<SanPham> arr = new ArrayList<>();
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getString("ma_san_pham"));
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				arr.add(sp);
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
	public double nhan2so(double a, Integer b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int updateSanPham(String msp ,String ten_san_pham, String hinh_anh, double don_gia, String mo_ta, int so_luong) {
		Connection cons = DBConnect.getConnection();
		String sql = "UPDATE `shop_con_ti_hiu`.`product` SET `ten_san_pham` = '"+ten_san_pham+"', `hinh_anh` = '"+hinh_anh+"', `don_gia` = '"+don_gia+"', `mo_ta` = '"+mo_ta+"', `so_luong` = '"+so_luong+"' WHERE (`ma_san_pham` = '"+msp +"')";
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
	public int deleteSanPham(String msp) {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "DELETE FROM `shop_con_ti_hiu`.`product` WHERE (`ma_san_pham` = '"+msp+"');";
		int Result = 0;
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			Result = ps.executeUpdate();
			ps.close();
			cons.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result;
	}

}
