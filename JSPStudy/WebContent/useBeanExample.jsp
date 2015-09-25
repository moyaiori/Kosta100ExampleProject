<%@ page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="user" class="kr.or.kosta.user.domain.User" scope="session"/>
<jsp:setProperty property="id" name="user" value="moyas"/>
<jsp:setProperty property="name" name="user" value="이광용"/>
<jsp:setProperty property="passwd" name="user" value="1111"/>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

아이디 : <jsp:getProperty property="id" name="user"/><br>
이름 : <jsp:getProperty property="name" name="user"/><br>
비밀번호 : <jsp:getProperty property="passwd" name="user"/><br>


</body>
</html>