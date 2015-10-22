<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${message }<br>

<ul>
	<c:forEach items="${list }" var="name">
		<li>${name }</li>
	</c:forEach>
</ul>
