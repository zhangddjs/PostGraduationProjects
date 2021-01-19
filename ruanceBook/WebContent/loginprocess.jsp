<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/WEB-INF/loginerror2.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginprocess</title>
</head>
<body>
	<%
		String userid = request.getParameter("username");
		String userpassword = request.getParameter("pwd");
		String dbName, driver, url, sql;
		dbName = "ruance_bookmanager";
		driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		url = "jdbc:sqlserver://localhost:1433;DatebaseName=" + dbName;
		sql = "select * from users";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "sa", "123456");
			Statement stm = con.createStatement();
			
			stm.execute("use " + dbName);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				if(userid.equals(rs.getString("id")) && userpassword.equals(rs.getString("password"))){
					rs.close();
					stm.close();
					con.close();
					request.getRequestDispatcher("/WEB-INF/loginsuccess.jsp").forward(request, response);
				}
			}
			rs.close();
			stm.close();
			con.close();
			%>
			<jsp:forward page="/WEB-INF/loginerror.jsp" />
			<%

		} catch (Exception e){
			%>
			<jsp:forward page="/WEB-INF/sqlerror.jsp" />
			<%
		}
	%>
</body>
</html>