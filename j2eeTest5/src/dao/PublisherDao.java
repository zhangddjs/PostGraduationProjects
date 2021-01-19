package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import bean2.*;
import dbutil.DBUtil;

public class PublisherDao {

	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;

	/**
	 * @功能 添加出版社
	 * @参数 PublisherBean对象
	 * @返回值 无
	 */
	public void addPub(PublisherBean pub) {
		DBUtil dbUtil = null;
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "insert into publisher(publisherNum,publisherName)values(?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pub.getPublisherNum());
			pstm.setString(2, pub.getPublisherName());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(con);
		}
	}

	/**
	 * @功能 修改出版社
	 * @参数 PublisherBean对象
	 * @返回值 无
	 */
	public void updatePub(PublisherBean pub) {
		DBUtil dbUtil = null;
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "update publisher set publisherNum=?,publisherName=? where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, pub.getPublisherNum());
			pstm.setString(2, pub.getPublisherName());
			pstm.setInt(3, pub.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(con);

		}
	}

	/**
	 * @功能 查询所有出版社
	 * @参数 无
	 * @返回值 List<PublisherBean>
	 */
	public List<PublisherBean> getPubList() {
		DBUtil dbUtil = null;
		List<PublisherBean> pubList = new ArrayList<PublisherBean>();
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "select * from publisher";
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				PublisherBean pub = new PublisherBean();
				pub.setId(rs.getInt(1));
				pub.setPublisherNum(rs.getString(2));
				pub.setPublisherName(rs.getString(3));
				pubList.add(pub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(con);
		}
		return pubList;
	}

	/**
	 * @功能 根据id查询出版社
	 * @参数 id
	 * @返回值 PublisherBean
	 */
	public PublisherBean getPub(int id) {
		PublisherBean pub = null;
		DBUtil dbUtil = null;
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			pub = new PublisherBean();
			String sql = "select * from publisher where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				pub.setId(id);
				pub.setPublisherNum(rs.getString(2));
				pub.setPublisherName(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(con);
		}
		return pub;
	}
	
	/**
	 * @功能 删除出版社
	 * @参数 id
	 * @返回值 无
	 */
	public void deletePub(int id){
		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "delete from publisher where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(con);
		}
	}
}
