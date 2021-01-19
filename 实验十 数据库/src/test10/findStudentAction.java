package test10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class findStudentAction extends JFrame implements ActionListener {
	private String buttonChoose;
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String userName = "sa";
	private String passWord = "123456";
	private String dbName = "学生管理";
	private String url = "jdbc:sqlserver://localhost:1433;DataBaseName=" + dbName;
	private int judge = 0;

	JPanel row1 = new JPanel();
	JComboBox fun = new JComboBox();

	JPanel row2 = new JPanel();
	JButton yesButton = new JButton("确定");
	JButton cancleButton = new JButton("取消");

	File stuFile = new File("stuInformation.txt");

	public findStudentAction() {
		super("查询学生");
		setBounds(570, 335, 250, 130);
		setLayout(new GridLayout(2, 1, 10, 10));

		row1.setLayout(new FlowLayout());
		fun.addItem("按院系查找");
		fun.addItem("按姓名查找");
		row1.add(new JLabel("请选择查找方式:"));
		row1.add(fun);

		row2.setLayout(new FlowLayout(FlowLayout.CENTER));
		yesButton.addActionListener(this);
		cancleButton.addActionListener(this);
		row2.add(yesButton);
		row2.add(cancleButton);

		add(row1);
		add(row2);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yesButton) {
			buttonChoose = fun.getSelectedItem().toString();
			setVisible(false);

			if (buttonChoose.equals("按院系查找")) {
				String s = JOptionPane.showInputDialog(this, "输入要查询的学生所在的院系:", "查询学生", JOptionPane.PLAIN_MESSAGE);
				if (s != null && (s.equals("计科系") || s.equals("化工系") || s.equals("管理系"))) {
					// 建立数据库连接
					String sql1 = "select * from 学生信息 where 院系='" + s + "'";
					try {
						Class.forName(driver);
						Connection con1 = DriverManager.getConnection(url, userName, passWord);
						Statement stmt1 = con1.createStatement();
						ResultSet rs1 = stmt1.executeQuery(sql1);
						while (rs1.next()) {
							System.out.println("第" + (judge + 1) + "个学生的信息：");
							System.out.println("姓名：" + rs1.getString(1));
							System.out.println("学号：" + rs1.getString(2));
							System.out.println("性别：" + rs1.getString(3));
							System.out.println("院系：" + rs1.getString(4));
							System.out.println("专业：" + rs1.getString(5));
							System.out.println("班级：" + rs1.getString(6));
							System.out.println("身份证号：" + rs1.getString(7));
							judge++;
						}
						if (rs1 != null)
							rs1.close();
						if (stmt1 != null)
							stmt1.close();
						if (con1 != null && !con1.isClosed()) {
							con1.close();
						}
					} catch (ClassNotFoundException e1) {
						System.out.println("注册数据库失败");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
				if (s != null && judge == 0 && (s.equals("计科系") || s.equals("化工系") || s.equals("管理系"))) {
					JOptionPane.showMessageDialog(this, "该院系没有检测到学生信息！", "查询结果", JOptionPane.ERROR_MESSAGE);
				} else if (s != null && !s.equals("计科系") && !s.equals("化工系") && !s.equals("管理系")) {
					JOptionPane.showMessageDialog(this, "不存在该院系！", "查询结果", JOptionPane.ERROR_MESSAGE);
				} else if (s != null && judge != 0) {
					JOptionPane.showMessageDialog(this, "该院系共检索到" + judge + "个学生的信息!", "查询结果",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (buttonChoose.equals("按姓名查找")) {
				String s = JOptionPane.showInputDialog(this, "输入要查询的学生的姓名:", "查询学生", JOptionPane.PLAIN_MESSAGE);

				if (s != null) {
					// 建立数据库连接
					String sql2 = "select * from 学生信息 where 姓名='" + s + "'";
					try {
						Class.forName(driver);
						Connection con2 = DriverManager.getConnection(url, userName, passWord);
						Statement stmt2 = con2.createStatement();
						ResultSet rs2 = stmt2.executeQuery(sql2);
						while (rs2.next()) {
							System.out.println("姓名：" + rs2.getString(1));
							System.out.println("学号：" + rs2.getString(2));
							System.out.println("性别：" + rs2.getString(3));
							System.out.println("院系：" + rs2.getString(4));
							System.out.println("专业：" + rs2.getString(5));
							System.out.println("班级：" + rs2.getString(6));
							System.out.println("身份证号：" + rs2.getString(7));
							judge++;
						}
						if (rs2 != null)
							rs2.close();
						if (stmt2 != null)
							stmt2.close();
						if (con2 != null && !con2.isClosed()) {
							con2.close();
						}
					} catch (ClassNotFoundException e1) {
						System.out.println("注册数据库失败");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (s != null && judge == 0) {
					JOptionPane.showMessageDialog(this, "没有检测到学生信息！", "查询结果", JOptionPane.ERROR_MESSAGE);
				} else if (s != null && judge != 0) {
					JOptionPane.showMessageDialog(this, "检测到该学生信息！", "查询结果", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		if (e.getSource() == cancleButton)

			setVisible(false);

	}

}
