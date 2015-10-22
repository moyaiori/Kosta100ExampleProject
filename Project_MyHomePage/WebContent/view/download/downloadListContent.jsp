<%@page import="kr.or.kosta.download.dao.DownloadDao"%>
<%@page import="kr.or.kosta.download.dao.JdbcDownloadDao"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="kr.or.kosta.user.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.board.dao.JdbcBoardDao"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@page contentType="text/html; charset=utf-8"%>
<script type="text/javascript" src="../../js/main.js"></script>

<div class="contentView">
	<div class="boardPageTitle">자료실</div>
	<div class="boardDiv">
		<table class="boardTable">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>첨부파일</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>작성 IP</th>
					<th>조회</th>
				</tr>
			</thead>
<%
	request.setCharacterEncoding("utf-8");
	
	List<Board> boardList = null;
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	DownloadDao boardDao = (DownloadDao)factory.getDao(JdbcDownloadDao.class);
	
	String loginId = null;

	// 쿠키 읽기
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
			}
		}
	}
	
	
	int pageing = (int)Math.ceil((double)(boardDao.getPageNum() / 5)) + 1;	// 전체 페이지 크기
	int serachPageing = 0;
	if(null != request.getParameter("type") && null != request.getParameter("keyword")){
		serachPageing = (int)Math.ceil((double)(boardDao.searchArticlePage(request.getParameter("keyword"), request.getParameter("type")) / 5)) + 1;	// 검색 전체 페이지 크기 
	}
	int nowPageNum = 1;						// 현재 페이지 번호
		
	
	if(null != request.getParameter("pageNum")){
		nowPageNum = Integer.parseInt(request.getParameter("pageNum"));
	}
	
	if(null != request.getParameter("serchPageNum")){
		nowPageNum = Integer.parseInt(request.getParameter("serchPageNum"));
	}
	

	int listNo = 0;
	listNo = (nowPageNum - 1) / 3;
	int pageBeginNum = 0;
	pageBeginNum = (listNo * 3) + 1;

	boardList = boardDao.getList(nowPageNum);	// 현재 페이지의 게시판 리스트를 가져옴
	
	
	String searcType = null;
	String searckeyword = null;
	
	searcType = request.getParameter("type");
	searckeyword = request.getParameter("keyword");

	int articleNum = 6;		// 게시판 인덱스 넘버
	// 검색 게시판
	if(null != searcType && null != searckeyword){
		System.out.println("type : " + request.getParameter("type"));
		System.out.println("keyword : " + request.getParameter("keyword"));

		boardList = boardDao.searchArticle(searckeyword, searcType, nowPageNum);
		
		for(Board result : boardList){
		articleNum--;
%>

			<tbody>
					<tr>
						<td class="boardNum" ><%=articleNum + ((nowPageNum - 1) * 5)%></td>
						<td class="boardTitle"><a href="downloadRead.jsp?article_id=<%=result.getArticle_id() %>"><%=result.getSubject() %></a></td>
						<td class="boardDownload"><%=result.getFile() %></td>
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
				<form action="downloadList.jps" method="get">
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
<%
	if(loginId != null){
%>
				<button class="btn" onclick="movePageWirte_DL();">글쓰기</button>
<%
	}
%>				
			</div>
			<div class="boardPageing">
				<ul>
			
					<li><a href="downloadList.jps?serchPageNum=1&type=<%=searcType%>&keyword=<%=searckeyword%>">처음으로</a></li>
<% 
	if(listNo > 0){
%>
					<li><a href="downloadList.jps?serchPageNum=<%=((listNo - 1) * 3) + 1 %>&type=<%=searcType%>&keyword=<%=searckeyword%>">&lt;&lt;</a></li>
<%
	}

	if(nowPageNum > 1){
%>
					<li><a href="downloadList.jps?serchPageNum=<%=nowPageNum - 1 %>&type=<%=searcType%>&keyword=<%=searckeyword%>">&lt;</a></li>
<%
	}
	
	for(int i = 1; i <= 3; i++){
		if((listNo * 3) + i <= serachPageing){
			if(nowPageNum == (listNo * 3) + i){
%>	
					<li><a style="border: 2px solid red;" href="downloadList.jps?serchPageNum=<%=(nowPageNum * 3) + i %>&type=<%=searcType%>&keyword=<%=searckeyword%>" ><%=(listNo * 3) + i %></a></li>
<%
			}else{
%>
					<li><a href="downloadList.jps?serchPageNum=<%=(listNo * 3) + i %>&type=<%=searcType%>&keyword=<%=searckeyword%>"><%= (listNo * 3) + i %></a></li>
<%
			}
		}
	}

	if(nowPageNum < serachPageing){
%>
					<li><a href="downloadList.jps?serchPageNum=<%=nowPageNum + 1 %>&type=<%=searcType%>&keyword=<%=searckeyword%>">&gt;</a></li>
<%
	}
	
	if(listNo < ((serachPageing - 1) / 3)){
%>
					<li><a href="downloadList.jps?serchPageNum=<%=((listNo + 1) * 3) + 1%>&type=<%=searcType%>&keyword=<%=searckeyword%>">&gt;&gt;</a></li>
<% 
	}
%>
					<li><a href="downloadList.jps?serchPageNum=<%=serachPageing %>&type=<%=searcType%>&keyword=<%=searckeyword%>">끝으로</a></li>
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
						<td class="boardTitle"><a href="downloadRead.jsp?article_id=<%=result.getArticle_id() %>"><%=result.getSubject() %></a></td>
						<td class="boardDownload"><%=result.getFile() %></td>
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
				<form action="downloadList.jsp" method="get">
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
<%
	if(loginId != null){
%>
				<button class="btn" onclick="movePageWirte_DL();">글쓰기</button>
<%
	}
%>				
			</div>
			<div class="boardPageing">
				<ul>
					<li><a href="downloadList.jps?pageNum=1">처음으로</a></li>
<% 
	if(listNo > 0){
%>
					<li><a href="downloadList.jps?pageNum=<%=((listNo - 1) * 3) + 1 %>">&lt;&lt;</a></li>
<%
	}

	if(nowPageNum > 1){
%>
					<li><a href="downloadList.jps?pageNum=<%=nowPageNum - 1 %>">&lt;</a></li>
<%
	}
	for(int i = 1; i <= 3; i++){
		if((listNo * 3) + i <= pageing){
			if(nowPageNum == (listNo * 3) + i){
%>	
					<li><a style="border: 2px solid red;" href="downloadList.jps?pageNum=<%=(listNo * 3) + i %>" ><%=(listNo * 3) + i %></a></li>
<%
			}else{
%>
					<li><a href="downloadList.jps?pageNum=<%= (listNo * 3) + i %>"><%= (listNo * 3) + i %></a></li>
<%
			}
		}
	}
	if(nowPageNum < pageing){
%>
					<li><a href="downloadList.jps?pageNum=<%=nowPageNum + 1 %>">&gt;</a></li>
<%
	}
	
	if(listNo < ((pageing - 1) / 3)){
%>
					<li><a href="downloadList.jps?pageNum=<%=((listNo + 1) * 3) + 1%>">&gt;&gt;</a></li>
<% 
	}
%>
					<li><a href="downloadList.jps?pageNum=<%=pageing %>">끝으로</a></li>
					
				</ul>
			</div>
		</div>
	</div>
</div>
<%
}
%>