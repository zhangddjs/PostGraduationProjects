package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8D85\u5E02\u7BA1\u7406");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JButton button = new JButton("\u6DFB\u52A0\u5546\u54C1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add add = new Add();
			}
		});
		button.setBounds(163, 58, 93, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u67E5\u8BE2\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select slc = new Select();
			}
		});
		button_1.setBounds(163, 107, 93, 23);
		panel.add(button_1);
	}
}
