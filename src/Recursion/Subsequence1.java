package Recursion;

public class Subsequence1 {
	
	
	public static void subsequence(String str, int idx, String newStr) {
		
		
		if(idx==str.length()) {
			
			System.out.println(newStr);
			return;
			
			
		}
		
		char currChar=str.charAt(idx);
		
		subsequence(str, idx+1, newStr+currChar);
		
		subsequence(str, idx+1, newStr);
		
		
	}

	public static void main(String[] args) {
	
		String str="abc";
		
		subsequence(str, 0, "");
		

	}

}
