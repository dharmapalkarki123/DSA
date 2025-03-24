package Functions;

import java.util.Scanner;

public class SumOfOdd {
	
	public static int AddOddNumber(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			if(i%2!=0) {
				sum=sum+i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		
		int result=AddOddNumber(n);
		System.out.println(result);
		

	}

}
