//判断类，即判断输入的值，并执行相应操作。
public class Choose {
	static void judgement(int i){
		if(i==1){
			System.out.println("录入班次信息");
			InputInformation.Input();
		}
		else if(i==2){
			System.out.println("浏览班次信息");
		}
		else if(i==3){
			System.out.println("查询路线");
		}
		else if(i==4){
			System.out.println("售票和退票功能");
		}
		else
			System.out.println("Input Error!");
	}
}
