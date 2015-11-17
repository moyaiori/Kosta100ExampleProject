<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajax JSON 데이터 전송</title>
<script src="/js/jquery-2.1.3.js"></script>
<script>
$(function() {
	$("button").click(function(event){
		var user = {id:"bangry", name:"김기정", passwd:"1234"}; // user 객체
		// 객체를 JSON string으로 변환
		var userString = JSON.stringify(user);
		//var userJson = JSON.parse(userString);
		//alert(userString);

		$.ajax({
			url : "/user/json6",
			method: "post", // json은 post로 전송해야함
			dataType: "json", 
			data: userString,
			contentType: "application/json",
			success : function(object) {
				alert(object.name);
				alert(object.id);
				alert(object.passwd);
				setData(object);
			}
		});
		return false;
	});
	
	function setData(user){
		var userInfo = "";
		userInfo += "<h2>"+user.id+"</h2>";
		userInfo += "<h2>"+user.passwd+"</h2>";
		userInfo += "<h2>"+user.name+"</h2>";
		$("#message").html(userInfo);
	}
});
</script>
</head>
<body>
	<button>JSON 데이터 전송</button>
	<div id="message"></div>
</body>
</html>