<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String name = request.getParameter("name");
	String shenfenId = request.getParameter("shenfenId");
	String youxiang = request.getParameter("youxiang");
	String age0 = request.getParameter("age");
	int age = -1;
	try{
		age = Integer.parseInt(age0);
	} catch(Exception e){
		response.sendRedirect("err.html");
		return;
	}
	String address = request.getParameter("address");
	//身份截取最后一位
	String str2 = null;
	try{
		str2 = shenfenId.substring(shenfenId.length()-1, shenfenId.length());
	} catch(Exception e){
		response.sendRedirect("err.html");
		return;
	}
	//身份前17位纯数字	
	boolean result=shenfenId.substring(0, shenfenId.length() - 1).matches("[0-9]+");
	if(result && (str2.equals("X") || str2.matches("[0-9]+"))){
	} else {
		response.sendRedirect("err.html");
		return;
	}
	//邮箱是否包含@和.
	boolean result2 = youxiang.contains("@");
	boolean result3 = youxiang.contains(".");
	if((result2 && result3) || youxiang.equals("")){
	} else {
		response.sendRedirect("err.html");
		return;
	}
	//其他
	if(name == null 
			|| name.length() > 10
			|| shenfenId == null 
			|| age < 18 
			|| age > 80
			|| (shenfenId.length() != 18 && shenfenId.length() != 15)
			|| !result){
		response.sendRedirect("err.html");
		return;
	}
	else
		response.sendRedirect("success.html");
%>
<body>
	
</body>
</html>