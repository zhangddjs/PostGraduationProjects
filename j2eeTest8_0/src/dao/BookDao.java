package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.BookBean;
import util.HibernateUtil;

public class BookDao {
	
	/**
	 * @功能 添加书籍
	 * @参数 BookBean对象
	 * @返回值 无
	 */
	public void addBook(BookBean book) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
	}

	/**
	 * @功能 修改书籍
	 * @参数 BookBean对象
	 * @返回值 无
	 */
	public void updateBook(BookBean book) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
	}

	/**
	 * @功能 查询所有书籍
	 * @参数 无
	 * @返回值 List<BookBean>
	 */
	@SuppressWarnings("unchecked")
	public List<BookBean> getBookList() {
		List<BookBean> bookList;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		bookList = session.createQuery("from BookBean").list();
		//bookList = session.createSQLQuery("select * from book").addEntity(BookBean.class).list();
		session.getTransaction().commit();
		return bookList;
	}

	/**
	 * @功能 根据id查询书籍
	 * @参数 id
	 * @返回值 BookBean
	 */
	public BookBean getBook(int id) {
		BookBean book = new BookBean();
		SessionFactory sf;
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		book = (BookBean) session.get(BookBean.class, id);
		session.getTransaction().commit();
		return book;
	}
	
	/**
	 * @功能 删除书籍
	 * @参数 BookBean对象
	 * @返回值 无
	 */
	public void deleteBook(BookBean book){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
	}
}
