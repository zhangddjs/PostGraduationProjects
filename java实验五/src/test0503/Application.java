package test0503;

public class Application {

	 public static void main(String[] args) {
		char a[] = {'J','A','V','A'};
		char b[] = {'H','E','L','L','O'};
		char c[] = {'J','A','V','A'};
		string str1 = new string(a);
		string str2 = new string(b);
		string str3 = new string(c);
		System.out.println("×Ö·û´®1µÄ³¤¶È:"+str1.length());
		System.out.println("×Ö·û´®2ÊÇ·ñºÍ×Ö·û´®1ÏàµÈ");
		str2.compare(str1);
		System.out.println("×Ö·û´®3ÊÇ·ñºÍ×Ö·û´®1ÏàµÈ");
		str3.compare(str1);
		System.out.println("×Ö·û´®2Îª£º");
		str2.tostring();
		System.out.println("×Ö·û´®3Îª£º");
		str3.tostring();
	}

}

