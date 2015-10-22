<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page isELIgnored="true" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>title</title>
</head>
<body><body>
<%
// 테스트를 위한 Scope객체에 데이터 저장
String today = String.format("%1$tF %1$tT", Calendar.getInstance());
request.setAttribute("today", today);

session.setAttribute("id", "bangry");

String[] names = {"김기정", "박기정", "최기정"};
application.setAttribute("list", names);

%>

${requestScope.today}<br>
${today}<br>

${id}<br>

${list[0]}, ${list[1]}, ${list[2]}<br><%--
<jsp:getProperty property="id" name="student"/>
<jsp:getProperty property="name" name="student"/>
<jsp:getProperty property="dog" name="student"/>
--%>
${student.id},
${student.name}, 
${student.dog.name}<br>

</body>
</html>