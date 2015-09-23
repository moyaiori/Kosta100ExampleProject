package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.util.logging.resources.logging;

/**
 * 메인 페이지
 */
public class MainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("id");
		*/
		
		String loginId = null;
		String saveId = "";
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginId")) {
					loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
				
				if (cookie.getName().equals("saveid")) {
					saveId = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
			}
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>로그인 세션</title>");
		out.println("<script type='text/javascript'>");
		out.println("window.onload = function(){document.getElementById('logout').onclick = function (){");
		out.println("location.replace('login');");
		out.println(" };");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		
		if (loginId == null) {
			out.println("<form action='login' method='post'>");
			out.println(" <label>아이디 : <input type='text' name='id' placeholder='아이디' style='line-height: 15px;' value=" + saveId + "></label><br>");
			out.println(" <label>비밀번호 : <input type='password' name='passwd' placeholder='비밀번호' style='line-height: 15px;'></label><br>");
			
			if (saveId.equals("")) {
				out.println(" <label>아이디 저장 : <input type='checkbox' name='savecb' value='true'></label><br>");
			}else{
				out.println(" <label>아이디 저장 : <input type='checkbox' name='savecb' value='true' checked='checked'></label><br>");
			}
			out.println(" <input type='submit' value='로그인'>");
			out.println(" <input type='reset' value='취소'>");
			out.println("</form>");
		}else{
			out.println("<span>\"" + loginId + "\"님이 로그인중</span>");
			out.println("<button id='logout'>로그아웃</button>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

}








