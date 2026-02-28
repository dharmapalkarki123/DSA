package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
	
	
	
	public static int countOfNode(Node rootNode) {
		
		if(rootNode==null) {
			return 0;
		}
		
		int leftCount=countOfNode(rootNode.leftNode);
		int rightCount=countOfNode(rootNode.rightNode);
		return leftCount+rightCount+1;
		
		
		
	}
	
public static int SumOfNode(Node rootNode) {
		
		if(rootNode==null) {
			return 0;
		}
		
		int leftCount=SumOfNode(rootNode.leftNode);
		int rightCount=SumOfNode(rootNode.rightNode);
		return leftCount+rightCount+rootNode.data;
		
		
		
	}
	

public static int heightOfTree(Node rootNode) {
	
	if(rootNode==null) {
		return 0;
	}
	
	int leftheight=heightOfTree(rootNode.leftNode);
	int rightheight=heightOfTree(rootNode.rightNode);
	
	if(leftheight>rightheight) {
		
		return leftheight+1;
		
	}else {
		
		return rightheight+1;
		
	}
	
	
	
	
	
}
	
public static int diameterOfTree(Node rootNode) {
	
	if(rootNode==null) {
		return 0;
	}
	
	int diam1=diameterOfTree(rootNode.leftNode);
	int diam2=diameterOfTree(rootNode.rightNode);
	
	int diam3=heightOfTree(rootNode.leftNode)+heightOfTree(rootNode.rightNode)+1;
	

		
		return Math.max(diam3, Math.max(diam1, diam2));
		
	}
	
	
	
	
static class TreeInfo {
    int height;
    int diameter;

    TreeInfo(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

public static TreeInfo diameter(Node rootNode) {

    if (rootNode == null) {
        return new TreeInfo(0, 0);
    }

    TreeInfo left = diameter(rootNode.leftNode);
    TreeInfo right = diameter(rootNode.rightNode);

    int myHeight = Math.max(left.height, right.height) + 1;

    int diam1 = left.diameter;
    int diam2 = right.diameter;
    int diam3 = left.height + right.height + 1;

    int myDiameter = Math.max(diam3, Math.max(diam1, diam2));

    return new TreeInfo(myHeight, myDiameter);
}
	

public static boolean isIdentical(Node root, Node subRoot) {

    if (root == null && subRoot == null) {
        return true;
    }

    if (root == null || subRoot == null) {
        return false;
    }

    if (root.data == subRoot.data) {
        return isIdentical(root.leftNode, subRoot.leftNode)
                && isIdentical(root.rightNode, subRoot.rightNode);
    }

    return false;
}

public static boolean isSubtree(Node root, Node subRoot) {

    if (subRoot == null) {
        return true;
    }

    if (root == null) {
        return false;
    }

    if (isIdentical(root, subRoot)) {
        return true;
    }

    return isSubtree(root.leftNode, subRoot)
            || isSubtree(root.rightNode, subRoot);
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
		//System.out.println(diameterOfTree(rootNode));
		
//		TreeInfo result = diameter(rootNode);
//		System.out.println(result.diameter);
		
		// Create subtree
        Node subRoot = new Node(2);
        subRoot.leftNode = new Node(4);
        subRoot.rightNode = new Node(5);

        System.out.println("Diameter: " + diameter(rootNode).diameter);
        System.out.println("Is Subtree: " + isSubtree(rootNode, subRoot));
		
		
	}
}