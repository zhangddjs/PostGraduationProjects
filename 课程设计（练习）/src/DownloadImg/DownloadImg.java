package DownloadImg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.heaton.bot.HTMLPage;
import com.heaton.bot.HTTPSocket;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class DownloadImg {

	private JFrame frmDownloadImages;
	private JTextField _url;
	private JTextField _save;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DownloadImg window = new DownloadImg();
					window.frmDownloadImages.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DownloadImg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDownloadImages = new JFrame();
		frmDownloadImages.setTitle("Download Images");
		frmDownloadImages.setBounds(100, 100, 409, 357);
		frmDownloadImages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDownloadImages.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Download images from(one page only):");
		lblNewLabel.setBounds(10, 10, 244, 15);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmDownloadImages.getContentPane().add(lblNewLabel);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(10, 35, 54, 15);
		lblUrl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmDownloadImages.getContentPane().add(lblUrl);

		_url = new JTextField();
		_url.setText("http://www.heatonresearch.com/about/");
		_url.setBounds(50, 32, 333, 21);
		frmDownloadImages.getContentPane().add(_url);
		_url.setColumns(10);

		JLabel lblSelectALocal = new JLabel("Select local path to download images to:");
		lblSelectALocal.setBounds(10, 60, 244, 15);
		lblSelectALocal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmDownloadImages.getContentPane().add(lblSelectALocal);

		_save = new JTextField();
		_save.setText("E:\\java\u8BFE\u7A0B\u8BBE\u8BA1\\\u8BD5\u9A8C\u6210\u679C\\DownloadImages");
		_save.setBounds(10, 85, 373, 21);
		frmDownloadImages.getContentPane().add(_save);
		_save.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 149, 373, 160);
		frmDownloadImages.getContentPane().add(scrollPane);

		JList _log = new JList();
		scrollPane.setViewportView(_log);

		JButton _go = new JButton("Go!");
		_go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HTTPSocket http = new HTTPSocket();
					HTMLPage page = new HTMLPage(http);
					page.open(_url.getText(), null);
					Vector vec = page.getImages();
					if (vec.size() > 0) {
						String array[] = new String[vec.size()];
						vec.copyInto(array);
						_log.setListData(array);
						for (int i = 0; i < vec.size(); i++) {
							processImage((String) vec.elementAt(i));
						}
					}
				} catch (Exception e1) {
					String s[] = new String[1];
					s[0] = "Error:" + e1;
					_log.setListData(s);
				}
			}
		});
		_go.setBounds(130, 116, 130, 23);
		frmDownloadImages.getContentPane().add(_go);

	}

	protected void processImage(String name) {
		try {
			if (_save.getText().length() > 0) {
				int i = name.lastIndexOf("/");
				if (i != -1) {
					FileOutputStream fso = new FileOutputStream(new File(_save.getText(), name.substring(i)));
					HTTPSocket http = new HTTPSocket();
					URL url = new URL(name);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					InputStream inputStream = conn.getInputStream();
					byte[] getData = readInputStream(inputStream);
					fso.write(getData);
					fso.close();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmDownloadImages, e, "Error", JOptionPane.OK_CANCEL_OPTION, null);
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
}
