package package7_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Application {
	public static void main(String[] args){
	     double max=0,max1=0; 
		 int sum=0,sum1=0;
		 int  x= 0;
		 double  g=0;
		 double c=0;
		 Student1  stu;
		 Teacher  tea;
		System.out.println("请输入5个学生 信息(学号、姓名、年龄、成绩)以逗号隔开");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 try {
			 for(int i=0;i<5;i++){
		      String str=br.readLine();
		      String[] s1=str.split(",");
		      x =Integer.parseInt(s1[2]);
		      c =Double.valueOf(s1[3]);
		      if(c>max)
					 max=c;
		      sum+=c;
		     stu=new Student1(s1[0],s1[1],x );
		      stu.setData(c);	
		      stu.showData();
		      }
			 System.out.println("请输入5个教师信息(职工号、姓名、年龄、工资)以逗号隔开");
			 for(int i=0;i<5;i++){
			      String str=br.readLine();
			      String[] s1=str.split(",");
			      x=Integer.parseInt(s1[2]);
			      g=Double.valueOf(s1[3]);
			      if(g>max)
						 max1=g;
					 	 sum1+=g;
				  tea =new Teacher(s1[0],s1[1],x);
			      tea.setData(g);	
			     	tea.showData();
			      }
		  } 
		 catch (IOException e) {
		    e.printStackTrace();
		 }
    	 System.out.println("学生最高分数："+max);
		 System.out.println("学生平均分数："+sum/5);
		 System.out.println("教师最高工资："+max1);
		 System.out.println("教师平均工资："+sum1/5);
	}
}
class CollageNumber {
	public int age;
	String  name;
	String  id;
	public CollageNumber (String id, String name, int age){
		 this.id=id;
		 this.name=name;
         this.age=age;
	}
	 void  setData(double x){
       }
     void  showData(){
    	 System.out.println("id is "+id) ;
 		 System.out.println("name is "+name);
 		 System.out.println("age is "+age);
     }
}
class Student1 extends CollageNumber { 
   double grade; //
  public Student1(String id, String name, int age){
    super(id,name,age);
  }
	void  setData(double x){
         grade=x;
    }
   double  getgrade (){
      return grade;
    }
	void  showData(){
		 super.showData();
         System.out.println(name+"  grade is "+getgrade ());
    }
}
class Teacher extends CollageNumber {
	double salary;
		public Teacher(String id, String name, int age){
		    super(id,name,age);		
	}
		void  setData(double x){
			salary=x;
	    }
	   double  getsalary(){
	      return salary;
	    }
	   void  showData(){
		   super.showData();
	         System.out.println(name+"  salary is "+getsalary());
	    }
}

