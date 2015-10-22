<%@page import="kr.or.kosta.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="some" value="ifExample.jsp">
	<c:param name="id" value="moya"/>
</c:url>

<%--
<c:redirect url="${some }"/>
<jsp:forward page="${some }"></jsp:forward> 
 --%>
 
 <a href="${some }">이동</a>
 
 
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>jstl url example</title>
</head>
<body>

</body>
</html>