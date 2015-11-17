<%-- 웹컨테이너에 의해 발생하는 모든 에러내용을 보여주기 위한 JSP --%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isErrorPage="true" %>

<% response.setStatus(HttpServletResponse.SC_OK); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>서버 장애</title>
<link rel="stylesheet" type="text/css"
	href="../style/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="../style/bootstrap-theme.css.map">
<link rel="stylesheet" type="text/css"
	href="../style/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="../style/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../style/bootstrap.css.map">
<link rel="stylesheet" type="text/css" href="../style/bootstrap.min.css">
<style type="text/css">
* {margin:0;padding:0;}
#error_content {margin:0; padding:0;}
#error_content *{margin:0; padding:0; color:#444; list-style:none; font-size:15x; line-height:normal; font-family:돋움, Dotum, 굴림, Gulim, Helvetica, Sans-serif;}
#error_content img{border:none;}
#error_content a{text-decoration:none; color:#444;}
#error_content a:visited{text-decoration:none; color:#666;}
#error_content a:hover{text-decoration:underline;}
#error_content {width:600px; _width /**/:510px; height:700px; _height:208px; margin:0 auto; margin-top:50px; padding:0 0 0 0px; border:1px solid #e5e5e5;  }
#error_content h1 {margin:48px 0 14px 0; padding:0;}
#error_content p {margin:0; padding:0; color:#888; font:20px/1.5em 돋움,Dotum,Helvetica,sans-serif;}
#error_content p.btn {padding:15px 0 0 1px; font-size:0;}
#error_content p.btn img {margin-right:1px; *margin-right:1px;}
</style>
</head>
<body>
<div  style="background-color:rgb(198,214,239) " align="center" id="error_content">
		<img src="../images/error_500.jpg">
	<br/>
	<br/>
	<p>
		<input type="submit" value="이전 페이지" style="padding: 3px; border: 1px solid #ddd; margin: 5px 5px" onclick="history.back();" class="btn btn-default"/>
		<input type="button" value="홈 페이지" style="padding: 3px;  border: 1px solid #ddd;" onclick="location.href='/index.bins'" class="btn btn-default"/>
	</p>
	
	 <img src="../images/st_lov.gif"> 
	
</div>
</body>
</html>







