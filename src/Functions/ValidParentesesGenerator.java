package Functions;

import java.util.*;

public class ValidParentesesGenerator {

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParentheses(n);
        System.out.println("Valid Parentheses Combinations:");
        for (String s : result) {
            System.out.println(s);
        }
    }

    // Main function to generate parentheses
    public static List<String> generateParentheses(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(combinations, "", 0, 0, n);
        return combinations;
    }

    // Recursive helper function
    private static void generateAll(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generateAll(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            generateAll(result, current + ")", open, close + 1, max);
        }
    }
}

