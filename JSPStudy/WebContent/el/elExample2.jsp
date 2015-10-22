<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>title</title>
</head>
<body>
<h2>EL의 11개 디폴트 객체들</h2>
${pageContext}<br>
요청방식 : ${pageContext.request.method}<br>
요청방식 : ${pageContext.request.requestURI}<br>
요청방식 : ${pageContext["request"].protocol}<br>

${pageScope}<br>
<%
pageContext.setAttribute("id", "Bangry");
%>
<%=pageContext.getAttribute("id") %><br>
${pageScope.id}<br>
${id}<br>

${requestScope}<br>
<%
request.setAttribute("name", "김기정");
%>
${requestScope.name}<br>


${sessionScope}<br>
${applicationScope}<br>

모든 스코프객체에서 검색 : ${name}<br>

<%=request.getParameter("id") %>
${param.id}<br>

${paramValues}<br>
${paramValues.hobby[0]},${paramValues.hobby[1]}

${header}<br>
브라우저 정보 : ${header["user-agent"]}<br>

${headerValues}<br>

${initParam}<br>
${initParam.message}<br>
${cookie}<br>
쿠키이름 : ${cookie.loginCookie.name}<br>
쿠키값 : ${cookie.loginCookie.value}




</body>
</html>