package test10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;

public class addStudentAction extends JFrame implements ActionListener {
	// 先开始布局：创建几个面板，包括：姓名-学号，性别-院系，专业-班级，身份证号，保存按钮
	// 一共有5个面板，那么定义界面为5行1列的网格界面，对齐方式为10,10
	// 定义面板
	// 姓名-学号面板
	JPanel row1 = new JPanel();
	JLabel nameLabel = new JLabel("姓名", JLabel.RIGHT);
	JTextField name = new JTextField(10);
	JLabel studyIDLabel = new JLabel("学号", JLabel.RIGHT);
	JTextField studyID = new JTextField(10);

	// 性别-院系面板
	JPanel row2 = new JPanel();
	JLabel sexLabel = new JLabel("性别", JLabel.RIGHT);
	ButtonGroup sexGroup = new ButtonGroup();
	JRadioButton man = new JRadioButton("男", true);
	JRadioButton woman = new JRadioButton("女");
	JLabel yuanXiLabel = new JLabel("院系", JLabel.RIGHT);
	JComboBox yuanXiComBox = new JComboBox();

	// 专业-班级面板
	JPanel row3 = new JPanel();
	JLabel zhuanYeLabel = new JLabel("专业", JLabel.RIGHT);
	JComboBox zhuanYeComBox = new JComboBox();
	JLabel classLabel = new JLabel("班级", JLabel.RIGHT);
	JComboBox banJiComBox = new JComboBox();

	// 身份证号面板
	JPanel row4 = new JPanel();
	JLabel personIDLabel = new JLabel("身份证号", JLabel.RIGHT);
	JTextField personID = new JTextField(18);

	// 保存按钮面板
	JPanel row5 = new JPanel();
	JButton save = new JButton("保存");

	// 记录保存的学生个数以及学生对象
	Student stu = new Student();

	// 重载构造函数
	public addStudentAction() {
		// 构造一个5行一列的大小为500*800窗口
		super("添加学生");
		setBounds(790, 300, 370, 270);
		setLayout(new GridLayout(5, 1, 10, 10));

		// 5个面板都是浮动式面板
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
		row1.setLayout(flowLayout);
		row1.add(nameLabel);
		row1.add(name);
		row1.add(studyIDLabel);
		row1.add(studyID);
		add(row1);

		row2.setLayout(flowLayout);
		row2.add(sexLabel);
		sexGroup.add(man);
		sexGroup.add(woman);
		row2.add(man);
		row2.add(woman);
		row2.add(yuanXiLabel);
		yuanXiComBox.addItem("计科系");
		yuanXiComBox.addItem("化工系");
		yuanXiComBox.addItem("管理系");
		row2.add(yuanXiComBox);
		add(row2);

		row3.setLayout(flowLayout);
		row3.add(zhuanYeLabel);
		zhuanYeComBox.addItem("软件工程");
		zhuanYeComBox.addItem("化学工程与工艺");
		zhuanYeComBox.addItem("会计");
		row3.add(zhuanYeComBox);
		row3.add(classLabel);
		banJiComBox.addItem("1班");
		banJiComBox.addItem("2班");
		banJiComBox.addItem("3班");
		row3.add(banJiComBox);
		add(row3);

		row4.setLayout(flowLayout);
		row4.add(personIDLabel);
		row4.add(personID);
		add(row4);

		row5.setLayout(flowLayout);
		row5.add(save);
		add(row5);

		// 为按钮添加事件监听以及处理机制
		save.addActionListener(this);

		setVisible(true);
	}

	// 事件处理
	public void actionPerformed(ActionEvent e){
		String nameInput = name.getText();
		String studyIDInput = studyID.getText();
		String personIDInput = personID.getText();
		String sexSelect;
		String yuanXiSelect;
		String zhuanYeSelect;
		String banJiSelect;
		
		if(sexGroup.isSelected(man.getModel()))
			sexSelect = "男";
		else
			sexSelect = "女";
		yuanXiSelect = yuanXiComBox.getSelectedItem().toString();
		zhuanYeSelect = zhuanYeComBox.getSelectedItem().toString();
		banJiSelect = banJiComBox.getSelectedItem().toString();
		stu.setInformation(nameInput, studyIDInput, sexSelect, yuanXiSelect, zhuanYeSelect, banJiSelect, personIDInput);
		
		if(e.getActionCommand() == "保存"){
			boolean judge = false;
			
			//判断格式是否正确
			if(nameInput.length() == 0 
					||studyIDInput.length() != 10 
					||studyIDInput.matches(".*[^0-9]+.*")
					||(personIDInput.length() != 15
					&& personIDInput.length() != 18)
					||personIDInput.matches(".*[^0123456789x]+.*")
					||!personIDInput.matches("[0-9]+[0123456789x]")){				
				JOptionPane.showMessageDialog(this, "保存失败！格式不正确！", "添加学生", JOptionPane.WARNING_MESSAGE);
				judge = true;
			}					
			
			//若格式正确且无重复元素则保存成功
			if(!judge){				
				try {
					stu.saveRow();
					JOptionPane.showMessageDialog(this, "保存成功！", "添加学生", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "保存失敗！学生信息内容有重复！", "添加学生", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}