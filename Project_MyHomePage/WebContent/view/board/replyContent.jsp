<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>
<script type="text/javascript" src="../../js/main.js"></script>

<%
	request.setCharacterEncoding("utf-8");

	String articleId = request.getParameter("article_id");
	String replyTitle = request.getParameter("title");
	

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
%>

<div class="contentView">
	<div class="boardPageTitle">답글 쓰기</div>
<form action="boardReplyProc.jsp"  method="post">
	<table class="boardWriteTable">
		<tr>
			<th class="boardWriteTitle" colspan="4">※ 비밀번호는 글 수정, 삭제시 필요합니다.</th>
		</tr>
		<tr>
			<td>글제목</td>
			<td><input type="text" name="subject" value="[RE]<%=replyTitle %>" /></td>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" size="30"/></td>
		</tr>

		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" value="<%=loginId %>" size="30" disabled /></td>
			<td>이메일</td>
			<td><input type="text" name="email" size="30" value="<%=email %>" disabled></td>
		</tr>

		<tr>
			<td>글내용</td>
			<td colspan="3"><textarea name="content" class="boardWriteTextArea"></textarea></td>
		</tr>

		<tr>
			<td colspan="4">
				<button class="btn" style="float: left;" onclick="movePageBoardList(); return false;">목록으로</button>
				<input type="hidden" name="article_id" value="<%=articleId%>">
				<input class="btn" style="float: right;" type="submit" value="글쓰기">
			</td>
		</tr>
	</table>
</form>
</div>