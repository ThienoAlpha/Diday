package model;

public class PhanHoi {
	private String ten_tai_khoan;
	private String ho_ten_phan_hoi;
	private String so_dien_thoai;
	private String loi_nhan;
	private String tieu_de;
	
	public PhanHoi(String ten_tai_khoan, String ho_ten_phan_hoi, String so_dien_thoai, String loi_nhan, String tieu_de) {
		super();
		this.ten_tai_khoan = ten_tai_khoan;
		this.ho_ten_phan_hoi = ho_ten_phan_hoi;
		this.so_dien_thoai = so_dien_thoai;
		this.loi_nhan = loi_nhan;
		this.tieu_de = tieu_de;
	}
	
	public PhanHoi() {}

	public String getTen_tai_khoan() {
		return ten_tai_khoan;
	}

	public void setTen_tai_khoan(String ten_tai_khoan) {
		this.ten_tai_khoan = ten_tai_khoan;
	}

	public String getHo_ten_phan_hoi() {
		return ho_ten_phan_hoi;
	}

	public void setHo_ten_phan_hoi(String ho_ten_phan_hoi) {
		this.ho_ten_phan_hoi = ho_ten_phan_hoi;
	}

	public String getTieu_de() {
		return tieu_de;
	}

	public void setTieu_de(String tieu_de) {
		this.tieu_de = tieu_de;
	}

	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}

	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}

	public String getLoi_nhan() {
		return loi_nhan;
	}

	public void setLoi_nhan(String loi_nhan) {
		this.loi_nhan = loi_nhan;
	}
	
	
}
