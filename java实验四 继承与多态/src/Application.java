
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher A=new Teacher();
		Student B=new Student();
		A.setinformation("夏老师",10000,"教授","计科","软件工程","46#602");
//		A.introduction();
		B.setinformation("张东东",1403023042,"计科","软件工程",1,100);
//		B.introduction();
		TeacherLesson java=new TeacherLesson();
		java.javalesson(10000);
		Ziwojieshao person=new Ziwojieshao();
		System.out.print("该老师的自我介绍：");
		person.jieShao(A);
		System.out.println();
		Studentchengji C=new Studentchengji();
		C.javalesson(1403023042);
		System.out.print("学生的自我介绍：");
		person.jieShao(B);

	}

}
