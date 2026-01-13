package Recursion;

import java.util.Arrays;
import java.util.List;

public class ArrayList {
	
	  static void subtractAndPrint(int[] array) {

	        // subtract 1 from each element (not below 0)
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] > 0) {
	                array[i]--;
	            }
	        }

	        // print current state
	        System.out.println(Arrays.toString(array));

	        // base case: all elements are zero
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] != 0) {
	                subtractAndPrint(array); // recurse
	                return;
	            }
	        }
	            }
	        


	public static void main(String[] args) {
		int[] array = {6, 7, 9};
		subtractAndPrint(array);
		
		

	}

}
