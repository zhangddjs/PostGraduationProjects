package package5;

import java.util.Scanner;

public class Number2 {

	public static void main(String[] args) {
		int a, b;
		Number2 num = new Number2();
		System.out.println("������2������");
		Scanner reader = new Scanner(System.in);
		a = reader.nextInt();
		b = reader.nextInt();
		int d = num.fun(a, b);
		System.out.println("�������Ϊ��" + d);
		System.out.println("��С������Ϊ��" + a * b / d);
	}

	int fun(int a, int b) {
		int max = a >= b ? a : b;
		int min = a <= b ? a : b;
		for (int i = min; i > 0; i--) {
			if (max % i == 0 && min % i == 0) {
				return i;
			}
		}
		return 1;
	}
}
