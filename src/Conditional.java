import java.util.Scanner;

public class Conditional {
	
	public static void main(String args[]) {
		
		Scanner sc=new  Scanner(System.in);
		
		int a = sc.nextInt();
		int b=sc.nextInt();
		
		if(a<b) {
			System.out.printf("%d is greater  ",  b);
		}else {
			System.out.printf(" %d is greater", a);
		}
		
		
	}

}
