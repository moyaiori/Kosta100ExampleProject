<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>title</title>
</head>
<body>

<c:catch var="exception">
<%
	String message = null;
	message.toString();
%>
</c:catch>

예외내용 : ${exception }

</body>
</html>