package test;

import DAO.DanhMucDaoImpl;
import DAO.SanPhamDaoImpl;
import DAO.TaiKhoanDAOImpl;

public class Main {
	public static void main(String[] args) {
		DanhMucDaoImpl dm = new DanhMucDaoImpl();
		SanPhamDaoImpl sp = new SanPhamDaoImpl();
		TaiKhoanDAOImpl tk = new TaiKhoanDAOImpl();
		System.out.print(tk.kiemTraTaiKhoan("thieno.pic@gmail.com"));
	}
}
