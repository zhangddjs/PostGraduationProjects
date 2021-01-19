<%@page import="java.sql.*"%>
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
		String sid = request.getParameter("sid");
		String name = request.getParameter("name");
		String xh = request.getParameter("xinghao");
		String gg = request.getParameter("guige");
		String date = request.getParameter("buydate");
		String amount = request.getParameter("amount");
		String price = request.getParameter("price");
		String cs = request.getParameter("changshang");
		String sys = request.getParameter("shiyanshi");
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=web";
		String user="sa";
		String password="123456";
		Connection con=DriverManager.getConnection(url, user, password);
		String sql=new String("select * from 设备管理");
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
	%>
	<form action="shebeiEdit.jsp?oldid=<%=id %>" method="post">
		<table>
			<tr><td>设备编号:</td><td><input type="text" name="sid" value='<%=sid %>'></td></tr>
			<tr><td>设备名:</td><td><input type="text" name="name" value='<%=name %>'></td></tr>
			<tr><td>型号:</td><td><input type="text" name="xh" value='<%=xh %>'></td></tr>
			<tr><td>规格:</td><td><input type="text" name="gg" value='<%=gg %>'></td></tr>
			<tr><td>购买日期:</td><td><input type="text" name="date" value='<%=date %>'></td></tr>
			<tr><td>数量:</td><td><input type="text" name="amount" value='<%=amount %>'></td></tr>
			<tr><td>单价:</td><td><input type="text" name="price" value='<%=price %>'></td></tr>
			<tr><td>厂商:</td><td><input type="text" name="cs" value='<%=cs %>'></td></tr>
			<tr><td>所属实验室:</td><td><input type="text" name="sys" value='<%=sys %>'></td></tr>
			
<%--			<tr>
				<td>所属实验室名:</td>
			 	<td>
                  	<select name="shiyanshiId">
						<%
							while(rs.next()){
								if(rs.getString("shiyanshiName").equals(sys)){
						%>
							<option value="<%=rs.getInt("sid") %>" selected="selected"><%=rs.getString("publisherName") %></option>
						<%
								} else {
						%>
						
							<option value="<%=rs.getInt("sid") %>"><%=rs.getString("shiyanshiName") %></option>
						<%
								}
							}
						%>
					</select>
                </td>
			</tr>
--%>
			<tr><td><input type="submit" value="提交"></td></tr>
		</table>
	</form>
</body>
</html>