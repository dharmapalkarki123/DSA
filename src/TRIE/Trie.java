package TRIE;

// Trie (Prefix Tree) Implementation in Java
// This code supports:
// 1. Insert word
// 2. Search word
// 3. Word Break problem
// 4. Prefix check
// 5. Count nodes
// 6. Find longest word where all prefixes exist

public class Trie {

    // Node class represents each character in Trie
    static class Node {

        Node[] children; // Array of size 26 for 'a' to 'z'
        boolean endOfWord; // True if this node marks end of a word

        public Node() {
            children = new Node[26];

            // Initialize all children as null
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

            endOfWord = false; // Initially not end of any word
        }
    }

    // Root node of Trie (empty node)
    static Node rootNode = new Node();

    // ================= INSERT FUNCTION =================
    // Inserts a word into Trie
    public static void insert(String word) {

        Node curr = rootNode; // Start from root

        for (int i = 0; i < word.length(); i++) {

            // Get index for character (0-25)
            int idx = word.charAt(i) - 'a';

            // If node doesn't exist, create new node
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // If last character, mark end of word
            if (i == word.length() - 1) {
                curr.children[idx].endOfWord = true;
            }

            // Move to next node
            curr = curr.children[idx];
        }
    }

    // ================= SEARCH FUNCTION =================
    // Returns true if word exists in Trie
    public static boolean search(String key) {

        Node curr = rootNode;

        for (int i = 0; i < key.length(); i++) {

            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];

            // If character path not found
            if (node == null) {
                return false;
            }

            // If last character but not marked as endOfWord
            if (i == key.length() - 1 && node.endOfWord == false) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    // ================= WORD BREAK =================
    // Checks if string can be segmented into valid words from Trie
    public static boolean wordBreak(String key) {

        // Base case: empty string
        if (key.length() == 0) {
            return true;
        }

        // Try every possible split
        for (int i = 1; i <= key.length(); i++) {

            String firstPart = key.substring(0, i);   // prefix
            String secPart = key.substring(i);        // remaining string

            // If prefix is valid and remaining part also valid
            if (search(firstPart) && wordBreak(secPart)) {
                return true;
            }
        }

        return false;
    }

    // ================= START WITH PREFIX =================
    // Returns true if any word starts with given prefix
    public static boolean startWith(String prefix) {

        Node curr = rootNode;

        for (int i = 0; i < prefix.length(); i++) {

            int idx = prefix.charAt(i) - 'a';

            // If path doesn't exist
            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    // ================= COUNT NODES =================
    // Counts total nodes in Trie (useful for substring problems)
    public static int countNode(Node rootNode) {

        if (rootNode == null) {
            return 0;
        }

        int count = 0;

        // Recursively count children
        for (int i = 0; i < 26; i++) {
            if (rootNode.children[i] != null) {
                count += countNode(rootNode.children[i]);
            }
        }

        // +1 for current node
        return count + 1;
    }

    // ================= LONGEST WORD =================
    // Stores final answer globally
    public static String ans = "";

    // Finds longest word such that all prefixes exist
    public static void longestWord(Node rootNode, StringBuilder temp) {

        if (rootNode == null) {
            return;
        }

        // Traverse all possible characters
        for (int i = 0; i < 26; i++) {

            // Only go if child exists AND it is end of a valid word
            if (rootNode.children[i] != null && rootNode.children[i].endOfWord == true) {

                // Add character to current string
                temp.append((char) (i + 'a'));

                // Update answer if longer string found
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                // Recursive call
                longestWord(rootNode.children[i], temp);

                // Backtrack (remove last character)
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        // Example words
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        // Insert words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Find longest word with all prefixes present
        longestWord(rootNode, new StringBuilder(""));

        // Output result
        System.out.println("Longest word with all prefixes: " + ans);

        // ================= TEST CASES =================

        // Search example
        // System.out.println(search("apple"));

        // Word Break example
        // System.out.println(wordBreak("appleapp"));

        // Prefix check example
        // System.out.println(startWith("app"));

        // Count nodes example
        // System.out.println(countNode(rootNode));
    }
}
