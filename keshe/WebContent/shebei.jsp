<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a:hover {
	color: DeepSkyBlue;
	font-weight: bold;
	font-style: italic;
}
</style>
<script type="text/javascript">
window.onload = function() {
	var aNodes = document.getElementsByTagName("table")[0]
			.getElementsByTagName("a");
	for (var i = 0; i < aNodes.length; i++) {
		if (i % 2 == 1) {
			aNodes[i].onclick = function() {
				removeTr(this);
				return false;
			}
		}
	}
	function removeTr(trn) {
		var trNode = trn.parentNode.parentNode;
		var trText = trNode.getElementsByTagName("td")[0].firstChild.nodeValue;
		trText = trim(trText);
		var flag = confirm("确定要删除" + trText + "的信息吗？");
		if (flag) {
			//trNode.parentNode.removeChild(trNode);
			window.location("DeleteShebei?id=" + trText);
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
<body>
	<a href="shebeiAddPage.jsp">添加</a>
	<table border=1 width="100%">
		<tr align="center">
			<th width="10%">设备编号</th>
			<th width="10%">设备名</th>
			<th width="10%">型号</th>
			<th width="10%">规格</th>
			<th width="10%">购买日期</th>
			<th width="10%">数量</th>
			<th width="10%">单价</th>
			<th width="10%">厂商</th>
			<th width="10%">所属实验室</th>
			<th width="10%">操作</th>
		</tr>
	<%
		String dbname,username,password,url,sql;
		dbname = "web";
		username = "sa";
		password = "123456";
		url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbname;
		sql = "select * from 设备管理";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
	%>
		<tr>
			<td align="center"><%=rs.getString("设备编号") %></td>
			<td align="center"><%=rs.getString("设备名") %></td>
			<td align="center"><%=rs.getString("型号") %></td>
			<td align="center"><%=rs.getString("规格") %></td>
			<td align="center"><%=rs.getString("购买日期") %></td>
			<td align="center"><%=rs.getString("数量") %></td>
			<td align="center"><%=rs.getString("单价") %></td>
			<td align="center"><%=rs.getString("厂商") %></td>
			<td align="center"><%=rs.getString("所属实验室") %></td>
			<td align="center">
				<a href="shebeiEditPage.jsp?sid=<%=rs.getString("设备编号") %>
						&id=<%=rs.getInt("id") %>
						&name=<%=rs.getString("设备名") %>
						&xinghao=<%=rs.getString("型号") %>
						&guige=<%=rs.getString("规格") %>
						&buydate=<%=rs.getString("购买日期") %>
						&amount=<%=rs.getString("数量") %>
						&price=<%=rs.getString("单价") %>
						&changshang=<%=rs.getString("厂商") %>
						&shiyanshi=<%=rs.getString("所属实验室") %>">
						编辑</a>&nbsp&nbsp&nbsp
				<a href="#">删除</a>
			</td>
		</tr>
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
	</table>
</body>
</html>