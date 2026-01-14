package Recursion;



public class Occerance2 {
	
	public static int first =-1;
	public static int last= -1;
	
	public static void occerance(String str, int idx, char element) {
	
		
		if(idx==str.length()) {
			
			System.out.println(first);
			System.out.println(last);
			return;
		}
		
		
		char currentElemnt= str.charAt(idx);
		
		if(currentElemnt==element) {
			 
			if(first==-1) {
				
				first=idx;
			}else {
				last=idx;
			}
			
		}
		
		occerance(str, idx+1, element);
		
		
	}

	public static void main(String[] args) {
		String str="abaacdab";
		
			

		occerance(str, 0, 'b');
	}

}
