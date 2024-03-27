package model;

import java.util.Date;

public class DonHang {
	private String ma_don_hang;
	private String ma_san_pham;
	private String ma_tai_khoan;
	private String dia_chi_giao_hang;
	private int so_luong;
	private String phuong_thuc_thanh_toan;
	private String ho_ten_nguoi_nhan;
	private double don_gia;
	private String so_dien_thoai;
	private String don_vi_van_chuyen;
	private String thoi_gian_tao;
	private boolean trang_thai;
	
	public DonHang(String ma_don_hang, String ma_san_pham, String ma_tai_khoan, String dia_chi_giao_hang, int so_luong,
			double don_gia, String don_vi_van_chuyen,String so_dien_thoai, String thoi_gian_tao, boolean trang_thai, String ho_ten_nguoi_nhan,String phuong_thuc_thanh_toan) {
		super();
		this.ma_don_hang = ma_don_hang;
		this.ma_san_pham = ma_san_pham;
		this.ma_tai_khoan = ma_tai_khoan;
		this.dia_chi_giao_hang = dia_chi_giao_hang;
		this.so_luong = so_luong;
		this.don_gia = don_gia;
		this.don_vi_van_chuyen = don_vi_van_chuyen;
		this.so_dien_thoai = so_dien_thoai;	 
		this.thoi_gian_tao = thoi_gian_tao;
		this.trang_thai=trang_thai;
		this.ho_ten_nguoi_nhan = ho_ten_nguoi_nhan;
		this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
	}
	
	public DonHang() {}

	public String getMa_don_hang() {
		return ma_don_hang;
	}

	public void setMa_don_hang(String ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}

	public String getMa_san_pham() {
		return ma_san_pham;
	}

	public void setMa_san_pham(String ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}

	public String getMa_tai_khoan() {
		return ma_tai_khoan;
	}

	public void setMa_tai_khoan(String ma_tai_khoan) {
		this.ma_tai_khoan = ma_tai_khoan;
	}

	public String getDia_chi_giao_hang() {
		return dia_chi_giao_hang;
	}

	public void setDia_chi_giao_hang(String dia_chi_giao_hang) {
		this.dia_chi_giao_hang = dia_chi_giao_hang;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public double getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(double don_gia) {
		this.don_gia = don_gia;
	}

	public String getDon_vi_van_chuyen() {
		return don_vi_van_chuyen;
	}

	public void setDon_vi_van_chuyen(String don_vi_van_chuyen) {
		this.don_vi_van_chuyen = don_vi_van_chuyen;
	}

	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}

	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}

	
	public boolean isTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(boolean trang_thai) {
		this.trang_thai = trang_thai;
	}

	public String getThoi_gian_tao() {
		return thoi_gian_tao;
	}

	public void setThoi_gian_tao(String thoi_gian_tao) {
		this.thoi_gian_tao = thoi_gian_tao;
	}

	public String getHo_ten_nguoi_nhan() {
		return ho_ten_nguoi_nhan;
	}

	public void setHo_ten_nguoi_nhan(String ho_ten_nguoi_nhan) {
		this.ho_ten_nguoi_nhan = ho_ten_nguoi_nhan;
	}

	public String getPhuong_thuc_thanh_toan() {
		return phuong_thuc_thanh_toan;
	}

	public void setPhuong_thuc_thanh_toan(String phuong_thuc_thanh_toan) {
		this.phuong_thuc_thanh_toan = phuong_thuc_thanh_toan;
	}
	
}
