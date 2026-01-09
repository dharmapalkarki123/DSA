package Recursion;

public class guestCall1 {
	
	
	public static int guestCall(int n) {
		
		if(n<=1) {
			return 1;
		}
		
		
		
		//for single
		int singleCall=guestCall(n-1);
		
		//for pair call
		int pairCall=(n-1)*guestCall(n-2);
		
		
		return singleCall+pairCall;
		
		
		
	}

	public static void main(String[] args) {
		
		int n=4;
		
		System.out.println(guestCall(n));
		
		

	}

}
