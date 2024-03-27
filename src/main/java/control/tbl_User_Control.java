package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tbl_User_Control
 */
@WebServlet("/tbl_User_Control")
public class tbl_User_Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tbl_User_Control() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String caseControlProduct = request.getParameter("case_user");
		switch (caseControlProduct) {
		case "edit": 
			editUser(request, response);
			break;
		case "delete": 
			deleteProduct(request, response);
			break;
		default:
			break;
			}
	}
		
	protected void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msp = request.getParameter("msp");
		String ten_san_pham = request.getParameter("ten_san_pham");
		String hinh_anh = request.getParameter("hinh_anh");
		Double don_gia = Double.parseDouble(request.getParameter("don_gia"));
		String mo_ta = request.getParameter("mo_ta");
		int so_luong = Integer.parseInt(request.getParameter("so_luong"));
		try {
//			sanPhamDao.updateSanPham(msp, ten_san_pham, hinh_anh, don_gia, mo_ta, so_luong);
			response.sendRedirect("/E-Shoper/AddProductControl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}

