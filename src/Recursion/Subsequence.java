package Recursion;

public class Subsequence {
    public static void SubsequenceString (String str, int idx, String newString) {
    	
    	if(idx==str.length()) {
    		System.out.println(newString);
    		return;
    	}
    	
    	
    	char currChar= str.charAt(idx);
    	
    	SubsequenceString(str, idx+1, newString+currChar);
    	
    	SubsequenceString(str, idx+1, newString);
    	
    }
 
    

    public static void main(String[] args) {
    	
    	String str="abc";
    	SubsequenceString(str, 0, "");
      
    }
}
