package package3;

import java.util.Scanner;

public class AverageScore {

	public static void main(String[] args) {
		double chengji[] = new double[5];
		double sum = 0;
		double ave;
		System.out.println("����������ѧ�����ġ�Ӣ�������ѧ�ɼ�");
		Scanner reader = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			chengji[i] = reader.nextDouble();
			sum += chengji[i];
		}
		ave = sum/5;
		ave = Math.round(ave * 10) / 10.0;
		System.out.println("5�ſε�ƽ���ɼ�Ϊ:" + ave);
		
	}

}
