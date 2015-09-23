package kr.or.kosta.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * form으로부터 데이터 받아 처리하기 + 훅메소드 구현
 */
public class JoinServlet extends HttpServlet {
	
	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	/**
	 * 훅 메소드(요청 방식에 상관없이 요청처리를 위한 메소드)  post, get 둘다 지원
	 */
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// id = ??
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String[] hobbys = request.getParameterValues("hobby");
		String gendor = request.getParameter("gendor");
		String file = request.getParameter("upload");
		String[] stars = request.getParameterValues("star");
		String profile = request.getParameter("profile");
		
		
		System.out.println("id : " + id);
		System.out.println("passwd : " + passwd);
		if (hobbys != null) {
			for (String string : hobbys) {
				System.out.println("hobbys : " + string);
			}
		}
		System.out.println("gendor : " + gendor);
		System.out.println("file : " + file);
		if (stars != null) {
			for (String string : stars) {
				System.out.println("star : " + string);
			}
		}
		System.out.println("profile : " + profile);
		
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + " : " + value);
			
		}
	}

}
