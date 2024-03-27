package DAO;

import java.util.ArrayList;

import model.DanhMuc;

public interface DanhMucDAO {
	//load danh sách danh mục cha
	ArrayList<DanhMuc> getListDanhMucCha();
	
	//load danh sách danh mục con
	ArrayList<DanhMuc> getListDanhMucCon(String ma_danh_muc);
	
	//get danh mục cha
	DanhMuc getDanhMucCha(String ten_danh_muc);
	
	//get danh muc con
	DanhMuc getDanhMucCon(String ten_danh_muc);
}
