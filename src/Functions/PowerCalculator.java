
package Functions;
import java.util.Scanner;

public class PowerCalculator {
    public static double powerIterative(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result*x; // Multiply x, n times
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();
        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();
        System.out.println("Result: " + powerIterative(x, n));
        sc.close();
    }
}
