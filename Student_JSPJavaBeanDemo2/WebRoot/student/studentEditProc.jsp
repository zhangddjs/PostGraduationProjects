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
		String id = request.getParameter("id");
		int id2  = Integer.parseInt(id);
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String intro = request.getParameter("intro");
		int age2 = Integer.parseInt(age);
		int departId = Integer.parseInt(request.getParameter("departId"));
		
		Student stu = new Student();
		stu.setId(id2);
		stu.setNumber(number);
		stu.setName(name);
		stu.setAge(age2);
		stu.setIntro(intro);
		
		Department depart = new Department();
		depart.setId(departId);
		stu.setDepart(depart);
		
		StudentDAO stuDao = new StudentDAO();
		stuDao.updateStudent(stu);
		
		response.sendRedirect("studentManagement.jsp");
%>
</body>
</html>