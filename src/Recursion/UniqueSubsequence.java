package Recursion;

import java.util.HashSet;

public class UniqueSubsequence {
	
	public static void uniqueSubsequence(String str,int idx,String newString,HashSet<String> set) {
		
		if(idx==str.length()) {
			
			if(set.contains(newString)) {
				return;
			} else {
				System.out.println(newString);
				set.add(newString);
				return;
			}
			
			
		}
		
		char currChar=str.charAt(idx);
		
		uniqueSubsequence(str, idx+1, newString+currChar, set);
		
		uniqueSubsequence(str, idx+1, newString, set);
		
		
	}
	
	
	
	
	
	 public static void main(String[] args) {
		 
		 
		 String str="aaaa";
		 
		 HashSet<String> set=new HashSet<>();
		 
		 uniqueSubsequence(str,0,"", set);
		 
		 
		 
		 
	 }
	 

}
