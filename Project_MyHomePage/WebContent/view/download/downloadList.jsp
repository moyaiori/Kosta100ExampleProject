<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/style/index.css">
<title>kosta 100 Lee HomePage(download)</title>
</head>
<body>
	<jsp:include page="/view/menus/header.jsp"></jsp:include>
	<div class="mainView">
		<jsp:include page="downloadListContent.jsp"></jsp:include>
		<jsp:include page="/view/menus/login.jsp"></jsp:include>
		<jsp:include page="/view/menus/side.jsp"></jsp:include>
	</div>
	<jsp:include page="/view/menus/footer.jsp"></jsp:include>
</body>
</html>