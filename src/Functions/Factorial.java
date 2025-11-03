package Functions;
import java.util.Scanner;

public class Factorial {
	
	
	public static void printFact(int n) {
		
		
		if(n<1) {
			System.out.println("Invalid number");
			return;
		}
		
		 int res=1;
		 
		 for(int i=n; i>=1;i--) {
			 
			 res=res*i;
			 
			 
		 }
		 
		 System.out.println(res);
		 
		 return;

	
	}

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a number");
		 int n=sc.nextInt();
		 
		 printFact(n);
		 

	}

}
