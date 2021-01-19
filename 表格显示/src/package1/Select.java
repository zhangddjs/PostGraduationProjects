package package1;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Select {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(scrollPane);

		String sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbName = "shop";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;
		String userName = "sa";
		String passWord = "123456";
		String sqlResult = "select * from 信息";
		TableModel dataModel;
		table = new JTable();

		try {
			Class.forName(sqlDriver);
			Connection con = DriverManager.getConnection(url, userName, passWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlResult); // 执行sql语句，并将结果放在rs中
			rs = stmt.executeQuery(sqlResult);
			Vector vect = new Vector(); // 实例化一个向量
			vect.removeAllElements();// 初始化向量对象
			String title[] = {"商品号","商品名称","生成公司","售价"};
			dataModel = new AbstractTableModel() { // 对表的建模
				public int getColumnCount() { // 取得表的列数
					return 4;
				}

				public int getRowCount() { // 取得表的行数
					return vect.size();
				}

				public String getColumnName(int columnIndex) {
					return title[columnIndex];
				}

				public Object getValueAt(int row, int col) { 		// 取得表中单元格的值

					if (!vect.isEmpty())
						return ((Vector) vect.elementAt(row)).elementAt(col);
					else
						return null;

				}
			};
			table.setModel(dataModel);
			while (rs.next()) {
				Vector rec_vector = new Vector();
				// 从结果集中取数据放入向量rec_vector中
				rec_vector.addElement(rs.getString(1));
				rec_vector.addElement(rs.getString(2));
				rec_vector.addElement(rs.getString(3));
				rec_vector.addElement(rs.getInt(4));
				vect.addElement(rec_vector);// 向量rec_vector加入向量vect中
			}

			// 关闭JDBC对象
			/*
			 * 操作完成以后要把所有使用的JDBC对象全都关闭，以释放JDBC资源，关闭顺序和声 明顺序相反： 1、关闭记录集 2、关闭声明
			 * 3、关闭连接对象
			 */

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

		scrollPane.getViewport().add(table);

	}
}
