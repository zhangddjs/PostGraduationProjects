package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import po.BookBean;
import util.HibernateUtil;

@Repository("BookDao")
public class BookDao {
	/**
	 * @category add a book to book2.table
	 * @param book
	 */
	public void addBook(BookBean book) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
	}
	
	/**
	 * @category update one book's information in book2.table
	 * @param book
	 */
	public void updateBook(BookBean book) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
	}
	
	/**
	 * @category get the information about a book by id
	 * @param id
	 * @return book
	 */
	public BookBean getBook(int id) {
		BookBean book = new BookBean();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		book = (BookBean) session.get(BookBean.class, id);
		session.getTransaction().commit();
		return book;
	}
	
	/**
	 * @category get the booklist
	 * @return bookList
	 */
	@SuppressWarnings("unchecked")
	public List<BookBean> getBookList() {
		List<BookBean> bookList;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		bookList = session.createQuery("from BookBean").list();
		session.getTransaction().commit();
		return bookList;
	}
	
	/**
	 * @category delete a book
	 * @param book
	 */
	public void DeleteBook(BookBean book) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
	}

}
