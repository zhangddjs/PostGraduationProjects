<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../servlet/PublisherServlet?action=add" method="post">
		<table>
			<tr>
				<td>编码</td>
				<td><input type="text" name="publisherNum"/></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="publisherName"/></td>
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