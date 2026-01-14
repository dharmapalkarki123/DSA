package Recursion;

public class LongestSubstring {
	
	public static void longestSub(String str, int idx, String newSubString) {
		
		if(idx==str.length()) {
			
			System.out.println(newSubString);
			return;
			
		}
		
		char currenEle=str.charAt(idx);
		
		longestSub(str, idx+1, newSubString+currenEle);
		
		longestSub(str, idx+1, newSubString);
		
		
		
		
	}
	

	public static void main(String[] args) {
		
		String str="abcabcbb";
		
		longestSub(str, 0, " ");
		
		
		
		

	}

}
