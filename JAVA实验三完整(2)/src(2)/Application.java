
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
		//��ӡZhang�����������Ϣ
		Zhang.getInformation();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//�����ع��췽���������Zhang2����ӡ����Ϣ
		HighSchoolStudent Zhang2=new HighSchoolStudent("Zhangdd2",
		"19951106","female","320211199511054139","18326659654","Hefei University",
		"20140911","Yixing");
		
		//�������ַ���ת��������
		String bir1=Zhang.date.replaceAll("[^0123456789]+","");
		String bir2=Zhang2.date.replaceAll("[^0123456789]+","");
		int age1=Integer.parseInt(bir1);
		int age2=Integer.parseInt(bir2);
		
		//�Ƚ�ת��֮������ֵĴ�С������ԽС������Խ��
		if(age1>age2)
			System.out.println("******Zhang2��Zhang��******");
		else
			System.out.println("******Zhang��Zhang2��******");
		
		//�ж�2���Ƿ�Ϊͬһ���ˣ������߼��������ж�
		boolean isSame;
		if(Zhang.name==Zhang2.name){
			isSame=true;
			System.out.println("2����ͬһ���ˣ�"+isSame);
		}
		else{
			isSame=false;
			System.out.println("2����ͬһ���ˣ�"+isSame);
		}
		
		//�������ҽ���
		Zhang.introduction();
		Zhang2.introduction();
		
	}

}
