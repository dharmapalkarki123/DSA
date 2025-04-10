package Sorting;

public class InsertionSort {
	
	
	public static void printArryay(int array[]) {
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		
		int array[]= {7,8,3,1,2};
		
		
	  for(int i=1; i<array.length;i++) {
		  
		 int current=array[i];
		 
		 int j=i-1;
		 
		 while(j>=0 && current<array[j]) {
			 
			 array[j+1]=array[j];
			 j--;
			 
		 }
		 array[j+1]=current;
		  
	
	  }
	  
	  printArryay(array);
	  
	
		
		
	}

}
