<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>title</title>
</head>
<body>

<%-- EL에서의 리터럴 --%>
${'싱글 쿼트로도 출력이되요'}<br>
${"EL이 머예요?"}<br>
${'EL을 왜 써요?'}<br>
${100}<br>
${100.56}<br>
${true}<br>
${false}<br>
${null}<br>
<%--<%=null --%><br>

<%-- EL 연산자 --%>
${10 + 20}<br>
<%=100 + "200" %><br>
${100 + "200"}<br>
100을 3으로 나눈 나머지값 : ${100 mod 3 }<br>
${300 == 300 }, ${300 eq 300 }<br>
${100 > 50 ? "크다" : "작다" }<br>


</body>
</html>