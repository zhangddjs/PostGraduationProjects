package test0501;

public class Application {

	public static void main(String[] args) {
		PingXue java = new PingXue();
		PingXue shuJu = new PingXue();
		BaiFenBi BF = new BaiFenBi();
		java.px();
		shuJu.px();
		shuJu.paiXu();
		java.paiXu();
		double jAver = java.getAverage();
		double sAver = shuJu.getAverage();
		System.out.println("java�Ľ�ѧ��ѧΪ��");
		java.print();
		System.out.println("���ݽṹ�Ľ�ѧ��ѧΪ��");
		shuJu.print();
		System.out.println("java�γ̵�ƽ����ѧ����Ϊ��" + jAver);
		System.out.println("���ݽṹ�γ̵�ƽ����ѧ����Ϊ��" + sAver);
		System.out.println();
		System.out.println();
		System.out.println("*******Ոݔ��java�γ̷֔��εİٷֱ�*******");
		BF.shuRu(java.a);
		System.out.println("*******Ոݔ�����ݽṹ�γ̷֔��εİٷֱ�*******");
		BF.shuRu(shuJu.a);
	}

}
