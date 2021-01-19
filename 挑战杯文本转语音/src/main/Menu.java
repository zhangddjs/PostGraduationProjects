package main;

import java.awt.EventQueue;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.JList;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1140, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		  {
		   UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		   SwingUtilities.updateComponentTreeUI(frame);
		  }
		catch(Exception ex)
		  {
		   System.out.println("Exception:"+ex); 
		  }
		KeyStroke Ctrl_cutKey;
		FileReader fileReader;
		FileWriter fileWriter;
		BufferedReader in;
		BufferedWriter out;
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnfile = new JMenu("\u6587\u4EF6(file)");
		menuBar.add(mnfile);
		
		JMenuItem mntmnew = new JMenuItem("\u65B0\u5EFA(new)");
		mntmnew.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK);
		mntmnew.setAccelerator(Ctrl_cutKey);
		mnfile.add(mntmnew);
		
		JMenuItem mntmopen = new JMenuItem("\u6253\u5F00(open)");
		mntmopen.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
		mntmopen.setAccelerator(Ctrl_cutKey);
		mnfile.add(mntmopen);
		
		JMenuItem mntmsave = new JMenuItem("\u4FDD\u5B58(save)");
		mntmsave.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
		mntmsave.setAccelerator(Ctrl_cutKey);
		mnfile.add(mntmsave);
		
		JMenuItem mntmsaveAs = new JMenuItem("\u53E6\u5B58\u4E3A(save as...)");
		mnfile.add(mntmsaveAs);
		
		JMenuItem mntmexit = new JMenuItem("\u9000\u51FA(exit)");
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK);
		mntmexit.setAccelerator(Ctrl_cutKey);
		mnfile.add(mntmexit);
		
		JMenu mnedit = new JMenu("\u7F16\u8F91(edit)");
		menuBar.add(mnedit);
		
		JMenuItem mntmundo = new JMenuItem("\u64A4\u9500(undo)");
		mntmundo.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		mntmundo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnedit.add(mntmundo);
		
		JMenuItem mntmredo = new JMenuItem("\u91CD\u590D(redo)");
		mntmredo.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		mntmredo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		mnedit.add(mntmredo);
		
		JMenuItem mntmcut = new JMenuItem("\u526A\u5207(cut)");
		mntmcut.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		mntmcut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnedit.add(mntmcut);
		
		JMenuItem mntmcopy = new JMenuItem("\u590D\u5236(copy)");
		mntmcopy.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		mntmcopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnedit.add(mntmcopy);
		
		JMenuItem mntmpaste = new JMenuItem("\u7C98\u8D34(paste)");
		mntmpaste.setIcon(new ImageIcon(Menu.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		mntmpaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnedit.add(mntmpaste);
		
		JMenu mnview = new JMenu("\u89C6\u56FE(view)");
		menuBar.add(mnview);
		
		JMenu mnplayback = new JMenu("\u72B6\u6001(playback)");
		menuBar.add(mnplayback);
		
		JMenuItem mntmstop = new JMenuItem("\u505C\u6B62(stop)");
		mnplayback.add(mntmstop);
		
		JMenuItem mntmpause = new JMenuItem("\u6682\u505C(pause)");
		mnplayback.add(mntmpause);
		
		JMenuItem mntmplay = new JMenuItem("\u64AD\u653E(play)");
		mnplayback.add(mntmplay);
		
		JMenuItem mntmprevious = new JMenuItem("\u4E0A\u4E00\u4E2A(previous)");
		mnplayback.add(mntmprevious);
		
		JMenuItem mntmnext = new JMenuItem("\u4E0B\u4E00\u4E2A(next)");
		mnplayback.add(mntmnext);
		
		JMenu mnhelp = new JMenu("\u5E2E\u52A9(help)");
		menuBar.add(mnhelp);
		
		JMenuItem mntmabout = new JMenuItem("\u5173\u4E8E(About)");
		mnhelp.add(mntmabout);
		
		JToolBar toolBar_1 = new JToolBar();
		menuBar.add(toolBar_1);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(".\\icon\\Z1P5T)AF_8BD)O4]LK3A6@K.jpg"));
		toolBar_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(".\\icon\\[XP@VW$9~6_X1[1RV}NX)@A.jpg"));
		toolBar_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(".\\icon\\@AITQ]]N{H]VCD{1606183R.jpg"));
		toolBar_1.add(button_3);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(".\\icon\\B`5XQO5T0LH{TP6UYY(G_B4.jpg"));
		toolBar_1.add(button_5);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(".\\icon\\6IXHYG)43RI363]RIF9%M~6.jpg"));
		toolBar_1.add(button_4);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 158, 447);
		frame.getContentPane().add(list);
	}
}
