package test0501;

import java.util.Scanner;

public class BaiFenBi {

	public void shuRu(int a[]) {
		Scanner reader = new Scanner(System.in);
		System.out.println("������������ޣ�");
		int low = reader.nextInt();
		System.out.println("������������ޣ�");
		int high = reader.nextInt();
		BFB(a,low,high);
	}

	static void BFB(int a[], int low, int high) {
		double count = 0;
		for (int i = 0; i < 50; i++)
			if (a[i] <= high && a[i] >= low) {
				count++;
			}
		System.out.println("ԓ�֔������׵İٷֱȠ���" + count / 50 * 100 + "%");
	}
}
