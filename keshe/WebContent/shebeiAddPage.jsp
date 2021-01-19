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
		String bname = request.getParameter("bookname");
		String bid = request.getParameter("bookid");
		String price = request.getParameter("price");
		String pname = request.getParameter("publisherName");
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=publisher";
		String user="sa";
		String password="123456";
		Connection con=DriverManager.getConnection(url, user, password);
		String sql=new String("select * from publisherInfo");
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
	%>
	<form action="shebeiAdd.jsp" method="post">
		<table>
			<tr><td>设备编号:</td><td><input type="text" name="sid"></td></tr>
			<tr><td>设备名:</td><td><input type="text" name="name"></td></tr>
			<tr><td>型号:</td><td><input type="text" name="xh"></td></tr>
			<tr><td>规格:</td><td><input type="text" name="gg"></td></tr>
			<tr><td>购买日期:</td><td><input type="text" name="date"></td></tr>
			<tr><td>数量:</td><td><input type="text" name="amount"></td></tr>
			<tr><td>单价:</td><td><input type="text" name="price"></td></tr>
			<tr><td>厂商:</td><td><input type="text" name="cs"></td></tr>
			<tr><td>所属实验室:</td><td><input type="text" name="sys"></td></tr>
			<tr>
				<td>出版社:</td>
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