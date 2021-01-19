package bookMarket;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String bno = request.getParameter("bookNumber");
		String bname = request.getParameter("bookName");
		String writer = request.getParameter("writer");
		String publisher[] = request.getParameterValues("publisher");
		String sellDate = request.getParameter("sellDate");
		String place[] = request.getParameterValues("place");
		String zhuangtai[] = request.getParameterValues("zhuangtai");
		addDateBase(bno, bname, writer, publisher[0], sellDate, place[0], zhuangtai[0], request, response);
	}

	void addDateBase(String bno, String bname, String writer, String publisher, String sellDate,
			String place, String zhuangtai, HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String dbName = "ruance_bookmanager";
		String user = "sa";
		String password = "123456";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatebaseName=" + dbName;
		String sql = "insert into dbo.bookInfo values('"+bno+"','"+bname+"','"+writer+"','"+publisher+"','"+sellDate+"','"+place+"','"+zhuangtai+"')";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			stmt.execute("use " + dbName);
			stmt.execute(sql);
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
			//out.println("<script type=\"text/javascript\">alert(\"添加成功\")</script>");
			request.getRequestDispatcher("/WEB-INF/alterSuccess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/sqlerror.jsp").forward(request, response);
		}
	}

}
