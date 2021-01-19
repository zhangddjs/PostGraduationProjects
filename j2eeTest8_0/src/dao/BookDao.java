package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.BookBean;
import util.HibernateUtil;

public class BookDao {
	
	/**
	 * @���� ����鼮
	 * @���� BookBean����
	 * @����ֵ ��
	 */
	public void addBook(BookBean book) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
	}

	/**
	 * @���� �޸��鼮
	 * @���� BookBean����
	 * @����ֵ ��
	 */
	public void updateBook(BookBean book) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
	}

	/**
	 * @���� ��ѯ�����鼮
	 * @���� ��
	 * @����ֵ List<BookBean>
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
	 * @���� ����id��ѯ�鼮
	 * @���� id
	 * @����ֵ BookBean
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
	 * @���� ɾ���鼮
	 * @���� BookBean����
	 * @����ֵ ��
	 */
	public void deleteBook(BookBean book){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
	}
}
