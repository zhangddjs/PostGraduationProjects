package package6;

public class Test {

	public static void main(String[] args) {
		int n = 7;
		while (!(n % 2 == 1 && n % 3 == 2 && n % 5 == 4 && n % 6 == 5)){
			n += 7;
		}
		System.out.println(n);
	}

}
