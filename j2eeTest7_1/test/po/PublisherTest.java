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
		pub.setPublisherName("�Ϸʴ�W");
		pub.setPublisherNum("SBN-001");

		Configuration cf = new Configuration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * Sesion����save����������ָ�����������ֵ���뵽��Ӧ���ݱ���
		 */
		session.save(pub);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testUpdatePub() {
		PublisherBean pub = new PublisherBean();
		pub.setId(25);
		pub.setPublisherName("������W");
		pub.setPublisherNum("SBN-003");

		Configuration cf = new Configuration();
		cf.configure();
		SessionFactory sf = cf.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * Sesion����save����������ָ�����������ֵ���뵽��Ӧ���ݱ���
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
		 * Session����get����:���ݵڶ�������ָ��������ֵ���Ӷ�Ӧ���ݱ��ȡָ������ֵ��һ����¼������װ��һ��JavaBean���� ����
		 * ��һ��������ָ�������ݱ��¼��װ�ɺ���JavaBean���� ����Ҳ���������null
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
		 * Sesion����save����������ָ�����������ֵ���뵽��Ӧ���ݱ���
		 */
		session.delete(pub);
		session.getTransaction().commit();
		session.close();
	}

}
