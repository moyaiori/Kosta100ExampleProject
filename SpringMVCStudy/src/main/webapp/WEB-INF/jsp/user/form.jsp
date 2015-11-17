<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>title</title>
</head>
<body>
<h2>회원가입 화면 입니다.</h2>

<form action="/user/regist" method="post">
	<div>아이디<input type="text" name="id"></div>
	<div>비밀번호<input type="password" name="passwd"></div>
	<div>이름<input type="text" name="name"></div>
	<div><input type="submit"></div>
</form>

</body>
</html>