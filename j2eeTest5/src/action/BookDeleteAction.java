package action;

import com.opensymphony.xwork2.Action;

import dao.BookDao;

public class BookDeleteAction implements Action {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute()  {
		new BookDao().deleteBook(id);
		return "success";
	}
}
