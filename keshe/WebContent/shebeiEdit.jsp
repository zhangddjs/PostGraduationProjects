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
	String url="jdbc:sqlserver://localhost:1433;databaseName=web";
	String user="sa";
	String password="123456";
	Connection con=DriverManager.getConnection(url, user, password);
	String oldid = request.getParameter("oldid");
	String sid = request.getParameter("sid");
	String name = request.getParameter("name");
	String xh = request.getParameter("xh");
	String gg = request.getParameter("gg");
	String date = request.getParameter("date");
	String amount = request.getParameter("amount");
	String price = request.getParameter("price");
	String cs = request.getParameter("cs");
	String sys = request.getParameter("sys");
  	String sql=new String("update 设备管理  set 设备编号=?,设备名=?,型号=?,规格=?,购买日期=?,数量=?,单价=?,厂商=?,所属实验室=? where id=?");
	PreparedStatement stm=con.prepareStatement(sql);
  	stm.setString(1, sid);
  	stm.setString(2, name);
  	stm.setString(3, xh);
  	stm.setString(4, gg);
  	stm.setString(5, date);
  	stm.setString(6, amount);
  	stm.setString(7, price);
  	stm.setString(8, cs);
  	stm.setString(9, sys);
  	stm.setString(10, oldid);
  	stm.executeUpdate();
  	stm.close();
    con.close();
    response.sendRedirect("shebei.jsp");
%>
</body>
</html>