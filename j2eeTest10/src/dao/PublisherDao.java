package dao;

import java.util.List;

import org.hibernate.Session;
import po.*;

public class PublisherDao extends BaseDao {
	
	/**
	 * @���� ��ӳ�����
	 * @���� PublisherBean����
	 * @����ֵ ��
	 */
	public void addPub(PublisherBean pub) {
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		pub = (PublisherBean) session.get(PublisherBean.class, id);
		session.getTransaction().commit();
		return pub;
	}
	
	/**
	 * @���� ɾ��������
	 * @���� PublisherBean����
	 * @����ֵ ��
	 */
	public void deletePub(PublisherBean pub){
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(pub);
		session.getTransaction().commit();
	}
	
}
