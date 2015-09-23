package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
public class GugudanServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
//		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿을 활용한 구구단</title>");
		out.println("<meta chartset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table style='border:1px solid blue; border-collapse:collapse'>");
		out.println("<caption>구구단</caption>");
		for (int i = 2; i <= 9; i++) {
			out.println("<tr>");
			for (int j = 1; j <= 9; j++) {
				out.println("<td>" + i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		request.setCharacterEncoding("utf-8");

		System.out.println(request.getAttribute("id"));
		System.out.println(request.getParameter("name"));
	}

}
