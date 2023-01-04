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
import DTO.PlusDTO;

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
		case "/contentsInfo":
			site = getView(request);
			break;
		case "/write":
			site = "Write.jsp";
			break;
		case "/insert":
			site = insert(request);
			break;
		case "/edit":
			site = getEdit(request);
			break;
		case "/update": // 업데이트 기능
			site = getUpdate(request);
			break;
		case "/delete":
			site = getDelete(request);
			break;
		case "/home":
		case "/":
			request.setAttribute("mapList", dao.getMapList(request, response));
			site = "Index.jsp";
			break;
		}

		if(site.startsWith("redirect:/")) { //redirect/ 문자열 이후 경로만 가지고 옴
			String rview = site.substring("redirect:/".length());
							//substring : 문자열을 자름. length : 길이만큼 잘라준다.
			System.out.println(rview);
			response.sendRedirect(rview);
		} else { //forward
			ctx.getRequestDispatcher("/" + site).forward(request, response);
		}
		
	}
	
	public String getView(HttpServletRequest request) {
		int c_id = Integer.parseInt(request.getParameter("c_id"));
		PlusDTO pd = dao.getView(c_id);
		request.setAttribute("pd", pd);
		return "View.jsp";
	}

	public String insert(HttpServletRequest request) {
		System.out.println("Con insert");
		int cid = dao.nextInsertC_id(request);
		int rid = dao.nextInsertR_id(request);

		String r_name = request.getParameter("r_name");
		String c_date = request.getParameter("c_date");
		String r_address = request.getParameter("r_address");
		String r_latitude = request.getParameter("r_latitude");
		String r_longitude = request.getParameter("r_longitude");
		int c_grade = Integer.parseInt(request.getParameter("c_grade"));
		String c_coment = request.getParameter("c_coment");

		dao.insert_c(cid, rid, c_grade, c_coment);
		dao.insert_r(rid, r_name, r_address, r_latitude, r_longitude );

		return "redirect:/home";
	}

	public String getEdit(HttpServletRequest request) {
		int c_id = Integer.parseInt(request.getParameter("c_id"));
		PlusDTO pd = dao.getEdit(c_id);
		request.setAttribute("pd", pd);
		return "Edit.jsp";
	}

	public String getUpdate(HttpServletRequest request) {
		int rid = Integer.parseInt(request.getParameter("r_id"));

		String r_name = request.getParameter("r_name");
		String c_date = request.getParameter("c_date");
		String r_address = request.getParameter("r_address");
		String r_longitude = request.getParameter("r_longitude");
		String r_latitude = request.getParameter("r_latitude");
		int c_grade = Integer.parseInt(request.getParameter("c_grade"));
		String c_coment = request.getParameter("c_coment");

		dao.update_c(rid, c_grade, c_coment);
		dao.update_r(rid, r_name, r_address, r_latitude, r_longitude);

		return "/home";
	}

	public String getDelete(HttpServletRequest request) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));

		dao.delete_c(r_id);
		dao.delete_r(r_id);
		return "/home";
	}

}
