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
		String name = request.getParameter("Name");
		String place = request.getParameter("place");
		String cardKind = request.getParameter("kind"); 
		String cardNum = request.getParameter("cardNum");
		String checkedBooks[] = (String [])session.getAttribute("CHECKED_BOOK");
	%>

	<h3>Step3:订单确认</h3>
	<table width="250px" border="2px">
		<tr><td width="45%">顾客姓名</td><td><%= name %></td></tr>
		<tr><td>地址</td><td><%= place %></td></tr>
		<tr><td colspan="2">付款信息</td></tr>
		<tr><td>信用卡类型</td><td><%= cardKind %></td></tr>
		<tr><td>卡号</td><td><%= cardNum %></td></tr>
		<tr><td colspan="2">订货项目</td></tr>
		<tr><td/><td><% for(String ck : checkedBooks){
				out.print(ck);
				out.print("<br>");
			}	
			%></td>	
		</tr>		
	</table>

</body>
</html>