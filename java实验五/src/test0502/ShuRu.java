package test0502;
import java.util.Scanner;
import java.util.StringTokenizer;
public class ShuRu {
	private String str;
	int a, b, c;
	//�����ַ���
	public void sr(){
		Scanner reader = new Scanner(System.in);
		str = reader.nextLine();
	}
	//�ж��ַ���ĩβ�Լ��ַ����Ƿ��
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
	//�����ַ�������
	public int getZiFu(){
		return str.length();
	}
	//�����ַ���������
	public int getWords(){
		StringTokenizer fenxi;
		fenxi = new StringTokenizer(str, "?!. ");
		return fenxi.countTokens();
	}
	//�����ַ���������
	public int getSentences(){
		StringTokenizer fenxi;
		fenxi = new StringTokenizer(str, "?!.");
		return fenxi.countTokens();
	}
}
