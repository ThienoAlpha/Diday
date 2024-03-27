package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.DBConnect;
import model.LienLac;

public class LienLacDAOImpl implements LienLacDAO {

	@Override
	public int setLienLac(LienLac lc) {
		Connection cons = DBConnect.getConnection();
		int Result=0;
		String url = "INSERT INTO `e-shop`.`danh_sach_don_dat_hang`" + " (ten_tai_khoan,ho_va_ten,dia_chi,so_dien_thoai,ghi_chu) VALUES " +"(?,?,?,?,?);";
		try {
			PreparedStatement ps = cons.prepareStatement(url);
			ps.setString(1, lc.getTen_tai_khoan());
			ps.setString(2, lc.getHo_ten());
			ps.setString(3, lc.getDia_chi());
			ps.setString(4, lc.getSo_dien_thoai());
			ps.setString(5, lc.getGhi_chu());
			Result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result;
	}

}
