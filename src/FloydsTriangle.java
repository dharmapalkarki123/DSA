// Program to print Floyd's Triangle
// Floyd's Triangle is a pattern of numbers arranged in rows,
// where numbers increase sequentially starting from 1

public class FloydsTriangle {

    public static void main(String[] args) {

        // This variable will hold the current number to print
        // It starts from 1 and increases after every print
        int number = 1;

        // Outer loop controls the number of rows
        // Here, i represents the current row number
        // It runs from 1 to 5 (so total 5 rows will be printed)
        for (int i = 1; i <= 5; i++) {

            // Inner loop controls how many numbers to print in each row
            // For row 1 → print 1 number
            // For row 2 → print 2 numbers
            // For row 3 → print 3 numbers
            // and so on...
            for (int j = 1; j <= i; j++) {

                // Print the current number followed by a space
                System.out.print(number + " ");

                // Increase the number so next time it prints the next value
                number++;
            }

            // After finishing one row, move to the next line
            System.out.println();
        }
    }
}