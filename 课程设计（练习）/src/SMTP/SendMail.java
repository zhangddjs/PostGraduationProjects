package SMTP;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.swing.*;
public class SendMail extends JFrame{
	public SendMail(){
		setTitle("SendMail Example");
		getContentPane().setLayout(null);
		setSize(736, 312);
		setVisible(false);
		JLabel1.setText("From:");
		getContentPane().add(JLabel1);
		JLabel1.setBounds(12, 12, 36, 12);
		JLabel2.setText("To:");
		getContentPane().add(JLabel2);
		JLabel2.setBounds(12, 48, 36, 12);
		JLabel3.setText("Subject:");
		getContentPane().add(JLabel3);
		JLabel3.setBounds(12, 84, 48, 12);
		JLabel4.setText("SMTP Server:");
		getContentPane().add(JLabel4);
		JLabel4.setBounds(12, 120, 84, 12);
		getContentPane().add(_from);
		_from.setBounds(96, 12, 300, 24);
		getContentPane().add(_to);
		_to.setBounds(96, 48, 300, 24);
		getContentPane().add(_subject);
		_subject.setBounds(96, 84, 300, 24);
		getContentPane().add(_smtp);
		_smtp.setBounds(96, 120, 300, 24);
		getContentPane().add(_scrollPane2);
		_scrollPane2.setBounds(12, 156, 384, 108);
		_body.setText("Enter your message here.");
		_scrollPane2.getViewport().add(_body);
		_body.setBounds(0, 0, 381, 105);
		Send.setText("Sent");
		Send.setActionCommand("Send");
		getContentPane().add(Send);
		Send.setBounds(60, 276, 132, 24);
		Cancel.setText("Cancel");
		Cancel.setActionCommand("Cancel");
		getContentPane().add(Cancel);
		Cancel.setBounds(216, 276, 120, 24);
		getContentPane().add(_scrollPane);
		_scrollPane.setBounds(408, 12, 312, 288);
		getContentPane().add(_output);
		_output.setBounds(408, 12, 309, 285);
		
		
		SymAction lSymAction = new SymAction();
		Send.addActionListener(lSymAction);
		Cancel.addActionListener(lSymAction);
		
		
		_output.setModel(_model);
		_model.addElement("Server output displayed here:");
		_scrollPane.getViewport().setView(_output);
		_scrollPane2.getViewport().setView(_body);


	}
	
	public void setVisible(boolean b){
		if(b)
			setLocation(50, 50);
		super.setVisible(b);
	}

	static public void main(String args[]){
		(new SendMail()).show();
	}
	
	public void addNotify(){
		Dimension size = getSize();
		super.addNotify();
		if(frameSizeAdjusted)
			return;
		frameSizeAdjusted = true;
		
		Insets insets = getInsets();
		JMenuBar menuBar = getRootPane().getJMenuBar();
		int menuBarHeight = 0;
		if(menuBar != null)
			menuBarHeight = menuBar.getPreferredSize().height;
		setSize(insets.left
				+ insets.right
				+ size.width,
				insets.top
				+ insets.bottom
				+ size.height
				+ menuBarHeight);
	}
	
	boolean frameSizeAdjusted = false;
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JLabel JLabel3 = new JLabel();
	JLabel JLabel4 = new JLabel();
	JTextField _from = new JTextField();
	JTextField _to = new JTextField();
	JTextField _subject = new JTextField();
	JTextField _smtp = new JTextField();
	JScrollPane _scrollPane2 = new JScrollPane();
	JTextArea _body = new JTextArea();
	JButton Send = new JButton();
	JButton Cancel = new JButton();
	JScrollPane _scrollPane = new JScrollPane();
	JList _output = new JList();
	DefaultListModel _model = new DefaultListModel();
	BufferedReader _in;
	PrintWriter _out;	
	
	class SymAction implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object object = event.getSource();
			if(object == Send)
				Send_actionPerformed(event);
			else if(object == Cancel)
				Cancel_actionPerformed(event);
		}
	}
	protected void send(String s) throws IOException{
		if(s!=null){
			_model.addElement("C:" + s);
			_out.println(s);
			_out.flush();
		}
		
		String line = _in.readLine();
		if(line != null){
			_model.addElement("S:" + line);
		}
	}
	
	void Send_actionPerformed(ActionEvent event){
		try{
			Socket s = new Socket(_smtp.getText(), 25);
			_out = new PrintWriter(s.getOutputStream());
			_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			send(null);
			send("HELO: " + java.net.InetAddress.getLocalHost().getHostName());
			send("MAIL FROM: " + _from.getText());
			send("RCPT TO: " + _to.getText());
			send("DATA");
			_out.println("Subject:" + _subject.getText());
			_out.println(_body.getText());
			send(".");
			s.close();
		} catch (Exception e){
			_model.addElement("Error: " + e);
		}
	}
	
	void Cancel_actionPerformed(ActionEvent event){
		System.exit(0);
	}
}


