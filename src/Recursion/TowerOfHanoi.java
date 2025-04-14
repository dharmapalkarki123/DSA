package Recursion;

public class TowerOfHanoi {

    // Recursive function to solve Tower of Hanoi
    public static void solveHanoi(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move top n-1 disks from source to helper
        solveHanoi(n - 1, source, destination, helper);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move the n-1 disks from helper to destination
        solveHanoi(n - 1, helper, source, destination);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // You can change this to any number
        solveHanoi(numberOfDisks, 'A', 'B', 'C'); // A = source, B = helper, C = destination
    }
}
