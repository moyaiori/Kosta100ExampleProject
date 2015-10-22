<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <table border="1">
      <tr>
        <td colspan="4" align="center">◈ 회원 목록 ◈</td>
      </tr>
      
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>비밀번호</th>
      </tr>
      <c:forEach items="${list }" var="list">
		  <tr>
		  	<td>${list.id }</td>
		  	<td>${list.name }</td>
		  	<td>${list.passwd }</td>
		  </tr>
      </c:forEach>
	  
	  <tr>
	    <td colspan="3" align="center">
	    <button onclick="location.href='../index.mall'" >홈으로</button>
	    </td>
	  </tr>
	</table>
</div>