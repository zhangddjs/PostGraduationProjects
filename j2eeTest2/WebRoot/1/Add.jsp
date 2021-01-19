<%@page import="bean1.BookBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<%
  		BookBean book2 = new BookBean();
  		book2.setBookName(request.getParameter("bookName"));
  		book2.setBookNum(request.getParameter("bookNum"));
  		book2.setAuthor(request.getParameter("author"));
  		float price = Integer.parseInt(request.getParameter("price"));
  		book2.setPrice(price);
  	 %>
  
  <body>
  	<jsp:useBean id="book" class="bean1.BookBean"></jsp:useBean>
  	<jsp:setProperty property="*" name="book"/>
  	<font size="20" color="blue"></font>
  	<font color="blue">通过jsp标签显示</font><br>
  	书名:<jsp:getProperty property="bookName" name="book"/><br>
  	书号:<jsp:getProperty property="bookNum" name="book"/><br>
  	作者:<jsp:getProperty property="author" name="book"/><br>
  	价格:<jsp:getProperty property="price" name="book"/><br>
  	<font color="blue">通过java代码显示</font><br>
  	书名:<%=book2.getBookName() %><br>
  	书号:<%=book2.getBookNum() %><br>
  	作者:<%=book2.getAuthor() %><br>
  	价格:<%=book2.getPrice() %><br>
  </body>
</html>
