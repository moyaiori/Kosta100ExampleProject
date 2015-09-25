<%@page import="kr.or.kosta.user.domain.User"%>
<%@page import="kr.or.kosta.user.dao.JdbcUserDao"%>
<%@page import="kr.or.kosta.user.dao.UserDao"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:useBean id="user" class="kr.or.kosta.user.domain.User" scope="session"/>
<jsp:setProperty property="*" name="user"/>

<%
	request.setCharacterEncoding("utf-8");
	//String id = request.getParameter("id");
	//String name = request.getParameter("name");
	//String passwd = request.getParameter("passwd");
	
	//User user = new User(id, name, passwd);
	
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	UserDao userDao = (UserDao)factory.getDao(JdbcUserDao.class);
	userDao.add(user);
	
	//request.setAttribute("user", user);
	//request.getRequestDispatcher("registResult.jsp").forward(request, response);
%>

<jsp:forward page="registResult.jsp">
	<jsp:param value="kosta" name="company"/>
</jsp:forward>







