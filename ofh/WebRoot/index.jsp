<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
<script>
	function btnDelete(id){
		if(confirm("确认删除该条记录吗?"))
			location.href="userDelete?oid="+id;
	}
</script>
</head>
<body>

<!--property标签的value属性值是一个OGNL表达式，访问位于值栈栈顶的Action对象的message属性  -->
<!-- 值栈中的所有对象都被看成是ActionContext的根对象，OGNL表达式直接访问根对象的属性 -->
<a href="userAddPre">添加</a>
<table border="2" width="500px">
			<tr>
				<td>userId</td>
				<td>账号</td>
				<td>昵称</td>
				<td>年龄</td>
				<td>性别</td>
				<td>操作</td>
			</tr>
<s:iterator value="userList" var="user">
	<tr>
		<td><s:property value="#user.userId"/> </td>
		<td><s:property value="#user.userNum"/> </td>
		<td><s:property value="#user.userName"/> </td>
		<td><s:property value="#user.userAge"/> </td>
		<td><s:property value="#user.userGender"/> </td>
		<td><a href="userEdit?id=<s:property value='#user.userId'/>">编辑</a>&nbsp;<a href="#" onclick="btnDelete('<s:property value='#user.userId'/>')">删除</a></td>
	</tr>
</s:iterator>
</table>
<s:debug></s:debug>
</body>
</html>