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
		System.out.println("init");
		ctx = getServletContext();
		System.out.println("ctx");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String context = request.getContextPath(); // 톰캣의 Context path를 가져온다(server.xml에서 확인)
		String command = request.getServletPath();

		String site = null;

		PlusDAO pdao = new PlusDAO();
		
		switch (command) {
		case "/home":
			site = "Index.jsp";
			break;
		case "/maplist":
			request.setAttribute("mapList",pdao.getMapList(request, response));
			site = "Index.jsp";
			break;
		case "/detail":
			site = "Detail.jsp";
			break;
		case "/write":
			String ma = request.getParameter("Ma");
			String la = request.getParameter("La");
			site = "Write.jsp";
			break;
			/*
		case "/insert":
			site = insert(request);
			break;
		case "/edit":
			site = edit(request);
			break;
		case "/update": //업데이트 기능
			site = update(request);
			break;
		case "/delete":
			site = delete(request);
			break;
		*/
		}

		ctx.getRequestDispatcher("/" + site).forward(request, response);
	}

}
