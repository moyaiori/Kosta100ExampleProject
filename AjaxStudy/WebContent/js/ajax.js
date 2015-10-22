/** Ajax 비동기 데이터 통신 */
function ajax(obj){
	var method = obj.method ? obj.method.toUpperCase() : "GET";
	var url = obj.url;
	var data =  obj.data; // name=value
	var callback = obj.callback;
	
	var xhr = createXMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				callback(xhr);
			}else if(xhr.status == 400 || xhr.status == 404){
				alert("요청한 페이지를 찾을 수 없습니다..");			
			}else{
				alert("서버장애로 서비스 할 수 없습니다..");	
			}
		}
	};
	
	if(method=="GET"){
		if(data) url += ("?" + data);
		xhr.open(method, url, true);
		xhr.send();
	}else{
		xhr.open(method, url, true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(data);
	}
}

function createXMLHttpRequest(){
	var xhr = null;
	try{
		xhr = new XMLHttpRequest();
	}catch(e){
		xhr = new ActiveXObject("Msxml2.XMLHTTP");
	}
	return xhr;
}