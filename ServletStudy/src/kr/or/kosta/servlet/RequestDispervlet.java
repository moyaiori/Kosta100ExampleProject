package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispervlet
 */
public class RequestDispervlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통작업 수행...		
		String url = null;
		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			url = "/index.html";
		}else if(cmd.equalsIgnoreCase("gugu")){
			url = "/gugudan?name=이광용";
		}else if(cmd.equalsIgnoreCase("welcome")){
			url = "/hello";
		}
		// 데이터 전달을 위해 request 활용
		request.setAttribute("id", "블랙리스트");
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
