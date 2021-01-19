package util;

import java.sql.*;

import sorm.bean.JdbcInfo;
import sorm.core.ConfigReader;

public class DBUtil {
	
	public static Connection getConnection() {
		JdbcInfo jdbcInfo = ConfigReader.getInstance().getJdbcInfo();
		Connection conn = null;
		try {
			Class.forName(jdbcInfo.getDbDriver());
			conn = DriverManager.getConnection(jdbcInfo.getDbUrl(), jdbcInfo.getDbUser(), jdbcInfo.getDbPwd());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
