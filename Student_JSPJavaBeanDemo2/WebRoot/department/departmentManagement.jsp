<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.hfuu.dao.*" %>
<%@ page import="cn.edu.hfuu.po.*" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>院系管理</title>

<script>
	function btnDelete(id){
		if(confirm("确认删除该条记录吗?"))
			location.href="departmentDelete.jsp?id="+id;
	}
</script>
</head>
<body>
	<a href="departmentAdd.jsp">添加</a>&nbsp;&nbsp;
	<% 
		DepartmentDAO departDao = new DepartmentDAO();
		List departsList = new ArrayList();
		departsList = departDao.getDepartsList();
		
	%>
		<table border="2" width="500px">
			<tr>
				<td>院系编码</td>
				<td>院系名称</td>
				<td>操作</td>
			</tr>
	<% 
		for(int i = 0; i<departsList.size();i++){
			Department depart = (Department)departsList.get(i);
	%>
			<tr>
				<td><%=depart.getCode() %></td>
				<td><%=depart.getName() %></td>
				<td><a href="departmentEdit.jsp?id=<%=depart.getId() %>">编辑</a>&nbsp;<a href="#" onclick="btnDelete('<%=depart.getId() %>')">删除</a></td>
			</tr>
	<%} %>
		</table>
				

</body>
</html>