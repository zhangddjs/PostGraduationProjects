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
String name = request.getParameter("name");
String bno = request.getParameter("publisherId");
String bname = request.getParameter("publisherName");
String dbname,url,user,pwd,driver,sql,sql2;
dbname = "publisher";
user = "sa";
pwd = "123456";
driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
url = "jdbc:sqlserver://localhost:1433;Databasename=" + dbname;
sql = "update publisherInfo set publisherId = '" +bno+ "' where publisherId = '" +id+ "'";
sql2 = "update publisherInfo set publisherName = '" +bname+ "' where publisherId = '" +bno+ "'";
try{
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, pwd);
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.executeUpdate();
	stmt = con.prepareStatement(sql2);
	stmt.executeUpdate();
	//stmt.execute("");
	//stmt.execute("");
	stmt.close();
	con.close();
	response.sendRedirect("publisher.jsp");
} catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>