package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDAOImpl;
import Tools.MaHoa;
import model.TaiKhoan;

/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();

    public DangNhapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("command").equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/E-Shoper/index.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String casee = request.getParameter("case");
		switch (casee) {
		case "login": Log_in(request, response);
			break;
		case "guest": Log_in(request, response);
		break;
		default:
			break;
		}
		
		
	}
	
	protected void Log_in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten_tai_khoan_dn = request.getParameter("ten_tai_khoan_dn"),
				   mat_khau_dn = request.getParameter("mat_khau_dn"),
				   url = "",
				   dang_nhap_err="";
					TaiKhoan tKhoan = (TaiKhoan) taiKhoanDAO.getTaiKhoan(ten_tai_khoan_dn, MaHoa.maHoaMDS(mat_khau_dn));
					Integer ktra =tKhoan.getQuyen_truy_cap();
					String ma_tai_khoan = tKhoan.getMa_tai_khoan();
					
				if(taiKhoanDAO.kiemTraDangNhap(ten_tai_khoan_dn, MaHoa.maHoaMDS(mat_khau_dn))==true) {
					HttpSession session = request.getSession();
					session.setAttribute("username", ten_tai_khoan_dn);
					session.setAttribute("ma_tai_khoan", ma_tai_khoan);
					if(ktra==1) {
						session.setAttribute("quyen_truy_cap",1);
						url ="/account.jsp";
					}
					else {
						session.setAttribute("quyen_truy_cap",tKhoan.getQuyen_truy_cap());
						url ="/account.jsp";
						
					}
				}
				else {
					url ="/login.jsp";
					dang_nhap_err="Sai tài khoản hoặc mật khẩu!";
					request.setAttribute("dang_nhap_err", dang_nhap_err);
				}
			request.setAttribute("dang_nhap_err",dang_nhap_err );
			request.setAttribute("ten_tai_khoan_dn", ten_tai_khoan_dn);
			request.setAttribute("mat_khau_dn", mat_khau_dn);
			HttpSession session = request.getSession();
			session.setAttribute("mtk", ma_tai_khoan);
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
	}
	
	protected void Log_in_as_guest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_guest = request.getParameter("id_Guest");
	}
}
