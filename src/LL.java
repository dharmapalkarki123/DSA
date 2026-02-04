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
			return;
		}

		size--;
		head = head.next;
	}

	// delete last
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

		Node secondLast = head;
		Node lastNode = head.next;

		while (lastNode.next != null) {
			lastNode = lastNode.next;
			secondLast = secondLast.next;
		}

		secondLast.next = null;
	}

	// print list
	public void printList() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}

		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " -> ");
			currNode = currNode.next;
		}
		System.out.println("NULL");
	}

	public int getSize() {
		return size;
	}

	// iterative reverse
	public void iterativeReverse() {
		if (head == null || head.next == null) return;

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

	// recursive reverse
	public Node recursiveReverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node newHead = recursiveReverse(head.next);
		head.next.next = head;
		head.next = null;

		return newHead;
	}

	// remove Nth node from end
	public Node removeNthNode(Node head, int n) {
		if (head == null) return null;

		int size = 0;
		Node curr = head;
		while (curr != null) {
			curr = curr.next;
			size++;
		}

		if (n > size) return head;

		if (n == size) {
			return head.next; // remove first node
		}

		int indexToSearch = size - n;
		Node prev = head;

		for (int i = 1; i < indexToSearch; i++) {
			prev = prev.next;
		}

		prev.next = prev.next.next;
		return head;
	}
	
	public Node findMiddle(Node head) {
		Node hareNode=head;
		Node turtleNode=head;
		
		while(hareNode.next!=null && hareNode.next.next!=null) {
			
			hareNode=hareNode.next.next;
			turtleNode=turtleNode.next;
			
			
		}
		
		return turtleNode;
		
		
	}
	
	
	public Node Reverse(Node head) {
		
		Node prevNode=null;
		Node currNode=head;
		while(currNode!=null) {
			
			Node nextNode =currNode.next;
			
			currNode.next=prevNode;
			prevNode=currNode;
			currNode=nextNode;
			
		}
		return prevNode;
		
	}
	
	public boolean isPallindrome(Node head) {
		
		if(head==null||head.next==null) {
			return true;
			
		}
		
		Node middleNode=findMiddle(head);
		Node secondHalfStartNode=Reverse(middleNode.next);
		
		Node firstHalfNode=head;
		while(secondHalfStartNode!=null) {
			
			if(firstHalfNode.data!=secondHalfStartNode.data) {
				
				return false;
				
				
			}
			firstHalfNode=firstHalfNode.next;
			secondHalfStartNode=secondHalfStartNode.next;
			
			
		
			
			
			
		}
		
		return true;
		
		
		
		
	}
	

	public static void main(String[] args) {
		LL list = new LL();

		list.addFirst("A");
		list.addFirst("M");
		list.addLast("D");
		list.addLast("M");

		list.printList();
		System.out.println("Size: " + list.getSize());

		list.head = list.recursiveReverse(list.head);
//		list.head = list.removeNthNode(list.head, 2);

		list.printList();
		System.out.print(list.isPallindrome(list.head));
	}
}
