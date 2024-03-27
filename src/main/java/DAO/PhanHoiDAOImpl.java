package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.DBConnect;
import model.PhanHoi;

public class PhanHoiDAOImpl implements PhanHoiDAO{

	@Override
	public int setPhanHoi(PhanHoi ph) {
		Connection conn = DBConnect.getConnection(); 
		String url = "INSERT INTO `e-shop`.`phan_hoi`"+" (ten_tai_khoan, ho_ten_phan_hoi, so_dien_thoai, loi_nhan,tieu_de) VALUES"+" (?, ?, ?, ?,?)"; 
		int Result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(url);
			ps.setString(1,ph.getTen_tai_khoan());
			ps.setString(2, ph.getHo_ten_phan_hoi());
			ps.setString(3, ph.getSo_dien_thoai());
			ps.setString(4, ph.getLoi_nhan());
			ps.setString(5, ph.getTieu_de());
			
			Result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result;
	}
	
}
