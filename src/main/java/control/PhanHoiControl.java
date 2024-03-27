package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.PhanHoiDAOImpl;
import model.PhanHoi;

/**
 * Servlet implementation class PhanHoiControl
 */
@WebServlet("/PhanHoiControl")
public class PhanHoiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PhanHoiDAOImpl lacDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException {
		lacDAO = new PhanHoiDAOImpl();
	}
    public PhanHoiControl() {
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
		HttpSession session = request.getSession();
		String ten_tai_khoan = (String) session.getAttribute("username");
		String ho_va_ten = request.getParameter("ho_va_ten");
		String so_dien_thoai = request.getParameter("so_dien_thoai");
		String tieu_de = request.getParameter("titlle");
		String loi_nhan = request.getParameter("loi_nhan");
	
		
		PhanHoi ph = new PhanHoi(ten_tai_khoan,ho_va_ten,so_dien_thoai,loi_nhan,tieu_de);
		lacDAO.setPhanHoi(ph); 
		RequestDispatcher rd = request.getRequestDispatcher("/contact.jsp");
		rd.forward(request, response);
	}

}
