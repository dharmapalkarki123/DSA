package Recursion;

import java.util.ArrayList;

public class SubsetNaturalNum {
	
	public static void printSubset(ArrayList<Integer> subset) {
		
		for(int i=0; i<subset.size(); i++) {
			
			System.out.print(subset.get(i)+" ");
			
		}
		System.out.println();
		
		
	}
	
	
	
	public static void subOfNatural(int n, ArrayList<Integer> subset ) {
		
		
		if(n==0) {
			
			printSubset(subset);
			return;
		}
		
		
		//for Adding
		subset.add(n);
		subOfNatural(n-1, subset);
		
		//for removing
		subset.remove(subset.size()-1);
		subOfNatural(n-1, subset);
		
	}

	public static void main(String[] args) {
		
		
		int n=3;
		ArrayList<Integer> subset=new ArrayList<>();
		
		subOfNatural(n,subset);				
		
		
		
		
		
		
		
		
		

	}

}
