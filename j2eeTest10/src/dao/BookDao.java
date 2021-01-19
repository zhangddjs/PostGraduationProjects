package dao;

import java.util.List;

import org.hibernate.Session;
import po.BookBean;

public class BookDao extends BaseDao {
	
	/**
	 * @���� ����鼮
	 * @���� BookBean����
	 * @����ֵ ��
	 */
	public void addBook(BookBean book) {
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
	}
}
