package Recursion;

public class Permutation {

    /**
     * This function prints all permutations of a given string.
     * 
     * @param str          → Remaining characters to process
     * @param permutation  → Current formed permutation
     */
    public static void printPermu(String str, String permutation) {

        // ================= BASE CASE =================
        // If the original string becomes empty,
        // it means we have used all characters
        // and formed one complete permutation
        if (str.length() == 0) {
            System.out.println(permutation);
            return; // stop recursion for this branch
        }

        // ================= RECURSIVE CASE =================
        // Loop through each character of the string
        for (int i = 0; i < str.length(); i++) {

            // Pick the current character
            char currChar = str.charAt(i);

            // Create a new string by removing the current character
            // substring(0, i) → from start to i-1
            // substring(i+1) → from i+1 to end
            String newStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call:
            // Add current character to permutation
            // and process remaining string
            printPermu(newStr, permutation + currChar);
        }
    }

    public static void main(String[] args) {

        // Input string
        String str = "abc";

        // Initial call:
        // permutation is empty at the beginning
        printPermu(str, "");
    }
}