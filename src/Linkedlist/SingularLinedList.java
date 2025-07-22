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

		head = head.next; // Assigning head to next, which will delete the previous head and assign the
							// next node as the new head

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

				// update

				prevNode = currNode;
				currNode = nextNode;

			}
			
			
			head.next=null;
			head =prevNode;
			
		

	}
	
	
	public Node reverseRecursive(Node head) {
		if(head==null||head.next==null) {
			return head;
		}
		
		
		
		Node newHead=reverseRecursive(head.next);
		head.next.next=head;
		head.next=null;
		
		return newHead;
		
		
		
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
		
//		list.reverseIterate();
//		list.printList();
		
		list.head=list.reverseRecursive(list.head);
		list.printList();

		System.out.println(list.getSize());

	}

}
