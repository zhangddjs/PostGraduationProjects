<%@page import="java.util.ArrayList"%>
<%@page import="bean2.PublisherBean"%>
<%@page import="java.util.List"%>
<%@page import="dao.PublisherDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function btnDelete(id){
		if(confirm("确认删除该条记录吗?"))
			location.href="/j2eeTest2/servlet/PublisherServlet?action=delete&&id="+id;
	}
</script>
</head>
<body>
	<a href="/j2eeTest2/2/publisherAdd.jsp">添加</a>&nbsp;&nbsp;
	<% 
		List<PublisherBean> pubList = new ArrayList<PublisherBean>();
		pubList = (List<PublisherBean>)request.getAttribute("pubList");
	%>
		<table width="500px" align="center">
			<tr>
				<td>出版社id</td>
				<td>出版社编码</td>
				<td>出版社名称</td>
				<td>操作</td>
			</tr>
	<% 
		for(int i = 0; i<pubList.size();i++){
			PublisherBean pub = (PublisherBean)pubList.get(i);
	%>
			<tr>
				<td><%=pub.getId() %></td>
				<td><%=pub.getPublisherNum() %></td>
				<td><%=pub.getPublisherName() %></td>
				<td><a href="/j2eeTest2/2/publisherEdit.jsp?id=<%=pub.getId() %>">编辑</a>&nbsp;<a href="#" onclick="btnDelete('<%=pub.getId() %>')">删除</a></td>
			</tr>
	<%} %>
		</table>
</body>
</html>