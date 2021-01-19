<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/WEB-INF/loginerror2.jsp" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginprocess</title>
</head>
<body>
	<%
		if(request.getParameter("username").equals("zdd") && request.getParameter("pwd").equals("123456")){
			request.getRequestDispatcher("/WEB-INF/loginsuccess.jsp").forward(request, response);
		} else {
	%>
		<jsp:forward page="/WEB-INF/loginerror.jsp" />
		
	<%} %>
</body>
</html>