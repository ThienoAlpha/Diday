package control;

import java.io.IOException;
import java.sql.Struct;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DonHangImpl;
import DAO.LienLacDAOImpl;
import model.DonHang;
import model.LienLac;
import model.SanPham;

/**
 * Servlet implementation class ThanhToanControl
 */
@WebServlet("/ThanhToanControl")
public class ThanhToanControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
     LienLacDAOImpl lacDAO;
     DonHangImpl donHangDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
     @Override
    public void init() throws ServletException {
    	lacDAO = new LienLacDAOImpl();
    	donHangDAO = new DonHangImpl();
    }
    public ThanhToanControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "";
		if(session.getAttribute("username")==null) {
			url="/login.jsp";
		}
		else {
			url="/checkout.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		java.util.Date id = new java.util.Date();
		
		//Lấy dữ liệu từ View người dùng
		String ho_ten_nguoi_nhan = request.getParameter("ho_ten");
		String ma_tai_khoan = request.getParameter("ma_tai_khoan");
		String dia_chi = request.getParameter("dia_chi");
		String so_dien_thoai = request.getParameter("so_dien_thoai");
		String ghi_chu = request.getParameter("message");
		String don_vi_van_chuyen =request.getParameter("don_vi_van_chuyen");
		String ma_san_pham="";
		String phuong_thuc_thanh_toan = request.getParameter("thanh_toan");
		Double thanh_tien = Double.valueOf(request.getParameter("thanh_tien")); 
		String thoi_gian_tao = id.toString();
		int sl = Integer.valueOf(request.getParameter("so_luong"));
		
		//Kiểm tra đầu vào của dữ liệu
		String ho_ten_err = "",dia_chi_err = "", so_dien_thoai_err = "", phuong_thuc_thanh_toan_err = "", don_vi_van_chuyen_err = "";
		//Viết check đầu vào cho trang checkout, hoàn thành bảng tbl admin
		
		//Thêm sản phẩm vào database theo sản phẩm tương ứng
		TreeMap<SanPham, Integer> list = (TreeMap<SanPham, Integer>)session.getAttribute("danh_sach_don_hang");	
		for (Map.Entry<SanPham,Integer>sp: list.entrySet()) {
			
			ma_san_pham = sp.getKey().getMa_san_pham();
			DonHang donHang = new DonHang(""+id.getTime(),ma_san_pham,ma_tai_khoan,dia_chi,sl,thanh_tien,don_vi_van_chuyen,so_dien_thoai,thoi_gian_tao,false,ho_ten_nguoi_nhan,phuong_thuc_thanh_toan);
			donHangDAO.themDonHang(donHang);
		}
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/checkout.jsp");
		rd.forward(request, response);
	}

}
