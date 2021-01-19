package cn.edu.hfuu.util;

import java.sql.*;

public class DBUtil {
//	private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private String dbUrl = "jdbc:sqlserver://localhost:1433;databasename=student";
//	private String dbUser = "sa";
//	private String dbPwd = "catv";
	
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/javaee?useUnicode=true&characterEncoding=UTF-8";
	private String dbUser = "root";
	private String dbPwd = "1234";
	
	public DBUtil() {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection con){
		try{
			if(con!=null)
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void closeStatement(Statement stm){
		try{
			if(stm!=null)
			stm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closePreparedStatement(PreparedStatement pstm){
		try{
			if(pstm!=null)
			pstm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs){
		try{
			if(rs!=null)
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
