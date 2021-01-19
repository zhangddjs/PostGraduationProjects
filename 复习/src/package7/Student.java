package package7;

public class Student extends CollageNumber{

	private double chengji;
	Student(String id, String name, int age) {
		super(id, name, age);
	}
	
	void setData(double chengji){
		this.chengji = chengji;
	}
	double getGrade(){
		return chengji;
	}
	void showData(){
		super.showData();
		System.out.println("³É¼¨£º" + chengji);
	}

}
