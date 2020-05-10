import java.util.List;

/*
 * @lc app=leetcode id=648 lang=java
 *
 * [648] Replace Words
 */

// @lc code=start

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
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

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            TrieNode curr = root;
            int i = 0;
            for (; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                curr = curr.next[c];
                if (curr == null || curr.isWord) {
                    i++;
                    break;
                }
            }
            if (sb.length() > 0) {
                sb.append(' ');
            }
            if (curr == null || !curr.isWord) {   
                sb.append(word);
            } else {
                sb.append(word.substring(0, i));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

