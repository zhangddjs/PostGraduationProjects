<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bookManagement</title>
<style type="text/css">
a:hover {
	color: DeepSkyBlue;
	font-weight: bold;
	font-style: italic;
}
</style>
<script>
	window.onload = function() {
		var aNodes = document.getElementsByTagName("table")[0]
				.getElementsByTagName("a");
		for (var i = 0; i < aNodes.length; i++) {
			if (i % 2 == 0) {
				aNodes[i].onclick = function() {
					removeTr(this);
					return false;
				}
			}
		}
		function removeTr(trn) {
			var trNode = trn.parentNode.parentNode.parentNode;
			var trText = trNode.getElementsByTagName("td")[0].firstChild.nodeValue;
			trText = trim(trText);
			var flag = confirm("确定要删除" + trText + "的信息吗？");
			if (flag) {
				//trNode.parentNode.removeChild(trNode);
				window.location("deleteBook?bno=" + trText);
			}
		}

		function trim(str) {
			var reg = /^\s*|^\s$/g;
			str = str.replace(reg, "");
			return str;
		}
	}
</script>
</head>
<body bgcolor="GhostWhite">
	<div>
		<a href="bookAdd.html" target="main">添加书籍</a>&nbsp;&nbsp;&nbsp;<a
			href="bookSearch.html" target="main">查询书籍</a>
	</div>
	<br />
	<table border="2px" width="100%" cellspacing="0" cellpadding="0">
		<tr bgcolor="LightCyan" height="50px">
			<th width="15%">书号</th>
			<th width="25%">书名</th>
			<th width="10%">作者</th>
			<th width="25%">出版社</th>
			<th width="7%">类别</th>
			<th width="7%">单价</th>
			<th width="11%">操作</th>
		</tr>
		<%
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbName = "bookMarket";
			String user = "sa";
			String password = "123456";
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;
			String sql = "select * from bookInfo";

			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					out.println("<tr height=\"40px\">");
					out.println("<td>" + rs.getString(1) + "</td>");
					out.println("<td>" + rs.getString(2) + "</td>");
					out.println("<td>" + rs.getString(3) + "</td>");
					out.println("<td>" + rs.getString(4) + "</td>");
					out.println("<td>" + rs.getString(8) + "</td>");
					out.println("<td>" + rs.getString(6) + "</td>");
					out.println("<td align=\"center\"><div>");
					out.println("<a href=\"#\">删除</a>&nbsp;<a href=\"#\">编辑</a>");
					out.println("</div></td>");
					out.println("</tr>");
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
	</table>
</body>
</html>