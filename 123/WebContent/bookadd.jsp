<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setContentType("text/html;charset=UTF-8");
	request. setCharacterEncoding("UTF-8");
	String bookId = request.getParameter("bookId");
	String bookName = request.getParameter("bookName");
	String author = request.getParameter("author");
	String publisherId = request.getParameter("publisherId");
	String pubdate = request.getParameter("pubdate");
	String price = request.getParameter("price");
	String place = request.getParameter("place");
	String type = request.getParameter("type");
	String content = request.getParameter("content");
	%>
	<table border=1 bgcolor=#87ceeb>
	<tr>
		<th>
			参数名
		</th>
		<th>
			参数值
		</th>
	</tr>
			
	<tr>
		<td>
			书号
		</td>
		<td>
			<%= bookId%>
		</td>
	</tr>
	<tr>
		<td>
			书名
		</td>
		<td>
			<%= bookName%>
		</td>
	</tr>
	<tr>
		<td>
			作者
		</td>
		<td>
			<%= author%>
		</td>
	</tr>
	<tr>
		<td>
			出版社
		</td>
		<td>
			<%= publisherId%>
		</td>
	</tr>
	<tr>
		<td>
			出版日期
		</td>
		<td>
			<%= pubdate%>
		</td>
	</tr>
	<tr>
		<td>
			价格
		</td>
		<td>
			<%= price%>
		</td>
	</tr>
	<tr>
		<td>
			存储位置
		</td>
		<td>
			<%= place%>
		</td>
	</tr>
	<tr>
		<td>
			类型
		</td>
		<td>
			<%= type%>
		</td>
	</tr>
	<tr>
		<td>
			内容简介
		</td>
		<td>
			<%= content%>
		</td>
	</tr>
	</table>
	</body>
	</html>
	<%	
		out.flush();
		out.close();
	 %>
</body>
</html>