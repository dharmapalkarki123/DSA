package Recursion;

public class fibonacciseries {

    /**
     * This method prints Fibonacci numbers using recursion.
     * 
     * @param a → first previous number
     * @param b → second previous number
     * @param n → how many numbers left to print
     */
    public static void printFib(int a, int b, int n) {

        // Base Condition (Stopping condition)
        // If n becomes 0, stop recursion
        if (n == 0) {
            return;
        }

        // Calculate next Fibonacci number
        int c = a + b;

        // Print the next number
        System.out.println(c);

        // Recursive call:
        // Move forward in the series
        // b becomes new 'a'
        // c becomes new 'b'
        // decrease count (n-1)
        printFib(b, c, n - 1);
    }

    public static void main(String[] args) {

        // First two Fibonacci numbers
        int a = 0;
        int b = 1;

        // Total numbers you want in series
        int n = 5;

        // Print first number
        System.out.println(a);

        // Print second number
        System.out.println(b);

        // Call recursive function for remaining numbers
        // We already printed 2 numbers, so pass (n-2)
        printFib(a, b, n - 2);
    }
}