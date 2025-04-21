package Recursion;

import java.util.HashMap;

public class FibonacciMemoization {

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        // Check if value is already calculated
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calculate Fibonacci and store in memo
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}
