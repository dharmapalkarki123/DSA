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
		
		Node curr=rootNode;
		
		for(int i=0;i<word.length();i++) {
			
			int idx=word.charAt(i)-'a';
			
			if(curr.children[idx]==null) {
				
				//add new node
				curr.children[idx]=new Node();
				
			}
			
			if(i==word.length()-1) {
				
				curr.children[idx].endOfWord=true;
				
			}
			
		curr=	curr.children[idx];
			
			
			
		}
		
		
		
	}
	
	public static boolean search(String key) {
		
	Node curr=rootNode;
		
		for(int i=0;i<key.length();i++) {
			
			int idx=key.charAt(i)-'a';
			Node node=curr.children[idx];
			
			if(node==null) {
				
				return false;
				
			}
			
			
			if(i==key.length()-1 && node.endOfWord==false) {
				
				return false;
				
				
			}
			
			
			curr=curr.children[idx];
			
			
			
			
			
			
		}
		
		return true;
		
		
	}
	
	public static boolean wordBreak(String key) {
		
		if(key.length()==0) {
			
			return true;
			
		}
		
		for(int i=1;i<=key.length();i++) {
			
			String firstPart=key.substring(0,i);
			String secPart=key.substring(i);
			
			if(search(firstPart)&&wordBreak(secPart)) {
				
				
				return true;
				
			}
			
			
		}
		
		return false;
		
	}
	
	
	
	
	
  
    

    // Main method to test
    public static void main(String[] args) {
    
    	
    String	words[]= {"the","a","there","their","any"};
    
    String key="thethereanya";
    
    for(int i=0;i<words.length;i++) {
    	
    	insert(words[i]);
    }
    
    System.out.println(wordBreak(key));
    
//    System.out.println(search("the"));
//    System.out.println(search("there"));
//    System.out.println(search("thoe"));
    
    	
    }
}
