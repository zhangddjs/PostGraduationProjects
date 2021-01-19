package dao;

import java.util.List;

import org.hibernate.Session;
import po.User;

public class UserDao extends BaseDao {
	
	/**
	 * @���� ����û�
	 * @���� User����
	 * @����ֵ ��
	 */
	public void addUser(User user) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	/**
	 * @���� �޸��û�
	 * @���� User����
	 * @����ֵ ��
	 */
	public void updateUser(User user) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

	/**
	 * @���� ��ѯ�����û�
	 * @���� ��
	 * @����ֵ List<User>
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		List<User> userList;
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		userList = session.createQuery("from User").list();
		//userList = session.createSQLQuery("select * from user").addEntity(User.class).list();
		session.getTransaction().commit();
		return userList;
	}

	/**
	 * @���� ����id��ѯ�û�
	 * @���� id
	 * @����ֵ User
	 */
	public User getUser(int id) {
		User user = new User();
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		user = (User) session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}
	
	/**
	 * @���� ɾ���û�
	 * @���� User����
	 * @����ֵ ��
	 */
	public void deleteUser(User user){
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
}
