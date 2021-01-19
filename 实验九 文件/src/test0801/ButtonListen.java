package test0801;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonListen extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		//添加学生信息以及保存
		if(str == "添加学生"){
			addStudentAction newStudent = new addStudentAction();
			//newStudent.setTitle("添加学生");
			//newStudent.setBounds(20,20,500,200);	//窗口大小500*200
		}
		
		//添加教师信息
		if(str == "添加教师"){
			JOptionPane.showMessageDialog(this, "没有权限!", "添加教师", JOptionPane.WARNING_MESSAGE);
		}
		
		//查询教师信息
		if(str == "查询教师"){
			JOptionPane.showMessageDialog(this, "没有权限!", "查询教师", JOptionPane.WARNING_MESSAGE);
		}
		
		//查询学生信息
		if(str == "查询学生"){
			findStudentAction findStudent = new findStudentAction();
		}
		

	}

}
