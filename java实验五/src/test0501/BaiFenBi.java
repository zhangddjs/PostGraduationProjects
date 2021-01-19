package test0501;

import java.util.Scanner;

public class BaiFenBi {

	public void shuRu(int a[]) {
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入分数下限：");
		int low = reader.nextInt();
		System.out.println("请输入分数上限：");
		int high = reader.nextInt();
		BFB(a,low,high);
	}

	static void BFB(int a[], int low, int high) {
		double count = 0;
		for (int i = 0; i < 50; i++)
			if (a[i] <= high && a[i] >= low) {
				count++;
			}
		System.out.println("該分數段所佔的百分比爲：" + count / 50 * 100 + "%");
	}
}
