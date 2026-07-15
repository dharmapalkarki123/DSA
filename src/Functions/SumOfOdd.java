package Functions;

import java.util.Scanner; // Import Scanner class to take input from the keyboard

public class SumOfOdd {

    /*
     * Method Name: AddOddNumber
     * Purpose:
     * Finds the sum of all odd numbers from 1 to n.
     *
     * Example:
     * n = 10
     * Odd numbers = 1, 3, 5, 7, 9
     * Sum = 25
     */
    public static int AddOddNumber(int n) {

        // Variable to store the final sum
        int sum = 0;

        // Start looping from 1 up to n
        for (int i = 1; i <= n; i++) {

            // Check whether the current number is odd
            // If remainder after dividing by 2 is not 0, it is odd
            if (i % 2 != 0) {

                // Add the odd number to the total sum
                sum = sum + i;
            }
        }

        // Return the calculated sum
        return sum;
    }

    public static void main(String[] args) {

        // Create Scanner object for taking input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a number: ");

        // Read the integer entered by the user
        int n = sc.nextInt();

        // Call the method and store the returned value
        int result = AddOddNumber(n);

        // Print the final answer
        System.out.println("Sum of odd numbers from 1 to " + n + " is: " + result);

        // Close Scanner to free resources
        sc.close();
    }
}