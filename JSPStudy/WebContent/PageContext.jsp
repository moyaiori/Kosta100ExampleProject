<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8"">
<title>title</title>
</head>
<body>

<%
	//pageContext.setAttribute("", "");
	//pageContext.getAttribute("");
	//pageContext.removeAttribute("");
	
	pageContext.setAttribute("globalMessage", "허얼...", PageContext.APPLICATION_SCOPE);
	
	out.print(pageContext.findAttribute("globalMessage"));
	out.print(application.getAttribute("globalMessage"));
%>

</body>
</html>