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
    Queue<TrieNode> queue = new ArrayDeque<>();
    
    public StreamChecker(String[] words) {
        for (String word : words) {
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
    
    public boolean query(char letter) {
        queue.add(root);
        int size = queue.size();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            TrieNode curr = queue.poll();
            if (curr.next[letter - 'a'] != null) {
                found = found || curr.next[letter - 'a'].isWord;
                queue.add(curr.next[letter - 'a']);
            }
        }
        return found;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
// @lc code=end

