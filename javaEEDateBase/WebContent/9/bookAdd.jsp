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
		String driver,dbname,user,password,url,sql,sql2,bookid,bookname,price,publisher;
		driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		dbname = "publisher";
		user = "sa";
		password = "123456";
		bookid = request.getParameter("bookid");
		bookname = request.getParameter("bookname");
		price = request.getParameter("price");
		publisher = request.getParameter("publisher");
		url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbname;
		sql = "insert into book values(?,?,?,?)";
		sql2 = "use " + dbname;
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement stmt = con.prepareStatement(sql2);
			stmt.execute();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookid);
		  	stmt.setString(2, bookname);
		  	stmt.setString(3, price);
		  	stmt.setString(4, publisher);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			response.sendRedirect("book.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/sqlerror.jsp").forward(request, response);
		}
	%>
</body>
</html>