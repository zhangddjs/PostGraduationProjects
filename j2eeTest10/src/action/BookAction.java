package action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import dao.BookDao;
import dao.PublisherDao;
import po.BookBean;
import po.PublisherBean;

@SuppressWarnings("rawtypes")
public class BookAction implements Action, ModelDriven {
	private int oid;
	private BookBean book = new BookBean();
	private List<BookBean> bookList;
	private List<PublisherBean> publisherList;
	// DaoBean
	private BookDao bookDao;
	private PublisherDao publisherDao;

	public String bookList() {
		bookList = bookDao.getBookList();
		return "success";
	}

	public String bookAddPre() {
		publisherList = publisherDao.getPubList();
		return "success";
	}

	public String bookAdd() {
		book.setPublisher(publisherDao.getPub(book.getPublisher().getId()));
		bookDao.addBook(book);
		return "success";
	}

	public String bookDelete() {
		System.out.println(oid);
		bookDao.deleteBook(bookDao.getBook(oid));
		return "success";
	}

	public String execute() {
		return "success";
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public PublisherDao getPublisherDao() {
		return publisherDao;
	}

	public List<BookBean> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookBean> bookList) {
		this.bookList = bookList;
	}

	public List<PublisherBean> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<PublisherBean> publisherList) {
		this.publisherList = publisherList;
	}

	public BookBean getModel(){
		return this.book;
	}
	
}
