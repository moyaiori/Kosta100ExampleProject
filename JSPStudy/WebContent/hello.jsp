<%@page import="java.util.Calendar"%>
<%@page contentType="text/html; charset=utf-8" %>

<%!
	String message = "JSP 쉽네요";
	public String getMessage(String message){
		return message;
	}
%>

<%@ include file="external.jspf" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>

최초로 작성되는 JSP입니다.<br>

<% 
Calendar today = Calendar.getInstance();
String str = String.format("%1$tF %1$tT", today);
out.println(str);
%>

정적인 HTML 데이터 입니다..<br>
<table width="80%" border="1">
<%
for(int i=1; i <= 9; i++){
	out.println("<tr>");
	for(int j =1; j <= 9; j++){
		out.println("<td>" + i + " * " + j + " = " + i * j + "</td>");
	}
	out.println("</tr>");
}
%>


<%=message%>
</table>
</body>
</html>