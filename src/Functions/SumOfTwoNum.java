package Functions;

import java.util.Scanner;

public class SumOfTwoNum {
	
	public static int printSum(int a, int b) {
		
		int sum=a+b;
		
		return sum;
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner  sc =new Scanner(System.in);
		System.out.println("Enter first number");
		int a=sc.nextInt();
		
		System.out.println("Enter Second  number");
		
		int b=sc.nextInt();
		
		

	int sum=printSum(a,b);
		
		System.out.println("Sum of two number:"+sum);
		
		
	}

}
