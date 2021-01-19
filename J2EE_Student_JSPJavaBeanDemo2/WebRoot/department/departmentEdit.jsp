<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.hfuu.po.*" %>
<%@ page import="cn.edu.hfuu.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>院系编辑页面</title>
</head>
<body>
<% 
		
		String id = request.getParameter("id");
		int id2 = Integer.parseInt(id);
		DepartmentDAO departDao = new DepartmentDAO();
		Department depart = departDao.getDepartment(id2);
%>
	<form action="departmentEditProc.jsp?id=<%=id %>" method="post">
		<table>
			<tr>
				<td>院系编码</td>
				<td><input type="text" name="code" value="<%=depart.getCode() %>" /></td>
			</tr>
			<tr>
				<td>院系名称</td>
				<td><input type="text" name="name" value="<%=depart.getName() %>" /></td>
			</tr>

			<tr>
				<td colspan="2">
					<input type="submit" value="保存"/>&nbsp;
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>