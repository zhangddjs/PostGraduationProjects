package test0501;

import java.util.Scanner;

public class PingXue {
	int a[] = new int[50];

	// �Ը��ſν�����ѧ
	public void px() {
		for (int i = 0; i < 50; i++) {
			a[i] = (int)(Math.random() * 100);
		}
	}

	// ��ȡƽ����
	public double getAverage() {
		double sum = 0;
		for (int i = 0; i < 50; i++) {
			sum += a[i];
		}
		double average = sum / 50;
		return average;
	}

	// ������������
	public void paiXu() {
		for (int i = 0; i < 50; i++) {
			for (int j = i; j < 50; j++) {
				if (a[j] < a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	// ��ӡԪ��
	public void print() {
		for (int i = 0; i < 50; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();	
	}

}
