package Sorting;

public class SelectionSort {
	
	
	public static void printArray(int array[]) {
		
		for(int i=0;i<array.length;i++) {
			
			System.out.print(array[i]+" ");
			
			
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		int array[]= {7,8,3,1,2};
		
		
		for(int i=0;i<array.length;i++) {
			
			for(int j=0;j<array.length-i-1;i--) {
				
				int smallest=array[j];
				if (smallest<array[j+1]) {
					
				}
				
			}
			
			
		}
		
		printArray(array);

	}

}
