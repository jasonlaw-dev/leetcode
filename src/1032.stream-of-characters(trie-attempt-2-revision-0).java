import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=1032 lang=java
 *
 * [1032] Stream of Characters
 */

// @lc code=start
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}

class StreamChecker {

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();
    
    public StreamChecker(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (curr.next[c] == null) {
                    curr.next[c] = new TrieNode();
                }
                curr = curr.next[c];
            }
            curr.isWord = true;
        }
    }
    
    public boolean query(char letter) {
        TrieNode curr = root;
        sb.append(letter);
        for (int i = sb.length() - 1; i >= 0 && curr != null; i--) {
            int c = sb.charAt(i) - 'a';
            curr = curr.next[c];
            if (curr != null && curr.isWord) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
// @lc code=end

