package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig 인터페이스의 주요 메소드들
 */
public class ServletConfigSErvlet extends HttpServlet {
	
	String color = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		color = config.getInitParameter("color");
//		Enumeration<String> e = config.getInitParameterNames();
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) getServletContext().getAttribute("id");
		 System.out.println("공유 아이디: " + id);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ServletConfigSErvlet 인터페이스의 주요 메소드들</title>");
		out.println("<meta chartset='utf-8'>");
		out.println("</head>");
		out.println("<body style='background-color: " + color +"';>");
		out.println("안녕하세요");
		out.println("</body>");
		out.println("</html>");
	}
}
