package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PubEdit
 */
@WebServlet("/PubEdit")
public class PubEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PubEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String bno = request.getParameter("publisherId");
		String bname = request.getParameter("publisherName");
		String dbname,url,user,pwd,driver,sql,sql2;
		dbname = "publisher";
		user = "sa";
		pwd = "123456";
		driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		url = "jdbc:sqlserver://localhost:1433;Databasename=" + dbname;
		sql = "update publisherInfo set publisherId = '" +bno+ "' where publisherId = '" +id+ "'";
		sql2 = "update publisherInfo set publisherName = '" +bname+ "' where publisherId = '" +bno+ "'";
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pwd);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			//stmt.execute("");
			//stmt.execute("");
			stmt.close();
			con.close();
			response.sendRedirect("publisher.jsp");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
