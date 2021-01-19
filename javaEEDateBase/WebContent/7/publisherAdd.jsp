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
		String driver,dbname,user,password,url,sql,publisherId,publisherName;
		driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		dbname = "publisher";
		user = "sa";
		password = "123456";
		publisherId = request.getParameter("publisherId");
		publisherName = request.getParameter("publisherName");
		url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbname;
		sql = "insert into publisherInfo values('"+publisherId+"','"+publisherName+"')";
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			stmt.execute("use " + dbname);
			stmt.execute(sql);
			stmt.close();
			con.close();
			response.sendRedirect("publisher.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/sqlerror.jsp").forward(request, response);
		}
	%>
</body>
</html>