package action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import dao.BookDao;
import po.BookBean;

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
