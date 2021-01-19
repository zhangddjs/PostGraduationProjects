package action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import dao.UserDao;
import po.User;

public class UserAction implements Action {
	private int oid;
	private User user;
	private List<User> userList;
	//private List<PublisherBean> publisherList;
	// DaoBean
	private UserDao userDao;
	//private PublisherDao publisherDao;

	public String userList() {
		userList = userDao.getUserList();
		return "success";
	}

	public String userAddPre() {
		return "success";
	}

	public String userAdd() {
		userDao.addUser(user);
		return "success";
	}

	public String userDelete() {
	//	System.out.println(oid);
		userDao.deleteUser(userDao.getUser(oid));
		return "success";
	}

	public String execute() {
		return "success";
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}


	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}
	
}
