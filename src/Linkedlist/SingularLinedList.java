package Linkedlist;

public class SingularLinedList {

	Node head;
	private int size;

	public SingularLinedList() {
		this.size = 0;
	}

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}

	public void addFirst(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void addLast(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node currNode = head;
		while (currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = newNode;
	}

	public void printList() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + "->");
			currNode = currNode.next;
		}
		System.out.println("NULL");
	}

	public void deleteFirst() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		size--;
		head = head.next; // Assigning head to next, which will delete the previous head and assign the next node as the new head
	}

	public void deleteLast() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		size--;
		if (head.next == null) {
			head = null;
			return;
		}
		Node secondLastNode = head;
		Node lastNode = head.next;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
			secondLastNode = secondLastNode.next;
		}
		secondLastNode.next = null;
	}

	public int getSize() {
		return size;
	}

	public void reverseIterate() {
		if (head == null || head.next == null) {
			System.out.println("Linked List Is empty");
			return;
		}
		Node prevNode = head;
		Node currNode = head.next;
		while (currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head.next = null;
		head = prevNode;
	}

	public Node reverseRecursive(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node newHead = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	public Node removeNthNode(Node head, int n) {
		if (head.next == null) {
			return null;
		}
		int size = 0;
		Node currNode = head;
		while (currNode != null) {
			currNode = currNode.next;
			size++;
		}
		if (n == size) {
			return head.next;
		}
		int indexSearch = size - n;
		Node prevNode = head;
		int i = 1;
		while (i < indexSearch) {
			prevNode = prevNode.next;
			i++;
		}
		prevNode.next = prevNode.next.next;
		return head;
	}

	// Check if the Linked List is a Palindrome
	public boolean isPalindrome() {
		if (head == null || head.next == null) {
			return true; // Empty or single node is always palindrome
		}

		// Step 1: Find the middle
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse second half
		Node prev = null;
		Node curr = slow;

		while (curr != null) {
			Node nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}

		// Step 3: Compare both halves
		Node left = head;
		Node right = prev;

		while (right != null) {
			if (!left.data.equals(right.data)) {
				return false;
			}
			left = left.next;
			right = right.next;
		}

		return true;
	}

	//  Check if linked list has any loop (cycle)
	public boolean isCircular() {
		if (head == null) return false;

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true; // Loop detected
			}
		}

		return false;
	}

	//Check if last node points directly to head (perfect circular list)
	public boolean isPerfectCircular() {
		if (head == null) return false;

		Node temp = head;
		while (temp.next != null && temp.next != head) {
			temp = temp.next;
		}

		return temp.next == head;
	}

	public static void main(String[] args) {
		SingularLinedList list = new SingularLinedList();

		list.addFirst("a");
		list.addFirst("b");
		list.printList();

		list.addLast("c");
		list.addLast("e");
		list.addLast("f");
		list.printList();

		list.deleteFirst();
		list.printList();

		list.deleteLast();
		list.printList();

		list.head = list.reverseRecursive(list.head);
		list.printList();

		list.head = list.removeNthNode(list.head, 1);
		list.printList();

		System.out.println("Is Palindrome: " + list.isPalindrome());

		// Test circular check
		System.out.println("Is Circular (any loop): " + list.isCircular());
		System.out.println("Is Perfect Circular (last node → head): " + list.isPerfectCircular());

		//  Manually make circular
		// list.head.next.next.next = list.head;  // Uncomment to test loop
		// System.out.println("Is Circular after loop: " + list.isCircular());

		System.out.println("Size: " + list.getSize());
	}
}
