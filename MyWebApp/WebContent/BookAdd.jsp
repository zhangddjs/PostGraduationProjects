<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookAddJSP</title>
</head>
<body>
	这是目标JSP
	<br>
	<%
		String bnum = request.getParameter("bookNum");
		String bname = request.getParameter("bookName");
		String author = request.getParameter("Author");
		String bookPub[] = request.getParameterValues("bookPub");
		String pubDate = request.getParameter("PubDate");
		String bookPrice = request.getParameter("bookPrice");
		String bookPlace = request.getParameter("bookPlace");
		String bookKind = request.getParameter("bookKind");
	%>
	<table border='1px' width='80%' align='center'>
		<tr><td width='50%'>bnum:</td><td>ISBN-<%=bnum %></td></tr>
		<tr><td>bname:</td><td><%=bname %></td></tr>
		<tr><td>author:</td><td><%=author %></td></tr>
		<tr><td>bookPub:</td><td><%=bookPub[0] %></td></tr>
		<tr><td>pubDate:</td><td><%=pubDate %></td></tr>
		<tr><td>bookPrice:</td><td><%=bookPrice %></td></tr>
		<tr><td>bookPlace:</td><td><%=bookPlace %></td></tr>
		<tr><td>bookKind:</td><td><%=bookKind %></td></tr>
	</table>
</body>
</html>