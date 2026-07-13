import java.util.Scanner;

public class Conditional {

    public static void main(String[] args) {

        // ===== USER INPUT & IF-ELSE =====
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        if (a > b) {
            System.out.println(a + " is greater");
        } else {
            System.out.println(b + " is greater");
        }

        // ===== SWITCH CASE =====
        switch (b) {
            case 1:
                System.out.println("Dharmapal");
                break;
            case 2:
                System.out.println("Sujata");
                break;
            case 3:
                System.out.println("Nisha");
                break;
            default:
                System.out.println("Invalid");
        }

        // ===== PATTERN 1: SOLID SQUARE =====
        System.out.println("\nSolid Square:");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // ===== PATTERN 2: HOLLOW SQUARE =====
        System.out.println("\nHollow Square:");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i == 1 || j == 1 || i == 4 || j == 4) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // ===== PATTERN 3: INCREASING TRIANGLE =====
        System.out.println("\nIncreasing Triangle:");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // ===== PATTERN 4: DECREASING TRIANGLE =====
        System.out.println("\nDecreasing Triangle:");
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // ===== PATTERN 5: NUMBER DESCENDING =====
        System.out.println("\nNumber Pattern (Descending):");
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // ===== PATTERN 6: NUMBER ASCENDING =====
        System.out.println("\nNumber Pattern (Ascending):");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // ===== PATTERN 7: CONTINUOUS NUMBERS =====
        System.out.println("\nContinuous Numbers:");
        int num = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }

        // ===== PATTERN 8: 0-1 PATTERN =====
        System.out.println("\n0-1 Pattern:");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}