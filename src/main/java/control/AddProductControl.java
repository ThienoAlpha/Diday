package control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DanhMucDaoImpl;
import DAO.SanPhamDAO;
import DAO.SanPhamDaoImpl;
import model.SanPham;

/**
 * Servlet implementation class AddProductControl
 */
@WebServlet("/AddProductControl")
public class AddProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDaoImpl sanPhamDao;
    private DanhMucDaoImpl danhMucDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		sanPhamDao = new SanPhamDaoImpl();
		danhMucDao = new DanhMucDaoImpl();
	}
	
    public AddProductControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("admin/tbl_product.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String caseControlProduct = request.getParameter("case");
		switch (caseControlProduct) {
		case "add": 
			addProduct(request, response);
			break;
		case "edit": 
			editProduct(request, response);
			break;
		case "delete": 
			deleteProduct(request, response);
			break;
		default:
			break;
		}
		
		
	}
	
	protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khai báo biến lấy dữ liệu từ form người dùng
		String ten_danh_muc = request.getParameter("loai_hang");
		String ten_the_loai = request.getParameter("ten_the_loai");
		String ten_san_pham = request.getParameter("ten_san_pham");
		String hinh_anh = request.getParameter("hinh_anh");
		int so_luong = Integer.parseInt(request.getParameter("so_luong"));
		String mo_ta = request.getParameter("mo_ta");
		Double don_gia = Double.parseDouble(request.getParameter("don_gia"));
		
		//Khai báo biến ghép chuỗi tạo msp tự động
		String ma_san_pham = "";
		String ma_danh_muc = "";
		
		switch (ten_danh_muc) {
		case "Phương tiện di chuyển":
			ma_danh_muc = danhMucDao.getDanhMucCha(ten_danh_muc).getMa_danh_muc();
			break;
		case "Vũ khí":
			ma_danh_muc = danhMucDao.getDanhMucCha(ten_danh_muc).getMa_danh_muc();
			break;
		case "Đồ đa dụng":
			ma_danh_muc = danhMucDao.getDanhMucCha(ten_danh_muc).getMa_danh_muc();
			break;
		default:
			break;
		}
		String mdmString = ma_danh_muc;
		switch (ten_the_loai) {
		case "Hàng không":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Đường bộ":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Thủy chiến":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Xuyên thời gian":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Hạng nặng":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Hạng trung":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Hạng nhẹ":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Giải trí":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Chứa đựng":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		case "Làm đẹp":
			ma_danh_muc = danhMucDao.getDanhMucCon(ten_the_loai).getMa_danh_muc();
			ma_san_pham =  danhMucDao.getDanhMucCon(ten_danh_muc).getMa_danh_muc() + ma_danh_muc;
			break;
		default:
			break;	
		}
		
		Random rd = new Random();
		String lastmsp = String.valueOf(rd.nextInt(10000));
		
		ma_san_pham = ma_san_pham + lastmsp;
		SanPham sanPham = new SanPham();
		sanPham.setMa_san_pham(ma_san_pham);
		sanPham.setMa_danh_muc(ma_danh_muc);
		sanPham.setTen_san_pham(ten_san_pham);
		sanPham.setHinh_anh(hinh_anh);
		sanPham.setSo_luong(so_luong);
		sanPham.setMo_ta(mo_ta);
		sanPham.setDon_gia(don_gia);
		
		try {
			sanPhamDao.setSanPham(sanPham);
			response.sendRedirect("/E-Shoper/AddProductControl");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	protected void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msp = request.getParameter("msp");
		String ten_san_pham = request.getParameter("ten_san_pham");
		String hinh_anh = request.getParameter("hinh_anh");
		Double don_gia = Double.parseDouble(request.getParameter("don_gia"));
		String mo_ta = request.getParameter("mo_ta");
		int so_luong = Integer.parseInt(request.getParameter("so_luong"));
		try {
			sanPhamDao.updateSanPham(msp, ten_san_pham, hinh_anh, don_gia, mo_ta, so_luong);
			response.sendRedirect("/E-Shoper/AddProductControl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msp = request.getParameter("msp");
		try {
			sanPhamDao.deleteSanPham(msp);
			response.sendRedirect("/E-Shoper/AddProductControl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
