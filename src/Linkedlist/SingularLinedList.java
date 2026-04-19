package Linkedlist;

public class SingularLinedList {

    Node head; // Head of linked list (starting node)
    private int size; // Tracks number of nodes

    public SingularLinedList() {
        this.size = 0; // Initially list is empty
    }

    // Node class represents each element of Linked List
    class Node {
        String data; // Data stored in node
        Node next;   // Reference to next node

        Node(String data) {
            this.data = data;
            this.next = null; // Initially points to nothing
            size++; // Increase size whenever new node is created
        }
    }

    // Add node at beginning
    public void addFirst(String data) {
        Node newNode = new Node(data);

        // If list is empty → new node becomes head
        if (head == null) {
            head = newNode;
            return;
        }

        // Point new node to current head
        newNode.next = head;

        // Update head to new node
        head = newNode;
    }

    // Add node at end
    public void addLast(String data) {
        Node newNode = new Node(data);

        // If list is empty → new node becomes head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to last node
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        // Attach new node at end
        currNode.next = newNode;
    }

    // Print entire linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node currNode = head;

        // Traverse and print each node
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }

        System.out.println("NULL"); // End of list
    }

    // Delete first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--; // Decrease size

        // Move head to next node (old head gets removed)
        head = head.next;
    }

    // Delete last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        size--;

        // If only one node → make list empty
        if (head.next == null) {
            head = null;
            return;
        }

        // Track second last and last node
        Node secondLastNode = head;
        Node lastNode = head.next;

        // Move until last node
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }

        // Remove last node
        secondLastNode.next = null;
    }

    // Return size of linked list
    public int getSize() {
        return size;
    }

    // Reverse list using iteration
    public void reverseIterate() {

        // If empty or only one node → nothing to reverse
        if (head == null || head.next == null) {
            System.out.println("Linked List Is empty");
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {

            // Save next node
            Node nextNode = currNode.next;

            // Reverse link
            currNode.next = prevNode;

            // Move pointers forward
            prevNode = currNode;
            currNode = nextNode;
        }

        // Fix last node
        head.next = null;

        // Update head
        head = prevNode;
    }

    // Reverse list using recursion
    public Node reverseRecursive(Node head) {

        // Base case: if list empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse remaining list
        Node newHead = reverseRecursive(head.next);

        // Fix current node
        head.next.next = head; // reverse link
        head.next = null;      // break old link

        return newHead; // return new head
    }

    // Remove Nth node from end
    public Node removeNthNode(Node head, int n) {

        // If only one node
        if (head.next == null) {
            return null;
        }

        // Step 1: Find size
        int size = 0;
        Node currNode = head;

        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }

        // If removing first node
        if (n == size) {
            return head.next;
        }

        // Find node before target
        int indexSearch = size - n;
        Node prevNode = head;
        int i = 1;

        while (i < indexSearch) {
            prevNode = prevNode.next;
            i++;
        }

        // Remove node
        prevNode.next = prevNode.next.next;

        return head;
    }

    // Check if Linked List is Palindrome
    public boolean isPalindrome() {

        // Empty or single node → always palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle using slow & fast pointer
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

            // If mismatch → not palindrome
            if (!left.data.equals(right.data)) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    // Check if linked list has any loop (cycle)
    public boolean isCircular() {

        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        // Floyd's Cycle Detection (Tortoise & Hare)
        while (fast != null && fast.next != null) {

            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            // If both meet → loop exists
            if (slow == fast) {
                return true;
            }
        }

        return false; // No loop
    }

    // Check if last node directly points to head
    public boolean isPerfectCircular() {

        if (head == null) return false;

        Node temp = head;

        // Traverse till last node or loop back to head
        while (temp.next != null && temp.next != head) {
            temp = temp.next;
        }

        // If last node points to head → perfect circular
        return temp.next == head;
    }

    public static void main(String[] args) {

        SingularLinedList list = new SingularLinedList();

        // Add elements at beginning
        list.addFirst("a");
        list.addFirst("b");
        list.printList();

        // Add elements at end
        list.addLast("c");
        list.addLast("e");
        list.addLast("f");
        list.printList();

        // Delete first node
        list.deleteFirst();
        list.printList();

        // Delete last node
        list.deleteLast();
        list.printList();

        // Reverse using recursion
        list.head = list.reverseRecursive(list.head);
        list.printList();

        // Remove last node (n=1)
        list.head = list.removeNthNode(list.head, 1);
        list.printList();

        // Check palindrome
        System.out.println("Is Palindrome: " + list.isPalindrome());

        // Check cycle
        System.out.println("Is Circular (any loop): " + list.isCircular());

        // Check perfect circular
        System.out.println("Is Perfect Circular (last node → head): " + list.isPerfectCircular());

        // Manually create loop (for testing)
        // list.head.next.next.next = list.head;

        // Size of list
        System.out.println("Size: " + list.getSize());
    }
}