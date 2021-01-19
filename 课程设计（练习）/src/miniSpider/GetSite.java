package miniSpider;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.heaton.bot.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;

public class GetSite  implements ISpiderReportable{

	private JFrame frame;
	private JTextField _url;
	private JTextField _save;
	private JTextField _logPath;
	Spider _Spider = null;
	int _pagesCount;
	boolean frameSizeAdjusted = false;
	private JLabel _current;
	private JLabel lblNewLabel;
	private JLabel lblUrl;
	private JLabel lblSelectLo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel _pages;
	private JButton _go;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetSite window = new GetSite();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GetSite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Download pages of:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 10, 150, 21);
		frame.getContentPane().add(lblNewLabel);
		
		lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUrl.setBounds(22, 41, 54, 15);
		frame.getContentPane().add(lblUrl);
		
		_url = new JTextField();
		_url.setText("http://www.baidu.com/");
		_url.setBounds(63, 38, 361, 21);
		frame.getContentPane().add(_url);
		_url.setColumns(10);
		
		lblSelectLo = new JLabel("Select local path to downloads files:");
		lblSelectLo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelectLo.setBounds(22, 81, 219, 15);
		frame.getContentPane().add(lblSelectLo);
		
		_save = new JTextField();
		_save.setText("E:\\java\u8BFE\u7A0B\u8BBE\u8BA1\\\u8BD5\u9A8C\u6210\u679C\\Spider\\downloads");
		_save.setBounds(22, 106, 402, 21);
		frame.getContentPane().add(_save);
		_save.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Select local path(or filename) to write log to(optional):");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(22, 137, 315, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		_logPath = new JTextField();
		_logPath.setText("E:\\java\u8BFE\u7A0B\u8BBE\u8BA1\\\u8BD5\u9A8C\u6210\u679C\\Spider\\log\\spider.log");
		_logPath.setBounds(22, 162, 402, 21);
		frame.getContentPane().add(_logPath);
		_logPath.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Number of pages:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 202, 112, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		_pages = new JLabel("0");
		_pages.setBounds(129, 202, 54, 15);
		frame.getContentPane().add(_pages);
		
		_current = new JLabel("");
		_current.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		_current.setBounds(22, 227, 402, 15);
		frame.getContentPane().add(_current);
		
		_go = new JButton("GO!");
		SymAction lSymAction = new SymAction();
		_go.addActionListener(lSymAction);
		_go.setBounds(111, 259, 211, 23);
		frame.getContentPane().add(_go);
		_go.setActionCommand("jbutton");
		
		
	}
	class SymAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == _go) {
				Go_actionPerformed(e);
			}
		}
	}
	void Go_actionPerformed(ActionEvent e){
		IWorkloadStorable w1 = new SpiderInternalWorkload();
		if (_Spider != null) {
			Runnable doLater = new Runnable() {
				public void run() {
					_go.setText("Canceling...");
				}
			};
			SwingUtilities.invokeLater(doLater);
			_Spider.halt();
			return;
		}
		try {
			if (_url.getText().length() > 0) {
				HTTPSocket http = new HTTPSocket();
				http.send(_url.getText(), null);
			} else {
				_current.setText("<<distributed mode>>");
				return;
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "Error URL!", "Error", JOptionPane.OK_CANCEL_OPTION, null);
			return;
		}
		Runnable doLater = new Runnable() {
			public void run() {
				_go.setText("Cancel");
				_current.setText("Loading....");
			}
		};
		SwingUtilities.invokeLater(doLater);
		_pagesCount = 0;
		if (_logPath.getText().length() > 0) {
			File file = new File(_logPath.getText());
			file.delete();
			Log.setLevel(Log.LOG_LEVEL_NORMAL);
			Log.setFile(true);
			Log.setConsole(false);
			Log.setPath(_logPath.getText());
		}
//		try {
//			w1 = new SpiderSQLWorkload("sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:WOEKLOAD");
//		} catch (Exception e1) {
//			JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.OK_CANCEL_OPTION, null);
//		}
		_Spider = new Spider(this, _url.getText(), new HTTPSocket(), 100, w1);
		_Spider.setMaxBody(200);
		_Spider.start();
	}
	
	protected void processFile(HTTP file){
		try{
			if(_save.getText().length() > 0){
				int i = file.getURL().lastIndexOf("/");
				if(i != -1){
					String filename = file.getURL();
					FileOutputStream fso = new FileOutputStream(new File(_save.getText(), filename.substring(i)));
					URL url = new URL(filename);

					if(filename.equals("/"))
						filename = "root.html";
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					InputStream inputStream = conn.getInputStream();
					byte[] getData = readInputStream(inputStream);
					fso.write(getData);
					fso.close();
				}
			}
		} catch(Exception e){
			Log.logException("Can't save output file:", e);
		}
	}
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}

		bos.close();
		return bos.toByteArray();
	}
	
	public boolean foundInternalLink(String url){
		return true;
	}
	public boolean foundExternalLink(String url){
		return false;
	}
	public boolean foundOtherLink(String url){
		return false;
	}
	
	class UpdateTarget implements Runnable{
		public String _t;
		public void run(){
			_current.setText(_t);
			_pages.setText("" + _pagesCount);
		}
	}
	public void processPage(HTTP page){
		_pagesCount++;
		UpdateTarget ut = new UpdateTarget();
		ut._t = page.getURL();
		SwingUtilities.invokeLater(ut);
		processFile(page);
	}
	
	public void completePage(HTTP page, boolean error){}
	public boolean getRemoveQuery(){
		return true;
	}
	public void spiderComplete(){
		if(_Spider.isHalted()){
			JOptionPane.showMessageDialog(frame,
							"Download of site has been canceled."
							+ "Check log file for any errors.",
							"Done",
							JOptionPane.OK_CANCEL_OPTION,
							null);
		}
		else{
			JOptionPane.showMessageDialog(frame,
					"Download of site is complete."
					+ "Check log file for any errors.",
					"Done",
					JOptionPane.OK_CANCEL_OPTION,
					null);
		}
		_Spider = null;
		Runnable doLater = new Runnable(){
			public void run(){
				_go.setText("GO!");
			}
		};
		SwingUtilities.invokeLater(doLater);
	}

	
}
