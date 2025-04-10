package Sorting;

public class BubbleSort {
	
	
	public static void printArryay(int array[]) {
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		
		int array[]= {7,8,3,1,2};
		
		
	  for(int i=0; i<array.length-1;i++) {
		  
		  int smallestIndex=i;
		  
		  for(int j=i+1;j<array.length;j++) {
			  
		if (array[smallestIndex]>array[j]) {
			
			smallestIndex=j;
			
		}
			  
			
			  
		  }
		  
		  int temp=array[smallestIndex];
			array[smallestIndex]=array[i];
			array[i]=temp;
	  }
	  
	  printArryay(array);
	  
	
		
		
	}

}
