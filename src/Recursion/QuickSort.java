package Recursion;

public class QuickSort {
	
	
	public static int partition(int array[],int low,int high) {
		
		int pivort=array[high];
		int i=low-1;
		
		for(int j=low;j<high;j++) {
			
			if(array[j]<pivort) {
				
				i++;
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				
				
			}
			
			
			
		}
		
		i++;
		int temp=array[i];
		array[i]=pivort;
		array[high]=temp;
		return i; //pivort index
		
		
		
		
		
	}
	
	
	public static void quickSort(int array[], int low, int high) {
		
		if(low<high) {
			
			
			int pidx=partition(array,low,high);
			
			quickSort(array, low, pidx-1);
			quickSort(array, pidx+1, high);
			
			
		
			
		}
		
		
		
	}

	public static void main(String[] args) {
		
		int[] array= {6,3,9,5,2,8};
		
	   int n=array.length;
	   
	   quickSort(array, 0, n-1);
	   
	   //print
	   for(int i=0;i<n;i++) {
		   
		   System.out.print(array[i]+" ");
		   
		   
	   }
	   System.out.println();
		

	}

}
