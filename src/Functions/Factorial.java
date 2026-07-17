package Functions;

import java.util.Scanner;

public class Factorial {

    // This method calculates and prints the factorial of a number
    public static void printFact(int n) {

        // Step 1: Validate input
        // Factorial is defined only for positive integers (1,2,3,...)
        // If user enters 0 or negative number, we stop the function
        if (n < 1) {
            System.out.println("Invalid number");
            return; // exit the function early
        }

        // Step 2: Initialize result variable
        // Factorial multiplication always starts from 1
        int res = 1;

        // Step 3: Loop from n down to 1
        // Example: if n = 5 → 5 * 4 * 3 * 2 * 1
        for (int i = n; i >= 1; i--) {

            // Multiply current value of res with i
            // This builds the factorial step by step
            res = res * i;
        }

        // Step 4: Print the final factorial result
        System.out.println(res);

        // Optional return (not necessary because method is void)
        return;
    }

    public static void main(String[] args) {

        // Step 5: Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter a number
        System.out.println("Enter a number");

        // Read integer input from user
        int n = sc.nextInt();

        // Step 6: Call the function to calculate factorial
        printFact(n);
    }
}