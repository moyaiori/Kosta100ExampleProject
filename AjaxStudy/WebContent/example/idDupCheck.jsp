<%@ page contentType="text/html; charset=utf-8" %>
<%
String id = request.getParameter("id");
// DB 연동 생략^^
// bangry는 존재한다는 가정..
if(id.equals("bangry") || id.equals("killer")){
%>
true
<%	
}else{
%>
false
<%	
}
%>