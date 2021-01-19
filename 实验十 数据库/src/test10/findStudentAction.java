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
	private String dbName = "ѧ������";
	private String url = "jdbc:sqlserver://localhost:1433;DataBaseName=" + dbName;
	private int judge = 0;

	JPanel row1 = new JPanel();
	JComboBox fun = new JComboBox();

	JPanel row2 = new JPanel();
	JButton yesButton = new JButton("ȷ��");
	JButton cancleButton = new JButton("ȡ��");

	File stuFile = new File("stuInformation.txt");

	public findStudentAction() {
		super("��ѯѧ��");
		setBounds(570, 335, 250, 130);
		setLayout(new GridLayout(2, 1, 10, 10));

		row1.setLayout(new FlowLayout());
		fun.addItem("��Ժϵ����");
		fun.addItem("����������");
		row1.add(new JLabel("��ѡ����ҷ�ʽ:"));
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

			if (buttonChoose.equals("��Ժϵ����")) {
				String s = JOptionPane.showInputDialog(this, "����Ҫ��ѯ��ѧ�����ڵ�Ժϵ:", "��ѯѧ��", JOptionPane.PLAIN_MESSAGE);
				if (s != null && (s.equals("�ƿ�ϵ") || s.equals("����ϵ") || s.equals("����ϵ"))) {
					// �������ݿ�����
					String sql1 = "select * from ѧ����Ϣ where Ժϵ='" + s + "'";
					try {
						Class.forName(driver);
						Connection con1 = DriverManager.getConnection(url, userName, passWord);
						Statement stmt1 = con1.createStatement();
						ResultSet rs1 = stmt1.executeQuery(sql1);
						while (rs1.next()) {
							System.out.println("��" + (judge + 1) + "��ѧ������Ϣ��");
							System.out.println("������" + rs1.getString(1));
							System.out.println("ѧ�ţ�" + rs1.getString(2));
							System.out.println("�Ա�" + rs1.getString(3));
							System.out.println("Ժϵ��" + rs1.getString(4));
							System.out.println("רҵ��" + rs1.getString(5));
							System.out.println("�༶��" + rs1.getString(6));
							System.out.println("���֤�ţ�" + rs1.getString(7));
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
						System.out.println("ע�����ݿ�ʧ��");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
				if (s != null && judge == 0 && (s.equals("�ƿ�ϵ") || s.equals("����ϵ") || s.equals("����ϵ"))) {
					JOptionPane.showMessageDialog(this, "��Ժϵû�м�⵽ѧ����Ϣ��", "��ѯ���", JOptionPane.ERROR_MESSAGE);
				} else if (s != null && !s.equals("�ƿ�ϵ") && !s.equals("����ϵ") && !s.equals("����ϵ")) {
					JOptionPane.showMessageDialog(this, "�����ڸ�Ժϵ��", "��ѯ���", JOptionPane.ERROR_MESSAGE);
				} else if (s != null && judge != 0) {
					JOptionPane.showMessageDialog(this, "��Ժϵ��������" + judge + "��ѧ������Ϣ!", "��ѯ���",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (buttonChoose.equals("����������")) {
				String s = JOptionPane.showInputDialog(this, "����Ҫ��ѯ��ѧ��������:", "��ѯѧ��", JOptionPane.PLAIN_MESSAGE);

				if (s != null) {
					// �������ݿ�����
					String sql2 = "select * from ѧ����Ϣ where ����='" + s + "'";
					try {
						Class.forName(driver);
						Connection con2 = DriverManager.getConnection(url, userName, passWord);
						Statement stmt2 = con2.createStatement();
						ResultSet rs2 = stmt2.executeQuery(sql2);
						while (rs2.next()) {
							System.out.println("������" + rs2.getString(1));
							System.out.println("ѧ�ţ�" + rs2.getString(2));
							System.out.println("�Ա�" + rs2.getString(3));
							System.out.println("Ժϵ��" + rs2.getString(4));
							System.out.println("רҵ��" + rs2.getString(5));
							System.out.println("�༶��" + rs2.getString(6));
							System.out.println("���֤�ţ�" + rs2.getString(7));
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
						System.out.println("ע�����ݿ�ʧ��");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (s != null && judge == 0) {
					JOptionPane.showMessageDialog(this, "û�м�⵽ѧ����Ϣ��", "��ѯ���", JOptionPane.ERROR_MESSAGE);
				} else if (s != null && judge != 0) {
					JOptionPane.showMessageDialog(this, "��⵽��ѧ����Ϣ��", "��ѯ���", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		if (e.getSource() == cancleButton)

			setVisible(false);

	}

}
