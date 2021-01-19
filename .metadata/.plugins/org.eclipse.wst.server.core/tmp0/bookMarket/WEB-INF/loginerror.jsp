<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" defer="defer">
	function loginerr(){
		alert("登陆失败，请检查用户名和密码是否正确");
		window.location="login.html";
	}
	window.setTimeout("loginerr()", 1000);
</script>
</head>
<body>
	<h4 align="center">登录中……</h4>
</body>
</html>