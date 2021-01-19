package action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import dao.BookDao;
import dao.PublisherDao;
import po.BookBean;
import po.PublisherBean;

@SuppressWarnings("rawtypes")
public class BookAddAction implements Action, ModelDriven {
	
	private BookBean book = new BookBean();
	private List<PublisherBean> publisherList;
	
	public List<PublisherBean> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<PublisherBean> publisherList) {
		this.publisherList = publisherList;
	}

	public BookBean getModel(){
		return this.book;
	}

	public String bookAddPre()  {
		publisherList = new PublisherDao().getPubList();
		return "success";
	}

	public String bookAdd()  {
		
		BookDao bookDao = new BookDao();
		book.setPublisher(new PublisherDao().getPub(book.getPublisher().getId()));
		System.out.println(book.getPublisher().getPublisherName());
		bookDao.addBook(book);
		return Action.SUCCESS;
		
	}

	public String execute()  {
		
		return "success";
	}
}
