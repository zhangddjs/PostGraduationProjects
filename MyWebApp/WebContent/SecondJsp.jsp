<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SecondJSP</title>
</head>
<body>
	<table border=1>
		<tr align="center">
			<td>书号</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>价格</td>
			<td>类别</td>
			<td>操作</td>
		</tr>
	<%
		for(int i = 0; i < 5; i++){
	%>
		<tr align="center">
			<td>ISBN-001</td>
			<td>Web开发</td>
			<td>范月华</td>
			<td>清华出版社</td>
			<td>25</td>
			<td>新书</td>
			<td><a href="#">编辑</a>&nbsp<a href="#">删除</a></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>