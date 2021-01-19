<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书店后台管理系统</title>
</head>

<%
	Cookie [] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			String cookieName = cookie.getName();
			if("loginName".equals(cookieName)){
%>
<frameset rows="15%,*">
	<frame src="indextop.html" name="top" />
	<frameset cols="20%,*">
		<frame src="indexleft.html" name="left" />
		<frame src="welcome.html" name="main" />
	</frameset>
</frameset>				
<%
			}
		}
	} else {
		response.sendRedirect("login.html");
	}
%>

</html>