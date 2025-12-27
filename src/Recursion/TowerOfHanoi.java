package Recursion;



public class TowerOfHanoi {

    // Recursive function to solve Tower of Hanoi
    public static void solveHanoi(int n, String src, String helper, String des) {
    	
    	if(n==0) {
    		
    		System.out.println("transfer disk"+n+"from" +src+ "to" +des);
    		return;

    		
    	}
    	
    	
    	solveHanoi(n-1, src, des, helper);
    	
    	System.out.println("transfer disk"+n+"from" +src+ "to" +des);
    	
    	solveHanoi(n-1, helper, src, des);
    	
    	
   
    }

    public static void main(String[] args) {
    	
    	
    	int n=2;
      solveHanoi(n, "S", "H", "D");
    }
}

