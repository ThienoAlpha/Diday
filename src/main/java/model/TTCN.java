package model;

public class TTCN {
	private String id;
	private String hoten;
	private String diachi;
	private String sdt;
	private String hinh_anh;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getHinh_anh() {
		return hinh_anh;
	}
	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}
	public TTCN(String id, String hoten, String diachi, String sdt, String hinh_anh) {
		this.id = id;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.hinh_anh = hinh_anh;
	}
	public TTCN() {}
}
