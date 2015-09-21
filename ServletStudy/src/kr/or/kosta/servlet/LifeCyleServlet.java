package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
public class LifeCyleServlet extends HttpServlet {
	
	int count;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		count = 0;	// 서블릿 생성시 초기화
		System.out.println("init() Called");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() Called : count(" + count + ")");
		count++;
		super.service(arg0, arg1);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
//		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>카운터</title>");
		out.println("<meta chartset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		out.println("접속자수 : ");
		out.println(count);
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		//count = 0;
		System.out.println("destroy() called");
	}

}
