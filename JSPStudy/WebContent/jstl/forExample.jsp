<%@page import="kr.or.kosta.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	List<String> names = new ArrayList<String>();
	names.add("김");
	names.add("이");
	names.add("박");
	
	request.setAttribute("names", names);
	
	
	List<User> users = new ArrayList<User>();
	users.add(new User("1", "11", "111"));
	users.add(new User("2", "22", "222"));
	users.add(new User("3", "33", "333"));
	
	request.setAttribute("users", users);
%>

<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>jstl for example</title>
</head>
<body>

<ul>
	<c:forEach items="${names }" var="name">
		<li>${name }</li>
	</c:forEach>
</ul>

<table border="1">
	<tr>
		<td>id</td>
		<td>name</td>
		<td>passwd</td>
	</tr>
	<c:forEach var="user" items="${users }">
		<tr>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.passwd }</td>
		</tr>
	</c:forEach>
</table>


<%
	request.setAttribute("user", "이름,비밀번호,아이디,나이");
%>

<c:forTokens items="user" delims=",">
	${user }<br>
</c:forTokens>

</html>