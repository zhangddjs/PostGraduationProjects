package test0502;

public class Application {

	public static void main(String[] args) {
		ShuRu English = new ShuRu();
		System.out.println("输入一串英文文字：");
		English.sr();
		boolean judge = English.judge();
		if (judge) {
			int ziFu = English.getZiFu();
			int words = English.getWords();
			int sentence = English.getSentences();
			System.out.println("该文字有" + ziFu + "个字符");
			System.out.println("有" + words + "个单词");
			System.out.println("有" + sentence + "个句子");
		}
	}
}
