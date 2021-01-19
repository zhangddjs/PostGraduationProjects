<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>

</head>

<body>

	<%
		Statement sql;

		ResultSet rs;

		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动  

		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=UniversityDB"; //连接服务器和数据库sample  

		String userName = "sa"; //默认用户名  

		String userPwd = "123456"; //密码  

		Connection dbConn;

		try {

			Class.forName(driverName);

			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

			sql = dbConn.createStatement();

			rs = sql.executeQuery("select*from course");

			System.out.println("Connection Successful!"); //如果连接成功 控制台输出Connection Successful! 

			out.println("<table Border>");

			out.println("<tr><td colspan=8 align=center>用户数据</td></tr>");

			out.println("<tr>");

			out.println("<td width=100>CourseId</td>");

			out.println("<td width=100>Title</td>");

			out.println("<td width=100>Department</td>");

			out.println("<td width=100>Credits</td>");

			out.println("</tr>");

			while (rs.next())

			{

				out.println("<tr>");

				out.println("<td>" + rs.getString(1) + "</td>");

				out.println("<td>" + rs.getString(2) + "</td>");

				out.println("<td>" + rs.getString(3) + "</td>");

				out.println("<td>" + rs.getString(4) + "</td>");

				out.println("</tr>");

			}

			out.println("</table>");

			dbConn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
	%>

</body>

</html>