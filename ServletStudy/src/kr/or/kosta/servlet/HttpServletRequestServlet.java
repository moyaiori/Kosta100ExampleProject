package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletRequest 인터페이스의 주요 메소드들
 */
public class HttpServletRequestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>HttpServletRequest 인터페이스의 주요 메소드들</title>");
		out.println("<meta chartset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		//웹 클라이언트의 요청 메시지 분석
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String httpVersion = request.getProtocol();
		String query = request.getQueryString();
		
		Enumeration<String> e = request.getHeaderNames();
		out.println("<ul>");
		out.println("<li>요청방식 : " + method +"</li>");
		out.println("<li>요청 URI : " + uri +"</li>");
		out.println("<li>요청버전 : " + httpVersion +"</li>");
		out.println("<li>쿼리스트링 : " + query +"</li>");
		
		
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = request.getHeader(name);
			out.println("<li>" + name + " : " + value + "<br></li>");
		}
		out.println("</ul>");
		out.println(request.getRemoteHost() + "<br>");
		out.println(request.getRemoteAddr() + "<br>");
		out.println(request.getContentType() + "<br>");
		out.println(request.getContentLength() + "<br>");
		out.println(request.getContextPath() + "<br>");
		out.println("</body>");
		out.println("</html>");}

}
