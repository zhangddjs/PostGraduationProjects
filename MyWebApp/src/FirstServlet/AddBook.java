package FirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import sun.util.calendar.BaseCalendar.Date;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Date date = new Date();
		String time = date.toString();
		PrintWriter out = response.getWriter();
		String bnum = request.getParameter("bookNum");
		String bname = request.getParameter("bookName");
		String author = request.getParameter("Author");
		String bookPub[] = request.getParameterValues("bookPub");
		String pubDate = request.getParameter("PubDate");
		String bookPrice = request.getParameter("bookPrice");
		String bookPlace = request.getParameter("bookPlace");
		String bookKind = request.getParameter("bookKind");
		out.println("<html>");
		out.println("<body>");
		out.println("<div>" + time + "</div>");
		out.println("<div>");
		out.println("<table border='1px' width='80%' align='center'>");
		out.println("<tr>");
		out.println("<td width='50%'>bnum:</td><td>ISBN-" + bnum + "</td>");
		out.println("<tr>");
		out.println("<td>bname:</td><td>" + bname + "</td>");
		out.println("<tr>");
		out.println("<td>author:</td><td>" + author + "</td>");
		out.println("<tr>");
		out.println("<td>bookPub:</td><td>" + bookPub[0] + "</td>");
		out.println("<tr>");
		out.println("<td>pubDate:</td><td>" + pubDate + "</td>");
		out.println("<tr>");
		out.println("<td>bookPrice:</td><td>" + bookPrice + "</td>");
		out.println("<tr>");
		out.println("<td>bookPlace:</td><td>" + bookPlace + "</td>");
		out.println("<tr>");
		out.println("<td>bookKind:</td><td>" + bookKind + "</td>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
