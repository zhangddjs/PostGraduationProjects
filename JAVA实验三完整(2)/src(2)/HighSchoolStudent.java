
public class HighSchoolStudent {
	String name;
	String date;
	String sex;
	String IDNumber;
	String MobileNumber;
	String school;
	String timetoschool;
	String home;
/*	String setname(String name){
		this.name=name;
		return name;
	}
	String setdate(String date){
		this.date=date;
		return date;

	}
	String setsex(String sex){
		this.sex=sex;
		return sex;
	}
	String setschool(String school){
		this.school=school;
		return school;
	}
	String settimetoschool(String timetoschool){
		this.timetoschool=timetoschool;
		return timetoschool;
	}
	String sethome(String home){
		this.home=home;
		return home;
	}*/
	public HighSchoolStudent() {
//		System.out.println();// TODO Auto-generated constructor stub
	}
	HighSchoolStudent(String name,String date,String sex,
			String IDNumber,String MobileNumber,String school,
			String timetoschool,String home){
		this.setName(name);
		this.setDate(date);
		this.setSex(sex);
		this.setIDNumber(IDNumber);
		this.setMobileNumber(MobileNumber);
		this.setSchool(school);
		this.setTimetoSchool(timetoschool);
		this.setHome(home);
/*		this.getname();
		this.getdate();
		this.getsex();
		this.getIDNumber();
		this.getMobileNumber();
		this.getschool();
		this.gettimetoschool();
		this.gethome();
*/
		this.getInformation();
	}
	public void getInformation(){
		System.out.println("Name:"+this.getName());
		System.out.println("Birthday:"+this.getDate());
		System.out.println("sex:"+this.getSex());
		System.out.println("IDNumber:"+this.getIDNumber());
		System.out.println("MobileNumber:"+this.getMobileNumber());
		System.out.println("School:"+this.getSchool());
		System.out.println("TimetoSchool:"+this.getTimetoSchool());
		System.out.println("HomeTown:"+this.getHome());
	}
	
	/*void getname(){
		System.out.println("name:"+name);
	}
	void getdate(){
		System.out.println("birthday:"+date);
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTimetoSchool() {
		return timetoschool;
	}
	public void setTimetoSchool(String timetoschool) {
		this.timetoschool = timetoschool;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getIDNumber(){
		return IDNumber;
	}
	public String getMobileNumber(){
		return MobileNumber;
	}
	public void setIDNumber(String IDNumber){
		this.IDNumber=IDNumber;
	}
	public void setMobileNumber(String MobileNumber){
		this.MobileNumber=MobileNumber;
	}
/*	void getschool(){
		System.out.println("school:"+school);
	}
	void gettimetoschool(){
		System.out.println("timetoschool:"+timetoschool);
	}
	void gethome(){
		System.out.println("hometown:"+home);
	}
	void getsex(){
	System.out.println("sex:"+sex);
	}*/
	
	//自我介绍
	void introduction(){
		System.out.println(name+":大家好，我是"+school+"学校的"+name);
	}
}

