package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse 인터페이스의 주요 메소드들
 */
public class HttpServletResponseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
//		response.setHeader("Content-Type", "text/html; charset=utf-8");
//		response.setHeader("xxxxx", "yyyyy");
		PrintWriter out = response.getWriter();
		
		//응답 메시지의 상태코드 강제 변경
//		response.setStatus(404);
//		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//		response.sendError(HttpServletResponse.SC_FORBIDDEN);
		
		/*
		String id = request.getParameter("id");
		if ("moya".equals(id)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>HttpServletRequest 인터페이스의 주요 메소드들</title>");
		out.println("<meta chartset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("안녕하세요");
		out.println("</body>");
		out.println("</html>");
		*/
		
		// 웹 브라우저 자동 요청 처리 (디스패치)
//		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//		response.setHeader("Location", "gugudan");
		response.sendRedirect("gugudan");
	}

}
