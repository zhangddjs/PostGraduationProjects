package test04;

public class Teacher extends HighSchoolStudent implements Introduction{
	private long workNumber;
	private String level;
	private String xi;
	private String zhuanye;
	private String jiaoyanshi;
	void setinformation(String name,long workNumber,String level,
			String xi,String zhuanye,String jiaoyanshi){
		this.name=name;
		this.workNumber=workNumber;
		this.level=level;
		this.xi=xi;
		this.zhuanye=zhuanye;
		this.jiaoyanshi=jiaoyanshi;
	}
	public void introduction(){
		System.out.println("��Һã�����"+xi+"ϵ"+zhuanye+"רҵ��ʦ��"
				+ "������"+workNumber+"��");
	}

}
