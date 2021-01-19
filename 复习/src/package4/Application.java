package package4;

public class Application {

	public static void main(String[] args) {
		int a[] = { 22, 14, 31, 46, 52, 12, 33 };
		MaoPao m = new MaoPao();
		m.maopao(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}

	}

}

class MaoPao {
	private int i, j, temp;

	void maopao(int a[]) {
		for (i = 0; i < a.length - 1; i++) {
			for (j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}