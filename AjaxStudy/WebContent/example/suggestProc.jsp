<%@ page contentType="text/plain; charset=utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
request.setCharacterEncoding("utf-8");
String keyword = request.getParameter("keyword");
if(keyword == null) return;
//String keyword = "j";

// DB에 저장되어 있는 키워드 리스트
List<String> keywords = new ArrayList<String>();
keywords.add("Java");
keywords.add("Java 완벽 가이드");
keywords.add("Servlet");
keywords.add("Servlet 완벽 정복");
keywords.add("JSP");
keywords.add("JSP Note");
keywords.add("JSP를 자바라");
keywords.add("HTML");
keywords.add("CSS");
keywords.add("JavaScript");
keywords.add("XML");
keywords.add("Ajax");
keywords.add("jQuery");

keyword = keyword.toUpperCase();
ArrayList<String> suggestList = new ArrayList<String>();
for(String key : keywords){
	if(key.toUpperCase().startsWith(keyword)){
		suggestList.add(key);				
	}
}
%>
{
   "count":<%= suggestList.size()%>,
   "list":[
   <% 
	for(int i=0; i<suggestList.size(); i++){
		if(i == suggestList.size()-1){
		%>
		"<%=suggestList.get(i) %>"
		<%			
		}else{
		%>
		"<%=suggestList.get(i)%>",
		<%			
		}
	%>
	<%		
	}
   %>
   ]
}


