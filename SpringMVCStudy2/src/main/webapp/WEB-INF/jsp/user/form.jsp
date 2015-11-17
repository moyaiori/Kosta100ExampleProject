<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>회원가입화면입니다..</h2>
<form action="/user/regist" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="passwd"><br>
이름 : <input type="text" name="name"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>