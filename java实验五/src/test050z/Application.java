package test050z;

import java.util.StringTokenizer;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("My name is Carrol");
		StringTokenizer fenxi = new StringTokenizer(s);
		String firstWord = fenxi.nextToken();
		
		System.out.println("字符串为:"+s);
		System.out.println("字符串长度:"+s.length());
		System.out.println("字符串第一个字符:"+s.toCharArray()[0]);
		System.out.println("字符串最后一个字符"+s.toCharArray()[s.toCharArray().length-1]);
		System.out.println("字符串第一个单词:"+firstWord);

	}

}
