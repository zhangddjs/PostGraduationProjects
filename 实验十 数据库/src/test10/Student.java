package test10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
	private String name;
	private String studyID;
	private String sex;
	private String yuanXi;
	private String zhuanYe;
	private String banJi;
	private String personID;
	// �������ݿ�����
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dbName = "ѧ������";
	private String userName = "sa";
	private String passWord = "123456";
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;

	// ����ѧ����Ϣ
	protected void setInformation(String name, String studyID, String sex, String yuanXi, String zhuanYe, String banJi,
			String personID) {
		this.name = name;
		this.studyID = studyID;
		this.sex = sex;
		this.yuanXi = yuanXi;
		this.zhuanYe = zhuanYe;
		this.banJi = banJi;
		this.personID = personID;
	}

	// ��ȡѧ����Ϣ
	protected String getStudyID() {
		return studyID;
	}

	protected String getName() {
		return name;
	}

	protected String getYuanXi() {
		return yuanXi;
	}

	protected String getPersonID() {
		return personID;
	}

	protected String getSex() {
		return sex;
	}

	protected String getZhuanYe() {
		return zhuanYe;
	}

	protected String getBanJi() {
		return banJi;
	}

	// ��ѧ����Ϣ��������ݿ�
	protected void saveRow() throws SQLException{
		String sql1 = "insert into ѧ����Ϣ values('" + name + "','" + studyID + "','" + sex + "','" + yuanXi + "','"
				+ zhuanYe + "','" + banJi + "','" + personID + "')";
		try {
			Class.forName(driver);
			System.out.println("ע�����ݿ�ɹ�");
			Connection con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("�������ӳɹ���");
			PreparedStatement stmt = con.prepareStatement(sql1);
			System.out.println("�����Ϣ�ɹ���");
//			con.setAutoCommit(false);
//			con.commit();
			stmt.executeUpdate();
			if (stmt != null)
				stmt.close();
			if (con != null && !con.isClosed()) {
				con.close();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ע�����ݿ�ʧ��");
		} catch (SQLException e) {
			throw e;
		}
	}

}
