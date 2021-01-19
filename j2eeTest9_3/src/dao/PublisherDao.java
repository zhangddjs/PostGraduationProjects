package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import po.PublisherBean;
import util.HibernateUtil;

@Repository("PublisherDao")
public class PublisherDao {
	/**
	 * @category add a publisher to publisher2.table
	 * @param publisher
	 */
	public void addPublisher(PublisherBean publisher) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(publisher);
		session.getTransaction().commit();
	}
	
	/**
	 * @category update one publisher's information in publisher2.table
	 * @param publisher
	 */
	public void updatePublisher(PublisherBean publisher) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(publisher);
		session.getTransaction().commit();
	}
	
	/**
	 * @category get the information about a publisher by id
	 * @param id
	 * @return publisher
	 */
	public PublisherBean getPublisher(int id) {
		PublisherBean publisher = new PublisherBean();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		publisher = (PublisherBean) session.get(PublisherBean.class, id);
		session.getTransaction().commit();
		return publisher;
	}
	
	/**
	 * @category get the publisherlist
	 * @return publisherList
	 */
	@SuppressWarnings("unchecked")
	public List<PublisherBean> getPublisherList() {
		List<PublisherBean> publisherList;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		publisherList = session.createQuery("from publisher").list();
		session.getTransaction().commit();
		return publisherList;
	}
	
	/**
	 * @category delete a publisher
	 * @param publisher
	 */
	public void DeletePublisher(PublisherBean publisher) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(publisher);
		session.getTransaction().commit();
	}

}
