<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>books</title>
</head>
<body>

	<h3>Books</h3>
	<br><br>
	<a href="book.jsp?bookName=Java">Java</a><br><br>
	<a href="book.jsp?bookName=C%23">C#</a><br><br>
	<a href="book.jsp?bookName=C/C%2B%2B">C/C++</a><br><br>
	<a href="book.jsp?bookName=HTML/CSS">HTML/CSS</a><br><br>
	<a href="book.jsp?bookName=JSP">JSP</a><br><br>
	<a href="book.jsp?bookName=Servlet">Servlet</a><br><br>
	<a href="book.jsp?bookName=Javascript">Javascript</a><br><br>
	
	<br><br>
	
	<%
		Cookie [] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0){
			for(Cookie cookie : cookies){
				String cookieVal = cookie.getValue();
				out.println(cookieVal + "<br>");
			}
		}
	%>

</body>
</html>