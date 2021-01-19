package 操作系统课程设计;

import java.awt.*;
import java.awt.event.*;

class work //作业类，定义作业和空闲分区的属性
	{
		 int front;//作业的起始地址
	     int length;//作业的长度
         String data;//作业的名称 或分区的状态
        }
	
public class 内存管理  extends Frame  implements ActionListener {
	   
	int free_quantity;//记录可分配空闲分区表的数量
	int occupy_quantity;//记录已分配的作业数量	
	
	//可视化窗口组件定义
	Label lb0,lb1,lb2,lb3,lb4;
	Button bt0,bt1,bt2,bt3,bt4;
	TextField tf0,tf1,tf4;
	TextArea tf2,tf3;
	Panel pa;
	
	
	public  内存管理()
	{   
	    
		super("简单的动态分区存储管理系统");
		setSize(400,100);
		setLocation(500, 200);
		setLayout(new FlowLayout());
		pa=new Panel();
		bt1=new Button("申请");
		bt2=new Button("撤销");
		bt3=new Button("查看");
		bt4=new Button("退出");
		
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
		内存管理  n = new 内存管理();//创建实体数组
		                                   }
	
	public static work[] free=new work[5];//定义空闲分区数组
	public static work[] occupy=new work[10];//定义作业数组
 
	public boolean flase;
      
	void initial(work free[],work occupy[] )//对空闲分区进行初始化
	{
		int i;
		String s="free";
		free[0].front=0;
		free[0].length=300;//change
		free[0].data=s;
		occupy[0].front=0;
		occupy[0].length=0;
		occupy[0].data="  ";
		//分配表数据全部置0或空，空闲分区表第一个分区长度为30，下一个分区的长度是上一个分区的首地址+长度
		free_quantity=1;//change

		occupy_quantity=0;//分配表作业数目置0
		
	}


	
public	void setup(){
	for(int i=0;i<5;i++)//初始化作业数组
	{free[i]=new work(); }
	for(int i=0;i<10;i++)//初始化作业数组
	{occupy[i]=new work(); }
	
	
}




public void actionPerformed(ActionEvent e)//对监听的事件进行相应
{  
  

	if(e.getSource()==bt1)
	new 申请空间();
		
	else
		if(e.getSource()==bt2)

	  new 撤销作业(); 
	else
		if(e.getSource()==bt3)
		new 显示();	
		else
			if(e.getSource()==bt4){
				System.exit(0);
			}
	     
	

	
}


class 申请空间  extends Frame implements ActionListener{//创建申请空间类
	  private Button button1=new Button("确定");//定义按钮组件
	  private Button button2=new Button("退出");
	  public Label lab1=new Label("作业空间",Label.CENTER );//定义标签组件
	  public Label lab2=new Label("作业名",Label.CENTER );
	  public TextField text1=new TextField();//定义文本组件
	  public TextField text2=new TextField();
	  public TextField text3=new TextField();
	  public TextField text4=new TextField();
	  public TextField text5=new TextField();
	  public Panel pan1=new Panel();//定义容器组件
	  public Panel pan2=new Panel();
	  public Panel pan5=new Panel();
	  public Panel button=new Panel();
	  
	   private class WindowCloser extends WindowAdapter{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
       }


public 申请空间(){
	super("申请空间");
      setup();
	addWindowListener(new WindowCloser());//窗口监听
	pack();
	setVisible(true);
	button1.addActionListener(this);//添加监听事件
	button2.addActionListener(this);
	   setSize(280,200);//设置窗口大小
	   setLocation(300, 300); //主窗口 出现在位置  
	   setResizable(false);   //不能调大小 
}
public void setup()//组件的布局
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
	    	this.setVisible(false);//关闭当前窗口	
	  if(e.getSource()==button1)
		  {
		  int i,j,flag=0,f2=0;
		  String  a=text1.getText();//读取输入的作业大小
		  int	 job_length=Integer.parseInt(a);//将读到的字符转化为数字
		  String	job_name=text2.getText();//读取作业名
		  for(i=0;i<free_quantity;i++)
		  {
		  	if(free[i].length>=job_length) //如果空闲空间I的长度>=作业长度
		  	{
		  	   flag=1;   //空闲标志位就置1
		  	}
		  
		  }
		  
		  for(int k=0;k<occupy_quantity;k++)
		  {
		  	if((job_name).equals(occupy[k].data)==true) //如果空闲空间I的长度>=作业长度
		  	{
		  	   f2=1;   //空闲标志位就置1
		  	}
		  
		  }
		  
		  
		  
		  
		  
		  if(flag==0)
		  {
		  	text5.setText("对不起,当前没有能满足你申请长度的空闲内存,请稍候再试！\n");
		  }
		
		  else if(f2==1)
		  {
		  	text5.setText("该作业名已存在！\n");
		  }
		  
		  
		  
		   else
		  { //	t=0;
		  	j=0;
		  	for(i=0;i<free_quantity;i++)
		  	{ 
		  	   if(free[i].length>=job_length){break;}
		  	
		  	}
		  	
		  	occupy[occupy_quantity].front=free[i].front;//把未用的空闲空间的首地址付给已用空间的首地址
		  	occupy[occupy_quantity].data=job_name;//已用空间的内容为作业名
		  	occupy[occupy_quantity].length=job_length;//已用空间的长度为作业的长度
		  	occupy_quantity++;  
		  	//已用空间数量加1
		  	if(free[i].length>job_length) //如果空间的长度大于作业的长度，
		  	{
		  	   free[i].front+=job_length; //空闲空间的起始首地址=原空闲区间的起始长度加作业长度
		  	   free[i].length-=job_length;//空闲区间的长度=原空闲区间的长度-作业的长度
		  	}
		  	else                         //如果空间的长度=作业的长度
		  	{
		  	   for(j=i;j<free_quantity;j++)
		  	   {
		  			free[j]=free[j+1];//空闲区间前移一位
		  	   } 
		  	   free_quantity--;//空闲区间的数量减一
		  	}
		  		text5.setText("已申请空间!\n");
		  }
		
  
		
		  }
	  }
}



class 撤销作业  extends Frame implements ActionListener{
	  public Label lab1=new Label("输入要撤销的作业名",Label.CENTER );
	  public TextField text1=new TextField();
	  private Button button1=new Button("确定");
	  private Button button2=new Button("退出");
	  
	   private class WindowCloser extends WindowAdapter{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
       }


public 撤销作业(){
	super("撤销作业");
setup();
	addWindowListener(new WindowCloser());
	pack();
	setVisible(true);
	button1.addActionListener(this);
	button2.addActionListener(this);
	   setSize(200,200);//设置窗口大小
	   setLocation(200, 200); //主窗口 出现在位置  
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
			   flag=i;//把i的值赋给flag;
			   start=occupy[i].front;//把已用空间的首地址赋给start
			   len=occupy[i].length;//把已用空间的长度赋给len
			}
				
			}
			if(flag==-1)
			{
				text1.setText("没有这个作业名，请重新输入作业名！\n");
			}
			else
			{                 //加入空闲表
			for(i=0;i<free_quantity;i++)
			{
			   if((free[i].front+free[i].length)==start)//上空
			   {
				   if(((i+1)<free_quantity)&&(free[i+1].front==start+len))//下空
				{
			   //第i个空闲区间的长度=第i个空闲区间的长度+第i+1个空闲区间的长度（下空闲区）+length
					 free[i].length=free[i].length+free[i+1].length+len;
					 for(j=i+1;j<free_quantity;j++)
			   {
					   free[j]=free[j+1];//空闲区间前移一位
			   }
					  free_quantity--;//空闲区的数量渐少了一个
					p=1;
				}
				   else 
				{
				   free[i].length+=len;//（上空下不空）第i个空闲区间的长度=第i个空闲区间的长度+length，空闲区个数不变
				   p=1;
				}
			   }
			   if(free[i].front==(start+len))//下空上不空
			   {
				free[i].front=start;//起始地址等于待回收地址
				free[i].length+=len;//第i个空闲区间的长度=第i个空闲区间的长度+length
				 for(j=i+1;j<free_quantity;j++)
				  
				p=1;
			   }
			
			
			}
			if(p==0) //上下空闲区都不空（直接在空闲区表中找一个空表目，将其内容插入）
			{
			   free[free_quantity].front=start;
			   free[free_quantity].length=len;
			   free_quantity++;  //空闲区的数量加1
			}
			   //删除分配表中的该作业
			for(i=flag;i<occupy_quantity;i++)
			{
			   occupy[i]=occupy[i+1];
			}
			occupy_quantity--;//已用的区的数量
			text1.setText("内存空间回收完毕!\n");
			}
	 }		 
	if(e.getSource()==button2)
	    	this.setVisible(false);
	
}
}


///////////

class 显示 extends Frame implements ActionListener{//进程显示类，用于显示进程

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
	  private Button button2=new Button("退出");
	  
	   private class WindowCloser extends WindowAdapter{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
       }
	   
public 显示(){
	super("显示空闲表和分配表");
setup();
	addWindowListener(new WindowCloser());
	pack();
	setVisible(true);
	button2.addActionListener(this);
	   setSize(400,400);//设置窗口大小
	   setLocation(300, 300); //主窗口 出现在位置  
	   setResizable(false);   //不能调大小 
	   显示();




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


void 显示()//显示分区表以及分配表
{
	text1.setText("\n空闲表：\n");text2.setText("\n\n");text3.setText("\n\n");
    text1.append("\n起始地址：\n");text2.append("\n长度\n");text3.append("\n状态\n");
	  for(int i=0;i<free_quantity;i++){//在对应的文本区显示运行进程的信息
	  text1.append(free[i].front+"\n");
	  text2.append(free[i].length+"\n");
	  text3.append(free[i].data+"\n");
	
}	
	  text1.append("\n分配表：\n");text2.append("\n\n");text3.append("\n\n");
	  text1.append("\n起始地址：\n");text2.append("\n长度\n");text3.append("\n作业名\n");
	  for(int i=0;i<occupy_quantity;i++){//在对应的文本区显示等待进程的信息
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

