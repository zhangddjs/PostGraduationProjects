package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.*;
import util.HibernateUtil;

public class PublisherDao {

	/**
	 * @功能 添加出版社
	 * @参数 PublisherBean对象
	 * @返回值 无
	 */
	public void addPub(PublisherBean pub) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(pub);
		session.getTransaction().commit();
	}

	/**
	 * @功能 修改出版社
	 * @参数 PublisherBean对象
	 * @返回值 无
	 */
	public void updatePub(PublisherBean pub) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(pub);
		session.getTransaction().commit();
	}

	/**
	 * @功能 查询所有出版社
	 * @参数 无
	 * @返回值 List<PublisherBean>
	 */
	@SuppressWarnings("unchecked")
	public List<PublisherBean> getPubList() {
		List<PublisherBean> pubList;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		pubList = session.createQuery("from PublisherBean").list();
		session.getTransaction().commit();
		return pubList;
	}

	/**
	 * @功能 根据id查询出版社
	 * @参数 id
	 * @返回值 PublisherBean
	 */
	public PublisherBean getPub(int id) {
		PublisherBean pub = null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		pub = (PublisherBean) session.get(BookBean.class, id);
		session.getTransaction().commit();
		return pub;
	}
	
	/**
	 * @功能 删除出版社
	 * @参数 PublisherBean对象
	 * @返回值 无
	 */
	public void deletePub(PublisherBean pub){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(pub);
		session.getTransaction().commit();
	}
	
}
