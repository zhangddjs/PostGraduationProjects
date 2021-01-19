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
		String code = request.getParameter("code");
		String name = request.getParameter("name");
	
		
		Department depart = new Department();
		depart.setId(id2);
		depart.setCode(code);
		depart.setName(name);
		
		DepartmentDAO departDao = new DepartmentDAO();
		departDao.updateDepartment(depart);
		
		response.sendRedirect("departmentManagement.jsp");
%>
</body>
</html>