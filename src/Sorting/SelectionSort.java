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
		
		
		for(int i=0;i<array.length-1;i++) {
			int smallest=i;
			
			for(int j=i+1;j<array.length;j++) {
				
			
				if (array[smallest]>array[j]) {
					
					smallest=j;
					
					
				}
				
			}
			
			int temp=array[smallest];
			array[smallest]=array[i];
			array[i]=temp;
			
			
		}
		
		printArray(array);

	}

}
