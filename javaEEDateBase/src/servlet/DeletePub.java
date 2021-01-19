package servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeletePub")
public class DeletePub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePub() {
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
		String pno = request.getParameter("pno");
		String dbname,url,user,pwd,driver,sql;
		dbname = "publisher";
		user = "sa";
		pwd = "123456";
		driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		url = "jdbc:sqlserver://localhost:1433;Databasename=" + dbname;
		sql = "delete from publisherInfo where id = '" + pno + "'";
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pwd);
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			stmt.close();
			con.close();
			response.sendRedirect("publisher.jsp");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
