<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8"">
<title>title</title>
<script type="text/javascript">
window.onload = function(){
	//alert("조금 쉬었다가 합니까?");
}
</script>
<%
	application.setAttribute("globalMessage", "hello");
	String fontSize = application.getInitParameter("fontSize");
%>

</head>
<body style="font-family: 나눔고딕코딩; font-size: <%= fontSize %>;">

요청방식 : <%=request.getMethod() %><br>
요청URL : <%=request.getRequestURL() %><br>
프로토콜 : <%=request.getProtocol() %><br>
브라우저 아이피 : <%=request.getRemoteHost() %><br>
요청 파라미터 : <%=request.getParameter("name") %><br>

<%
//response.sendRedirect("http://www.naver.com");
//response.sendError(HttpServletResponse.SC_BAD_REQUEST);
%>

<%
//	session.setAttribute("loginId", "moya");
%>
<%= config.getInitParameter("private")%>

</body>
</html>