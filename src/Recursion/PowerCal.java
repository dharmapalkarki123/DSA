package Recursion;
//print x^n(stack height=logn)
public class PowerCal {
	public static int powerCal(int x, int n) {
		
		
		if(x==0) {
			return 0;
		}
		if (n==0) {
			return 1;
			
		}
		
		if(n%2==0) {
			
			return powerCal(x, n/2)*powerCal(x, n/2);
			
		}else  
			
			return powerCal(x, n/2)*powerCal(x, n/2)*x;
				
				
			}

			public static void main(String[] args) {
				
				int x=4 , n=5;
				
				int ans=powerCal(x, n);
				System.out.println(ans);

			}

}
