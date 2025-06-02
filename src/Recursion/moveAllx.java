package Recursion;

public class moveAllx {
	
	
	public static void moveAllx(String str, int count, int idx,String newString) {
		
		if(idx==str.length()) {
			for(int i=0;i<count;i++) {
				
				newString+="x";
				
				
				
			}
			
			
			System.out .println(newString);
			return;
		}
		
		
		char currChar=str.charAt(idx);
		if(currChar=='x') {
			count++;
			moveAllx(str, count, idx+1, newString);
		}else {
			newString+=currChar;
			
			moveAllx(str, count, idx+1, newString);
		}
		
		
	}
	
	

	public static void main(String[] args) {
		
		
		String str="abxdexxxfg";
		
	moveAllx(str, 0, 0, "");


	}

}
