package model;

public class ChiTietHoaDon {
	private String ma_chi_tiet_hoa_don;
	private String ma_hoa_don;
	private String ma_san_pham;
	private int so_luong;
	private double don_gia;
	private int giam_gia;
	
	public ChiTietHoaDon() {
		
	}
	public ChiTietHoaDon(String ma_chi_tiet_hoa_don, String ma_hoa_don, String ma_san_pham, int so_luong,
			double don_gia, int giam_gia) {
		super();
		this.ma_chi_tiet_hoa_don = ma_chi_tiet_hoa_don;
		this.ma_hoa_don = ma_hoa_don;
		this.ma_san_pham = ma_san_pham;
		this.so_luong = so_luong;
		this.don_gia = don_gia;
		this.giam_gia = giam_gia;
	}
	public String getMa_chi_tiet_hoa_don() {
		return ma_chi_tiet_hoa_don;
	}
	public void setMa_chi_tiet_hoa_don(String ma_chi_tiet_hoa_don) {
		this.ma_chi_tiet_hoa_don = ma_chi_tiet_hoa_don;
	}
	public String getMa_hoa_don() {
		return ma_hoa_don;
	}
	public void setMa_hoa_don(String ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}
	public String getMa_san_pham() {
		return ma_san_pham;
	}
	public void setMa_san_pham(String ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
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
	public int getGiam_gia() {
		return giam_gia;
	}
	public void setGiam_gia(int giam_gia) {
		this.giam_gia = giam_gia;
	}
	
}
