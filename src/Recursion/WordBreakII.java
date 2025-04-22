package Recursion;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, memo);
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int end = 1; end <= s.length(); end++) {
            String prefix = s.substring(0, end);
            if (wordSet.contains(prefix)) {
                List<String> suffixWays = backtrack(s.substring(end), wordSet, memo);
                for (String suffix : suffixWays) {
                    result.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII solver = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> results = solver.wordBreak(s, wordDict);
        for (String sentence : results) {
            System.out.println(sentence);
        }
    }
}
