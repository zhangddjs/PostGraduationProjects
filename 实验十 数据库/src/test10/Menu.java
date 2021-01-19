package test10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JFrame{
	public Menu(){
		//新建窗口
		super("信息");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600,300,190,190);
		//设定按钮类型
		setLayout(new FlowLayout());
		
		
		//创建按钮
		JButton student = new JButton("添加学生");
		JButton teacher = new JButton("添加教师");
		JButton findTeacher = new JButton("查询教师");
		JButton findStudent = new JButton("查询学生");
				
		//添加按钮
		add(student);add(teacher);add(findTeacher);add(findStudent);
		
		//创建按钮监视器
		ActionListener buttonListener = new ButtonListen();
		
		//调用监视器
		student.addActionListener(buttonListener);		//打开一个新窗口
		teacher.addActionListener(buttonListener);
		findTeacher.addActionListener(buttonListener);
		findStudent.addActionListener(buttonListener);
		//可视
		setVisible(true);
	}

}
