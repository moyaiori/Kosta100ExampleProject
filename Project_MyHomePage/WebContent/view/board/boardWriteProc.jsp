<%@page import="java.net.URLDecoder"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@page import="kr.or.kosta.board.dao.JdbcBoardDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="board" class="kr.or.kosta.user.domain.Board" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>
<%
	request.setCharacterEncoding("utf-8");
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	JdbcBoardDao boardDao = (JdbcBoardDao)factory.getDao(JdbcBoardDao.class);

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
	boardDao.wirte(board);

%>

<script>
	location.href = "boardList.jsp";
</script>