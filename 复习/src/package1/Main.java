package package1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int VUL = reader.nextInt();
		int D = reader.nextInt();
		int d = D, vul;
		int count = 0;
		for(vul = VUL; vul>d; vul -= d++){
			count++;
		}
		if (VUL % D == 0){
			System.out.println(count + VUL / D);
		} else {
			System.out.println(count + VUL / D + 1);
		}

	}

}
