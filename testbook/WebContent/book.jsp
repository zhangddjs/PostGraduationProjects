<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bookDetail</title>
</head>
<body>

	<%
		String bookName = request.getParameter("bookName");
	%>
	<h4>Book Detail</h4>
	Book:<%= bookName%>
	<br><br><br><br>
	<a href="books.jsp">Return</a>
	
	<%
		Cookie [] cookies = request.getCookies();
		List<Cookie> booksCookies = new ArrayList<Cookie>();
		Cookie tempCookie = null;
		if(cookies!=null && cookies.length>0){
			for(Cookie cookie : cookies){
				String cookieName = cookie.getName();
				if(cookieName.startsWith("MYBOOK_")){
					booksCookies.add(cookie);
					if(cookie.getValue().equals(bookName)){
						tempCookie = cookie;
					}
				}
			}
		}
		
		if(booksCookies.size() >= 5 && tempCookie == null){
			tempCookie = booksCookies.get(0);
		}
		
		if(tempCookie != null){
			tempCookie.setMaxAge(0);
			response.addCookie(tempCookie);
		}
	
		Cookie cookie = new Cookie("MYBOOK_" + bookName, bookName);
		response.addCookie(cookie);
	%>

</body>
</html>