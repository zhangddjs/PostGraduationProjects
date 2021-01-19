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
		String checked[] = request.getParameterValues("book");
		session.setAttribute("CHECKED_BOOK", checked);
	%>

	<h3>Step2:请输入寄送地址和信用卡信息</h3>
	<form action="step3.jsp" method="post">
		<table border="2" width="238px" height="200px">
			<tr><td colspan="2">基本信息</td></tr>
			<tr><td width="30%">姓名</td><td><input type="text" name="Name"/></td></tr>
			<tr><td>寄送地址</td><td><input type="text" name="place"/></td></tr>
			<tr><td colspan="2">信用卡信息</td></tr>
			<tr><td rowspan="2">种类</td><td rowspan="2"><input type="radio" name="kind" value="Visa"/>Visa
										<input type="radio" name="kind" value="Master"/>Master</td></tr>
			<tr/>
			<tr><td>卡号</td><td><input type="text" name="cardNum"/></td></tr>
			<tr><td colspan="2"><input type="submit" value="继续"></td></tr>
		</table>
	</form>

</body>
</html>