package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean2.PublisherBean;
import dao.PublisherDao;

public class PublisherServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PublisherServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		int pubId = -1;
		String pubNum = null;
		String pubName = null;
		PublisherDao pub = new PublisherDao();
		PublisherBean pubBean = new PublisherBean();
		if (action.equals("add")) {
			pubNum = request.getParameter("publisherNum");
			pubName = request.getParameter("publisherName");
			pubBean.setPublisherNum(pubNum);
			pubBean.setPublisherName(pubName);
			pub.addPub(pubBean);
			request.getRequestDispatcher("../PublisherList").forward(request, response);
		}
		if (action.equals("update")) {
			pubId = Integer.parseInt(request.getParameter("id"));
			pubNum = request.getParameter("publisherNum");
			pubName = request.getParameter("publisherName");
			pubBean.setId(pubId);
			pubBean.setPublisherNum(pubNum);
			pubBean.setPublisherName(pubName);
			pub.updatePub(pubBean);
			request.getRequestDispatcher("../PublisherList").forward(request, response);
		}
		if (action.equals("delete")) {
			pubId = Integer.parseInt(request.getParameter("id"));
			pub.deletePub(pubId);
			request.getRequestDispatcher("../PublisherList").forward(request, response);
		}
		if (action.equals("search")) {
			pubId = Integer.parseInt(request.getParameter("id"));
			pub.getPub(pubId);
			request.getRequestDispatcher("../PublisherList").forward(request, response);
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}