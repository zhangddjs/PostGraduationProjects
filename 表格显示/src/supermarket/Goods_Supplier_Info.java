package supermarket;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Goods_Supplier_Info extends JFrame{
	private static final long serialVersionUID = 1L;
	
	/*Create the frame */
	
	/**
	 * @wbp.parser.constructor
	 */
	public Goods_Supplier_Info(String Gno, String Gname, String Gup, String Sname, int selectKind) {
		super();
		getContentPane().setLayout(null);
		setBounds(100, 100, 634, 557);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		final JLabel result = new JLabel();
		result.setText("��ѯ���Ϊ��");
		result.setBounds(27, 25, 86, 28);
		getContentPane().add(result);

		final JLabel huohaol = new JLabel();
		huohaol.setText("����");
		huohaol.setBounds(46, 85, 44, 18);
		getContentPane().add(huohaol);

		final JLabel spmcl = new JLabel();
		spmcl.setText("��Ʒ����");
		spmcl.setBounds(151, 85, 66, 18);
		getContentPane().add(spmcl);

		final JLabel pricel = new JLabel();
		pricel.setText("����");
		pricel.setBounds(260, 85, 35, 18);
		getContentPane().add(pricel);
		
		final JLabel ghsl = new JLabel();
		ghsl.setText("������");
		ghsl.setBounds(355, 85, 66, 18);
		getContentPane().add(ghsl);

		final JLabel count = new JLabel();
		count.setText("����");
		count.setBounds(458, 85, 66, 18);
	    getContentPane().add(count);
	    
	    JPanel mreminder = new JPanel();
	    mreminder.setBounds(46, 109, 523, 341);
	    mreminder.setBorder(new TitledBorder(""));
	    getContentPane().add(mreminder);
		
	    String Quantity;
		UserClient client = new UserClient();
		ArrayList<Register> list = client.getGoodsInformation(Gno, Gname, Gup, Sname, selectKind);
				
	    if(!list.isEmpty()) {
  	        int flag = 0;
  	        int num = list.size();
  	        
	        while(flag < num) { 
	        	
	        	mreminder.setLayout(new GridLayout(num, 5));
	    		
                Gno = list.get(flag).getGno();
                Gname = list.get(flag).getGname();
                Gup = list.get(flag).getGup()+"Ԫ";
                Sname = list.get(flag).getSname();
                Quantity = String.valueOf((list.get(flag).getQuantity()));
                   
                final JLabel huohaofeil = new JLabel(Gno, SwingConstants.LEFT);
                mreminder.add(huohaofeil);

     		    final JLabel spmcfeild = new JLabel(Gname, SwingConstants.LEFT);
     		    mreminder.add(spmcfeild);

     		    final JLabel pricefei = new JLabel(Gup, SwingConstants.LEFT);
     		    mreminder.add(pricefei);
     		    
     		    final JLabel ghsfeild = new JLabel(Sname, SwingConstants.LEFT);
     		    mreminder.add(ghsfeild);

     	        final JLabel countfei = new JLabel(Quantity, SwingConstants.LEFT);
     	        mreminder.add(countfei);
     		    
		        flag++;	
		        
		        getContentPane().add(mreminder);
		    }
        }
	    
	    else {
	    	Font font = new Font("���������", Font.BOLD, 20);
	    	Color color = new Color(0xff, 0, 0);
		    final JLabel resultplay = new JLabel("�޽����ʾ", SwingConstants.LEFT);
		    resultplay.setFont(font);
		    resultplay.setForeground(color);    //Ϊ����������ɫ
		    
		    mreminder.add(resultplay);
		    
		    getContentPane().add(mreminder);
	    }
	   
	    final JButton returnb = new JButton();
	    returnb.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(final MouseEvent e) {
			    dispose();
	        }
	    });
	    returnb.setText("����");
	    returnb.setBounds(251, 469, 106, 28);
	    getContentPane().add(returnb);
	   
    }

	public Goods_Supplier_Info(String Sname, String Sphone, String Scity, int selectKind) {
		super();
		getContentPane().setLayout(null);
		setBounds(100, 100, 475, 513);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel result = new JLabel();
		result.setText("��ѯ���Ϊ��");
		result.setBounds(27, 25, 86, 28);
		getContentPane().add(result);

		final JLabel huohaol = new JLabel();
		huohaol.setText("��������");
		huohaol.setBounds(46, 85, 52, 18);
		getContentPane().add(huohaol);

		final JLabel spmcl = new JLabel();
		spmcl.setText("��ϵ�绰");
		spmcl.setBounds(178, 85, 52, 18);
		getContentPane().add(spmcl);

		final JLabel pricel = new JLabel();
		pricel.setText("���ڳ���");
		pricel.setBounds(290, 85, 52, 18);
		getContentPane().add(pricel);
	    
	    JPanel mdisplay = new JPanel();
	    mdisplay.setBounds(46, 109, 367, 270);
	    mdisplay.setBorder(new TitledBorder(""));
		
		UserClient client = new UserClient();
		ArrayList<Register> list = client.getSupplierInformation(Sname, Sphone, Scity, selectKind);
				
	    if(!list.isEmpty()) {
  	        int flag = 0;
  	        int num = list.size();
  	        
	        while(flag < num) { 
	        	
	        	mdisplay.setLayout(new GridLayout(num, 3));
	    		
                Sname = list.get(flag).getSname();
                Sphone = list.get(flag).getSphone();
                Scity = list.get(flag).getScity();
                   
                final JLabel ghsmfei = new JLabel(Sname, SwingConstants.LEFT);
                mdisplay.add(ghsmfei);

     		    final JLabel telfeild = new JLabel(Sphone, SwingConstants.LEFT);
     		    mdisplay.add(telfeild);

     		    final JLabel cityfeild = new JLabel(Scity, SwingConstants.LEFT);
     		    mdisplay.add(cityfeild);    		    
     		    
		        flag++;	
		        getContentPane().add(mdisplay);
		    }
        }
	    
	    else {
	    	Font font = new Font("���������", Font.BOLD, 20);
	    	Color color = new Color(0xff, 0, 0);
		    final JLabel redisplay = new JLabel("�޽����ʾ", SwingConstants.LEFT);
		    redisplay.setFont(font);
		    redisplay.setForeground(color);    //Ϊ����������ɫ
		    
		    mdisplay.add(redisplay);
		    
		    getContentPane().add(mdisplay);
	    }
	   
	    final JButton returnb = new JButton();
	    returnb.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(final MouseEvent e) {
			    dispose();
	        }
	    });
	    returnb.setText("����");
	    returnb.setBounds(178, 417, 106, 28);
	    getContentPane().add(returnb);
	}

}




public ArrayList<Register>  getGoodsInformation(String Gno, String Gname, String Gup, String Sname, int kind) {
		
		ArrayList<Register> list = new ArrayList<Register>();
		try {
  			conn = UserConnection.getConnection();
  			
  			/* ʹ����StringBuilder��������ǰ�ĸ�ѡ��ѡ��������Ϊ��ѯ����ִ�в�ѯ��ʵ�ֶ�����

��ѯ*/
  			StringBuilder sb = new StringBuilder( "select Goods.Gno, Gname, Gup, Supplier.Sname, 

Quantity from  " +
  					"Goods, Supplier, GSU " +
  					"where Goods.Gno = GSU.Gno and  " +
  					"Supplier.Sname = Goods.Sname and Supplier.Sname = GSU.Sname "); 
  			
  			sb.append((Gno.equals("") ? "" : "and Goods.Gno = '" + Gno + "' ")); 			
  			sb.append((Gup.equals("") ? "" : "and Gup " + Gup));
  			
  			switch(kind) {    //����ѯ���ࣺ��ȷ��ѯ or ģ����ѯ
  			case 0: 
  				sb.append("and 1 = 0 ");    //��û��ѡ���ѯ����ʱ��Ĭ��ִ�в�ѯ������Ϊ�٣���

ʾ���޲�ѯ�����
  				break;
  			case 1:
  				sb.append(Gname.equals("") ? "" : " and Gname = '" + Gname + "' ");
  				sb.append(Sname.equals("") ? "" : " and Supplier.Sname = '" + Sname + "' ");
  				break;
  			case 2:
  				sb.append(Gname.equals("") ? "" : " and Gname like '%" + Gname + "%' ");
  				sb.append(Sname.equals("") ? "" : " and Supplier.Sname like '%" + Sname + "%' 

");
  				break;
  			
  			}

  			String sql = sb.toString();
  			ps = conn.prepareStatement(sql);     
  			rs=ps.executeQuery();
  			while(rs.next()) {
  				Register register = new Register();
  				register.setGno(rs.getString("Gno"));
  				register.setGname(rs.getString("Gname"));
  				register.setGup(rs.getString("Gup"));
  				register.setSname(rs.getString("Sname"));
  				register.setQuantity(rs.getInt("Quantity"));
  				
  				list.add(register);    //��ÿһ����¼�������list��
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
	