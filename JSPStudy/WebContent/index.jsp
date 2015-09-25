<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
String loginId = null;
String saveId = "";

// 쿠키 읽기
Cookie[] cookies = request.getCookies();

if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("loginId")) {
			loginId = URLDecoder.decode(cookie.getValue(), "utf-8");
		}
		
		if (cookie.getName().equals("saveId")) {
			saveId = URLDecoder.decode(cookie.getValue(), "utf-8");
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영합니다</title>
</head>
<body>

<%
if(loginId == null){
%>
<form action="user/login.jsp" method="post">
<label>아이디 : <input type="text" name="id" placeholder="아이디" value="<%=saveId %>" style="line-height: 15px;"></label><br>
<label>비밀번호 : <input type="password" name="passwd" placeholder="비밀번호" style="line-height: 15px;"></label><br>
<label>아이디 저장 : <input type="checkbox" name="savecb" value="true" ></label><br>
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>
<a href="user/regist.jsp">회원가입</a>
<%
}else{
%>
<%=loginId %>님 로그인 <a href="user/login.jsp">로그아웃</a>
<%
}
%>


</body>
</html>