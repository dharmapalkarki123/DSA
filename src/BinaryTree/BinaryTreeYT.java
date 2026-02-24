package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import Recursion.removeDuplicate;

public class BinaryTreeYT {

	static class Node {
		int data;
		Node leftNode;
		Node rightNode;

		Node(int data) {

			this.data = data;
			this.leftNode = null;
			this.rightNode = null;

		}

	}

	static class BinaryTree {

		static int idx = -1;

		public static Node buildTree(int nodes[]) {

			idx++;

			if (nodes[idx] == -1) {
				return null;
			}

			Node newNode = new Node(nodes[idx]);
			newNode.leftNode = buildTree(nodes);
			newNode.rightNode = buildTree(nodes);

			return newNode;

		}

	}

	public static void preorder(Node rootNode) {

		if (rootNode == null) {
			return;
		}

		System.out.print(rootNode.data + " ");

		preorder(rootNode.leftNode);
		preorder(rootNode.rightNode);

	}

	public static void inorderTraversal(Node rootNode) {

		if (rootNode == null) {

			return;
		}

		inorderTraversal(rootNode.leftNode);
		System.out.print(rootNode.data + " ");
		inorderTraversal(rootNode.rightNode);

	}

	public static void postTraversal(Node rootNode) {

		if (rootNode == null) {

			return;
		}

		postTraversal(rootNode.leftNode);
		postTraversal(rootNode.rightNode);
		System.out.print(rootNode.data + " ");

	}
	
	public static void levelOrdwe(Node rootNode) {
		
		if(rootNode==null) {
			return;
		}
		
		Queue<Node> q =new LinkedList<>();
		
		q.add(rootNode);
		q.add(null);
		
		while(!q.isEmpty()) {
			
			Node currNode=q.remove();
			
			if(currNode==null) {
				
				System.out.println();
				if(q.isEmpty()) {
					
					break;
					
				}else {
					q.add(null);
				}
				
			}else {
				
				System.out.println(currNode.data+" ");
				if(currNode.leftNode !=null) {
					
					q.add(currNode.leftNode);
					
					
				}
				
				if(currNode.rightNode !=null) {
					
					q.add(currNode.rightNode);
					
				}
				
			}
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	public static int countOfNode(Node rooNode) {
		
		if(rooNode==null) {
			return 0;
		}
		
		int leftCount=countOfNode(rooNode.leftNode);
		int rightCount=countOfNode(rooNode.rightNode);
		return leftCount+rightCount+1;
		
		
		
	}
	
public static int SumOfNode(Node rooNode) {
		
		if(rooNode==null) {
			return 0;
		}
		
		int leftCount=SumOfNode(rooNode.leftNode);
		int rightCount=SumOfNode(rooNode.rightNode);
		return leftCount+rightCount+rooNode.data;
		
		
		
	}
	

public static int heightOfTree(Node rooNode) {
	
	if(rooNode==null) {
		return 0;
	}
	
	int leftheight=heightOfTree(rooNode.leftNode);
	int rightheight=heightOfTree(rooNode.rightNode);
	
	if(leftheight>rightheight) {
		
		return leftheight+1;
		
	}else {
		
		return rightheight+1;
		
	}
	
	
	
	
	
}
	
public static int diameterOfTree(Node rooNode) {
	
	if(rooNode==null) {
		return 0;
	}
	
	int diam1=diameterOfTree(rooNode.leftNode);
	int diam2=diameterOfTree(rooNode.rightNode);
	
	int diam3=heightOfTree(rooNode.leftNode)+heightOfTree(rooNode.rightNode)+1;
	

		
		return Math.max(diam3, Math.max(diam1, diam2));
		
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

		BinaryTree tree = new BinaryTree();
		Node rootNode = tree.buildTree(nodes);

		// System.out.println(rootNode.data);
		// preorder(rootNode);

		// inorderTraversal(rootNode);

		//postTraversal(rootNode);

		//levelOrdwe(rootNode);
		
		//System.out.println(countOfNode(rootNode));
		//System.out.println(SumOfNode(rootNode));
		//System.out.println(heightOfTree(rootNode));
		System.out.println(diameterOfTree(rootNode));
		
		
	}
}