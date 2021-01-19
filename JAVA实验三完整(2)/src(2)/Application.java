
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HighSchoolStudent Zhang=new HighSchoolStudent();
		Zhang.setName("Zhangdd");
		Zhang.setDate("19951105");
		Zhang.setSex("male");
		Zhang.setIDNumber("320211199511054138");
		Zhang.setMobileNumber("18326659653");
		Zhang.setSchool("Hefei University");
		Zhang.setTimetoSchool("20140910");
		Zhang.setHome("Wuxi");
/*		Zhang.getname();
		Zhang.getdate();
		Zhang.getsex();
		Zhang.getIDNumber();
		Zhang.getMobileNumber();
		Zhang.getschool();
		Zhang.gettimetoschool();
		Zhang.gethome();
*/
		//打印Zhang对象的所有信息
		Zhang.getInformation();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//用重载构造方法定义对象Zhang2并打印其信息
		HighSchoolStudent Zhang2=new HighSchoolStudent("Zhangdd2",
		"19951106","female","320211199511054139","18326659654","Hefei University",
		"20140911","Yixing");
		
		//将生日字符串转化成数字
		String bir1=Zhang.date.replaceAll("[^0123456789]+","");
		String bir2=Zhang2.date.replaceAll("[^0123456789]+","");
		int age1=Integer.parseInt(bir1);
		int age2=Integer.parseInt(bir2);
		
		//比较转化之后的数字的大小，数字越小，年龄越大
		if(age1>age2)
			System.out.println("******Zhang2比Zhang大******");
		else
			System.out.println("******Zhang比Zhang2大******");
		
		//判断2人是否为同一个人，声明逻辑变量再判断
		boolean isSame;
		if(Zhang.name==Zhang2.name){
			isSame=true;
			System.out.println("2人是同一个人："+isSame);
		}
		else{
			isSame=false;
			System.out.println("2人是同一个人："+isSame);
		}
		
		//调用自我介绍
		Zhang.introduction();
		Zhang2.introduction();
		
	}

}
