<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>회원가입결과</title>
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
    <table border="1">
      <tr>
        <td colspan="4" align="center">${name }회원가입을 축하합니다.</td>
      </tr>
      
      <tr>
        <td>아이디</td>
        <td>
        	${user.id }
        </td>
      </tr>
      
	  <tr>
	    <td>이름</td>
        <td>
        	${user.name }
        </td>
	  </tr>
	  
	  <tr>
	    <td>비밀번호</td>
        <td>
        	${user.passwd }
        </td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	    <button onclick="location.href='../index.mall'" >홈으로</button>
	    </td>
	  </tr>
	</table>
</div>
</body>
</html>

