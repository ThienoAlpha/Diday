package model;



public class TaiKhoan {
	private String ma_tai_khoan;
	private String ten_tai_khoan;
	private String ten_nguoi_dang_nhap;
	private int quyen_truy_cap;
	private String mat_khau;
	private boolean tinh_trang;
	
	
	public TaiKhoan(String ma_tai_khoan, String ten_tai_khoan, String ten_nguoi_dang_nhap, int quyen_truy_cap,
			String mat_khau, boolean tinh_trang) {
		super();
		this.ma_tai_khoan = ma_tai_khoan;
		this.ten_tai_khoan = ten_tai_khoan;
		this.ten_nguoi_dang_nhap = ten_nguoi_dang_nhap;
		this.quyen_truy_cap = quyen_truy_cap;
		this.mat_khau = mat_khau;
		this.tinh_trang = tinh_trang;
	}

	public TaiKhoan() {
		super();
	}

	public String getMa_tai_khoan() {
		return ma_tai_khoan;
	}
	public void setMa_tai_khoan(String ma_tai_khoan) {
		this.ma_tai_khoan = ma_tai_khoan;
	}
	public String getTen_tai_khoan() {
		return ten_tai_khoan;
	}
	public void setTen_tai_khoan(String ten_tai_khoan) {
		this.ten_tai_khoan = ten_tai_khoan;
	}
	public String getTen_nguoi_dang_nhap() {
		return ten_nguoi_dang_nhap;
	}
	public void setTen_nguoi_dang_nhap(String ten_nguoi_dang_nhap) {
		this.ten_nguoi_dang_nhap = ten_nguoi_dang_nhap;
	}
	public int getQuyen_truy_cap() {
		return quyen_truy_cap;
	}
	public void setQuyen_truy_cap(int quyen_truy_cap) {
		this.quyen_truy_cap = quyen_truy_cap;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}

	public boolean getTinh_trang() {
		return tinh_trang;
	}
	public void setTinh_trang(boolean tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
	
}
