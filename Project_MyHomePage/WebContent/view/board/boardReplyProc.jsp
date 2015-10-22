<%@page import="kr.or.kosta.reply.dao.JdbcReplyDao"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@page import="kr.or.kosta.board.dao.JdbcBoardDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="board" class="kr.or.kosta.user.domain.Board" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>
<%
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	JdbcReplyDao replyDao = (JdbcReplyDao)factory.getDao(JdbcReplyDao.class);

	//System.out.println("article_id : " + board.getArticle_id());
	String email = null;
	String loginId = null;
	
	// 쿠키 읽기
	Cookie[] cookies = request.getCookies();
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("email")) {
				email = URLDecoder.decode(cookie.getValue(), "utf-8");
			}else if (cookie.getName().equals("loginId")) {
				loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
			}
		}
	}
	
	board.setWriter(loginId);
	board.setIp(request.getRemoteAddr());
	//System.out.println("board : " + board);
	replyDao.reply(board);
%>

<script>
	location.href = "boardList.jsp";
</script>