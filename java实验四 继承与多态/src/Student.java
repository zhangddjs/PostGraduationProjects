
public class Student extends HighSchoolStudent implements Introduction{
	private long studyID;
	private String zhuanye;
	private String xi;
	private int Class;
	private int chengji;
	void setinformation(String name,long studyID,String xi,String zhuanye,int Class,int chengji){
		this.studyID=studyID;
		this.xi=xi;
		this.zhuanye=zhuanye;
		this.Class=Class;
		this.chengji=chengji;
		this.name=name;
	}
	public void introduction(){
		System.out.println("大家好，我叫"+name+"，"
				+ "是"+xi+"系"+zhuanye+"专业"+Class+"班的学生！");
	}
}
