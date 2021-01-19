package 风格;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JFrameButton extends JFrame implements ActionListener
{
    JButton windLook = new JButton("Windows 窗口");
    JButton unixLook = new JButton("Unix 窗口");
    JButton javaLook = new JButton("Java 窗口");
    JButton macLook = new JButton("Mac 窗口");
    JButton gtkLook = new JButton("GTK 窗口");
    JLabel label = new JLabel("选择界面的风格");
 public JFrameButton()
 {
  this.setLayout(new FlowLayout());
  this.add(label);
  this.add(windLook);
  windLook.addActionListener(this);
  this.add(unixLook);
  unixLook.addActionListener(this);
  this.add(javaLook);
  javaLook.addActionListener(this);
  this.add(macLook);
  macLook.addActionListener(this);
  this.add(gtkLook);
  gtkLook.addActionListener(this);
 
}

 public void actionPerformed(ActionEvent e)
 {
  String look = "javax.swing.plaf.metal.MetalLookAndFeel";
  if(e.getSource()==javaLook)
   look = "javax.swing.plaf.metal.MetalLookAndFeel";
  else if(e.getSource()==windLook)
   look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
  else if(e.getSource()==unixLook)
   look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
  else if(e.getSource()==macLook)
   look = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
  else if(e.getSource()==gtkLook)
   look = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
   try
  {
   UIManager.setLookAndFeel(look);
   SwingUtilities.updateComponentTreeUI(this);
  }
  catch(Exception ex)
  {
   System.out.println("Exception:"+ex); 
  }
 }
 public static void main(String[] args)
 {
  JFrameButton jwb = new JFrameButton();
  jwb.setTitle("界面风格设置");
  jwb.setLocationRelativeTo(null);//窗口居中显示
  jwb.setResizable(false);
  jwb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  jwb.setSize(600,100);
  jwb.setVisible(true);
 }
}