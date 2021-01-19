<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
</head>
<body>
<a href="userList">返回</a>
<!--property标签的value属性值是一个OGNL表达式，访问位于值栈栈顶的Action对象的message属性  -->
<!-- 值栈中的所有对象都被看成是ActionContext的根对象，OGNL表达式直接访问根对象的属性 -->
	<s:form action="userAdd">
		<s:textfield name="user.userNum" label="账号"></s:textfield>
		<s:textfield name="user.userName" label="昵称"></s:textfield>
		<s:textfield name="user.userPassword" label="密码"></s:textfield>
		<s:radio name="user.userGender" label="性别" list="{'male','female'}"></s:radio>
		<s:textfield name="user.userAge" label="年龄"></s:textfield>
		<%-- <sd:datetimepicker name="pubDate" label="出版日期" displayFormat="yyyy-MM-dd"></sd:datetimepicker> --%>
		<s:submit value="添加"></s:submit>
	</s:form>

<s:debug></s:debug>
</body>
</html>