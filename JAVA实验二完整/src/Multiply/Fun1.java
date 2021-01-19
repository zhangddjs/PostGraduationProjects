package Multiply;

public class Fun1 {
	int a,c=1;
	double b,sum=0;		
	void step(){
		System.out.printf("sum=");
		for(a=1; a<=20; a++){
			c*=a;
			b=(float)1/c;
			sum+=b;
			if(a!=20)
				System.out.printf("1/%d!+",a);
			else
				System.out.printf("1/%d!",a);
		}
		System.out.println("="+sum);
	}
}
