package action;

import com.opensymphony.xwork2.Action;

import dao.BookDao;
import po.BookBean;

public class BookDeleteAction implements Action {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute()  {
		BookBean book = new BookBean();
		book = new BookDao().getBook(id);
		new BookDao().deleteBook(book);
		return "success";
	}
}
