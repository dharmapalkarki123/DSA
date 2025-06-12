
// Find the number of ways in which you can invite n people to your party single or in pairs.
package Recursion;

public class GuestCall {
	
	public static int guestCall(int n) {
		
		 if(n<=1) {
			 return 1;
		 }
		
		//for single 
		int SingleCall=guestCall(n-1);
		
		//for pair call
		
		int PairCall= (n-1)*guestCall(n-2);
		
		
		return SingleCall+PairCall;
		
	}
	
	public static void main(String[] args) {
		
		int n=4;
		
		System.out.println(guestCall(n));
		
		
	}

}
