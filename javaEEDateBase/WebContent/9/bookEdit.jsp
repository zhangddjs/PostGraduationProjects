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
	request.setCharacterEncoding("utf-8");
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName=publisher";
	String user="sa";
	String password="123456";
	Connection con=DriverManager.getConnection(url, user, password);
	String id=request.getParameter("id");
	String bid=request.getParameter("bookid");
  	String name=request.getParameter("bookname");
  	String price=request.getParameter("price");
  	String publisher=request.getParameter("publisherId");
  	String sql=new String("update book  set bookid=?,bookname=?,price=?,publisher=? where id=?");
	PreparedStatement stm=con.prepareStatement(sql);
  	stm.setString(1, bid);
  	stm.setString(2, name);
  	stm.setString(3, price);
  	stm.setString(4, publisher);
  	stm.setString(5, id);
  	stm.executeUpdate();
  	stm.close();
    con.close();
    response.sendRedirect("book.jsp");
%>
</body>
</html>