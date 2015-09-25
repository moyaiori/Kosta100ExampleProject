package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.common.dao.DaoFactory;
import kr.or.kosta.common.dao.DaoFactory.DaoFactoryType;
import kr.or.kosta.common.dao.JdbcDaoFactory;
import kr.or.kosta.user.dao.JdbcUserDao;
import kr.or.kosta.user.dao.UserDao;
import kr.or.kosta.user.domain.User;

/**
 * Dao 퍁너 적용 DB 연동
 */
public class jdbcServlet2 extends HttpServlet {

	private String fileRepository = "I:/KOSTA100/workspace/ServletStudy/fileDirectory/";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		DaoFactory factory = new JdbcDaoFactory();
		DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
		
		
		List<User> list = null;
		try {
			UserDao userDao = (UserDao) factory.getDao(JdbcUserDao.class);
			list = userDao.getAll();
		} catch (Exception e) {
			new ServletException(e);
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("회원 목록");
		out.println("</title>");
		out.println("<style>");
		out.println("table {");
		out.println("border-collapse: collapse;");
		out.println("}");
		out.println("table, th, td {");
		out.println("border: 1px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table style='border: 1px solid blue'>");
		out.println("<tr>");
		out.println("<th>아이디</th>");
		out.println("<th>이름</th>");
		out.println("<th>비밀번호</th>");
		out.println("</tr>");
		
		for (User user : list) {
			out.println("<tr>");
			out.println("<td>" + user.getId() + "</td>");
			out.println("<td>" + user.getName() + "</td>");
			out.println("<td>" + user.getPasswd() + "</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
