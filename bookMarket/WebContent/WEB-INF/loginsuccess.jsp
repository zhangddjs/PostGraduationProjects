<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript" defer="defer">
	function loginsuccess(){
		alert("登录成功！");
		window.location="index.jsp";
	}
	window.setTimeout("loginsuccess()", 1000);
</script>
</head>
	<h4 align="center">登录中……</h4>
<%
	String loginName = request.getParameter("username");
	if(loginName != null){
		Cookie cookie = new Cookie("loginName", loginName);
		//cookie.setMaxAge(600);
		response.addCookie(cookie);
	}
%>
<body>
</body>
</html>