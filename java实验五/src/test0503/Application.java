package test0503;

public class Application {

	 public static void main(String[] args) {
		char a[] = {'J','A','V','A'};
		char b[] = {'H','E','L','L','O'};
		char c[] = {'J','A','V','A'};
		string str1 = new string(a);
		string str2 = new string(b);
		string str3 = new string(c);
		System.out.println("�ַ���1�ĳ���:"+str1.length());
		System.out.println("�ַ���2�Ƿ���ַ���1���");
		str2.compare(str1);
		System.out.println("�ַ���3�Ƿ���ַ���1���");
		str3.compare(str1);
		System.out.println("�ַ���2Ϊ��");
		str2.tostring();
		System.out.println("�ַ���3Ϊ��");
		str3.tostring();
	}

}

