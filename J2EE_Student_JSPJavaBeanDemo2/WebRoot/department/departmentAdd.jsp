<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>院系添加</title>
</head>
<body>

	<form action="departmentAddProc.jsp" method="post">
		<table>
			<tr>
				<td>编码</td>
				<td><input type="text" name="code"/></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="name"/></td>
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