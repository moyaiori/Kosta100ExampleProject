<%@page import="kr.or.kosta.board.dao.BoardDao"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="kr.or.kosta.user.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.board.dao.JdbcBoardDao"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="../../js/main.js"></script>

<%
	request.setCharacterEncoding("utf-8");

	String searcType = null;				// 검색 타입(글제목, 작성자, 글내용)
	String searckeyword = null;				// 검색어
	int pageing = 0;						// 일반 게시판 총 게시물글 숫자
	int serachPageing = 0;					// 검색 게시판 총 게시물글 숫자
	int nowPageNum = 1;						// 현재 페이지 번호
	int listNo = 0;							// 게시판 목록번호
	int pageBeginNum = 0;					// 현재 게시판 목록의 시작 번호
	int articleNum = 6;		// 게시판 인덱스 넘버
	
	List<Board> boardList = null;
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	BoardDao boardDao = (BoardDao)factory.getDao(JdbcBoardDao.class);

	pageing = (int)Math.ceil((double)(boardDao.getPageNum() / 5)) + 1;	// 전체 페이지 크기
	pageContext.setAttribute("pageing", pageing);
	
	if(null != request.getParameter("type") && null != request.getParameter("keyword")){
		serachPageing = (int)Math.ceil((double)(boardDao.searchArticlePage(request.getParameter("keyword"), request.getParameter("type")) / 5)) + 1;	// 검색 전체 페이지 크기 
		pageContext.setAttribute("serachPageing", serachPageing);
	}

	if(null != request.getParameter("pageNum")){
		nowPageNum = Integer.parseInt(request.getParameter("pageNum"));
	}
	
	if(null != request.getParameter("serchPageNum")){
		nowPageNum = Integer.parseInt(request.getParameter("serchPageNum"));
	}
	pageContext.setAttribute("nowPageNum", nowPageNum);
	
	listNo = (nowPageNum - 1) / 3;
	pageContext.setAttribute("listNo", listNo);
	
	pageBeginNum = (listNo * 3) + 1;
	pageContext.setAttribute("pageBeginNum", pageBeginNum);
	
	pageContext.setAttribute("boardList", boardList);
	
	searcType = request.getParameter("type");
	searckeyword = request.getParameter("keyword");
	
	if(null != searcType && null != searckeyword){
		boardList = boardDao.searchArticle(searckeyword, searcType, nowPageNum);
	}else{
		boardList = boardDao.getList(nowPageNum);	// 현재 페이지의 게시판 리스트를 가져옴
	}
	pageContext.setAttribute("boardList", boardList);
%>


<div class="contentView">
	<div class="boardPageTitle">자유 게시판</div>
	<div class="boardDiv">
		<table class="boardTable">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>작성 IP</th>
					<th>조회</th>
				</tr>
			</thead>
			
<c:if test="${empty searcType && empty searckeyword}">
	<c:forEach items="${boardList }" var="boardList">
	</c:forEach>

</c:if>
<%
	// 검색 게시판, 여기까지헀음
	if(null != searcType && null != searckeyword){
		boardList = boardDao.searchArticle(searckeyword, searcType, nowPageNum);
		
		for(Board result : boardList){
		articleNum--;
%>
			<tbody>
					<tr>
						<td class="boardNum" ><%=articleNum + ((nowPageNum - 1) * 5)%></td>
						<td class="boardTitle">
<%
	for(int i = 0; i < Integer.parseInt(result.getStep_no()); i++){
%>
						<img alt="" style="height:16px;" src="../../images/forward.png">
<%
	}
%>
						<a href="boardRead.jsp?article_id=<%=result.getArticle_id() %>"><%=result.getSubject() %></a></td>
						<td class="boardWriter"><%=result.getWriter() %></td>
						<td class="boardDate"><%=result.getRegdate() %></td>
						<td class="boardIP"><%=result.getIp() %></td>
						<td class="boardViews"><%=result.getHitcount() %></td>
					</tr>
			</tbody>
<%
		}
%>
		</table>
		<div class="boardFooter">
			<div class="boardSearch">
				<form action="boardList.jsp" method="get">
					<select name="type">
						<option value="title">글제목</option>
						<option value="content">글내용</option>
						<option value="writer">작성자</option>
					</select> <input type="text" name="keyword"> <input class="btn"
						type="submit" value="검색">
				</form>
			</div>
			<div class="boardWrite">
				<button class="btn" onclick="movePageIndex();">첫 화면으로</button>
		<c:if test="${not empty cookie.loginId }">
				<button class="btn" onclick="movePageWirte();">글쓰기</button>
		</c:if>
			</div>
			<div class="boardPageing">
				<ul>
			
					<li><a href="boardList.jsp?serchPageNum=1&type=<%=searcType%>&keyword=<%=searckeyword%>">처음으로</a></li>
<% 
	if(listNo > 0){
%>
					<li><a href="boardList.jsp?serchPageNum=<%=((listNo - 1) * 3) + 1 %>&type=<%=searcType%>&keyword=<%=searckeyword%>">&lt;&lt;</a></li>
<%
	}

	if(nowPageNum > 1){
%>
					<li><a href="boardList.jsp?serchPageNum=<%=nowPageNum - 1 %>&type=<%=searcType%>&keyword=<%=searckeyword%>">&lt;</a></li>
<%
	}
	
	for(int i = 1; i <= 3; i++){
		if((listNo * 3) + i <= serachPageing){
			if(nowPageNum == (listNo * 3) + i){
%>	
					<li><a style="border: 2px solid red;" href="boardList.jsp?serchPageNum=<%=(nowPageNum * 3) + i %>&type=<%=searcType%>&keyword=<%=searckeyword%>" ><%=(listNo * 3) + i %></a></li>
<%
			}else{
%>
					<li><a href="boardList.jsp?serchPageNum=<%=(listNo * 3) + i %>&type=<%=searcType%>&keyword=<%=searckeyword%>"><%= (listNo * 3) + i %></a></li>
<%
			}
		}
	}

	if(nowPageNum < serachPageing){
%>
					<li><a href="boardList.jsp?serchPageNum=<%=nowPageNum + 1 %>&type=<%=searcType%>&keyword=<%=searckeyword%>">&gt;</a></li>
<%
	}
	
	if(listNo < ((serachPageing - 1) / 3)){
%>
					<li><a href="boardList.jsp?serchPageNum=<%=((listNo + 1) * 3) + 1%>&type=<%=searcType%>&keyword=<%=searckeyword%>">&gt;&gt;</a></li>
<% 
	}
%>
					<li><a href="boardList.jsp?serchPageNum=<%=serachPageing %>&type=<%=searcType%>&keyword=<%=searckeyword%>">끝으로</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<%
	}else {
		//-------------------------------- 일반 게시판 글
		for (Board result : boardList) {
			articleNum--;
%>
			<tbody>
					<tr>
						<td class="boardNum" ><%=articleNum + ((nowPageNum - 1) * 5)%></td>
						<td class="boardTitle">
<%
	for(int i = 0; i < Integer.parseInt(result.getStep_no()); i++){
%>
						<img alt="" style="height:16px;" src="../../images/forward.png">
<%
	}
%>
						<a href="boardRead.jsp?article_id=<%=result.getArticle_id() %>"><%=result.getSubject() %></a></td>
						<td class="boardWriter"><%=result.getWriter() %></td>
						<td class="boardDate"><%=result.getRegdate() %></td>
						<td class="boardIP"><%=result.getIp() %></td>
						<td class="boardViews"><%=result.getHitcount() %></td>
					</tr>
			</tbody>
<%
		}
%>
		</table>
		<div class="boardFooter">
			<div class="boardSearch">
				<form action="boardList.jsp" method="get">
					<select name="type">
						<option value="title">글제목</option>
						<option value="content">글내용</option>
						<option value="writer">작성자</option>
					</select>
					<input type="text" name="keyword">
					<input class="btn" type="submit" value="검색">
				</form>
			</div>
			<div class="boardWrite">
				<button class="btn" onclick="movePageIndex();">첫 화면으로</button>
			<c:if test="${not empty cookie.loginId }">
				<button class="btn" onclick="movePageWirte();">글쓰기</button>
			</c:if>
			</div>
			<div class="boardPageing">
				<ul>
					<li><a href="boardList.jsp?pageNum=1">처음으로</a></li>
<% 
	if(listNo > 0){
%>
					<li><a href="boardList.jsp?pageNum=<%=((listNo - 1) * 3) + 1 %>">&lt;&lt;</a></li>
<%
	}

	if(nowPageNum > 1){
%>
					<li><a href="boardList.jsp?pageNum=<%=nowPageNum - 1 %>">&lt;</a></li>
<%
	}
	for(int i = 1; i <= 3; i++){
		if((listNo * 3) + i <= pageing){
			if(nowPageNum == (listNo * 3) + i){
%>	
					<li><a style="border: 2px solid red;" href="boardList.jsp?pageNum=<%=(listNo * 3) + i %>" ><%=(listNo * 3) + i %></a></li>
<%
			}else{
%>
					<li><a href="boardList.jsp?pageNum=<%= (listNo * 3) + i %>"><%= (listNo * 3) + i %></a></li>
<%
			}
		}
	}
	if(nowPageNum < pageing){
%>
					<li><a href="boardList.jsp?pageNum=<%=nowPageNum + 1 %>">&gt;</a></li>
<%
	}
	
	if(listNo < ((pageing - 1) / 3)){
%>
					<li><a href="boardList.jsp?pageNum=<%=((listNo + 1) * 3) + 1%>">&gt;&gt;</a></li>
<% 
	}
%>
					<li><a href="boardList.jsp?pageNum=<%=pageing %>">끝으로</a></li>
					
				</ul>
			</div>
		</div>
	</div>
</div>
<%
}
%>