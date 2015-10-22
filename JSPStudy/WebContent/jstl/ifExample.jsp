<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="80"/>

<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>jstl if example</title>
</head>
<body>

<%
	if(60 < Integer.parseInt((String)pageContext.getAttribute("score"))){
%>
	패스입니다!!!
<%
	}else{
%>
	실패입니다!!!
<% 
	}
%>

<c:if test="${score >= 60 }">
성공입니다!!
</c:if>


<c:if test="${empty param.score}">
성공입니다!!
</c:if>

<c:if test="${not empty param.score}">
	<c:set var="score" value="${param.score }"/>
	<c:if test="${param.score > 60}">
	성공입니다!!
	</c:if>
</c:if>

<c:if test="${empty cookie.loginId }">
	폼 입력화면입니다..
</c:if>


</body>
</html>