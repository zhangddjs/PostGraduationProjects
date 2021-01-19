package test10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;

public class addStudentAction extends JFrame implements ActionListener {
	// �ȿ�ʼ���֣�����������壬����������-ѧ�ţ��Ա�-Ժϵ��רҵ-�༶�����֤�ţ����水ť
	// һ����5����壬��ô�������Ϊ5��1�е�������棬���뷽ʽΪ10,10
	// �������
	// ����-ѧ�����
	JPanel row1 = new JPanel();
	JLabel nameLabel = new JLabel("����", JLabel.RIGHT);
	JTextField name = new JTextField(10);
	JLabel studyIDLabel = new JLabel("ѧ��", JLabel.RIGHT);
	JTextField studyID = new JTextField(10);

	// �Ա�-Ժϵ���
	JPanel row2 = new JPanel();
	JLabel sexLabel = new JLabel("�Ա�", JLabel.RIGHT);
	ButtonGroup sexGroup = new ButtonGroup();
	JRadioButton man = new JRadioButton("��", true);
	JRadioButton woman = new JRadioButton("Ů");
	JLabel yuanXiLabel = new JLabel("Ժϵ", JLabel.RIGHT);
	JComboBox yuanXiComBox = new JComboBox();

	// רҵ-�༶���
	JPanel row3 = new JPanel();
	JLabel zhuanYeLabel = new JLabel("רҵ", JLabel.RIGHT);
	JComboBox zhuanYeComBox = new JComboBox();
	JLabel classLabel = new JLabel("�༶", JLabel.RIGHT);
	JComboBox banJiComBox = new JComboBox();

	// ���֤�����
	JPanel row4 = new JPanel();
	JLabel personIDLabel = new JLabel("���֤��", JLabel.RIGHT);
	JTextField personID = new JTextField(18);

	// ���水ť���
	JPanel row5 = new JPanel();
	JButton save = new JButton("����");

	// ��¼�����ѧ�������Լ�ѧ������
	Student stu = new Student();

	// ���ع��캯��
	public addStudentAction() {
		// ����һ��5��һ�еĴ�СΪ500*800����
		super("���ѧ��");
		setBounds(790, 300, 370, 270);
		setLayout(new GridLayout(5, 1, 10, 10));

		// 5����嶼�Ǹ���ʽ���
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
		yuanXiComBox.addItem("�ƿ�ϵ");
		yuanXiComBox.addItem("����ϵ");
		yuanXiComBox.addItem("����ϵ");
		row2.add(yuanXiComBox);
		add(row2);

		row3.setLayout(flowLayout);
		row3.add(zhuanYeLabel);
		zhuanYeComBox.addItem("�������");
		zhuanYeComBox.addItem("��ѧ�����빤��");
		zhuanYeComBox.addItem("���");
		row3.add(zhuanYeComBox);
		row3.add(classLabel);
		banJiComBox.addItem("1��");
		banJiComBox.addItem("2��");
		banJiComBox.addItem("3��");
		row3.add(banJiComBox);
		add(row3);

		row4.setLayout(flowLayout);
		row4.add(personIDLabel);
		row4.add(personID);
		add(row4);

		row5.setLayout(flowLayout);
		row5.add(save);
		add(row5);

		// Ϊ��ť����¼������Լ��������
		save.addActionListener(this);

		setVisible(true);
	}

	// �¼�����
	public void actionPerformed(ActionEvent e){
		String nameInput = name.getText();
		String studyIDInput = studyID.getText();
		String personIDInput = personID.getText();
		String sexSelect;
		String yuanXiSelect;
		String zhuanYeSelect;
		String banJiSelect;
		
		if(sexGroup.isSelected(man.getModel()))
			sexSelect = "��";
		else
			sexSelect = "Ů";
		yuanXiSelect = yuanXiComBox.getSelectedItem().toString();
		zhuanYeSelect = zhuanYeComBox.getSelectedItem().toString();
		banJiSelect = banJiComBox.getSelectedItem().toString();
		stu.setInformation(nameInput, studyIDInput, sexSelect, yuanXiSelect, zhuanYeSelect, banJiSelect, personIDInput);
		
		if(e.getActionCommand() == "����"){
			boolean judge = false;
			
			//�жϸ�ʽ�Ƿ���ȷ
			if(nameInput.length() == 0 
					||studyIDInput.length() != 10 
					||studyIDInput.matches(".*[^0-9]+.*")
					||(personIDInput.length() != 15
					&& personIDInput.length() != 18)
					||personIDInput.matches(".*[^0123456789x]+.*")
					||!personIDInput.matches("[0-9]+[0123456789x]")){				
				JOptionPane.showMessageDialog(this, "����ʧ�ܣ���ʽ����ȷ��", "���ѧ��", JOptionPane.WARNING_MESSAGE);
				judge = true;
			}					
			
			//����ʽ��ȷ�����ظ�Ԫ���򱣴�ɹ�
			if(!judge){				
				try {
					stu.saveRow();
					JOptionPane.showMessageDialog(this, "����ɹ���", "���ѧ��", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "����ʧ����ѧ����Ϣ�������ظ���", "���ѧ��", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}