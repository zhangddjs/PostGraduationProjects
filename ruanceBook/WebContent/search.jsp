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
	boolean flag = false;
	String user = "";
	Cookie [] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			String cookieName = cookie.getName();
			if("loginName".equals(cookieName)){
				flag = true;
				user = cookie.getValue();
			}
		}
	}
	if(flag){
%>
	<p>欢迎:<%=user %></p>
	<p><a href="logout.jsp">登出</a>&nbsp&nbsp<a href="search.html">查询</a></p>
<%
	} else {
%>
	<p><a href="login.html">请登录</a>&nbsp&nbsp<a href="search.html">查询</a></p>
<%
	}
%>
	<table border=1 width="100%">
		<tr align="center">
			<th width="15%">序号</th>
			<th width="15%">书名</th><th width="15%">作者</th>
			<th width="15%">出版社</th><th width="25%">出版日期</th>
		</tr>
	<%
		String dbname,username,password,url,sql,bookname;
		bookname = request.getParameter("bookname");
		dbname = "ruance_bookmanager";
		username = "sa";
		password = "123456";
		url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbname;
		sql = "select * from bookInfo where 书名 like '%"+bookname+"%'";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
	%>
		<tr>
			<td align="center"><%=rs.getString("序号") %></td>
			<td align="center"><a href="bookInfo.jsp?id=<%=rs.getString("序号") %>"><%=rs.getString("书名") %></a></td>
			<td align="center"><%=rs.getString("作者") %></td>
			<td align="center"><%=rs.getString("出版社") %></td>
			<td align="center"><%=rs.getString("出版日期") %></td>
		</tr>
	<%
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	%>
	</table>
</body>
</html>