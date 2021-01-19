<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String email = request.getParameter("email");
	String age0 = request.getParameter("age");
	int age = -1;
	try{
		age = Integer.parseInt(age0);
	} catch(Exception e){
		System.out.println("年龄空");
		response.sendRedirect("error.html");
		return;
	}
	if(name == null ||name.length()>15 || id == null || age < 18 || age > 80
			|| (id.length() != 18 && id.length() != 15) || !result){
		System.out.println("其他");
		response.sendRedirect("error.html");
		return;
	}
	String address = request.getParameter("address");
	String str2 = null;
	try{
		str2 =id.substring(id.length()-1,id.length());
	} catch(Exception e){
		System.out.println("身份证id空");
		response.sendRedirect("error.html");
		return;
	}
	boolean result=id.substring(0, id.length() - 1).matches("[0-9]+");
	if(result && (str2.equals("X") || str2.matches("[0-9]+"))){
	} else {
		System.out.println("身份证ID");
		response.sendRedirect("error.html");
		return;
	}
	boolean result2 = email.contains("@");
	boolean result3 = email.contains(".");
	if((result2 && result3) || email.equals("")){
	} else {
		System.out.println("邮箱");
		response.sendRedirect("error.html");
		return;
	}
	else
		response.sendRedirect("success.html");
%>
</body>
</html>
