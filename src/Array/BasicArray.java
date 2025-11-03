package Array;

import java.util.Scanner;

public class BasicArray {

	public static void main(String[] args) {
		
//		int[] marks= new int[3];
//		marks[0]=98;
//		marks[1]=97;
//		marks[2]=92;
//		
//		System.out.println(marks[0]);
//		System.out.println(marks[1]);
//		System.out.println(marks[2]);
		
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter size of array");
		int size=sc.nextInt();
		int[] mark= new int[size];
		
		
		
		for(int i=0;i<size;i++) {
			
		
			
			 mark[i]=sc.nextInt();
			
		
			 
			
		}
		
		System.out.println("Enter x number");
		
		int n=sc.nextInt();
		
		
		
		for(int i=0;i<size;i++) {
			
			if(mark[i]==n) {
				System.out.println("Position of n is " +i);
			}
			
		}
		
		
		
		for(int i=0;i<size;i++) {
			
		
			
		
			
		System.out.println(mark[i]);
			
		
			 
			
		}
		
		
		
		
		
		
	}
	
	
}
