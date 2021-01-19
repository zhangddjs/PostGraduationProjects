package package7;

public class CollageNumber {
	private String id;
	private String name;
	private int age;
	CollageNumber(String id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	void setData(double x){}
	void showData(){
		System.out.println("±àºÅ£º" + id);
		System.out.println("ĞÕÃû£º" + name);
		System.out.println("ÄêÁä£º" + age);
	}
}
