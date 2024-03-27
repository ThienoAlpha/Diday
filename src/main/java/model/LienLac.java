package model;

public class LienLac {
	private	String ten_tai_khoan;
	private String ho_ten;
	private String dia_chi;
	private String so_dien_thoai;
	private String ghi_chu;
	public LienLac(String ten_tai_khoan, String ho_ten, String dia_chi, String so_dien_thoai, String ghi_chu) {
		super();
		this.ten_tai_khoan = ten_tai_khoan;
		this.ho_ten = ho_ten;
		this.dia_chi = dia_chi;
		this.so_dien_thoai = so_dien_thoai;
		this.ghi_chu = ghi_chu;
	}
	public LienLac() {

	}
	public String getTen_tai_khoan() {
		return ten_tai_khoan;
	}
	public void setTen_tai_khoan(String ten_tai_khoan) {
		this.ten_tai_khoan = ten_tai_khoan;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	
	
	
}
