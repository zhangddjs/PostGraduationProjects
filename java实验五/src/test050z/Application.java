package test050z;

import java.util.StringTokenizer;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("My name is Carrol");
		StringTokenizer fenxi = new StringTokenizer(s);
		String firstWord = fenxi.nextToken();
		
		System.out.println("�ַ���Ϊ:"+s);
		System.out.println("�ַ�������:"+s.length());
		System.out.println("�ַ�����һ���ַ�:"+s.toCharArray()[0]);
		System.out.println("�ַ������һ���ַ�"+s.toCharArray()[s.toCharArray().length-1]);
		System.out.println("�ַ�����һ������:"+firstWord);

	}

}
