<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>title</title>
</head>
<body>


${"바보<바보>입니다." }<br>
<c:out value="바보<바보>입니다." escapeXml="true"/><br>
${param.id }
<c:out value="${param.id}" default="guest"/>

<c:out value="${param.id }">
	이야호
</c:out>

</body>
</html>