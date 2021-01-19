package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ÇëÇóÀ´ÁË...");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("user:" + user);
		System.out.println("password:" + password);
		String[] interests = request.getParameterValues("interestings");
		for(String interest:interests){
			System.out.println("-->" + interest);
		}
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		String method = httpServletRequest.getMethod();
		System.out.println(requestURI);
		System.out.println(method);
		PrintWriter out = response.getWriter();
		out.println("hello World!");

	}

}
