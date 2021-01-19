<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>访问</title>
</head>
<body>
	<!--采用Struts2 property标签读取ActionContext中的数据  -->
    <!--property标签的value属性值是一个OGNL表达式，访问非值栈中的对象属性，需要加前缀"#名字"  -->
	
	<!-- 通过OGNL表达式访问存放在ActionContext中Map类型request对象里的数据 -->
	 <h1> <s:property value="#request.r"/> </h1>
	 
	 <!-- 通过OGNL表达式访问存放在ActionContext中Map类型session对象里的数据 -->
	 <h1> <s:property value="#session.s"/> </h1>
	 
	 <!-- 通过OGNL表达式访问存放在ActionContext中Map类型application对象里的数据 -->
	 <h1> <s:property value="#application.a"/></h1> 
	 
	 <s:debug></s:debug>
	
</body>
</html>