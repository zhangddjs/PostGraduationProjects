package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Application extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu menuFile = new JMenu("文件(File)");
	private final JMenu menuEdit = new JMenu("编辑(Edit)");
	private final JMenu menuFormat = new JMenu("格式(Format)");
	private final JMenu menuHelp = new JMenu("帮助");
	protected UndoManager undoManager = new UndoManager();
	private final JMenuItem itemSetFile = new JMenuItem("新建(New)");
	private final JMenuItem itemOpen = new JMenuItem("打开(Open)");
	private final JMenuItem itemSaveAs = new JMenuItem("另存为(Save As...)");
	private final JMenuItem itemExit = new JMenuItem("退出(Exit)");
	private final JMenuItem itemCopy = new JMenuItem("复制(Copy)");
	private final JMenuItem itemPaste = new JMenuItem("粘贴(Paste)");
	private final JMenuItem itemUndo = new JMenuItem("撤销(Undo)");
	private final JMenuItem itemRedo = new JMenuItem("重复(Redo)");
	private final JMenuItem itemCut = new JMenuItem("剪切(Cut)");
	private final JMenuItem itemSave = new JMenuItem("保存(Save)");
	private final JMenuItem itemLineWrap = new JMenuItem("取消自动换行");
	private final JMenuItem itemAbout = new JMenuItem("关于(about)");
	private final JButton play = new JButton("朗读");
	JTextArea notePad = new JTextArea();
	KeyStroke Ctrl_cutKey;
	FileReader fileReader;
	FileWriter fileWriter;
	BufferedReader in;
	BufferedWriter out;

	public Application() {
		super("NotePad");
		setBounds(600, 300, 400, 400);
		addWindowListener(new WindowAdapter() { // 添加一个窗口监听
			public void windowClosing(WindowEvent e) { // 这是窗口关闭事件
				String command = "taskkill /f /im wscript.exe";
				try {
					Runtime.getRuntime().exec(command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0); // 退出
			}
		});

		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK);
		itemSetFile.setIcon(new ImageIcon(Application.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		itemSetFile.setAccelerator(Ctrl_cutKey);
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
		itemOpen.setIcon(new ImageIcon(Application.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		itemOpen.setAccelerator(Ctrl_cutKey);
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK);
		itemExit.setAccelerator(Ctrl_cutKey);
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK);
		itemCopy.setIcon(new ImageIcon(Application.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		itemCopy.setAccelerator(Ctrl_cutKey);
		Ctrl_cutKey = KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK);
		itemPaste
				.setIcon(new ImageIcon(Application.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		itemPaste.setAccelerator(Ctrl_cutKey);
		itemUndo.setEnabled(false);
		itemRedo.setEnabled(false);
		itemSetFile.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSaveAs.addActionListener(this);
		itemExit.addActionListener(this);
		itemCopy.addActionListener(this);
		itemPaste.addActionListener(this);
		itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		itemUndo.addActionListener(this);
		itemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		itemRedo.addActionListener(this);
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		itemCut.addActionListener(this);
		itemSave.addActionListener(this);
		itemLineWrap.addActionListener(this);
		itemAbout.addActionListener(this);
		notePad.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
				updateButtons();
			}
		});
		notePad.setLineWrap(true);

		menuFile.add(itemSetFile);
		menuFile.add(itemOpen);
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		itemSave.setIcon(new ImageIcon(Application.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));

		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		menuFile.add(itemExit);
		menuBar.add(menuFile);
		itemUndo.setIcon(new ImageIcon(Application.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));

		menuEdit.add(itemUndo);
		itemRedo.setIcon(new ImageIcon(Application.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));

		menuEdit.add(itemRedo);
		itemCut.setIcon(new ImageIcon(Application.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));

		menuEdit.add(itemCut);
		menuEdit.add(itemCopy);
		menuEdit.add(itemPaste);
		menuBar.add(menuEdit);

		menuFormat.add(itemLineWrap);
		menuBar.add(menuFormat);

		setJMenuBar(menuBar);

		menuBar.add(menuHelp);
		itemAbout.setIcon(new ImageIcon(Application.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));

		menuHelp.add(itemAbout);
		getContentPane().add(notePad);
		JScrollPane scrollPane = new JScrollPane(notePad);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setColumnHeaderView(play);
		play.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		JFileChooser Open = new JFileChooser();
		JFileChooser Save = new JFileChooser();
		FileNameExtensionFilter Text = new FileNameExtensionFilter("文本文件(*.txt)", "txt");
		Open.setFileFilter(Text);
		Save.setFileFilter(Text);

		if (s == "新建(New)") {
			notePad.setText(null);
		} else if (s == "打开(Open)") {

			int state = Open.showOpenDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				notePad.setText(null);
				try {
					File dir = Open.getCurrentDirectory();
					String name = Open.getSelectedFile().getName();
					File file = new File(dir, name);
					fileReader = new FileReader(file);
					in = new BufferedReader(fileReader);
					String str = null;
					while ((str = in.readLine()) != null) {
						notePad.append(str + "\n");
					}
					in.close();
					fileReader.close();
				} catch (IOException exp) {
				}
			}
		} else if (s == "朗读") {
			try {
				File file = new File("C:\\Users\\voice.vbs");
				fileWriter = new FileWriter(file);
				out = new BufferedWriter(fileWriter);
				String regexp = "\"";
				String str = notePad.getText();
				str = str.replaceAll(regexp, "");
				str = str.replaceAll(" ", "");
				str = str.replaceAll("\n", "");
				out.write("CreateObject(\"SAPI.SpVoice\").Speak \"" + str + "\"");
				out.close();
				fileWriter.close();
				Runtime.getRuntime().exec("cmd.exe /c start C:\\Users\\voice.vbs", null, new File("C:"));
				play.setText("停止朗读");
			} catch (IOException exp) {
			}
		} else if (s == "停止朗读") {
			try {
				String command = "taskkill /f /im wscript.exe";
				Runtime.getRuntime().exec(command);
				play.setText("朗读");
			} catch (IOException exp) {
			}
		} else if (s == "另存为(Save As...)") {
			int state = Save.showSaveDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				try {
					File dir = Save.getCurrentDirectory();
					String name = Save.getSelectedFile().getName();
					File file = new File(dir, name);
					fileWriter = new FileWriter(file);
					out = new BufferedWriter(fileWriter);
					out.write(notePad.getText());
					out.close();
					fileWriter.close();
				} catch (IOException exp) {
				}
			}
		} else if (s == "复制(Copy)") {
			notePad.copy();
		} else if (s == "粘贴(Paste)") {
			notePad.paste();
		} else if (s == "剪切(Cut)") {
			notePad.cut();
		} else if (s == "撤销(Undo)") {
			try {
				undoManager.undo();
			} catch (CannotRedoException cre) {
				cre.printStackTrace();
			}
			updateButtons();
		} else if (s == "重复(Redo)") {
			try {
				undoManager.redo();
			} catch (CannotRedoException cre) {
				cre.printStackTrace();
			}
			updateButtons();
		} else if (s == "保存(Save)") {
			int state = Save.showSaveDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				try {
					File dir = Save.getCurrentDirectory();
					String name = Save.getSelectedFile().getName();
					File file = new File(dir, name);
					fileWriter = new FileWriter(file);
					out = new BufferedWriter(fileWriter);
					out.write(notePad.getText());
					out.close();
					fileWriter.close();
				} catch (IOException exp) {
				}
			}
		} else if (s == "自动换行") {
			notePad.setLineWrap(true);
			itemLineWrap.setText("取消自动换行");
		} else if (s == "取消自动换行") {
			notePad.setLineWrap(false);
			itemLineWrap.setText("自动换行");
		} else if (s == "退出(Exit)") {
			String command = "taskkill /f /im wscript.exe";
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		} else if (s == "关于(about)") {
			JOptionPane.showMessageDialog(notePad, "作品：文本播放器\n作者：张东东");
		}
	}

	public void updateButtons() {
		itemUndo.setEnabled(undoManager.canUndo());
		itemRedo.setEnabled(undoManager.canRedo());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application window = new Application();
		window.setVisible(true);
	}

}
