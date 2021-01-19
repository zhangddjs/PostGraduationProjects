package cn.edu.hfuu.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hfuu.po.Student;
import cn.edu.hfuu.po.Department;
import cn.edu.hfuu.util.DBUtil;


public class DepartmentDAO {
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;
	
	public void addDepartment(Department depart){

		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			String sql = "insert into department(bm,mc)values(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,depart.getCode());
			pstm.setString(2,depart.getName());
			
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	public void updateDepartment(Department depart){

		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			String sql = "update department set bm=?,mc=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,depart.getCode());
			pstm.setString(2,depart.getName());
			pstm.setInt(3,depart.getId());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	public List getDepartsList(){
		DBUtil dbUtil = null;
		List departsList = new ArrayList();
		try{
			dbUtil = new DBUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from department";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				Department depart = new Department();
				depart.setId(rs.getInt("id"));
				depart.setCode(rs.getString("bm"));
				depart.setName(rs.getString("mc"));
				
				
				departsList.add(depart);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return departsList;
	}
	
	public Department getDepartment(int id){
		DBUtil dbUtil = null;
		Department depart = null ;
		try{
			dbUtil = new DBUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from Department where id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				depart = new Department();
				depart.setId(rs.getInt("id"));
				depart.setCode(rs.getString("bm"));
				depart.setName(rs.getString("mc"));
				

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return depart;
	}
	
	public void deleteDepartment(int id){
		
		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			conn  = dbUtil.getConnection();
			String sql = "delete from department where id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
	}
}
