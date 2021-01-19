<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "cn.edu.hfuu.dao.*,cn.edu.hfuu.po.*,java.util.List,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生添加</title>
</head>
<body>
<%  
		DepartmentDAO departDao = new DepartmentDAO(); 
		List departsList = new ArrayList(); 
		departsList = departDao.getDepartsList(); 
		 
%>
	<form action="studentAddProc.jsp" method="post">
		<table>
			<tr>
				<td>学号</td>
				<td><input type="text" name="number"/></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td>院系</td>
				<td>
					<select name="departId"> <!-- department -->
						<option value="0">---请选择院系---</option>
					<% 
						for(int i = 0; i < departsList.size(); i++){
							Department depart = (Department)departsList.get(i);
					%>
						<option value="<%=depart.getId() %>"><%=depart.getName() %></option>
					<%} %>	
					</select>
				</td>
			</tr>
			<tr>
				<td>个人介绍</td>
				<td>
					<textarea rows="10" cols="50" name="intro"></textarea>
				</td>
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