<%@page import="kr.or.kosta.user.domain.User"%>
<%@page import="kr.or.kosta.user.dao.JdbcUserDao"%>
<%@page import="kr.or.kosta.user.dao.UserDao"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory.DaoFactoryType"%>
<%@page import="kr.or.kosta.common.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="user" class="kr.or.kosta.user.domain.User" scope="session"/>
<jsp:setProperty property="*" name="user"/>

<%
	DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.JDBC);
	UserDao userDao = (UserDao)factory.getDao(JdbcUserDao.class);
	userDao.add(user);
%>

<%
	response.sendRedirect("/");
%>
