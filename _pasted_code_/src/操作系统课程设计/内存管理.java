package ����ϵͳ�γ����;

import java.awt.*;
import java.awt.event.*;

class work //��ҵ�࣬������ҵ�Ϳ��з���������
	{
		 int front;//��ҵ����ʼ��ַ
	     int length;//��ҵ�ĳ���
         String data;//��ҵ������ �������״̬
        }
	
public class �ڴ����  extends Frame  implements ActionListener {
	   
	int free_quantity;//��¼�ɷ�����з����������
	int occupy_quantity;//��¼�ѷ������ҵ����	
	
	//���ӻ������������
	Label lb0,lb1,lb2,lb3,lb4;
	Button bt0,bt1,bt2,bt3,bt4;
	TextField tf0,tf1,tf4;
	TextArea tf2,tf3;
	Panel pa;
	
	
	public  �ڴ����()
	{   
	    
		super("�򵥵Ķ�̬�����洢����ϵͳ");
		setSize(400,100);
		setLocation(500, 200);
		setLayout(new FlowLayout());
		pa=new Panel();
		bt1=new Button("����");
		bt2=new Button("����");
		bt3=new Button("�鿴");
		bt4=new Button("�˳�");
		
		bt1.setSize(300,100);
		bt2.setSize(300,100);
		bt3.setSize(300,100);
		bt4.setSize(300,100);
		
		pa.add(bt1);
		pa.add(bt2);
		pa.add(bt3);
		pa.add(bt4);
		
		setup();
		add(pa);
		initial(free,occupy);
		pa.setBackground(Color.gray);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);	
		setVisible(true);
}
	
	
	   
	
	public static void main(String[] args) {
		�ڴ����  n = new �ڴ����();//����ʵ������
		                                   }
	
	public static work[] free=new work[5];//������з�������
	public static work[] occupy=new work[10];//������ҵ����
 
	public boolean flase;
      
	void initial(work free[],work occupy[] )//�Կ��з������г�ʼ��
	{
		int i;
		String s="free";
		free[0].front=0;
		free[0].length=300;//change
		free[0].data=s;
		occupy[0].front=0;
		occupy[0].length=0;
		occupy[0].data="  ";
		//���������ȫ����0��գ����з������һ����������Ϊ30����һ�������ĳ�������һ���������׵�ַ+����
		free_quantity=1;//change

		occupy_quantity=0;//�������ҵ��Ŀ��0
		
	}


	
public	void setup(){
	for(int i=0;i<5;i++)//��ʼ����ҵ����
	{free[i]=new work(); }
	for(int i=0;i<10;i++)//��ʼ����ҵ����
	{occupy[i]=new work(); }
	
	
}




public void actionPerformed(ActionEvent e)//�Լ������¼�������Ӧ
{  
  

	if(e.getSource()==bt1)
	new ����ռ�();
		
	else
		if(e.getSource()==bt2)

	  new ������ҵ(); 
	else
		if(e.getSource()==bt3)
		new ��ʾ();	
		else
			if(e.getSource()==bt4){
				System.exit(0);
			}
	     
	

	
}


class ����ռ�  extends Frame implements ActionListener{//��������ռ���
	  private Button button1=new Button("ȷ��");//���尴ť���
	  private Button button2=new Button("�˳�");
	  public Label lab1=new Label("��ҵ�ռ�",Label.CENTER );//�����ǩ���
	  public Label lab2=new Label("��ҵ��",Label.CENTER );
	  public TextField text1=new TextField();//�����ı����
	  public TextField text2=new TextField();
	  public TextField text3=new TextField();
	  public TextField text4=new TextField();
	  public TextField text5=new TextField();
	  public Panel pan1=new Panel();//�����������
	  public Panel pan2=new Panel();
	  public Panel pan5=new Panel();
	  public Panel button=new Panel();
	  
	   private class WindowCloser extends WindowAdapter{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
       }


public ����ռ�(){
	super("����ռ�");
      setup();
	addWindowListener(new WindowCloser());//���ڼ���
	pack();
	setVisible(true);
	button1.addActionListener(this);//��Ӽ����¼�
	button2.addActionListener(this);
	   setSize(280,200);//���ô��ڴ�С
	   setLocation(300, 300); //������ ������λ��  
	   setResizable(false);   //���ܵ���С 
}
public void setup()//����Ĳ���
{
	pan1.setLayout(new FlowLayout());
	pan2.setLayout(new FlowLayout());
	button.setLayout(new FlowLayout());
	pan1.add(lab1);pan1.add(text1);
	pan2.add(lab2);pan2.add(text2);
	button.add(button1);button.add(button2);
	text5.setBounds(100, 100, 300, 100);
	setLayout(new FlowLayout());
	add(pan1);add(pan2);add(text5);add(button1);add(button);

}

public void actionPerformed(ActionEvent e) {
	  if(e.getSource()==button2)
	    	this.setVisible(false);//�رյ�ǰ����	
	  if(e.getSource()==button1)
		  {
		  int i,j,flag=0,f2=0;
		  String  a=text1.getText();//��ȡ�������ҵ��С
		  int	 job_length=Integer.parseInt(a);//���������ַ�ת��Ϊ����
		  String	job_name=text2.getText();//��ȡ��ҵ��
		  for(i=0;i<free_quantity;i++)
		  {
		  	if(free[i].length>=job_length) //������пռ�I�ĳ���>=��ҵ����
		  	{
		  	   flag=1;   //���б�־λ����1
		  	}
		  
		  }
		  
		  for(int k=0;k<occupy_quantity;k++)
		  {
		  	if((job_name).equals(occupy[k].data)==true) //������пռ�I�ĳ���>=��ҵ����
		  	{
		  	   f2=1;   //���б�־λ����1
		  	}
		  
		  }
		  
		  
		  
		  
		  
		  if(flag==0)
		  {
		  	text5.setText("�Բ���,��ǰû�������������볤�ȵĿ����ڴ�,���Ժ����ԣ�\n");
		  }
		
		  else if(f2==1)
		  {
		  	text5.setText("����ҵ���Ѵ��ڣ�\n");
		  }
		  
		  
		  
		   else
		  { //	t=0;
		  	j=0;
		  	for(i=0;i<free_quantity;i++)
		  	{ 
		  	   if(free[i].length>=job_length){break;}
		  	
		  	}
		  	
		  	occupy[occupy_quantity].front=free[i].front;//��δ�õĿ��пռ���׵�ַ�������ÿռ���׵�ַ
		  	occupy[occupy_quantity].data=job_name;//���ÿռ������Ϊ��ҵ��
		  	occupy[occupy_quantity].length=job_length;//���ÿռ�ĳ���Ϊ��ҵ�ĳ���
		  	occupy_quantity++;  
		  	//���ÿռ�������1
		  	if(free[i].length>job_length) //����ռ�ĳ��ȴ�����ҵ�ĳ��ȣ�
		  	{
		  	   free[i].front+=job_length; //���пռ����ʼ�׵�ַ=ԭ�����������ʼ���ȼ���ҵ����
		  	   free[i].length-=job_length;//��������ĳ���=ԭ��������ĳ���-��ҵ�ĳ���
		  	}
		  	else                         //����ռ�ĳ���=��ҵ�ĳ���
		  	{
		  	   for(j=i;j<free_quantity;j++)
		  	   {
		  			free[j]=free[j+1];//��������ǰ��һλ
		  	   } 
		  	   free_quantity--;//���������������һ
		  	}
		  		text5.setText("������ռ�!\n");
		  }
		
  
		
		  }
	  }
}



class ������ҵ  extends Frame implements ActionListener{
	  public Label lab1=new Label("����Ҫ��������ҵ��",Label.CENTER );
	  public TextField text1=new TextField();
	  private Button button1=new Button("ȷ��");
	  private Button button2=new Button("�˳�");
	  
	   private class WindowCloser extends WindowAdapter{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
       }


public ������ҵ(){
	super("������ҵ");
setup();
	addWindowListener(new WindowCloser());
	pack();
	setVisible(true);
	button1.addActionListener(this);
	button2.addActionListener(this);
	   setSize(200,200);//���ô��ڴ�С
	   setLocation(200, 200); //������ ������λ��  
}
public void setup(){	
	setLayout(new FlowLayout());
	add(lab1);add(text1);add(button1);add(button2);

}

public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==button1){
		
		 
		 int i,j,flag,p=0;
			int start=0;
			int len=0;	
			String job_name=text1.getText();	
			flag=-1;
			for(i=0;i<occupy_quantity;i++)
			{
			
				if((occupy[i].data).equals(job_name)==true)
			{
			   flag=i;//��i��ֵ����flag;
			   start=occupy[i].front;//�����ÿռ���׵�ַ����start
			   len=occupy[i].length;//�����ÿռ�ĳ��ȸ���len
			}
				
			}
			if(flag==-1)
			{
				text1.setText("û�������ҵ����������������ҵ����\n");
			}
			else
			{                 //������б�
			for(i=0;i<free_quantity;i++)
			{
			   if((free[i].front+free[i].length)==start)//�Ͽ�
			   {
				   if(((i+1)<free_quantity)&&(free[i+1].front==start+len))//�¿�
				{
			   //��i����������ĳ���=��i����������ĳ���+��i+1����������ĳ��ȣ��¿�������+length
					 free[i].length=free[i].length+free[i+1].length+len;
					 for(j=i+1;j<free_quantity;j++)
			   {
					   free[j]=free[j+1];//��������ǰ��һλ
			   }
					  free_quantity--;//������������������һ��
					p=1;
				}
				   else 
				{
				   free[i].length+=len;//���Ͽ��²��գ���i����������ĳ���=��i����������ĳ���+length����������������
				   p=1;
				}
			   }
			   if(free[i].front==(start+len))//�¿��ϲ���
			   {
				free[i].front=start;//��ʼ��ַ���ڴ����յ�ַ
				free[i].length+=len;//��i����������ĳ���=��i����������ĳ���+length
				 for(j=i+1;j<free_quantity;j++)
				  
				p=1;
			   }
			
			
			}
			if(p==0) //���¿����������գ�ֱ���ڿ�����������һ���ձ�Ŀ���������ݲ��룩
			{
			   free[free_quantity].front=start;
			   free[free_quantity].length=len;
			   free_quantity++;  //��������������1
			}
			   //ɾ��������еĸ���ҵ
			for(i=flag;i<occupy_quantity;i++)
			{
			   occupy[i]=occupy[i+1];
			}
			occupy_quantity--;//���õ���������
			text1.setText("�ڴ�ռ�������!\n");
			}
	 }		 
	if(e.getSource()==button2)
	    	this.setVisible(false);
	
}
}


///////////

class ��ʾ extends Frame implements ActionListener{//������ʾ�࣬������ʾ����

	  public TextArea text1=new TextArea();
	  public TextArea text2=new TextArea();
	  public TextArea text3=new TextArea();
	  public TextArea text4=new TextArea();
	  public Panel pan1=new Panel();
	  public Panel pan2=new Panel();
	  public Panel pan3=new Panel();
	  public Panel pan4=new Panel();
	  public Panel pan=new Panel();
	  public Panel button=new Panel();
	  private Button button2=new Button("�˳�");
	  
	   private class WindowCloser extends WindowAdapter{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
       }
	   
public ��ʾ(){
	super("��ʾ���б�ͷ����");
setup();
	addWindowListener(new WindowCloser());
	pack();
	setVisible(true);
	button2.addActionListener(this);
	   setSize(400,400);//���ô��ڴ�С
	   setLocation(300, 300); //������ ������λ��  
	   setResizable(false);   //���ܵ���С 
	   ��ʾ();




}
public void setup(){
	pan1.setLayout(new GridLayout(1,0));
	pan2.setLayout(new GridLayout(1,0));
	pan3.setLayout(new GridLayout(1,0));
	pan1.add("Center",text1);
	pan2.add("Center",text2);
	pan3.add("Center",text3);	
	button.setLayout(new FlowLayout());
	
	pan.setLayout(new GridLayout(1,0));
	pan.add(pan1);pan.add(pan2);pan.add(pan3);button.add(button2);
	setLayout(new BorderLayout());
	add("Center",pan);add("South",button);



}


void ��ʾ()//��ʾ�������Լ������
{
	text1.setText("\n���б�\n");text2.setText("\n\n");text3.setText("\n\n");
    text1.append("\n��ʼ��ַ��\n");text2.append("\n����\n");text3.append("\n״̬\n");
	  for(int i=0;i<free_quantity;i++){//�ڶ�Ӧ���ı�����ʾ���н��̵���Ϣ
	  text1.append(free[i].front+"\n");
	  text2.append(free[i].length+"\n");
	  text3.append(free[i].data+"\n");
	
}	
	  text1.append("\n�����\n");text2.append("\n\n");text3.append("\n\n");
	  text1.append("\n��ʼ��ַ��\n");text2.append("\n����\n");text3.append("\n��ҵ��\n");
	  for(int i=0;i<occupy_quantity;i++){//�ڶ�Ӧ���ı�����ʾ�ȴ����̵���Ϣ
	  text1.append(occupy[i].front+"\n");
	  text2.append(occupy[i].length+"\n");
	  text3.append(occupy[i].data+"\n");
	
}		
	
	
	
	
}

public void actionPerformed(ActionEvent e) {
	 
if(e.getSource()==button2)
	    	this.setVisible(false);
}
}




}

