package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean2.BookBean;
import dbutil.DBUtil;

public class BookDao {
	private Connection con = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;
	
	/**
	 * @功能 添加书籍
	 * @参数 BookBean对象
	 * @返回值 无
	 */
	public void addBook(BookBean book) {
		DBUtil dbUtil = null;
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "insert into book(bookNum,bookName,author,price,publisher,pubDate)values(?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, book.getBookNum());
			pstm.setString(2, book.getBookName());
			pstm.setString(3, book.getAuthor());
			pstm.setFloat(4, book.getPrice());
			pstm.setInt(5, book.getPublisher().getId());
			pstm.setString(6, book.getPubDate());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(con);
		}
	}

	/**
	 * @功能 修改书籍
	 * @参数 BookBean对象
	 * @返回值 无
	 */
	public void updateBook(BookBean book) {
		DBUtil dbUtil = null;
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "update book set bookNum=?,bookName=?,author=?,price=?,publisher=?,pubDate=? where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, book.getBookNum());
			pstm.setString(2, book.getBookName());
			pstm.setString(3, book.getAuthor());
			pstm.setFloat(4, book.getPrice());
			pstm.setInt(5, book.getPublisher().getId());
			pstm.setString(6, book.getPubDate());
			pstm.setInt(7, book.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(con);

		}
	}

	/**
	 * @功能 查询所有书籍
	 * @参数 无
	 * @返回值 List<BookBean>
	 */
	public List<BookBean> getBookList() {
		DBUtil dbUtil = null;
		List<BookBean> bookList = new ArrayList<BookBean>();
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "select * from book";
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				BookBean book = new BookBean();
				book.setId(rs.getInt(1));
				book.setBookNum(rs.getString(2));
				book.setBookName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getFloat(5));
				book.setPublisher(new PublisherDao().getPub(rs.getInt(6)));
				book.setPubDate(rs.getString(7));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(con);
		}
		return bookList;
	}

	/**
	 * @功能 根据id查询书籍
	 * @参数 id
	 * @返回值 BookBean
	 */
	public BookBean getBook(int id) {
		BookBean book = null;
		DBUtil dbUtil = null;
		try {
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			book = new BookBean();
			String sql = "select * from book where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				book.setId(id);
				book.setBookNum(rs.getString(2));
				book.setBookName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getFloat(5));
				book.setPublisher(new PublisherDao().getPub(rs.getInt(6)));
				book.setPubDate(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(con);
		}
		return book;
	}
	
	/**
	 * @功能 删除书籍
	 * @参数 id
	 * @返回值 无
	 */
	public void deleteBook(int id){
		DBUtil dbUtil = null;
		try{
			dbUtil = new DBUtil();
			con = dbUtil.getConnection();
			String sql = "delete from book where id=?";
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
