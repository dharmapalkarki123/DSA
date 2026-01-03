package Recursion;

public class Subsequence {
    public static void SubsequenceString (String str, int idx, String newString) {
    	
    	if(idx==str.length()) {
    		System.out.println(newString);
    		return;
    	}
    	
    	
    	char currChar= str.charAt(idx);
    	
    	//to be 
    	SubsequenceString(str, idx+1, newString+currChar);
    	
    	//or not be
    	
    	SubsequenceString(str, idx+1, newString);
    	
    }
 
    

    public static void main(String[] args) {
    	
    	String str="abc";
    	SubsequenceString(str, 0, "");
      
    }
}
