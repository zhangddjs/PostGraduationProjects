package test10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JFrame{
	public Menu(){
		//�½�����
		super("��Ϣ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600,300,190,190);
		//�趨��ť����
		setLayout(new FlowLayout());
		
		
		//������ť
		JButton student = new JButton("���ѧ��");
		JButton teacher = new JButton("��ӽ�ʦ");
		JButton findTeacher = new JButton("��ѯ��ʦ");
		JButton findStudent = new JButton("��ѯѧ��");
				
		//��Ӱ�ť
		add(student);add(teacher);add(findTeacher);add(findStudent);
		
		//������ť������
		ActionListener buttonListener = new ButtonListen();
		
		//���ü�����
		student.addActionListener(buttonListener);		//��һ���´���
		teacher.addActionListener(buttonListener);
		findTeacher.addActionListener(buttonListener);
		findStudent.addActionListener(buttonListener);
		//����
		setVisible(true);
	}

}
