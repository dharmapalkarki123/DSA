//package Functions;
//public class GCD {
//    // Method to find the GCD using Euclidean algorithm
//    public static int findGCD(int a, int b) {
//        // Continue until the second number becomes zero
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a; // When b is zero, a contains the GCD
//    }
//
//    public static void main(String[] args) {
//        int num1 = 24;
//        int num2 = 30;
//        
//        // Find and print the GCD of num1 and num2
//        int gcd = findGCD(num1, num2);
//        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
//    }
//}


package Functions;

import java.util.Scanner;

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
        Scanner  sc =new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 =sc.nextInt();        
        
        int gcd = findGCD(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }
}
