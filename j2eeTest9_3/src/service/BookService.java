package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.BookDao;
import dao.PublisherDao;
import po.BookBean;
import po.PublisherBean;

@Scope("prototype")	//通过注解指定作用域
@Service("BookServiceBean")
public class BookService {
	private BookDao bookDao;
	private PublisherDao publisherDao;

	// setter，getter方法
	public BookDao getBookDao() {
		return bookDao;
	}

	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public PublisherDao getpublisherDao() {
		return publisherDao;
	}

	@Resource
	public void setpublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	/**
	 * @category add a Book to book2.table
	 * @param book
	 *            (BookBean)
	 * @param oid
	 *            (int,publisher.id)
	 */
	public void addBook(BookBean book, int oid) {
		PublisherBean publisher = publisherDao.getPublisher(oid);
		book.setPublisher(publisher);
		bookDao.addBook(book);
	}

	/**
	 * @category get all books
	 */
	public void getBookList() {
		List<BookBean> bookList = bookDao.getBookList();

		if (bookList != null) {
			for (BookBean book : bookList) {
				System.out.println(book.getId() + ":" + book.getBookNum() + ":" + book.getBookName() + ":"
						+ book.getAuthor() + ":" + book.getPrice() + ":" + book.getPublisher().getPublisherName());
			}
		}
	}

}
