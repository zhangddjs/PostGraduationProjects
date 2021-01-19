package test0801;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class findStudentAction extends JFrame implements ActionListener {
	private String buttonChoose;
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
				Scanner find = null;
				try {
					find = new Scanner(stuFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (s != null && (s.equals("计科系") || s.equals("化工系") || s.equals("管理系"))) {
					while (find.hasNext()) {
						String info = find.next();
						if (info.contains("院系：" + s)) {
							judge++;
						}
						continue;
					}
				} else if (judge == 0 && (s.equals("计科系") || s.equals("化工系") || s.equals("管理系"))) {
					JOptionPane.showMessageDialog(this, "该院系没有检测到学生信息！", "查询结果", JOptionPane.ERROR_MESSAGE);
				} else if (!s.equals("计科系") && !s.equals("化工系") && !s.equals("管理系")) {
					JOptionPane.showMessageDialog(this, "不存在该院系！", "查询结果", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "该院系共检索到" + judge + "个学生的信息!", "查询结果",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (buttonChoose.equals("按姓名查找")) {
				String s = JOptionPane.showInputDialog(this, "输入要查询的学生的姓名:", "查询学生", JOptionPane.PLAIN_MESSAGE);
				Scanner find = null;
				try {
					find = new Scanner(stuFile);
					String regex = ".*学生的信息：";
					find.useDelimiter(regex);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (s != null) {
					while (find.hasNext()) {
						String info = find.next();
						if (info.contains("姓名：" + s)) {
							System.out.printf(s+"学生的信息为：");
							System.out.printf("%s", info);
							judge++;
						} 
						if(judge == 0){
							JOptionPane.showMessageDialog(this, "没有检测到学生信息！", "查询结果", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
		if (e.getSource() == cancleButton)

			setVisible(false);

	}

}
