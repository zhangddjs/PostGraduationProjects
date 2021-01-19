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
		String sqlResult = "select * from ��Ϣ";
		TableModel dataModel;
		table = new JTable();

		try {
			Class.forName(sqlDriver);
			Connection con = DriverManager.getConnection(url, userName, passWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlResult); // ִ��sql��䣬�����������rs��
			rs = stmt.executeQuery(sqlResult);
			Vector vect = new Vector(); // ʵ����һ������
			vect.removeAllElements();// ��ʼ����������
			String title[] = {"��Ʒ��","��Ʒ����","���ɹ�˾","�ۼ�"};
			dataModel = new AbstractTableModel() { // �Ա�Ľ�ģ
				public int getColumnCount() { // ȡ�ñ������
					return 4;
				}

				public int getRowCount() { // ȡ�ñ������
					return vect.size();
				}

				public String getColumnName(int columnIndex) {
					return title[columnIndex];
				}

				public Object getValueAt(int row, int col) { 		// ȡ�ñ��е�Ԫ���ֵ

					if (!vect.isEmpty())
						return ((Vector) vect.elementAt(row)).elementAt(col);
					else
						return null;

				}
			};
			table.setModel(dataModel);
			while (rs.next()) {
				Vector rec_vector = new Vector();
				// �ӽ������ȡ���ݷ�������rec_vector��
				rec_vector.addElement(rs.getString(1));
				rec_vector.addElement(rs.getString(2));
				rec_vector.addElement(rs.getString(3));
				rec_vector.addElement(rs.getInt(4));
				vect.addElement(rec_vector);// ����rec_vector��������vect��
			}

			// �ر�JDBC����
			/*
			 * ��������Ժ�Ҫ������ʹ�õ�JDBC����ȫ���رգ����ͷ�JDBC��Դ���ر�˳����� ��˳���෴�� 1���رռ�¼�� 2���ر�����
			 * 3���ر����Ӷ���
			 */

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

		scrollPane.getViewport().add(table);

	}
}
