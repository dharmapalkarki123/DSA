package Array;

public class Subsets {

    /*
     * METHOD: generateSubsets
     *
     * PURPOSE:
     * Generate and print ALL possible subsets (power set)
     * of a given string using recursion.
     *
     * PARAMETERS:
     * input  = characters that are still left to process
     * output = characters already chosen for the current subset
     *
     * EXAMPLE:
     * generateSubsets("abc", "")
     *
     * Initially:
     * input  = "abc"
     * output = ""
     *
     * For every character we have TWO choices:
     *
     * 1. Exclude the character
     * 2. Include the character
     *
     * Because each character has 2 choices,
     * total subsets = 2^n
     *
     * For "abc":
     *
     * a -> include / exclude
     * b -> include / exclude
     * c -> include / exclude
     *
     * Total subsets = 2 × 2 × 2 = 8
     */

    public static void generateSubsets(String input, String output) {

        /*
         * BASE CASE
         *
         * When input becomes empty,
         * it means all characters have been processed.
         *
         * At this point output contains one complete subset.
         *
         * Example:
         * output = "ab"
         *
         * Print it and stop this recursive path.
         */
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        /*
         * RECURSIVE CHOICE 1: EXCLUDE CURRENT CHARACTER
         *
         * input.charAt(0) = current character
         *
         * Example:
         * input = "abc"
         * current character = 'a'
         *
         * Exclude 'a'
         *
         * Remaining input = "bc"
         * output remains same = ""
         *
         * Call:
         * generateSubsets("bc", "")
         *
         * Meaning:
         * "Pretend 'a' does not exist."
         */
        generateSubsets(input.substring(1), output);

        /*
         * RECURSIVE CHOICE 2: INCLUDE CURRENT CHARACTER
         *
         * Example:
         * input = "abc"
         * current character = 'a'
         *
         * Include 'a'
         *
         * Remaining input = "bc"
         * output becomes "a"
         *
         * Call:
         * generateSubsets("bc", "a")
         *
         * Meaning:
         * "Keep 'a' in the subset."
         */
        generateSubsets(
                input.substring(1),
                output + input.charAt(0)
        );
    }

    public static void main(String[] args) {

        /*
         * START RECURSION
         *
         * input  = "abc"
         * output = ""
         *
         * Initially no characters have been selected.
         */
        generateSubsets("abc", "");
    }
}