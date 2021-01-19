package po;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import util.HibernateUtil;

public class BookTest {

	@Test
	public void testAddBook() {
		BookBean book = new BookBean();
		book.setBookNum("ISBN-01");
		book.setBookName("Java");
		book.setPrice(88);
		book.setAuthor("zdd");
		PublisherBean pub = new PublisherBean();
		pub.setId(2);
		book.setPublisher(pub);
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testUpdateBook() {
		BookBean book = new BookBean();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		book = (BookBean) session.get(BookBean.class, 6);
		book.setBookName("JavaEE");
		PublisherBean pub = new PublisherBean();
		pub.setId(3);
		book.setPublisher(pub);
		session.getTransaction().commit();
	}
	
	@Test
	public void testGetBook() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		BookBean book = new BookBean();
		book = (BookBean) session.get(BookBean.class, 1);
		PublisherBean pub = new PublisherBean();
		pub = book.getPublisher();
		if (book != null)
			System.out
			.println("bookInfo:Id:" + book.getId() + ":"
					+"bookName:" + book.getBookName() + ":"
					+"bookNum:" + book.getBookNum() + ":"
					+"author:" + book.getAuthor() + ":"
					+"price:" + book.getPrice());
		if (pub != null)
			System.out
			.println("book-PublisherInfo:Id:" + pub.getId() + ":"
					+"Name:" + pub.getPublisherName() + ":"
					+"Num:" + pub.getPublisherNum());
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testDeleteBook() {
		BookBean book = new BookBean();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		book = (BookBean) session.get(BookBean.class, 6);
		session.delete(book);
		session.getTransaction().commit();
	}

}
