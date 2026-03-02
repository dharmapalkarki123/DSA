package BinaryTree;

public class BST {
	
	
	static class Node{
		
		int data;
		Node leftNode;
		Node rigthNode;
		
		
		Node(int data){
			this.data=data;
			this.leftNode=null;
			this.rigthNode=null;
		}
		
	}
	
	public static Node insert(Node rootNode, int values) {
		
		if(rootNode==null) {
			
			rootNode=new Node(values);
			
			return rootNode;
		}
		
		
		if(rootNode.data>values) {
			//leftSubTree
			
			rootNode.leftNode=insert(rootNode.leftNode, values);
			
		}else {
			rootNode.rigthNode=insert(rootNode.rigthNode, values);
		}
		
		
		return rootNode;
		
		
		
		
		
	}
	
	
	public static void inorder(Node rootNode) {
		
		if(rootNode==null) {
			return;
		}
		
		inorder(rootNode.leftNode);
		System.out.print(rootNode.data+" ");
		inorder(rootNode.rigthNode);
		
	}
	
	

	public static void main(String[] args) {

		int[] values= {5,1,3,4,2,7};
		Node rootNode=null;
		
		for(int i=0;i<values.length;i++) {
			
			rootNode=insert(rootNode, values[i]);
			
			
		}
		
		inorder(rootNode);
		System.out.println();

	}

}
