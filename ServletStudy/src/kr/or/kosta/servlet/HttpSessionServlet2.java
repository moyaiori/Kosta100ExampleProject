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
public class HttpSessionServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = null;
		HttpSession session = request.getSession();
		System.out.println("session(loginId) : " + session.getAttribute("loginId"));
		System.out.println(session.isNew());
	}
}
