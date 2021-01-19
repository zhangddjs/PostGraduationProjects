package service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import dao.BookDao;
import dao.PublisherDao;
import po.BookBean;
import po.PublisherBean;

@Scope("prototype")	//ͨ��ע��ָ��������
@Service("BookServiceBean2")
public class BookService2 {
	private BookDao bookDao;
	private PublisherDao publisherDao;

	// ��Spring��������ע�룬����Ҫ�ṩ���ι��췽��
	public BookService2(BookDao bookDao, PublisherDao publisherDao) {
		this.bookDao = bookDao;
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
