package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Application {
	public static void main(String[] args) {
		//数据库连接的准备
		String sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";		//数据库驱动器，此处为sqlsever
		String dbName = "student";							//数据库名（database）
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;//数据库地址
		String userName = "sa";									//用户名
		String passWord = "123456";								//密码
		String sqlResult = "select * from chengji";				//查询结果
		
		//进行数据库连接操作
		try{
			Class.forName(sqlDriver);							//首先加载Sqlsever的驱动类
			Connection con = DriverManager.getConnection(url, userName, passWord);	//创建连接
			System.out.println("connect success");
			Statement stmt = con.createStatement();				//创建一个Statement执行sql语句
			ResultSet rs = stmt.executeQuery(sqlResult);		//执行sql语句，并将结果放在rs中
			
			//列是从左到右编号的，并且从列1开始
			//对结果的处理
			while (rs.next()) {
	                System.out.println("number: " + rs.getInt(1) + "    name : "
	                        + rs.getString("name") + "    math : " + rs.getString(3)
	                        + "    english : " + rs.getString(4));
	        }
			
			//关闭JDBC对象    
		  /* 操作完成以后要把所有使用的JDBC对象全都关闭，以释放JDBC资源，关闭顺序和声   
		     明顺序相反：   
		     1、关闭记录集   
		     2、关闭声明   
		     3、关闭连接对象  */ 
			 
			// 关闭记录集
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
            // 关闭声明
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
 
            // 关闭链接对象
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
		} catch (Exception e) {
			System.out.println("操作失败！");
			e.printStackTrace();
		}
	}
}
