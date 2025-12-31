package Recursion;

public class moveAllx1 {
	
	
	public static void moveAllxAtlast(String str, int idx, int count, String newStr) {
		
		
		if(idx==str.length()) {
			
			for(int i=0;i<count;i++) {
				
				newStr+="x";
				
				
			}
			
			System.out.println(newStr);
			
			return;
			
		}
		
		
		char currentElement=str.charAt(idx);
		
		if(currentElement=='x') {
			
			count++;
			
			moveAllxAtlast(str, idx+1, count, newStr);
			
			
			
		}else {
			
			newStr+= currentElement;
			
			moveAllxAtlast(str, idx+1, count, newStr);
			
			
		}
		
		
	}
	

	public static void main(String[] args) {
	 String str="abxrsxxua";
	 
	 String newStr="";
	 
	 moveAllxAtlast(str, 0, 0, "");
	 
	 

	}

}
