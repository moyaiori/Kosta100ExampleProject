<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8"">
<title>title</title>
</head>
<body style="font-family: 나눔고딕코딩; font-size: 20px;">

<%
	//String id = (String)session.getAttribute("loginId");
	String message = (String)application.getAttribute("globalMessage");
	
%>

<%= message %>
</body>
</html>