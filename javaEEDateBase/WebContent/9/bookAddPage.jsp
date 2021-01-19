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
	<form action="bookAdd.jsp" method="post">
		<table>
			<tr><td>书号:</td><td><input type="text" name="bookid"></td></tr>
			<tr><td>书名:</td><td><input type="text" name="bookname"></td></tr>
			<tr><td>价格:</td><td><input type="text" name="price"></td></tr>
			<tr>
				<td>出版社:</td>
				<td>
					<select name="publisher">
						<%
							while(rs.next()){
						%>
							<option value="<%=rs.getInt("id") %>"><%=rs.getString("publisherName") %></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr><td><input type="submit" value="提交"></td></tr>
		</table>
	</form>
</body>
</html>