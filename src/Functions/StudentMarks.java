package Functions;

import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int total = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();

            // Optional: Validate marks (0–100)
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid mark! Please enter between 0 and 100.");
                i--; // ask again for the same subject
                continue;
            }

            total += marks[i];
        }

        double average = (double) total / numSubjects;
        double percentage = ((double) total / (numSubjects * 100)) * 100;

        // Output
        System.out.println("\nTotal Marks = " + total);
        System.out.printf("Average Marks = %.2f%n", average);
        System.out.printf("Percentage = %.2f%%\n", percentage);

        scanner.close();
    }
}
