package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.*;
import util.HibernateUtil;

public class PublisherDao {

	/**
	 * @���� ��ӳ�����
	 * @���� PublisherBean����
	 * @����ֵ ��
	 */
	public void addPub(PublisherBean pub) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(pub);
		session.getTransaction().commit();
	}

	/**
	 * @���� �޸ĳ�����
	 * @���� PublisherBean����
	 * @����ֵ ��
	 */
	public void updatePub(PublisherBean pub) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(pub);
		session.getTransaction().commit();
	}

	/**
	 * @���� ��ѯ���г�����
	 * @���� ��
	 * @����ֵ List<PublisherBean>
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
	 * @���� ����id��ѯ������
	 * @���� id
	 * @����ֵ PublisherBean
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
	 * @���� ɾ��������
	 * @���� PublisherBean����
	 * @����ֵ ��
	 */
	public void deletePub(PublisherBean pub){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(pub);
		session.getTransaction().commit();
	}
	
}
