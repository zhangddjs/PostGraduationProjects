package dao;

import java.util.List;

import org.hibernate.Session;
import po.*;

public class PublisherDao extends BaseDao {
	
	/**
	 * @功能 添加出版社
	 * @参数 PublisherBean对象
	 * @返回值 无
	 */
	public void addPub(PublisherBean pub) {
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
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
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		pub = (PublisherBean) session.get(PublisherBean.class, id);
		session.getTransaction().commit();
		return pub;
	}
	
	/**
	 * @功能 删除出版社
	 * @参数 PublisherBean对象
	 * @返回值 无
	 */
	public void deletePub(PublisherBean pub){
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(pub);
		session.getTransaction().commit();
	}
	
}
