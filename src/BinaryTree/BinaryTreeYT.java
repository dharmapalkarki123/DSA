package BinaryTree;

public class BinaryTreeYT {
	
	
	static class Node{
		int data;
		Node leftNode;
		Node rightNode;
		
		
		
		Node(int data){
			
			this.data=data;
			this.leftNode=null;
			this.rightNode=null;
			
		}
		
	}
	
	
	static class BinaryTree{
		
		static int idx=-1;
		
		public static Node buildTree(int nodes[]) {
			
			idx++;
			
			if(nodes[idx]==-1) {
				return null;
			}
			
			Node newNode=new Node(nodes[idx]);
			newNode.leftNode=buildTree(nodes);
			newNode.rightNode=buildTree(nodes);
			
			return newNode;
			
			
		}
		
	}
	
	

	public static void main(String[] args) {
		int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

		BinaryTree tree=new BinaryTree();
	Node rootNode=	 tree.buildTree(nodes);
		
		
		
		System.out.println(rootNode.data);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}