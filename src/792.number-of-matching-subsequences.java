import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

// @lc code=start

class Node {
    String word;
    int charIdx = 0;

    Node(String word) {
        this.word = word;
    }
}

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        List<List<Node>> buckets = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < 26; i++) {
            buckets.add(new ArrayList<>());
        }
        for (String word : words) {
            buckets.get(word.charAt(0) - 'a').add(new Node(word));
        }
        for (char c : S.toCharArray()) {
            List<Node> bucket = buckets.get(c - 'a');
            buckets.set(c - 'a', new ArrayList<>());
            for (Node node : bucket) {
                node.charIdx++;
                if (node.charIdx != node.word.length()) {
                    buckets.get(node.word.charAt(node.charIdx) - 'a').add(node);
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

