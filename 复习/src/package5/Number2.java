package package5;

import java.util.Scanner;

public class Number2 {

	public static void main(String[] args) {
		int a, b;
		Number2 num = new Number2();
		System.out.println("请输入2个数：");
		Scanner reader = new Scanner(System.in);
		a = reader.nextInt();
		b = reader.nextInt();
		int d = num.fun(a, b);
		System.out.println("最大公因数为：" + d);
		System.out.println("最小公倍数为：" + a * b / d);
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
