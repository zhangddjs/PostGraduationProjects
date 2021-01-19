package Authorization;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SecurePrompt extends JDialog{
	boolean frameSizeAdjusted = false;
	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JTextField _uid = new JTextField();
	JButton _ok = new JButton();
	JPasswordField _pwd = new JPasswordField();
	JButton _cancel = new JButton();
	
	public SecurePrompt(Frame Parent){
		super(Parent, true);
		setTitle("Security");
		getContentPane().setLayout(null);
		setSize(403, 129);
		setVisible(false);
		JLabel1.setText("User ID:");
		getContentPane().add(JLabel1);
		JLabel1.setBounds(12, 12, 49, 24);
		JLabel2.setText("Password:");
		getContentPane().add(JLabel2);
		JLabel2.setBounds(12, 48, 72, 24);
		_uid.setText("jheaton");
		getContentPane().add(_uid);
		_uid.setBounds(72, 12, 324, 24);
		_ok.setText("OK");
		getContentPane().add(_ok);
		_ok.setBounds(60, 84, 84, 24);
		getContentPane().add(_pwd);
		_pwd.setBounds(72, 48, 324, 24);
		_cancel.setText("Cancel");
		getContentPane().add(_cancel);
		_cancel.setBounds(264, 84, 84, 24);
		SymAction lSymAction = new SymAction();
		_ok.addActionListener(lSymAction);
		_cancel.addActionListener(lSymAction);
	}
	
	public void setVisible(boolean b){
		if(b)
			setLocation(50, 50);
		super.setVisible(b);
	}
	
	public void addNotify(){
		super.addNotify();
		Dimension size = getSize();
		if(frameSizeAdjusted)
			return;
		frameSizeAdjusted = true;
		
		Insets insets = getInsets();
		setSize(insets.left +
				insets.right +
				size.width,
				insets.top +
				insets.bottom +
				size.height);
	}
	
	class SymAction implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object object = event.getSource();
			if(object == _ok)
				Ok_actionPerformed(event);
			else if(object == _cancel)
				Cancel_actionPerformed(event);
		}
	}
	
	void Ok_actionPerformed(ActionEvent event){
		setVisible(false);
	}
	
	void Cancel_actionPerformed(ActionEvent event){
		_uid.setText("");
		_pwd.setText("");
		setVisible(false);
	}

}
