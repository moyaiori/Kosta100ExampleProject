<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>jstl for example</title>
</head>
<body>

<c:forEach var="i" begin="0" end="10" varStatus="status">
	${status.index }, ${status.count }이광용입니다. <br>
</c:forEach>


<h2>구구단</h2>
<table border="1">
<c:forEach var="i" begin="2" end="9">
	<tr>
	<c:forEach var="j" begin="2" end="9">
		<td>${i } * ${j } = ${i * j }</td>
	</c:forEach>
	</tr>
</c:forEach>
</table>
</body>
</html>