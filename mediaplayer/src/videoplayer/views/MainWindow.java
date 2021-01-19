package videoplayer.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import videoplayer.main.PlayerMain;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	EmbeddedMediaPlayerComponent playerComponent;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JPanel controlPanel;
	private JProgressBar progress;
	private JMenuBar menuBar;
	private JMenu mnfile;
	private JMenuItem mntmOpenfile;
	private JMenuItem mntmSubtitle;
	private JMenuItem mntmexit;
	private JSlider slider;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 448);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnfile = new JMenu("\u6587\u4EF6");
		menuBar.add(mnfile);
		
		mntmOpenfile = new JMenuItem("\u6253\u5F00\u6587\u4EF6");
		mntmOpenfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerMain.openVideo();
			}
		});
		mnfile.add(mntmOpenfile);
		
		mntmSubtitle = new JMenuItem("\u9009\u62E9\u5B57\u5E55");
		mntmSubtitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerMain.openSubtitle();
			}
		});
		mnfile.add(mntmSubtitle);
		
		mntmexit = new JMenuItem("\u9000\u51FA");
		mntmexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerMain.exit();
			}
		});
		mnfile.add(mntmexit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel videopane = new JPanel();
		contentPane.add(videopane, BorderLayout.CENTER);
		videopane.setLayout(new BorderLayout(0, 0));
		
		playerComponent = new EmbeddedMediaPlayerComponent();
		videopane.add(playerComponent);
		
		panel = new JPanel();
		videopane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		controlPanel = new JPanel();
		panel.add(controlPanel);
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		button = new JButton("");
		controlPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayerMain.play();
			}
		});
		button.setIcon(new ImageIcon(".\\icon\\Z1P5T)AF_8BD)O4]LK3A6@K.jpg"));
		
		button_2 = new JButton("");
		controlPanel.add(button_2);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayerMain.pause();
			}
		});
		button_2.setIcon(new ImageIcon(".\\icon\\[XP@VW$9~6_X1[1RV}NX)@A.jpg"));
		
		button_1 = new JButton("");
		controlPanel.add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayerMain.stop();
			}
		});
		button_1.setIcon(new ImageIcon(".\\icon\\@AITQ]]N{H]VCD{1606183R.jpg"));
		
		button_4 = new JButton("");
		controlPanel.add(button_4);
		button_4.setIcon(new ImageIcon(".\\icon\\B`5XQO5T0LH{TP6UYY(G_B4.jpg"));
		
		button_3 = new JButton("");
		controlPanel.add(button_3);
		button_3.setIcon(new ImageIcon(".\\icon\\6IXHYG)43RI363]RIF9%M~6.jpg"));
		
		slider = new JSlider();
		slider.setValue(100);
		slider.setMaximum(120);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				PlayerMain.setVol(slider.getValue());
			}
		});
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(MainWindow.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMuteDisabled.png")));
		controlPanel.add(label);
		controlPanel.add(slider);
		
		progress = new JProgressBar();
		progress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				PlayerMain.jumpTo((float)x/progress.getWidth());
			}
		});
		progress.setStringPainted(true);
		panel.add(progress, BorderLayout.NORTH);
	}
	
	public EmbeddedMediaPlayer getMediaPlayer() {
		return playerComponent.getMediaPlayer();
	}
	
	public JProgressBar getProgressBar(){
		return progress;
	}

}
