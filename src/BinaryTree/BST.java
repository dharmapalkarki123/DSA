package BinaryTree;

import javax.naming.directory.SearchControls;

public class BST {

	static class Node {

		int data;
		Node leftNode;
		Node rigthNode;

		Node(int data) {
			this.data = data;
			this.leftNode = null;
			this.rigthNode = null;
		}

	}

	public static Node insert(Node rootNode, int values) {

		if (rootNode == null) {

			rootNode = new Node(values);

			return rootNode;
		}

		if (rootNode.data > values) {
			// leftSubTree

			rootNode.leftNode = insert(rootNode.leftNode, values);

		} else {
			rootNode.rigthNode = insert(rootNode.rigthNode, values);
		}

		return rootNode;

	}

	public static void inorder(Node rootNode) {

		if (rootNode == null) {
			return;
		}

		inorder(rootNode.leftNode);
		System.out.print(rootNode.data + " ");
		inorder(rootNode.rigthNode);

	}

	public static boolean Search(Node rootNode, int key) {

		if (rootNode == null) {

			return false;

		}

		if (rootNode.data > key) {

			return Search(rootNode.leftNode, key);

		} 
		else if (rootNode.data == key) {
			return true;
		} else {

			return Search(rootNode.rigthNode, key);

		}

	}
	
	
	public static Node deleteNode(Node rootNode, int val) {
		
		
		if(rootNode.data>val) {
			
			rootNode.leftNode=deleteNode(rootNode.leftNode, val);
			
		}else if(rootNode.data<val) {
			
			
			rootNode.rigthNode=deleteNode(rootNode.rigthNode, val);
			
		}else {
			
			//case 1
			if(rootNode.leftNode==null && rootNode.rigthNode==null) {
				
				return null;
				
				
			}
			
			//case2
			if(rootNode.leftNode==null) {
				
				
				return rootNode.rigthNode;
			}else if(rootNode.rigthNode==null){
				
				return rootNode.leftNode;
			}
			
			
			//case3
			
			Node IS =inorderSucessor(rootNode.rigthNode);
			rootNode.data=IS.data;
			 rootNode.rigthNode= deleteNode(rootNode.rigthNode, IS.data);
			
			
		}
		
		return rootNode;
		
		
		
		
		
	}
	
	
	
	
	public static Node inorderSucessor(Node rootNode) {
		
		while(rootNode.leftNode!=null) {
			
			rootNode=rootNode.leftNode;
			
		}
		
		
		return rootNode;
		
	}
	

	public static void main(String[] args) {

		int[] values = { 5, 1, 3, 4, 2, 7 };
		Node rootNode = null;

		for (int i = 0; i < values.length; i++) {

			rootNode = insert(rootNode, values[i]);

		}

		inorder(rootNode);
		System.out.println();

		if (Search(rootNode, 7)) {

			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
		
		
		
		deleteNode(rootNode, 4);
		inorder(rootNode);

	}

}
