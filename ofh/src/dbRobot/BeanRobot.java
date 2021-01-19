package dbRobot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class BeanRobot extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField ipFiled;
	private JTextField dbFiled;
	private JTextField dbNameFiled;
	private JTextField tabField;
	private JTextField packField;
	private JTextField catField;
	private JCheckBox checkBox;
	private JTextField userField;
	private JTextField pwdField;
	private JComboBox dbBox;
	DbUtil dbutil = new DbUtil() ;
	BeanUtil butil = new BeanUtil();
	JLabel labelInfo ;
	private JTable  jtable;
	private MyTableModel  tableModel ;
	HashMap dbInfoMap;
	String[] titles = {"ѡ��","�������"} ;
	
	//�����ļ���Ϣ
	Map<String,HashMap<String,String>> dbMap;
	public BeanRobot() {
		
		setTitle("���ݿ�����javabeanС����");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 544, 374);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(110, 13, 30, 15);
		panel.add(lblIp);

		ipFiled = new JTextField();
		ipFiled.setText("localhost");
		ipFiled.setBounds(146, 10, 147, 21);
		panel.add(ipFiled);
		ipFiled.setColumns(10);

		JLabel label = new JLabel("���ݿ�:");
		label.setBounds(80, 41, 54, 15);
		panel.add(label);

//		String dbStyles[] = { };
//		dbBox = new JComboBox(dbStyles);
		dbBox = new JComboBox();
		dbBox.setBounds(146, 39, 147, 21);
		dbBox.setVisible(true);
		dbBox.setMaximumRowCount(3);
		panel.add(dbBox);

		JLabel dbNamelabel = new JLabel("���ݿ���:");
		dbNamelabel.setBounds(70, 67, 60, 20);
		panel.add(dbNamelabel);

		dbNameFiled = new JTextField();
		dbNameFiled.setBounds(146, 68, 147, 21);
		dbNameFiled.setText("ofh");
		panel.add(dbNameFiled);
		dbNameFiled.setColumns(10);

		JLabel userLabel = new JLabel("�û���:");
		userLabel.setBounds(80, 98, 54, 15);
		panel.add(userLabel);

		userField = new JTextField();
		userField.setText("root");
		userField.setBounds(145, 97, 148, 21);
		panel.add(userField);
		userField.setColumns(10);

		JLabel pwdLabel = new JLabel("����:");
		pwdLabel.setBounds(95, 129, 54, 15);
		panel.add(pwdLabel);

		pwdField = new JTextField();
		pwdField.setText("123456");
		pwdField.setBounds(145, 126, 147, 21);
		panel.add(pwdField);
		pwdField.setColumns(10);

		JLabel packLabel = new JLabel("����:");
		packLabel.setBounds(95, 160, 54, 15);
		panel.add(packLabel);

		packField = new JTextField();
		packField.setText("po");
		packField.setBounds(146, 155, 147, 21);
		panel.add(packField);
		packField.setColumns(10);

		JLabel catlogLabel = new JLabel("���Ŀ¼��");
		catlogLabel.setBounds(70, 193, 65, 15);
		panel.add(catlogLabel);

		catField = new JTextField();
		catField.setText("D:\\eclipseworkplace\\ofh\\src\\");
		catField.setBounds(146, 190, 147, 21);
		panel.add(catField);
		catField.setColumns(10);

		checkBox = new JCheckBox("���ɰ��ṹĿ¼");
		checkBox.setSelected(true);
		checkBox.setBounds(145, 220, 147, 23);
		panel.add(checkBox);


		JLabel mustdbLabel = new JLabel("* ѡ�����ݿ�");
		mustdbLabel.setForeground(Color.RED);
		mustdbLabel.setBounds(303, 39, 176, 15);
		panel.add(mustdbLabel);
		JLabel mustIPLabel = new JLabel("* IP��ַ���˿ں�");
		mustIPLabel.setForeground(Color.RED);
		mustIPLabel.setBounds(303, 13, 176, 15);
		panel.add(mustIPLabel);

		JLabel mustPacklabel = new JLabel("* ���ṹ");
		mustPacklabel.setForeground(Color.RED);
		mustPacklabel.setBounds(303, 155, 79, 15);
		panel.add(mustPacklabel);

		JLabel catlabel = new JLabel("Ĭ��D:// ��ע���ʽ");
		catlabel.setForeground(Color.RED);
		catlabel.setBounds(303, 193, 179, 15);
		panel.add(catlabel);

		
		JButton button = new JButton("��ѯ");
		// ��ť���Ӷ���ִ��go()����
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go();
				
			}
		});
		button.setBounds(145, 267, 93, 23);
		panel.add(button);

		JButton crButton = new JButton("����Bean");
		// ��ť���Ӷ���ִ��go()����
		crButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
				
			}
		});
		crButton.setBounds(280, 267, 93, 23);
		panel.add(crButton);

		
		// ���ӹر��¼��������ر���ز���
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				close();
				System.exit(0);
			}

		});
		//���ñ��
		
		Object[][] tableData = {};
		tableModel = new MyTableModel(tableData,titles); 
		jtable = new JTable(this.tableModel) ;
		JScrollPane scr = new JScrollPane(this.jtable) ;
		scr.setBounds(430, 10, 200, 290);
		panel.add(scr);
		//��ӱ������¼�
		jtable.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		    	  int row=jtable.getSelectedRow();  
		            if(jtable.getSelectedColumn()==0)//����ǵ�һ�еĵ�Ԫ���򷵻أ�����Ӧ���
		                return;
		         //����Ӧ����
		    }
		});
		
		//��ʾ������Ϣlabel
		labelInfo = new JLabel("");  
		labelInfo.setForeground(Color.RED);  
		labelInfo.setBounds(20, 317, 600, 60);  
        panel.add(labelInfo); 
        
		//��ʼ��������Ϣ�����ݿ������б�
		dbMap = dbutil.getDbConfigMap();
		for(String key : dbMap.keySet()){
			this.getDbBox().addItem(key);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��������
		BeanRobot dtb = new BeanRobot();
		// ���ÿɼ�
		dtb.setVisible(true);
		// ���X�رմ���
		dtb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �������þ�����ʾ
		dtb.setSizeAndCentralizeMe(680, 440);

	}

	// ���þ���
	private void setSizeAndCentralizeMe(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(width, height);
		this.setLocation(screenSize.width / 2 - width / 2, screenSize.height
				/ 2 - height / 2);
	}

	public void create(){
		String sucessName = "";
		this.getLabelInfo().setText("");
		initInfo();
		//�Ƿ�ѡ����Ŀ¼��ʶ
		boolean createPackage = this.getCheckBox().getSelectedObjects() != null;

		//�ж�Ŀ¼�Ƿ����
		if (dbInfoMap.get("catName") != null ) {
			if(dbInfoMap.get("catName").toString().equals("")){
				dbInfoMap.put("catName", "D://");
			}
			if((new File(dbInfoMap.get("catName").toString()).isDirectory())!=true){
				this.getLabelInfo().setText("Ŀ¼�����ڣ�����������");
			}else{
				if(createPackage){
					if (dbInfoMap.get("packName") != null && !dbInfoMap.get("packName").toString().equals("")) {
					    String catPack = dbInfoMap.get("catName").toString()+dbInfoMap.get("packName").toString();
					    catPack = catPack.replace(".", "/");
						new File(catPack).mkdirs();
						dbInfoMap.put("catName", catPack);
					}
					//��ѡ
					int rowCount = this.jtable.getRowCount();
					for(int i = 0 ; i< rowCount ; i++){
						if(this.jtable.getValueAt(i,0).toString().equals("true")){
							String tabName = this.jtable.getValueAt(i,1).toString();
							List<Map<String, String>> tabFileds = dbutil.getColumnNames(dbInfoMap, tabName);
							butil.createBean(tabName, tabFileds,dbInfoMap);
							sucessName+=tabName+",";
						}
					}
				}else{
					int rowCount = this.jtable.getRowCount();
					for(int i = 0 ; i< rowCount ; i++){
						if(this.jtable.getValueAt(i,0).toString().equals("true")){
							String tabName = this.jtable.getValueAt(i,1).toString();
							List<Map<String, String>> tabFileds = dbutil.getColumnNames(dbInfoMap, tabName);
							butil.createBean(tabName, tabFileds,dbInfoMap);
							sucessName+=tabName+",";
						}
					}
					
				}
				this.getLabelInfo().setText("��"+sucessName+"���ɳɹ�");
			}
		}
	}
	
	public void go() {
		this.getLabelInfo().setText("");
		initInfo();
		String selTableStr = dbInfoMap.get("showTable").toString();
		//��ȡ����
		List<String> tableList = dbutil.getTableNames(dbInfoMap,dbInfoMap.get("dbName").toString());
		if(tableList == null){
			int rowCount = this.getTableModel().getRowCount();
			int delInd = 0;
			while(delInd < rowCount){
				this.getTableModel().removeRow(0);
				delInd++;
			}
			this.getLabelInfo().setText("���ݿ������쳣");
		}else{
			int rowCount = this.getTableModel().getRowCount();
			int delInd = 0;
			while(delInd < rowCount){
				this.getTableModel().removeRow(0);
				delInd++;
			}
			for(String tName : tableList){
				Object[] rowData = {new Boolean(false),tName};
				this.getTableModel().addRow(rowData);
			}

			
		}

	}

	public void initInfo(){
		//��ȡ�����ļ����ݿ�����
		String user = this.getUserField().getText();
		String pass = this.getPwdField().getText();
		String ip = this.getIpFiled().getText();
		String database = this.getDbNameFiled().getText();
		String dbName = this.getDbBox().getSelectedItem().toString();
		String packName =this.getPackField().getText();
		String catName =this.getCatField().getText();
		//�����������
		dbInfoMap = new HashMap();
		dbInfoMap = dbMap.get(dbName);
		dbInfoMap.put("userName", user);
		dbInfoMap.put("userpwd", pass);
		dbInfoMap.put("jdbc", dbMap.get(dbName).get("JdbcURL")+ip+dbMap.get(dbName).get("dbStr")+database);
		dbInfoMap.put("driver", dbMap.get(dbName).get("driverClassName"));
		dbInfoMap.put("dbName", database);
		dbInfoMap.put("packName", packName);
		dbInfoMap.put("catName", catName);

	}
	private void close() {
		System.out.println("�ر��¼�");
	}

	public JTextField getIpFiled() {
		return ipFiled;
	}

	public void setIpFiled(JTextField ipFiled) {
		this.ipFiled = ipFiled;
	}

	public JTextField getDbFiled() {
		return dbFiled;
	}

	public void setDbFiled(JTextField dbFiled) {
		this.dbFiled = dbFiled;
	}

	public JTextField getTabField() {
		return tabField;
	}

	public void setTabField(JTextField tabField) {
		this.tabField = tabField;
	}

	public JTextField getPackField() {
		return packField;
	}

	public void setPackField(JTextField packField) {
		this.packField = packField;
	}

	public JTextField getCatField() {
		return catField;
	}

	public void setCatField(JTextField catField) {
		this.catField = catField;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JCheckBox checkBox) {
		this.checkBox = checkBox;
	}


	public JTextField getUserField() {
		return userField;
	}

	public void setUserField(JTextField userField) {
		this.userField = userField;
	}

	public JTextField getPwdField() {
		return pwdField;
	}

	public void setPwdField(JTextField pwdField) {
		this.pwdField = pwdField;
	}

	public JTextField getDbNameFiled() {
		return dbNameFiled;
	}

	public void setDbNameFiled(JTextField dbNameFiled) {
		this.dbNameFiled = dbNameFiled;
	}

	public JComboBox getDbBox() {
		return dbBox;
	}

	public void setDbBox(JComboBox dbBox) {
		this.dbBox = dbBox;
	}

	public JLabel getLabelInfo() {
		return labelInfo;
	}

	public void setLabelInfo(JLabel labelInfo) {
		this.labelInfo = labelInfo;
	}

	public JTable getJtable() {
		return jtable;
	}

	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}


	public MyTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(MyTableModel tableModel) {
		this.tableModel = tableModel;
	}


	class MyTableModel extends DefaultTableModel{ 
		  public MyTableModel(Object[][] data,String[] columns)
	        { 
			  super(data,columns); 
	        } 
	        public boolean isCellEditable(int row,int column){ //����Table��Ԫ���Ƿ�ɱ༭
	            if(column==0)return true;        
	            return false; 
	        } 
	        public Class<?> getColumnClass(int columnIndex) 
	        { 
	            if(columnIndex==0)
	            { return Boolean.class; 
	            } 
	            return Object.class; 
	        } 
	  
	  }
}
