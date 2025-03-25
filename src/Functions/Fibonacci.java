package Functions;

import java.util.Scanner;

public class Fibonacci {
	
	public static void CalFibonacci(int n) {
		int a=0;
		int b=1;
		for(int i=1;i<=n;i++) {
			
			System.out.print(a +" ");
			int c=a+b;
			a=b;
			b=c;
			
		
		}
		
	}

	public static void main(String[] args) {

		
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		
     CalFibonacci(n);
    
		

	}

}
