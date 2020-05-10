import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}

class Solution {

    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (!word.equals("") && dfs(word, 0)) {
                res.add(word);
            }
            add(word);
        }
        return res;
    }
    private boolean dfs(String word, int i) {
        if (i == word.length()) return true;
        TrieNode curr = root;
        for (; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.next[c] == null) {
                return false;
            }
            curr = curr.next[c];
            if (curr.isWord) {
                if (dfs(word, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    private void add(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.next[c] == null) {
                curr.next[c] = new TrieNode();
            }
            curr = curr.next[c];
        }
        curr.isWord = true;
    }
}
// @lc code=end

