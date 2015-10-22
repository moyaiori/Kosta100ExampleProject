<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
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
%>
<div class="loginView">
<%
	if(loginId == null){
%>
	<div class="loginHeaer">로 그 인</div>
	<div class="loginBox">
		<form action="/view/menus/loginProc.jsp" method="post">
			<input type=text class="loginTF" name="id" id="id" size=15	placeholder="아이디">
			<input type=password class="loginTF" name="passwd" name="passwd" size=15 placeholder="비밀번호">
			<div class="loginButtonBox">
				<input class="btnLogin" type="submit" value="로그인">&nbsp;
				<button class="btnLogin" onclick="location.href='/view/join/join.jsp'; return false;">회원가입</button>
			</div>
		</form>
	</div>
<%
	}else{
%>
	<div class="loginHeaer">
	<%=loginId %> 님
	</div>
	<div class="loginBox">
		환영합니다.
	</div>
	<div class="loginButtonBox">
		<button class="btnLogin" onclick="location.href='/view/menus/loginProc.jsp'; return false;">로그아웃</button>
	</div>
<%
	}	 
%>
</div>