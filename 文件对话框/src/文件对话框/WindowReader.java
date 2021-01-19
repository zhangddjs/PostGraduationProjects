package �ļ��Ի���;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WindowReader extends JFrame implements ActionListener{
	JFileChooser fileDialog;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem itemSave,itemOpen;
	JTextArea text;
	BufferedReader in;
	FileReader fileReader;
	BufferedWriter out;
	FileWriter fileWriter;
	WindowReader(){
		init();
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init(){
		text = new JTextArea(10, 10);
		text.setFont(new Font("����_gb2312", Font.PLAIN, 28));
		add(new JScrollPane(text), BorderLayout.CENTER);
		menubar = new JMenuBar();
		menu = new JMenu("�ļ�");
		itemSave = new JMenuItem("�����ļ�");
		itemOpen = new JMenuItem("���ļ�");
		itemSave.addActionListener(this);
		itemOpen.addActionListener(this);
		menu.add(itemSave);
		menu.add(itemOpen);
		menubar.add(menu);
		setJMenuBar(menubar);
		fileDialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("java �ļ�", "java");
		fileDialog.setFileFilter(filter);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == itemSave){
			int state = fileDialog.showSaveDialog(this);
			if(state == JFileChooser.APPROVE_OPTION){
				try{
					File dir = fileDialog.getCurrentDirectory();
					String name = fileDialog.getSelectedFile().getName();
					File file = new File(dir, name);
					fileWriter = new FileWriter(file);
					out = new BufferedWriter(fileWriter);
					out.write(text.getText());
					out.close();
					fileWriter.close();
				}
				catch(IOException exp){}
			}
		}
		else if(e.getSource() == itemOpen){
			int state = fileDialog.showOpenDialog(this);
			if(state == JFileChooser.APPROVE_OPTION){
				text.setText(null);
				try{
					File dir = fileDialog.getCurrentDirectory();
					String name = fileDialog.getSelectedFile().getName();
					File file = new File(dir, name);
					fileReader = new FileReader(file);
					in = new BufferedReader(fileReader);
					String s = null;
					while((s = in.readLine()) != null){
						text.append(s + "\n");
					}
					in.close();
					fileReader.close();
				}
				catch(IOException exp){}
			}
		}
	}
}
