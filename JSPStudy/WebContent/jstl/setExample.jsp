<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="user" class="kr.or.kosta.user.domain.User" scope="request"/>

<c:set var="name" value="이광용" scope="request"/>
<c:set var="age" value="${10 }" scope="request"/>

<c:set target="${user }" property="id" value="moya"></c:set>
<c:remove var="name"/>
<c:set target="${user }" property="passwd" value="1111"></c:set>

<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>title</title>
</head>
<body>

이름 : ${name}<br>
나이 : ${age}<br>
아이디 : ${user.id }<br>
비밀번호 : ${user.passwd }


</body>
</html>