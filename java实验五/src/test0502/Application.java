package test0502;

public class Application {

	public static void main(String[] args) {
		ShuRu English = new ShuRu();
		System.out.println("����һ��Ӣ�����֣�");
		English.sr();
		boolean judge = English.judge();
		if (judge) {
			int ziFu = English.getZiFu();
			int words = English.getWords();
			int sentence = English.getSentences();
			System.out.println("��������" + ziFu + "���ַ�");
			System.out.println("��" + words + "������");
			System.out.println("��" + sentence + "������");
		}
	}
}
