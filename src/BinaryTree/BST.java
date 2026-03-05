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

	}

}
