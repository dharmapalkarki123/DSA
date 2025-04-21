package Recursion;

public class TowerOfHanoi {

    // Recursive function to solve Tower of Hanoi
    public static void solveHanoi(int n, String src, String helper, String des) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + des);
            return;
        }

        // Move top n-1 disks from source to helper
        solveHanoi(n - 1, src, des, helper);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + src + " to " + des);

        // Move the n-1 disks from helper to destination
        solveHanoi(n - 1, helper, src, des);
    }

    public static void main(String[] args) {
        int numberOfDisks = 2; // You can change this to any number
        solveHanoi(numberOfDisks, "A", "B", "C"); // A = source, B = helper, C = destination
    }
}
