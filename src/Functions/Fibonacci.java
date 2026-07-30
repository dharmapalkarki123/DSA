package Functions;

import java.util.Scanner;

/**

* This program prints Fibonacci series up to n terms.
*
* Fibonacci series:
* 0 1 1 2 3 5 8 13 ...
*
* Rule:
* next number = sum of previous two numbers
  */
  public class Fibonacci {

  /**

  * This method prints Fibonacci series up to n numbers
  * @param n → number of terms to print
    */
    public static void CalFibonacci(int n) {

    // First two numbers of Fibonacci series
    int a = 0;  // first number
    int b = 1;  // second number

    // Loop runs n times (to print n numbers)
    for (int i = 1; i <= n; i++) {

  
     // Print current number
     System.out.print(a + " ");
     
     // Calculate next number
     int c = a + b;
     
     // Shift values:
     // a becomes b
     // b becomes c (new number)
     a = b;
     b = c;


    }
    }

  public static void main(String[] args) {

 
   // Create Scanner object to take input from user
   Scanner scanner = new Scanner(System.in);
   
   System.out.println("Enter nubmer of term" );
   
   // Take input (how many Fibonacci numbers to print)
   int n = scanner.nextInt();
   
  
   // Call function to print Fibonacci series
   CalFibonacci(n);
  

  }
  }
