<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date();
		if(session.getAttribute("username") == null){
			out.println("访问无效，请");
			out.println("<a href='login.html'>登录</a>");
		}
		else{
	%>
		今天是<%=date.getYear() + 1900 %>年<%=date.getMonth() + 1 %>月<%=date.getDate() %>日
		<br>
		欢迎<%=session.getAttribute("username") %>
	<%
		}
	%>
</body>
</html>