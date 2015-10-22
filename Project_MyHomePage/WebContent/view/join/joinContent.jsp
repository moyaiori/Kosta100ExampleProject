<%@page contentType="text/html; charset=utf-8"%>
<script type="text/javascript">


function checkTF(){
	if(document.joinForm.name.value==""){
		alert("이름을 입력하세요");
		document.joinForm.name.focus();
		return false;
		
	}else if(document.joinForm.id.value==""){
		alert("아이디를 입력하세요"); 
		document.joinForm.id.focus(); 
		return false;
		
	}else if(document.joinForm.passwd.value==""){
		alert("비밀번호를 입력하세요");
		document.joinForm.passwd.focus();
		return false;
		
	}else if(document.joinForm.passwd_check.value==""){
		alert("비밀번호확인을 입력하세요");
		document.joinForm.passwd_check.focus();
		return false;
		
	}else if(document.joinForm.email.value==""){
		alert("이메일을 입력하세요");
		document.joinForm.email.focus();
		return false;
		
	}else if(document.joinForm.mobile2.value==""){
		alert("휴대번호 앞자리를 입력하세요");
		document.joinForm.email.focus();
		return false;
		
	}else if(document.joinForm.mobile3.value==""){
		alert("휴대번호 뒷자리를 입력하세요");
		document.joinForm.email.focus();
		return false;
		
	}
	
	if(document.joinForm.passwd.value!=document.joinForm.passwd_check.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.joinForm.passwd.focus();
		return false;
		
	}
	
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
	if(exptext.test(document.joinForm.email.value)==false){
		alert("이 메일형식이 올바르지 않습니다.");
		document.joinForm.email.focus();
		return false;
	}
	
	alert("회원가입이 정상적으로 처리되었습니다");
	document.joinForm.submit();
	
}

</script>
<div class="contentView">
	<h1>회 원 가 입</h1>
	<form action="/view/join/joinProc.jsp" method="post" name="joinForm">
		<table style="border-collapse: collapse;">
			<tbody class="joinTableBody">
				<tr>
					<th>이름</th>
					<td><input type="text" placeholder="홍길동" name="name"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" placeholder="hong" name="id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="passwd_check"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email"></tr>
				<tr>
					<th>휴대번호</th>
					<td>
						<select name="mobile1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
						</select> - 
						<input class="telTF" type="tel" name="mobile2">	- 
						<input class="telTF" type="tel" name="mobile3">
					</td>
				</tr>
				<tr>
					<th style="border-bottom: 0px solid">자기소개</th>
					<td style="border-bottom: 0px solid"><textarea
							style="resize: none" cols="60" rows="10"
							placeholder="간략한 자기소개를 작성해주세요" name="profile"></textarea></td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: center">
			<input type="button" value="회원가입" onclick="checkTF()">
			&nbsp;&nbsp;
			<input type="reset" value="초기화">
		</div>
	</form>
</div>