package control;

import java.io.IOException;
import java.sql.Date;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDAOImpl;
import Tools.MaHoa;
import model.TTCN;
import model.TaiKhoan;

/**
 * Servlet implementation class DangKyServlet
 */
@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
	private TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ten_nguoi_dang_nhap = request.getParameter("ten_nguoi_dang_nhap");
		String ten_tai_khoan = request.getParameter("ten_tai_khoan");
		String mat_khau = request.getParameter("mat_khau");
		
		String ten_tai_khoan_err="",ten_dang_nhap_err="",mat_khau_err="";
		if(ten_nguoi_dang_nhap.equals("")) {
			ten_dang_nhap_err = "Vui lòng nhập Họ và Tên của bạn!";
		}
		if(ten_dang_nhap_err.length()>0) {
			request.setAttribute("ten_dang_nhap_err", ten_dang_nhap_err);
		}
		
		if(ten_tai_khoan.equals("")) {
			ten_tai_khoan_err="Vui lòng nhập Email của bạn!";
		}
		else {
			if(taiKhoanDAO.kiemTraTaiKhoan(ten_tai_khoan)==true) {
				ten_tai_khoan_err ="Tên tài khoản Email đã được đăng ký!";
			}
		}
		if(ten_tai_khoan_err.length()>0) {
			request.setAttribute("ten_tai_khoan_err", ten_tai_khoan_err);
		}
		
		if(mat_khau.equals("")) {
			mat_khau_err = "Vui lòng nhập mật khẩu!";
		}
		if(mat_khau_err.length()>0) {
			request.setAttribute("mat_khau_err", mat_khau_err);
		}
		request.setAttribute("ten_nguoi_dang_nhap", ten_nguoi_dang_nhap);
		request.setAttribute("ten_tai_khoan", ten_tai_khoan);
		request.setAttribute("mat_khau", mat_khau);
		String url ="";
		try {
			if(ten_dang_nhap_err.length()==0 && ten_tai_khoan_err.length()==0 && mat_khau_err.length()==0) {
				java.util.Date id = new java.util.Date();
				String mtk = ""+id.getTime();
				TaiKhoan tk = new TaiKhoan(mtk,ten_tai_khoan,ten_nguoi_dang_nhap,2,MaHoa.maHoaMDS(mat_khau),true);
				taiKhoanDAO.themTaiKhoan(tk);
				String success ="";
				success="Đăng ký tài khoản thành công!";
				request.setAttribute("success", success);
				TTCN ttcn = new TTCN(mtk,ten_nguoi_dang_nhap,"","","avatar_default.jpg");
				taiKhoanDAO.taoTTCN(ttcn);
				HttpSession session = request.getSession();
				session.setAttribute("mtk",mtk );
				url = "/TTCN.jsp";
			}
			else {
				url ="/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
