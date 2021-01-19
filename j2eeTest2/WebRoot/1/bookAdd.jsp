<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="1/Add.jsp" method="post">
    	<table>
	    	<tr><td>书名</td><td><input type="text" name="bookName"></td>
    		<tr><td>书号</td><td><input type="text" name="bookNum"></td>
    		<tr><td>作者</td><td><input type="text" name="author"></td>
    		<tr><td>价格</td><td><input type="text" name="price"></td>
    		<tr><td colspan=2 align="center"><input type="submit" value="提交"></td></tr>
    	</table>
    </form>
  </body>
</html>
