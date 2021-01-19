package sorm.bean;

public class JdbcInfo {
	
	private String dbDriver;
	private String dbUrl;
	private String dbUser;
	private String dbPwd;
	public String getDbDriver() {
		return dbDriver;
	}
	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPwd() {
		return dbPwd;
	}
	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}
	public JdbcInfo(String dbDriver, String dbUrl, String dbUser, String dbPwd) {
		super();
		this.dbDriver = dbDriver;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPwd = dbPwd;
	}
	public JdbcInfo() {
	}

}
