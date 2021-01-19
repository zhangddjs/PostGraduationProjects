<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
	%>
	<form action="PubEdit.jsp?id=<%=id %>&name=<%=name %>>" method="post">
		<table>
			<tr><td>出版社号:</td><td><input type="text" name="publisherId" value='<%=id %>'></td></tr>
			<tr><td>出版社名:</td><td><input type="text" name="publisherName" value='<%=name %>'></td></tr>
			<tr><td><input type="submit" value="提交"></td></tr>
		</table>
	</form>
</body>
</html>