package TRIE;



public class Trie {

	static class Node{
		
		Node[] children;
		boolean endOfWord;
		
		public Node() {
			
			children=new Node[26];
			
			for(int i=0;i<26;i++) {
				
				children[i]=null;
				
			}
			
			endOfWord=false;
			
		}
		
		
	}
	
	static Node rootNode=new Node();
	
  	
	public static void insert(String word) {
		
		
		for(int i=0;i<word.length();i++) {
			
			int idx=word.charAt(i)-'a';
			
			if(rootNode.children[idx]==null) {
				
				//add new node
				rootNode.children[idx]=new Node();
				
			}
			
			if(i==word.length()-1) {
				
				rootNode.children[idx].endOfWord=true;
				
			}
			
		rootNode=	rootNode.children[idx];
			
			
			
		}
		
		
		
	}
	
	
	
	
  
    

    // Main method to test
    public static void main(String[] args) {
    
    	
    String	words[]= {"the","a","there","their","any"};
    
    for(int i=0;i<words.length;i++) {
    	
    	insert(words[i]);
    }
    	
    }
}
