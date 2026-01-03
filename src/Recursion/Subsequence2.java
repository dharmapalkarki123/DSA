package Recursion;

import java.util.HashSet;

public class Subsequence2 {
    public static void SubsequenceString (String str, int idx, String newString, HashSet<String> set) {
    	
    	if(idx==str.length()) {
    		if(set.contains(newString)) {
    			return;
    			
    		}else {
    			
    			System.out.println(newString);
    			set.add(newString);
    			return;
    			
    		}
    	
    	}
    	
    	
    	char currChar= str.charAt(idx);
    	
    	//to be 
    	SubsequenceString(str, idx+1, newString+currChar, set);
    	
    	//or not be
    	
    	SubsequenceString(str, idx+1, newString, set);
    	
    }
 
    

    public static void main(String[] args) {
    	
    	HashSet<String> set=new HashSet<>();
    	
    	String str="aaa";
    	SubsequenceString(str, 0, "", set);
      
    }
}
