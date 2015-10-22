<%@page import="kr.or.kosta.guestBook.dao.JdbcGuestBookDao"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>

<jsp:useBean id="guestBook" class="kr.or.kosta.user.domain.GuestBook" scope="request"/>
<jsp:setProperty property="content" name="guestBook"/>
<jsp:setProperty property="title" name="guestBook"/>
<%
	request.setCharacterEncoding("utf-8");
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	JdbcGuestBookDao guestBookDao = (JdbcGuestBookDao)factory.getDao(JdbcGuestBookDao.class);
	
	String loginId = null;
	Cookie[] cookies = request.getCookies();
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
			}
		}
	}
	
	guestBook.setId(loginId);
	guestBookDao.add(guestBook);
	
%>
<script>
location.href="/view/guestBook/guestBook.jsp";
</script>
<%-- 
<jsp:forward page="/view/guestBook/guestBook.jsp"/>
--%>