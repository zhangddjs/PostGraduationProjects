package test0502;
import java.util.Scanner;
import java.util.StringTokenizer;
public class ShuRu {
	private String str;
	int a, b, c;
	//ÊäÈë×Ö·û´®
	public void sr(){
		Scanner reader = new Scanner(System.in);
		str = reader.nextLine();
	}
	//ÅÐ¶Ï×Ö·û´®Ä©Î²ÒÔ¼°×Ö·û´®ÊÇ·ñ¿Õ
	public boolean judge(){
		a = str.lastIndexOf("?");
		b = str.lastIndexOf("!");
		c = str.lastIndexOf(".");
		if((a - str.length() != -1 && b - str.length() != -1 && c - str.length() != -1)
				||(a == -1 && b == -1 && c == -1)){
			System.out.println("Input error!");
			return false;
		}
		else{
			System.out.println("Input Right!");
			return true;
		}
	}
	//·µ»Ø×Ö·û´®³¤¶È
	public int getZiFu(){
		return str.length();
	}
	//·µ»Ø×Ö·û´®µ¥´ÊÊý
	public int getWords(){
		StringTokenizer fenxi;
		fenxi = new StringTokenizer(str, "?!. ");
		return fenxi.countTokens();
	}
	//·µ»Ø×Ö·û´®¾ä×ÓÊý
	public int getSentences(){
		StringTokenizer fenxi;
		fenxi = new StringTokenizer(str, "?!.");
		return fenxi.countTokens();
	}
}
