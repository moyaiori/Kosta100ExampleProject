<%@ page contentType="text/html; charset=utf-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Spring MVC 실습 메인페이지 입니다..  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>웹애플리케이션 이름 : ${context }</P>
<P>요청 URL : ${url }</P>
<P>이전 페이지 URL : ${referer}</P>
</body>
</html>
