package po;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class PublisherTest {

	@Test
	public void testAddPub() {
		PublisherBean pub = new PublisherBean();
		pub.setPublisherName("合肥大學");
		pub.setPublisherNum("SBN-001");

		Configuration cf = new Configuration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * Sesion对象save方法将参数指定对象的属性值插入到对应数据表中
		 */
		session.save(pub);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testUpdatePub() {
		PublisherBean pub = new PublisherBean();
		pub.setId(25);
		pub.setPublisherName("北京大學");
		pub.setPublisherNum("SBN-003");

		Configuration cf = new Configuration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * Sesion对象save方法将参数指定对象的属性值插入到对应数据表中
		 */
		session.update(pub);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGetPub() {
		Configuration cf = new Configuration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * Session对象get方法:根据第二个参数指定的主键值，从对应数据表获取指定主键值的一条记录，并封装成一个JavaBean对象 返回
		 * 第一个参数：指定把数据表记录封装成何种JavaBean对象 如果找不到，返回null
		 */
		PublisherBean pub = (PublisherBean) session.get(PublisherBean.class, 25);

		session.getTransaction().commit();
		session.close();
		
		if (pub != null)
			System.out
					.println("Id:" + pub.getId() + ":"
							+"Name:" + pub.getPublisherName() + ":"
							+"Num:" + pub.getPublisherNum());
	}
	
	@Test
	public void testDeletePub() {
		Configuration cf = new Configuration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();
		PublisherBean pub = (PublisherBean) session.get(PublisherBean.class, 25);
		/*
		 * Sesion对象save方法将参数指定对象的属性值插入到对应数据表中
		 */
		session.delete(pub);
		session.getTransaction().commit();
		session.close();
	}

}
