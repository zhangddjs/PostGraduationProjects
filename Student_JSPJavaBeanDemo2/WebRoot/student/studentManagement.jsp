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
<title>学生管理</title>

<script>
	function btnDelete(id){
		if(confirm("确认删除该条记录吗?"))
			location.href="studentDelete.jsp?id="+id;
	}
</script>
</head>
<body>
	<a href="studentAdd.jsp">添加</a>&nbsp;&nbsp;
	<% 
		StudentDAO stuDao = new StudentDAO();
		List stuList = new ArrayList();
		stuList = stuDao.getStudentsList();
		
	%>
		<table border="2" width="500px">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>院系</td>
				<td>操作</td>
			</tr>
	<% 
		for(int i = 0; i<stuList.size();i++){
			Student stu = (Student)stuList.get(i);
	%>
			<tr>
				<td><%=stu.getNumber() %></td>
				<td><%=stu.getName() %></td>
				<td><%=stu.getAge() %></td>
				<td><%=stu.getDepart().getName() %></td>
				<td><a href="studentEdit.jsp?id=<%=stu.getId() %>">编辑</a>&nbsp;<a href="#" onclick="btnDelete('<%=stu.getId() %>')">删除</a></td>
			</tr>
	<%} %>
		</table>
				

</body>
</html>