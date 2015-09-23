package kr.or.kosta.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpServletRequest 인터페이스의 주요 메소드들
 */
public class loginServlet extends HttpServlet {
	
	/**
	 * 로그아웃 처리
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		response.sendRedirect("main");
		*/
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginId")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		response.sendRedirect("main");
	}
	
	/**
	 * 로그인 처리
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String saveCb = request.getParameter("savecb");
		
		// DB 연동을 통해 회원인지 판단...
		// 편의를 위해 회원이라고 가정
		// 세션을 이용한 
		/* 
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("passwd", passwd);
		response.sendRedirect("main");*/
		
		//쿠키에는 한글 또는 특수문자를 저장할 수 없다.
		id =  URLEncoder.encode(id, "utf-8");
		
		// 쿠키를 이용한 로그인 처리
		Cookie cookie = new Cookie("loginId", id);
		// 유효기간 설정(초단위)
		// idCookie.setMaxAge(500);
		// 유효 도메인 설정
		// idCookie.setDomain(“www.some.co.kr”);
		// 유효 패스 설정
		// idCookie.setPath(“/”);
		response.addCookie(cookie);
		
		if (saveCb != null) {
			Cookie saveIdCk = new Cookie("saveid", id);
			saveIdCk.setMaxAge(60 * 60 * 24 * 365); // 1년동안 파일 저장
			response.addCookie(saveIdCk);
		}
				
		response.sendRedirect("main");
	}
}
