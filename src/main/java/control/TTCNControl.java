package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TaiKhoanDAOImpl;
import model.TTCN;

/**
 * Servlet implementation class TTCNControl
 */
@WebServlet("/TTCNControl")
public class TTCNControl extends HttpServlet {
	private TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TTCNControl() {
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
		String url = "";
		String hinh_anh = request.getParameter("hinh_anh");
		String ho_ten = request.getParameter("ho_ten");
		String dia_chi = request.getParameter("dia_chi");
		String so_dien_thoai = request.getParameter("so_dien_thoai");
		String mtk = request.getParameter("mtk");
		
		try {
			taiKhoanDAO.updateTTCN(mtk,ho_ten,dia_chi,so_dien_thoai,hinh_anh);
			url = "/login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
