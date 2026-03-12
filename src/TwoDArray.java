import java.util.Scanner;

public class TwoDArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        // Create 2D array
        int[][] arrays = new int[rows][cols];

        // Input elements into the array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arrays[i][j] = sc.nextInt();
            }
        }

        // Print the 2D array
        System.out.println("Matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }

        // Input two numbers
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Add the numbers
        int c = a + b;

        // Print result
        System.out.println("Sum: " + c);

        // Close scanner
        sc.close();
    }
}