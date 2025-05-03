package Recursion;

public class Subset {
    public static void generateSubsets(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        generateSubsets(input.substring(1), output);                  // exclude
        generateSubsets(input.substring(1), output + input.charAt(0)); // include
    }

    public static void main(String[] args) {
        generateSubsets("abc", "");  // Output: "", "c", "b", "bc", "a", "ac", "ab", "abc"
    }
}
