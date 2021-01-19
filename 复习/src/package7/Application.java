package package7;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Student stu = new Student("101", "уехЩ", 18);
		Teacher tea = new Teacher("110", "уткд", 20);
		stu.setData(100);
		tea.setData(1000);
		stu.showData();
		tea.showData();
	}

}
