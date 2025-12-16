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
	  for(int j=0;j<array.length-i-1;j++) {
		  
		  if(array[j]>array[j+1]) {
			  
			   int temp=array[j];
			  array[j]=array[j+1];
			  array[j+1]=temp;
			  
		  }
		  
	  }
	
	  }
	  
	  printArryay(array);
	  
	
		
		
	}

}
