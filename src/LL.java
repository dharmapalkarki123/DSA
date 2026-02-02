
public class LL {

	Node head;
	int size;

	LL() {
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

	// add first
	public void addFirst(String data) {

		Node newNode = new Node(data);

		if (head == null) {

			head = newNode;
			return;

		}

		newNode.next = head;
		head = newNode;

	}

	// add last
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

	// delete first
	public void deleteFirst() {

		if (head == null) {
			System.out.println("List is empty");

		}

		size--;
		head = head.next;

	}

	// delete last
	public void deleteLast() {

		if (head == null) {

			System.out.println("List is empty");

		}
		size--;

		if (head.next == null) {
			head = null;
		}

		Node secondLastNode = head;
		Node lasNode = head.next;

		while (lasNode.next != null) {

			lasNode = lasNode.next;
			secondLastNode = secondLastNode.next;

		}

		secondLastNode.next = null;

	}

	public void printList() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}

		Node currNode = head;

		while (currNode.next != null) {

			System.out.print(currNode.data + "->");

			currNode = currNode.next;

		}

		System.out.print("Null");

	}

	public int getSize() {
		return size;
	}
	
	
	public void iterativeReverse() {
		
		if(head==null ||head.next==null) {
			return;
		}
		
		
		Node prevNode=head;
		Node currNode=head.next;
		while(currNode!=null) {
			
			Node nextNode=currNode.next;
			currNode.next=prevNode;
			
			//update
			prevNode=currNode;
			currNode=nextNode;
			
			
		}
		head.next=null;
		head=prevNode;
		
		
		
	}
	
	
	
	
	public Node recursiveReverse(Node head) {
		
		if(head==null||head.next==null) {
			
			return head;
			
		}
		
		Node newNode=recursiveReverse(head.next);
		
		head.next.next=head;
		head.next=null;
		
		return newNode;
		
		
		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {

		LL list = new LL();

		list.addFirst("is");
		list.addFirst("this");

		list.addLast("a");
		list.addLast("ball");
//		 list.deleteFirst();
//		 list.deleteLast();
		list.printList();
		
		System.out.println();

		System.out.println(list.getSize());
		
		//list.iterativeReverse();
		
		list.head= list.recursiveReverse(list.head);
		
		list.printList();
		

	}

}
