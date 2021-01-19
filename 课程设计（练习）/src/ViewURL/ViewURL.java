package ViewURL;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.*;
import com.heaton.bot.*;

public class ViewURL extends JFrame{
	HTTP _http;
	public ViewURL(){
		_http = new HTTPSocket();
		setTitle("View URL");
		getContentPane().setLayout(null);
		setSize(495, 341);
		setVisible(false);
		getContentPane().add(_pane2);
		_pane2.setBounds(12, 168, 456, 144);
		_body.setBounds(0, 0, 456, 144);
		_pane2.getViewport().add(_body);
		_body.setBounds(0, 0, 453, 141);
		getContentPane().add(_pane1);
		_pane1.setBounds(12, 72, 456, 72);
		_pane1.getViewport().add(_headers);
		_headers.setBounds(0, 0, 453, 0);
		_label3.setText("Body");
		getContentPane().add(_label3);
		_label3.setBounds(12, 144, 456, 12);
		_label1.setText("URL:");
		getContentPane().add(_label1);
		_label1.setBounds(12, 12, 36, 24);
		_url.setText("http://www.baidu.com/");
		getContentPane().add(_url);
		_url.setBounds(48, 12, 348, 24);
		_go.setText("Go");
		_go.setActionCommand("Go");
		getContentPane().add(_go);
		_go.setBounds(408, 12, 60, 24);
		_label2.setText("HTTP Headers");
		getContentPane().add(_label2);
		_label2.setBounds(12, 48, 384, 12);
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		_go.addActionListener((ActionListener) lSymAction);
	}

	public void setVisible(boolean b){
		if(b)
			setLocation(50, 50);
		super.setVisible(b);
	}
	
	static public void main(String args[]){
		(new ViewURL()).setVisible(true);
	}
	
	public void addNotify(){
		Dimension size = getSize();
		super.addNotify();
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
	
	boolean frameSizeAdjusted = false;
	JScrollPane _pane2 = new JScrollPane();
	JTextArea _body = new JTextArea();
	JScrollPane _pane1 = new JScrollPane();
	JTable _headers = new JTable();
	JLabel _label3 = new JLabel();
	JLabel _label2 = new JLabel();
	JLabel _label1 = new JLabel();
	JTextField _url = new JTextField();
	JButton _go = new JButton();
	
	class SymWindow extends WindowAdapter{
		public void windowClosed(WindowEvent event){
			Object object = event.getSource();
			if(object == ViewURL.this)
				ViewURL_windowClosed(event);
		}
		
		public void windowClosing(WindowEvent event){
			Object object = event.getSource();
			if(object == ViewURL.this)
				ViewURL_WindowClosing(event);
		}
	}
	
	void ViewURL_WindowClosing(WindowEvent event){
		setVisible(false);
		dispose();
	}
	
	class SymAction implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object object = event.getSource();
			if(object == _go)
				Go_actionPerformed(event);
		}
	}
	
	void Go_actionPerformed(ActionEvent event){
		try{
			_http.send(_url.getText(), null);
			_body.setText(_http.getBody());
			_url.setText(_http.getURL());
			
			TableModel dataModel = new AbstractTableModel(){
				public int getColumnCount(){
					return 2;
				}
				public int getRowCount(){
					return _http.getServerHeaders().length();
				}
				public String getColumnName(int columnIndex){
					switch(columnIndex){
					case 0:return "HTTP Header";
					case 1:return "Value";
					}
					return "";
				}
				public Object getValueAt(int row, int col){
					if(col == 0)
						return _http.getServerHeaders().get(row).getName();
					else
						return _http.getServerHeaders().get(row).getValue();
				}
			};
			_headers.setModel(dataModel);
			_headers.sizeColumnsToFit(0);
		} catch(Exception e){
			_body.setText(e.toString());
		}
	}
	
	void ViewURL_windowClosed(WindowEvent event){
		System.exit(0);
	}
}
