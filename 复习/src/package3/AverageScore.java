package package3;

import java.util.Scanner;

public class AverageScore {

	public static void main(String[] args) {
		double chengji[] = new double[5];
		double sum = 0;
		double ave;
		System.out.println("依次输入数学、语文、英语、物理、化学成绩");
		Scanner reader = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			chengji[i] = reader.nextDouble();
			sum += chengji[i];
		}
		ave = sum/5;
		ave = Math.round(ave * 10) / 10.0;
		System.out.println("5门课的平均成绩为:" + ave);
		
	}

}
