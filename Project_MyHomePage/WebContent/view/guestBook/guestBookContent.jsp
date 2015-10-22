<%@page import="kr.or.kosta.guestBook.dao.JdbcGuestBookDao"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.kosta.user.domain.GuestBook"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@page import="javax.websocket.SendResult"%>
<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String loginId = null;
	
	Cookie[] cookies = request.getCookies();
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
			}
		}
	}
%>

<div class="contentView">
	<div class="titleText">방명록</div>
	<ul class="guestBook">
<%
	if(loginId != null){
%>
		<li>
			<a>
				<form action="/view/guestBook/guestBookProc.jsp" method="get">
					<input type="text" name="title" placeholder="제목" class="guestBookTitleTF">
					<textarea rows="5" cols="29" name="content" class="guestBookContentTF" placeholder="내용을 입력하세요(50자 제한)"></textarea>
					<input class="btnGuestBook" type="submit" value="글쓰기">
				</form>
			</a>
		</li>
<%
	}
		
	List<GuestBook> guestBookList = null;
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	JdbcGuestBookDao guestBookDao = (JdbcGuestBookDao)factory.getDao(JdbcGuestBookDao.class);
	
	guestBookList = guestBookDao.getAll();
	for (GuestBook result : guestBookList) {
%>
		<li>
			<a>
				<div class="guestBookTitle"><%=result.getTitle() %></div>
				<div class="guestBookName"><%=result.getId() %></div>
				<div class="guestBookTime"><%=result.getDate() %></div>
				<div class="guestBookContent"><%=result.getContent() %></div>
			</a>
		</li>
<%
	}
%>
	</ul>
	
</div>