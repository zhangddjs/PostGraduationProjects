<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" defer="defer">
	function loginerr(){
		alert("登出成功");
		window.location="book.jsp";
	}
	window.setTimeout("loginerr()", 200);
</script>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();  
    try  
    {  
         for(int i=0;i<cookies.length;i++)    
         {  
          //System.out.println(cookies[i].getName() + ":" + cookies[i].getValue());  
          Cookie cookie = new Cookie(cookies[i].getName(), null);  
          cookie.setMaxAge(0);  
          response.addCookie(cookie);  
         }  
    }catch(Exception ex)  
    {  
        // System.out.println("清空Cookies发生异常！");  
    }   
	%>
</body>
</html>