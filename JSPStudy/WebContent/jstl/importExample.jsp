<%@page import="kr.or.kosta.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>jstl for example</title>
</head>
<body>
<%--<c:import url="forExample.jsp"/>--%>
<%--<c:import url="http://www.naver.com"/>--%>
<c:import url="http://www.naver.com" var="url">
	<c:param name="야호" value="야호"/>
</c:import>

<%--${url } --%>
<c:out value="${url }" escapeXml="false"/>

</body>
</html>