package cn.edu.hfuu.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hfuu.po.Student;
import cn.edu.hfuu.po.Department;
import cn.edu.hfuu.util.DBUtil;


public class StudentDAO {
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;
	
	public void addStudent(Student stu){

		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			String sql = "insert into student(xh,xm,nl,grjs,yx)values(?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,stu.getNumber());
			pstm.setString(2,stu.getName());
			pstm.setInt(3,stu.getAge());
			pstm.setString(4, stu.getIntro());
			pstm.setInt(5, stu.getDepart().getId());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	public void updateStudent(Student stu){

		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			String sql = "update student set xh=?,xm=?,nl=?,grjs=?,yx=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,stu.getNumber());
			pstm.setString(2,stu.getName());
			pstm.setInt(3,stu.getAge());
			pstm.setString(4, stu.getIntro());
			pstm.setInt(5, stu.getDepart().getId());
			pstm.setInt(6, stu.getId());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	public List getStudentsList(){
		DBUtil dbUtil = null;
		List stuList = new ArrayList();
		try{
			dbUtil = new DBUtil();
			conn  = dbUtil.getConnection();
			String sql = "select student.id,student.xh,student.xm,student.nl,department.mc";
			sql = sql +  " from student,department where student.yx = department.id";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setNumber(rs.getString("xh"));
				stu.setName(rs.getString("xm"));
				stu.setAge(rs.getInt("nl"));
				
				Department depart = new Department();
				depart.setName(rs.getString("mc"));
				
				stu.setDepart(depart);
				
				stuList.add(stu);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return stuList;
	}
	
	public Student getStudent(int id){
		DBUtil dbUtil = null;
		Student stu = null ;
		try{
			dbUtil = new DBUtil();
			conn  = dbUtil.getConnection();
			String sql = "select student.id,student.xh,student.xm,student.nl,student.grjs,student.yx,department.bm,department.mc ";
			sql = sql + " from student,department where student.yx = department.id and student.id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setNumber(rs.getString("xh"));
				stu.setName(rs.getString("xm"));
				stu.setAge(rs.getInt("nl"));
				stu.setIntro(rs.getString("grjs"));
				
				Department depart = new Department();
				depart.setId(rs.getInt("yx"));
				depart.setCode(rs.getString("bm"));
				depart.setName(rs.getString("mc"));
				
				stu.setDepart(depart);
				

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return stu;
	}
	
	public void deleteStudent(int id){
		
		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			conn  = dbUtil.getConnection();
			String sql = "delete from student where id =?";
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
