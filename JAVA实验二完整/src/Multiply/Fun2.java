package Multiply;

public class Fun2 {
	int a,b,c;
	void mul(){
		for(a=1; a<=9; a++){
			for(b=1; b<=a; b++){
				c=a*b;
				System.out.printf("%dx%d=%d\t",a,b,c);
			}
			System.out.println();
		}
	}
	
}
