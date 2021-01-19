package po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String userNum;
	private String userName;
	private String userPassword;
	private String userGender;
	private int userAge;
	private String userImage;
	private String userHalfid;
	private String userHalftype;

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getUserAge() {
		return this.userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserHalfid() {
		return this.userHalfid;
	}

	public void setUserHalfid(String userHalfid) {
		this.userHalfid = userHalfid;
	}

	public String getUserHalftype() {
		return this.userHalftype;
	}

	public void setUserHalftype(String userHalftype) {
		this.userHalftype = userHalftype;
	}

	public User() {}
}