package test0801;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonListen extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		//���ѧ����Ϣ�Լ�����
		if(str == "���ѧ��"){
			addStudentAction newStudent = new addStudentAction();
			//newStudent.setTitle("���ѧ��");
			//newStudent.setBounds(20,20,500,200);	//���ڴ�С500*200
		}
		
		//��ӽ�ʦ��Ϣ
		if(str == "��ӽ�ʦ"){
			JOptionPane.showMessageDialog(this, "û��Ȩ��!", "��ӽ�ʦ", JOptionPane.WARNING_MESSAGE);
		}
		
		//��ѯ��ʦ��Ϣ
		if(str == "��ѯ��ʦ"){
			JOptionPane.showMessageDialog(this, "û��Ȩ��!", "��ѯ��ʦ", JOptionPane.WARNING_MESSAGE);
		}
		
		//��ѯѧ����Ϣ
		if(str == "��ѯѧ��"){
			findStudentAction findStudent = new findStudentAction();
		}
		

	}

}
