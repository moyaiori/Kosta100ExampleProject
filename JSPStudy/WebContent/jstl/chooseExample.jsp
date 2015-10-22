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

<c:choose>
	<c:when test="${score >= 90 }">
		수 입니다.
	</c:when>
	<c:when test="${score >= 80 }">
		우 입니다.
	</c:when>
	<c:when test="${score >= 70 }">
		미 입니다.
	</c:when>
	<c:when test="${score >= 60 }">
		양 입니다.
	</c:when>
	<c:otherwise>
		가 입니다.
	</c:otherwise>
</c:choose>


<c:choose>
	<c:when test="${empty cookie.loginId }">
		로그인을 해주십시오.
	</c:when>
	<c:otherwise>
		${cookie.loginid } 님이 로그인 중입니다.
	</c:otherwise>
</c:choose>


</body>
</html>