<%@page import="java.net.URLEncoder"%>
<%@page import="kr.or.kosta.user.domain.User"%>
<%@page import="kr.or.kosta.user.dao.UserDao"%>
<%@page import="kr.or.kosta.user.dao.JdbcUserDao"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
// 로그인 처리
if(request.getMethod().equalsIgnoreCase("post")){
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	UserDao userDao =  (UserDao)factory.getDao(JdbcUserDao.class);
	User user = userDao.isMember(id, passwd);
	
	if(user != null){
		id =  URLEncoder.encode(id, "utf-8");
		
		Cookie loginCookie = new Cookie("loginId", id);
		Cookie userEmail = new Cookie("email", user.getEmail());
		loginCookie.setPath("/");
		userEmail.setPath("/");
		response.addCookie(loginCookie);
		response.addCookie(userEmail);
		
		response.sendRedirect("/");
	}else{
%>
	<script>
		alert("아이디와 비밀번호를 확인하십시오");
		history.back();
	</script>
<%
	}
	// 로그아웃 처리
}else{
	// 쿠키 읽기
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
	response.sendRedirect("/");
}
%>
