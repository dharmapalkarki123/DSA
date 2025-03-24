package Functions;
public class GCD {
    // Method to find the GCD using Euclidean algorithm
    public static int findGCD(int a, int b) {
        // Continue until the second number becomes zero
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // When b is zero, a contains the GCD
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 98;
        
        // Find and print the GCD of num1 and num2
        int gcd = findGCD(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }
}
