package dao;

import java.util.List;

import org.hibernate.Session;
import po.User;

public class UserDao extends BaseDao {
	
	/**
	 * @功能 添加用户
	 * @参数 User对象
	 * @返回值 无
	 */
	public void addUser(User user) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	/**
	 * @功能 修改用户
	 * @参数 User对象
	 * @返回值 无
	 */
	public void updateUser(User user) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

	/**
	 * @功能 查询所有用户
	 * @参数 无
	 * @返回值 List<User>
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
	 * @功能 根据id查询用户
	 * @参数 id
	 * @返回值 User
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
	 * @功能 删除用户
	 * @参数 User对象
	 * @返回值 无
	 */
	public void deleteUser(User user){
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
}
