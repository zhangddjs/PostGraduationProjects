<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>书名</th>
			<th>书号</th>
			<th>作者</th>
			<th>出版社</th>
			<th>价格</th>
			<th>类别</th>
			<th>操作</th>
		</tr>
		<%for(int i=0;i<5;i++){ %>
			<tr bgcolor="#f0fff0">
			<td>ISBN-001</td>
			<td>WEB应用系统开发</td>
			<td>范月华</td>
			<td>清华大学出版社</font></td>
			<td>25</font></td>
			<td>新书</font></td>
			<td>删除 &nbsp编辑</td>
		</tr>
		<% } %>
	
	</table>
</body>
</html>