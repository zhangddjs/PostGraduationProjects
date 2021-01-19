package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public Add() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label = new JLabel("\u5546\u54C1\u53F7\uFF1A");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(72, 10, 63, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(155, 7, 165, 21);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(72, 41, 63, 15);
		panel.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(155, 38, 165, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("\u751F\u4EA7\u516C\u53F8\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(72, 71, 63, 15);
		panel.add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(155, 68, 165, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel label_3 = new JLabel("\u552E\u4EF7\uFF1A");
		label_3.setBounds(72, 102, 54, 15);
		panel.add(label_3);

		textField_3 = new JTextField();
		textField_3.setBounds(155, 99, 46, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_4 = new JLabel("\u5143");
		label_4.setBounds(211, 102, 54, 15);
		panel.add(label_4);

		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ���ݿ����������˴�Ϊsqlsever
				String dbName = "shop"; // ���ݿ�����database��
				String url = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dbName;// ���ݿ��ַ
				String userName = "sa"; // �û���
				String passWord = "123456"; // ����
				String id = textField.getText();
				String name = textField_1.getText();
				String factory = textField_2.getText();
				String prise = textField_3.getText();

				// �������ݿ����Ӳ���
				try {
					Class.forName(sqlDriver); // ���ȼ���Sqlsever��������
					Connection con = DriverManager.getConnection(url, userName, passWord); // ��������
					System.out.println("connect success");
					Statement stmt = con.createStatement(); // ����һ��Statementִ��sql���
					stmt.execute(
							"insert into ��Ϣ values('" + id + "','" + name + "','" + factory + "','" + prise + "')");

					// �ر�JDBC����
					/*
					 * ��������Ժ�Ҫ������ʹ�õ�JDBC����ȫ���رգ����ͷ�JDBC��Դ���ر�˳����� ��˳���෴�� 1���ر�����
					 * 2���ر����Ӷ���
					 */

					// �ر�����
					if (stmt != null) {
						try {
							stmt.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

					// �ر����Ӷ���
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				} catch (Exception e1) {
					System.out.println("����ʧ�ܣ�");
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		button.setBounds(121, 174, 63, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button_1.setBounds(236, 174, 63, 23);
		panel.add(button_1);
	}
}
