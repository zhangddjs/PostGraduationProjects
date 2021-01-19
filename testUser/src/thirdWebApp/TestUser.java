package thirdWebApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestUser
 */
public class TestUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String interests[] = request.getParameterValues("interestings");
		PrintWriter out = response.getWriter();
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");

		System.out.println("ÇëÇóÀ´ÁË¡­¡­");
		System.out.println("user:" + user);
		System.out.println("password:" + password);
		if (interests.length != 0) {
			for (String interest : interests) {
				System.out.println("-->" + interest);
			} 
		}
		String sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbName = "test_users";
		String userName = "sa";
		String passWord = "123456";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;
		String sql = "select count(id) from usersInfo where username = '" + user + "' and password = '" + password + "'";

		try {
			Class.forName(sqlDriver);
			Connection con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("connect success!");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			int count = Integer.parseInt(rs.getString(1));
			
			if (count > 0) {
				out.print("hello:" + user);
			} else {
				out.print("sorry:" + user);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if (initUser.equals(user) && initPassword.equals(password)) {
		// out.print("hello!" + user);
		// } else {
		// out.print("sorry!" + user);
		// }
	}

}
