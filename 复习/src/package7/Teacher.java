package package7;

public class Teacher extends CollageNumber{

	private double salary;
	Teacher(String id, String name, int age) {
		super(id, name, age);
	}
	void setData(double salary){
		this.salary = salary;
	}
	double getSalary(){
		return salary;
	}
	void showData(){
		super.showData();
		System.out.println("¹¤×Ê£º" + salary);
	}

}
