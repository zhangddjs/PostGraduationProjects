<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setContentType("text/html;charset=UTF-8");
	request. setCharacterEncoding("UTF-8");
	String name = (String)session.getAttribute("username");
	Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
	int year = c.get(Calendar.YEAR); 
	int month = c.get(Calendar.MONTH); 
	int date = c.get(Calendar.DATE); 
	if(null==name){
		response.sendRedirect("error.html");
	}else{
		out.println("今天是"+year+"年"+month+"月"+date+"日，欢迎"+name); 
	}
	%>
	
</body>
</html>