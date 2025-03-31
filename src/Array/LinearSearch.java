package Array;

import java.util.Scanner;


public class LinearSearch {

	
	public static void main(SSTRING[] args) {
		
		Scanner sc	=new Scanner(System.in);
		int num =sc.nextInt();
		
		int array[]=new int[num];
		
		for(int i=0;i<array.length;i++) {
			
		array[i]=sc.nextInt();	
			
		}
		
		int x=5;
				for(int i=0;i<array.length;i++) {
					if(array[i]==x) {
						System.out.println("Number found in index of" +i);
					}
				}
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	
	
}
