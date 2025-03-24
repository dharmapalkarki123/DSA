package Functions;

import java.util.Scanner;

public class Average {

	
	
	public static double CalAverage(int n1,int n2,int n3) {
		double average=(n1+n2+n3)/3.0;
		
		return average;
		
		
	}
	
	public static void main(String[] args) {
	
		Scanner  sc =new Scanner(System.in);
		
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int n3=sc.nextInt();
		double c1=CalAverage(n1, n2, n3);
		System.out.println(c1);

	}

}
