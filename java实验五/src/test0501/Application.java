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
		System.out.println("java的教学评学为：");
		java.print();
		System.out.println("数据结构的教学评学为：");
		shuJu.print();
		System.out.println("java课程的平均教学评分为：" + jAver);
		System.out.println("数据结构课程的平均教学评分为：" + sAver);
		System.out.println();
		System.out.println();
		System.out.println("*******請輸入java课程分數段的百分比*******");
		BF.shuRu(java.a);
		System.out.println("*******請輸入数据结构课程分數段的百分比*******");
		BF.shuRu(shuJu.a);
	}

}
