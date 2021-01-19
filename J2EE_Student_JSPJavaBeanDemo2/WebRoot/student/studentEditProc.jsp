<%@page import="cn.edu.hfuu.util.SetBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.hfuu.dao.*" %>
<%@ page import="cn.edu.hfuu.po.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
		request.setCharacterEncoding("utf-8");
		Student student = (Student) SetBean.setBean(request, "cn.edu.hfuu.po.Student");

		StudentDAO stuDao = new StudentDAO();
		stuDao.updateStudent(student);
		
		response.sendRedirect("studentManagement.jsp");
%>
</body>
</html>