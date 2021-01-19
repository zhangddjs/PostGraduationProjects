<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {}
	a:visited{
		font-stretch:已完成;
		poorfish:expression(this.onclick=function kill(){return false});
	}
	
</style>
<script type="text/javascript">
function yuyue(yuyue){
	alert('预约成功！');
	yuyue.style.display = "none" ;
	document.getElementById('replace_text').style.display = "" ;
}
function jieyue(yuyue){
	alert('借阅成功！');
	yuyue.style.display = "none" ;
	document.getElementById('replace_text2').style.display = "" ;
}
</script>
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
	<a href="book.jsp">返回</a>
	<%
		String id = request.getParameter("id");
		String dbname,username,password,url,sql;
		dbname = "ruance_bookmanager";
		username = "sa";
		password = "123456";
		url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbname;
		sql = "select * from bookInfo where 序号="+id;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
	%>
	<table border=0 width="100%">
		<tr><th><font color="blue">图书信息</font></th></tr>
		<tr>
			<th width="15%">序号</th>
			<td><%=rs.getString("序号") %></td>
		</tr>
		<tr>
			<th>书名</th>
			<td><%=rs.getString("书名") %></td>	
		</tr>
		<tr>
			<th>作者</th>
			<td><%=rs.getString("作者") %></td>	
		</tr>
		<tr>
			<th>出版社</th>
			<td><%=rs.getString("出版社") %></td>	
		</tr>
		<tr>
			<th>出版日期</th>
			<td><%=rs.getString("出版日期") %></td>	
		</tr>
		<tr>
			<th>馆藏位置</th>
			<td><%=rs.getString("馆藏位置") %></td>	
		</tr>
		<tr>
			<th>是否在馆</th>
			<%
				if(rs.getInt("是否在馆") == 1){
					
			%>
			<td>在馆</td>	
		</tr>
		<tr>
			<th>读者可以</th>
				<%
					if(flag){
				%>
			<td><a href="#" onclick="jieyue(this)" id="jieyue">借阅</a>
				<span id='replace_text2' style='display:none'>已借阅</span>
			</td>
				<%
					} else {
				%>
			<td><a href="login.html">登录</a>后进行借阅
			</td>
				<%
					}
				%>
			<%
				} else {
			%>
			<td><font color="red">已借出</font></td>
		</tr>
		<tr>
			<th>读者可以</th>
				<%
					if(flag){
				%>
			<td><a href="#" onclick="yuyue(this)" id="yuyue">提前预约</a>
				<span id='replace_text' style='display:none'>已预约</span>
			</td>
				<%
					} else {
				%>
			<td><a href="login.html">登录</a>后进行预约
			</td>
				<%
					}
				%>
			<%
				}
			%>
		</tr>
	</table>
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
	
</body>
</html>