package supermarket;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SaleFrame extends JFrame{
	Connection conn = null;
	PreparedStatement ps = null;
	Statement sm = null;
	ResultSet rs = null;
	private JTextField huohaofei;
	private JTextField countfeild;
	private JButton sure;
	private JTextField  sumfeild;
	private JButton bought;
	
	
	public SaleFrame(){
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		final JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(50, 20, 800, 140);
		panel1.setBorder(new TitledBorder(" 购买  "));
		
		final JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(50, 210, 800, 380);
		panel2.setBorder(new TitledBorder(" 所购买的商品  "));
		
		frame.add(panel1);
	
		
		final JLabel huohaol= new JLabel();
		huohaol.setText("货  号：");
		huohaol.setBounds(70, 40, 80, 20);
		panel1.add(huohaol);
		
		huohaofei= new JTextField();
		huohaofei.setBounds(170, 40, 180, 20);
		panel1.add(huohaofei);
		
		final JLabel count= new JLabel();
		count.setText("数  量：");
		count.setBounds(450, 40, 80, 20);
		panel1.add(count);
		
		countfeild= new JTextField();
		countfeild.setBounds(540, 40, 180, 20);
		panel1.add(countfeild);
		
		sure=new JButton();
		sure.setText("购买");
		sure.setBounds(350, 80, 100, 20);
		panel1.add(sure);
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == sure) {
				     SetData(frame, panel2);
			    }
			}
		});
		
		final JLabel sumprice= new JLabel();
		sumprice.setText("合计为：");
		sumprice.setBounds(70, 620, 60, 20);
		frame.add(sumprice);
		
		sumfeild=new JTextField();
		sumfeild.setBounds(150, 620, 100, 20);
		frame.add(sumfeild);
		
		bought=new JButton();
		bought.setText("付  款");
		bought.setBounds(750, 620, 80, 20);
		frame.add(bought);
		
		 
		
	}
	
	public void SetData(JFrame frame, JPanel panel){
		panel.setVisible(true);
		if(huohaofei.getText().equals("")||countfeild.getText().equals("")){
			JOptionPane.showMessageDialog(null, "请填写完整的信息", "购买失败", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
		    String Gno=huohaofei.getText();
		    String strQuantity=countfeild.getText();
	        String Gname,Gup,Quantity;
	        
		    ArrayList<Register> list = SelectData(Gno,strQuantity);
		    if(!list.isEmpty()) {
  	           int flag = 0;
  	           int num = list.size();
  	           while(flag < num) { 
	        	      panel.setLayout(new GridLayout(num, 3));
                      Gname = list.get(flag).getGname();
                      Gup = list.get(flag).getGup();
                      Quantity = String.valueOf((list.get(flag).getQuantity()));
                      //System.out.println(Gname);
                      final JLabel spmcfeild = new JLabel(Gname, SwingConstants.LEFT);
     		          panel.add(spmcfeild);

     		          final JLabel pricefei = new JLabel(Gup, SwingConstants.LEFT);
     		          panel.add(pricefei);
     		    
     		          final JLabel quantityfeil = new JLabel(Quantity, SwingConstants.LEFT);
                      panel.add(quantityfeil);
     		    
		              flag++;
		              
		              frame.add(panel);
		              JOptionPane.showMessageDialog(null, "已获取信息信息", "成功", JOptionPane.INFORMATION_MESSAGE);
		      }
		    }
		    
		 }
		
	}
	public ArrayList<Register>  SelectData(String Gno,String strQuantity){
		
		ArrayList<Register> list = new ArrayList<Register>();
		
		try {
			int quantity = Integer.parseInt(strQuantity);
  			conn = UserConnection.getConnection();
  			
  			StringBuilder sb =new StringBuilder("select Goods.Gname,Gup,GSU.Quantity from "+
  			" Goods,GSU "+ " where GSU.Gno=Goods.Gno " );
  			sb.append("and Goods.Gno = '" + Gno + "' "+" and GSU.Quantity >= "+ quantity);
  			String sql = sb.toString();
  			
  			ps = conn.prepareStatement(sql);     
  			rs=ps.executeQuery();
  			
  			while(rs.next()) {
  				Register register = new Register();
  				register.setGname(rs.getString("Gname"));
  				register.setGup(rs.getString("Gup"));
  				register.setQuantity(rs.getInt("Quantity"));
  				
  				list.add(register);    //将每一条记录存放至表list中
  				
  			}
  		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			UserConnection.close(rs,ps,conn);
		}
		
		return list;
		
	}
    public void EditData(Register register,String Quantity){
		
		
	}

}
