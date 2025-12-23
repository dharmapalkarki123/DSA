package Recursion;

public class PoowerCal {
	
	public static int powerCal(int x, int n) {
		

		if(x==0) {
			return 0;
		}
		if(n==0) {
			return 1;
		}

		int power1= powerCal(x,n-1);
		
		int power2=x*power1;
		 return power2;
		
		
		
		
	}

	public static void main(String[] args) {
		
		int x=4 , n=2;
		
		int ans=powerCal(x, n);
		System.out.println(ans);

	}

}
