package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import bean2.BookBean;
import dao.BookDao;

public class BookListAction implements Action {
	
	private List<BookBean> bookList;
	
	public List<BookBean> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookBean> bookList) {
		this.bookList = bookList;
	}

	public String execute()  {
		BookDao bookDao = new BookDao();
		bookList = bookDao.getBookList();
		return "success";
	}

}
