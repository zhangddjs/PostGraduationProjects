package test04;

public class HighSchoolStudent {
	String name;
	String date;
	String sex;
	String IDNumber;
	String MobileNumber;
	String school;
	String timetoschool;
	String home;
	String setname(String name){
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
	String setIDNumber(String IDNumber){
		this.IDNumber=IDNumber;
		return IDNumber;
	}
	String setMobileNumber(String MobileNumber){
		this.MobileNumber=MobileNumber;
		return MobileNumber;
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
	}
	void getname(){
		System.out.println("name:"+name);
	}
	void getdate(){
		System.out.println("birthday:"+date);
	}
	void getsex(){
		System.out.println("sex:"+sex);
	}
	void getIDNumber(){
		System.out.println("IDNumber:"+IDNumber);
	}
	void getMobileNumber(){
		System.out.println("MobileNumber:"+MobileNumber);
	}
	void getschool(){
		System.out.println("school:"+school);
	}
	void gettimetoschool(){
		System.out.println("timetoschool:"+timetoschool);
	}
	void gethome(){
		System.out.println("hometown:"+home);
	}
}
