<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>KOSTA - 회원가입 화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
    body {
	  font-family: '돋움' Century Gothic, Arial, Serif;
	}
	
	table {
	  border-collapse: collapse;
	  width: 300px;
	  margin: 30px auto;
    }
    
    td {
      background-color: #F7F7F7;
	  border: solid 1px silver;
	  padding: 10px 10px;
	}	
</style>
</head>
<body>
<div>
  <form action="registProc.jsp" method="post">
    <table border="1">
      <tr>
        <td colspan="4" align="center">◈ 회원 가입 ◈</td>
      </tr>
      
      <tr>
        <td>아이디</td>
        <td>
          <input type="text" name="id" size="8"> 
        </td>
      </tr>
      
	  <tr>
	    <td>이름</td>
	    <td><input type="text" name="name"  size="8"/></td>
	  </tr>
      
	  <tr>
	    <td>비밀번호</td>
	    <td><input type="password" name="passwd"  size="8"/></td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	      <input type="submit" value="회원가입"/>
	      <input type="reset" value="다시작성" />
	    </td>
	  </tr>
	</table>
  </form>
</div>
</body>
</html>

