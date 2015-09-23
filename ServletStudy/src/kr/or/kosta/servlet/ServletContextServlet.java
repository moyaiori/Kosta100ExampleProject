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
public class ServletContextServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext container = getServletContext();
		// 실행환경(컨테이너) 정보 제공
		System.out.println(container.getServerInfo());
		System.out.println(container.getContextPath());
		
		//서블릿간 데이터 공유
		container.setAttribute("id", "bangry");
		//container.removeAttribute("id");
		//response.sendRedirect("config");
		
		String url = container.getInitParameter("dbURL");
		System.out.println(url);
	}

}
