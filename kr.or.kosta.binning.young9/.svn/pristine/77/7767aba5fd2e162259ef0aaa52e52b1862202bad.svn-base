<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<table align="center">
	<caption>회원목록</caption>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
	</tr>
	<c:forEach items="${list}" var="user">
	<tr>
		<td>${user.id}</td>
		<td>${user.passwd}</td>
		<td>${user.name}</td>
	</tr>	
	</c:forEach> 
</table>

</body>
</html>