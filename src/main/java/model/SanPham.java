package model;

public class SanPham implements Comparable<SanPham>{
	
	
	private String ma_san_pham;
	private DanhMuc danh_muc;
	private String ten_san_pham;
	private String ma_danh_muc;
	private String hinh_anh;
	private int so_luong;
	private String mo_ta;
	private double don_gia;
	private String audio;

	
	public SanPham(String ma_san_pham, DanhMuc danh_muc, String ten_san_pham, String hinh_anh, int so_luong,
			String mo_ta, double don_gia, String audio) {
		super();
		
		this.ma_san_pham = ma_san_pham;
		this.danh_muc = danh_muc;
		this.ten_san_pham = ten_san_pham;
		this.hinh_anh = hinh_anh;
		this.so_luong = so_luong;
		this.mo_ta = mo_ta;
		this.don_gia = don_gia;
		this.audio = audio;
	}
	
	
	public String getMa_san_pham() {
		return ma_san_pham;
	}
	public void setMa_san_pham(String ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}

	public DanhMuc getDanh_muc() {
		return danh_muc;
	}

	
	
	public void setDanh_muc(DanhMuc danh_muc) {
		this.danh_muc = danh_muc;
	}


	public String getTen_san_pham() {
		return ten_san_pham;
	}
	public void setTen_san_pham(String ten_danh_muc) {
		this.ten_san_pham = ten_danh_muc;
	}
	public String getHinh_anh() {
		return hinh_anh;
	}
	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public String getMo_ta() {
		return mo_ta;
	}
	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}
	public double getDon_gia() {
		return don_gia;
	}
	public void setDon_gia(double don_gia) {
		this.don_gia = don_gia;
	}
	
	public String getAudio() {
		return audio;
	}


	public void setAudio(String audio) {
		this.audio = audio;
	}


	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMa_danh_muc() {
		return ma_danh_muc;
	}


	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}


	@Override
	public int compareTo(SanPham sp) {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.ma_san_pham) - Integer.parseInt(sp.ma_san_pham);
	}
	
	
	
}
