package Recursion;

public class Factorial {
	
	public static int CalFactorial(int n) {
		if(n==1||n==0) {
			return 1;
		}
		
		
		
		return n*CalFactorial(n-1);
		
	}

	public static void main(String[] args) {
		
		int n=5;
		int fact= CalFactorial(n);
		
		System.out.println(fact);
		
		
	

	}

}
