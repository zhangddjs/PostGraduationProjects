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
		System.out.println("大家好，我是"+xi+"系"+zhuanye+"专业教师，"
				+ "工号是"+workNumber+"。");
	}

}
