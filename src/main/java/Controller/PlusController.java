package Controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.PlusDAO;

@WebServlet("/")
public class PlusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlusDAO dao;
	private ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		dao = new PlusDAO();
		ctx = getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath(); // 톰캣의 Context path를 가져온다(server.xml에서 확인)
		String command = request.getServletPath();
		String site = null;
		
		switch (command) {
		case "/write":
			site = "Write.jsp";
			break;
		case "/writing":
			site = "";
			break;
		case "/list":
			site = "";
			break;
		
		}
		
	ctx.getRequestDispatcher("/" + site).forward(request, response);
	}
	
}
