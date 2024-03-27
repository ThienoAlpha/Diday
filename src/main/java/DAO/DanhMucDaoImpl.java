package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import model.DanhMuc;

public class DanhMucDaoImpl implements DanhMucDAO{
	
	
	public ArrayList<DanhMuc> getListDanhMucCha(){
		Connection connection = DBConnect.getConnection();
		String sql ="SELECT * FROM `shop_con_ti_hiu`.danhmuc Where danh_muc_cha ='null'";
		ArrayList<DanhMuc> arr = new ArrayList<>();
		try {
			PreparedStatement ps =connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DanhMuc dm = new DanhMuc();
				dm.setMa_danh_muc(rs.getString("ma_danh_muc"));
				dm.setTen_danh_muc(rs.getString("ten_danh_muc"));
				dm.setDanh_muc_cha(rs.getString("danh_muc_cha"));
				arr.add(dm);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<DanhMuc> getListDanhMucCon(String ma_danh_muc) {
		Connection connection = DBConnect.getConnection();
		String sql ="SELECT * FROM `shop_con_ti_hiu`.danhmuc Where danh_muc_cha ='"+ma_danh_muc+"'";
		ArrayList<DanhMuc> arr = new ArrayList<>();
		try {
			PreparedStatement ps =connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DanhMuc dm = new DanhMuc();
				dm.setMa_danh_muc(rs.getString("ma_danh_muc"));
				dm.setTen_danh_muc(rs.getString("ten_danh_muc"));
				dm.setDanh_muc_cha(rs.getString("danh_muc_cha"));
				arr.add(dm);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return arr; 
	}

	@Override
	public DanhMuc getDanhMucCha(String ten_danh_muc) {
		Connection connection = DBConnect.getConnection();
		DanhMuc dm = new DanhMuc();
		String sql = "SELECT ma_danh_muc FROM `shop_con_ti_hiu`.danhmuc where ten_danh_muc = '"+ten_danh_muc+"'";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				dm.setMa_danh_muc(rs.getString("ma_danh_muc"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dm;
	}

	@Override
	public DanhMuc getDanhMucCon(String ten_danh_muc) {
		Connection connection = DBConnect.getConnection();
		DanhMuc dm = new DanhMuc();
		String sql = "SELECT ma_danh_muc FROM `shop_con_ti_hiu`.danhmuc where ten_danh_muc = '"+ten_danh_muc+"'";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				dm.setMa_danh_muc(rs.getString("ma_danh_muc"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dm;
	}
	
	
	
	



}
