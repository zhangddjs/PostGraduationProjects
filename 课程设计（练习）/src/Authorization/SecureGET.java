package Authorization;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.heaton.bot.*;

public class SecureGET extends JFrame{
	boolean frameSizeAdjusted = false;
	JTextField _url = new JTextField();
	JButton _go = new JButton();
	JScrollPane JScrollPane1 = new JScrollPane();
	JTextArea _body = new JTextArea();
	
	public SecureGET(){
		setTitle("Secure GET");
		getContentPane().setLayout(null);
		setSize(405, 305);
		setVisible(false);
		_url.setText("http://www.baidu.com/");
		getContentPane().add(_url);
		_url.setBounds(12, 12, 312, 24);
		_go.setText("GO!");
		_go.setActionCommand("GO!");
		getContentPane().add(_go);
		_go.setBounds(336, 12, 60, 24);
		JScrollPane1.setOpaque(true);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(12, 48, 384, 252);
		_body.setEditable(false);
		JScrollPane1.getViewport().add(_body);
		_body.setBounds(0, 0, 381, 249);
		
		SymAction lSymAction = new SymAction();
		_go.addActionListener(lSymAction);
	}
	
	public SecureGET(String sTitle){
		this();
		setTitle(sTitle);
	}
	
	public void setVisible(boolean b){
		if(b)
			setLocation(50, 50);
		super.setVisible(b);
	}
	
	public static void main(String[] args) {
		(new SecureGET()).setVisible(true);
	}
	
	public void addNotify(){
		super.addNotify();
		Dimension size = getSize();
		if(frameSizeAdjusted)
			return;
		frameSizeAdjusted = true;
		Insets insets = getInsets();
		JMenuBar menuBar = getRootPane().getJMenuBar();
		int menuBarHeight = 0;
		if(menuBar != null)
			menuBarHeight = menuBar.getPreferredSize().height;
		setSize(insets.left +
				insets.right +
				size.width,
				insets.top +
				insets.bottom +
				size.height +
				menuBarHeight);
	}

	class SymAction implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object object = event.getSource();
			if(object == _go)
				Go_actionPerformed(event);
		}
	}
	
	void Go_actionPerformed(ActionEvent event){
		boolean done = false;
		HTTPSocket http = new HTTPSocket();
		while(!done){
			try{
				http.send(_url.getText(), null);
				_body.setText(http.getBody());
				done = true;
			} catch(Exception e){
				if(e.getMessage().indexOf("401") != -1){
					if((http.getUser().length()!=0) ||
							(http.getPassword().length() != 0)){
						JOptionPane.showMessageDialog(this,
								"Invalid user id/password.",
								"Security Error",
								JOptionPane.OK_CANCEL_OPTION,
								null);
					}
					SecurePrompt prompt = new SecurePrompt(this);
					prompt.show();
					if((prompt._uid.getText().length()!=0) ||
						(prompt._pwd.getText().length()!=0)){
						http.setUser(prompt._uid.getText());
						http.setPassword(prompt._pwd.getText());
					}else
						done = true;
				}else
					done = true;
				_body.setText(e.getMessage());
			}
		}
	}
}
