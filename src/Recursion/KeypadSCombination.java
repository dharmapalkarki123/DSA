package Recursion;

public class KeypadSCombination {
	
	public static String[] keypad= {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	
	public static void printCom(String str, int idx, String Combination) {
		
		
		if(idx==str.length()) {
			
			System.out.println(Combination);
			
			return;
			
		}
		
		char currChar=str.charAt(idx);
		String mapping=keypad[currChar-'0'];
		
		for(int i=0; i<mapping.length(); i++) {
			
			printCom(str,idx+1,Combination+mapping.charAt(i));
			
		}
		
		
		
		
	}

	public static void main(String[] args) {
		
		String str="23";
		
		printCom(str, 0, "");
		

	}

}
