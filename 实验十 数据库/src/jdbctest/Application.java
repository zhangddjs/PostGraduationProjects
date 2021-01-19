package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Application {
	public static void main(String[] args) {
		//���ݿ����ӵ�׼��
		String sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";		//���ݿ����������˴�Ϊsqlsever
		String dbName = "student";							//���ݿ�����database��
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;//���ݿ��ַ
		String userName = "sa";									//�û���
		String passWord = "123456";								//����
		String sqlResult = "select * from chengji";				//��ѯ���
		
		//�������ݿ����Ӳ���
		try{
			Class.forName(sqlDriver);							//���ȼ���Sqlsever��������
			Connection con = DriverManager.getConnection(url, userName, passWord);	//��������
			System.out.println("connect success");
			Statement stmt = con.createStatement();				//����һ��Statementִ��sql���
			ResultSet rs = stmt.executeQuery(sqlResult);		//ִ��sql��䣬�����������rs��
			
			//���Ǵ����ұ�ŵģ����Ҵ���1��ʼ
			//�Խ���Ĵ���
			while (rs.next()) {
	                System.out.println("number: " + rs.getInt(1) + "    name : "
	                        + rs.getString("name") + "    math : " + rs.getString(3)
	                        + "    english : " + rs.getString(4));
	        }
			
			//�ر�JDBC����    
		  /* ��������Ժ�Ҫ������ʹ�õ�JDBC����ȫ���رգ����ͷ�JDBC��Դ���ر�˳�����   
		     ��˳���෴��   
		     1���رռ�¼��   
		     2���ر�����   
		     3���ر����Ӷ���  */ 
			 
			// �رռ�¼��
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
            // �ر�����
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
            // �ر����Ӷ���
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
		} catch (Exception e) {
			System.out.println("����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
