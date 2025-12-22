package Recursion;

import java.security.PublicKey;
import java.util.Scanner;

public class SumOfNaturalNum {

//	public static void printSum(int n,int i,int sum) {
//		
//		if(n==i) {
//			
//			sum=sum+i;
//			
//			System.out.println(sum);
//			
//			return;
//			
//		}
//		
//		sum=sum+i;
//		
//		printSum(n, i+1, sum);
//		
//		System.out.println(i);
//		
//		
//		
//		
//	
//		
//		
//		
//		
//	}
//	
//	
//	public static void main(String[] args) {
//		
//		
//		printSum(5, 1, 0);
//	
//
//	}
	
	
	public static void printSum(int n,int i, int sum) {
		
		if(i==n) {
			
			sum += i;
			System.out.println(sum);
			
			
			return;
		}
		
		
		
		sum += i;
		printSum(n, i+1, sum);
		System.out.println(i);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		printSum(5,1,0);
		
		
		
	}
	
	
	
	
	
	
	

}
