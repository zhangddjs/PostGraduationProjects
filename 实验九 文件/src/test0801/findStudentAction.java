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
				Scanner find = null;
				try {
					find = new Scanner(stuFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (s != null && (s.equals("�ƿ�ϵ") || s.equals("����ϵ") || s.equals("����ϵ"))) {
					while (find.hasNext()) {
						String info = find.next();
						if (info.contains("Ժϵ��" + s)) {
							judge++;
						}
						continue;
					}
				} else if (judge == 0 && (s.equals("�ƿ�ϵ") || s.equals("����ϵ") || s.equals("����ϵ"))) {
					JOptionPane.showMessageDialog(this, "��Ժϵû�м�⵽ѧ����Ϣ��", "��ѯ���", JOptionPane.ERROR_MESSAGE);
				} else if (!s.equals("�ƿ�ϵ") && !s.equals("����ϵ") && !s.equals("����ϵ")) {
					JOptionPane.showMessageDialog(this, "�����ڸ�Ժϵ��", "��ѯ���", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "��Ժϵ��������" + judge + "��ѧ������Ϣ!", "��ѯ���",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (buttonChoose.equals("����������")) {
				String s = JOptionPane.showInputDialog(this, "����Ҫ��ѯ��ѧ��������:", "��ѯѧ��", JOptionPane.PLAIN_MESSAGE);
				Scanner find = null;
				try {
					find = new Scanner(stuFile);
					String regex = ".*ѧ������Ϣ��";
					find.useDelimiter(regex);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (s != null) {
					while (find.hasNext()) {
						String info = find.next();
						if (info.contains("������" + s)) {
							System.out.printf(s+"ѧ������ϢΪ��");
							System.out.printf("%s", info);
							judge++;
						} 
						if(judge == 0){
							JOptionPane.showMessageDialog(this, "û�м�⵽ѧ����Ϣ��", "��ѯ���", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
		if (e.getSource() == cancleButton)

			setVisible(false);

	}

}
