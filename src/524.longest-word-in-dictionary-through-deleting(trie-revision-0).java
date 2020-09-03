import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word = null;
    Set<Integer> visited = new HashSet<>();
}
class Solution {
    public String findLongestWord(String s, List<String> d) {
        TrieNode root = new TrieNode();
        for (String w : d) {
            TrieNode curr = root;
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new TrieNode();
                }
                curr = curr.next[idx];
            }
            curr.word = w;
        }
        return find(s, root, 0);
    }
    public String find(String s, TrieNode root, int i) {
        if (root == null) return "";
        if (i == s.length()) return root.word != null ? root.word : "";
        if (root.visited.contains(i)) return "";
        root.visited.add(i);
        int idx = s.charAt(i) - 'a';
        String cand1 = find(s, root.next[idx], i + 1);
        String cand2 = find(s, root, i + 1);
        if (cand1.length() != cand2.length()) return cand1.length() > cand2.length() ? cand1 : cand2;
        return cand1.compareTo(cand2) < 0 ? cand1 : cand2;
    }
}
// @lc code=end

