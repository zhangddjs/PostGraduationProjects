
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher A=new Teacher();
		Student B=new Student();
		A.setinformation("����ʦ",10000,"����","�ƿ�","�������","46#602");
//		A.introduction();
		B.setinformation("�Ŷ���",1403023042,"�ƿ�","�������",1,100);
//		B.introduction();
		TeacherLesson java=new TeacherLesson();
		java.javalesson(10000);
		Ziwojieshao person=new Ziwojieshao();
		System.out.print("����ʦ�����ҽ��ܣ�");
		person.jieShao(A);
		System.out.println();
		Studentchengji C=new Studentchengji();
		C.javalesson(1403023042);
		System.out.print("ѧ�������ҽ��ܣ�");
		person.jieShao(B);

	}

}
