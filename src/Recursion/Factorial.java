package Recursion;

public class Factorial {
	
	
	public static int CalFact(int n) {
		
		if(n==0 ||n==1) {
			
		
			return 1;
		}
		
		
		
	int fac=CalFact(n-1);
	int fact1=n*fac;
	return fact1;
	
		
		
		
		
	}

	public static void main(String[] args) {
		int n=5;
		
	int fact2=	CalFact(n);
	System.out.println(fact2);
	
		
		
	

	}

}
