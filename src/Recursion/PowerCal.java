package Recursion;
//print x^n(stack height=logn)
public class PowerCal {
	public static int powerCal(int x, int n) {
		
		if(n==0) {
			return 1;
		}
			if (x==0) {
				
				return 0;
				
			}	//if n is even
				if(n%2==0) {
					
					return powerCal(x,n/2)*powerCal(x, n/2);
					
				}else { //n is odd
					
					return powerCal(x,n/2)*powerCal(x, n/2)*x;
					
				}
				
				
				
				
			}

			public static void main(String[] args) {
				
				int x=4 , n=2;
				
				int ans=powerCal(x, n);
				System.out.println(ans);

			}

}
