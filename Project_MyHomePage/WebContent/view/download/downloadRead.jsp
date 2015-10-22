<%@page import="kr.or.kosta.download.dao.DownloadDao"%>
<%@page import="kr.or.kosta.download.dao.JdbcDownloadDao"%>
<%@page import="kr.or.kosta.user.domain.Board"%>
<%@page import="kr.or.kosta.board.dao.JdbcBoardDao"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>


<%
	request.setCharacterEncoding("utf-8");
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	DownloadDao boardDao = (DownloadDao) factory.getDao(JdbcDownloadDao.class);

	String article_id = request.getParameter("article_id");
	Board resultBoard = boardDao.getArticle(article_id);
	
	boardDao.updateHitCount(article_id);
	
	//System.out.println("resultBoard : " + resultBoard);
	System.out.println("file : " + resultBoard.getFile());
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/style/index.css">
<script type="text/javascript" src="../../js/main.js"></script>
<title>kosta 100 Lee HomePage(board)</title>
</head>
<body>
	<jsp:include page="/view/menus/header.jsp"></jsp:include>
	<div class="mainView">
	
		<div class="contentView">
			<div class="boardPageTitle">글 읽기</div>
			<table class="boardWriteTitle">
				<tr>
					<th>글제목</th>
					<td colspan="3"><%=resultBoard.getSubject() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=resultBoard.getWriter() %></td>
					<th>작성일</th>
					<td><%=resultBoard.getRegdate() %></td>
				</tr>
				<tr>
					<th>아이피</th>
					<td><%=resultBoard.getIp() %></td>
					<th>조회수</th>
					<td><%=resultBoard.getHitcount() %></td>
				</tr>
				<tr>
					<th>첨부 자료</th>
					<td><a href="/download?file=<%=resultBoard.getFile()%>"><%=resultBoard.getFile() %></a></td>
				</tr>
				<tr>
					<td colspan="4" style="padding: 10px 30px">
					<%=resultBoard.getContent() %>
					</td>
				</tr>
			</table>
			<div class="boardReadBtnGroup">
				<button class="btn" onclick="movePageBoardList_DL();">목록으로</button>
				<button class="btn" onclick="movePageWirte();">글쓰기</button>
				<%--<button class="btn" onclick="movePageReply('<%=article_id %>','<%=resultBoard.getSubject()%>');">답글쓰기</button> --%>
				<button class="btn">수정하기</button>
				<button class="btn">삭제하기</button>
			</div>
		</div>

		<jsp:include page="/view/menus/login.jsp"></jsp:include>
		<jsp:include page="/view/menus/side.jsp"></jsp:include>
	</div>
	<jsp:include page="/view/menus/footer.jsp"></jsp:include>
</body>
</html>