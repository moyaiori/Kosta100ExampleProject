package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RequestDispervlet
 */
public class HttpSessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = "moya";
		HttpSession session = request.getSession();
		session.setAttribute("loginId", userId);
		response.sendRedirect("session2");
		System.out.println(session.isNew());
		}
}
