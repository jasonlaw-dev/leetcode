import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 */

// @lc code=start


class TrieNode {
    int index = -1;
    List<Integer> list = new ArrayList<>();
    TrieNode[] next = new TrieNode[26];
}

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], i, root);
        }
        for (int i = 0; i < words.length; i++) {
            search(words[i], i, root, res);
        }
        return res;
    }

    public void addWord(String word, int wordIndex, TrieNode root) {
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalindrome(word, 0, i)) {
                root.list.add(wordIndex);
            }

            int c = word.charAt(i) - 'a';
            if (root.next[c] == null) {
                root.next[c] = new TrieNode();
            }
            root = root.next[c];
        }
        root.list.add(wordIndex);
        root.index = wordIndex;
    }

    public void search(String word, int wordIndex, TrieNode root, List<List<Integer>> res) {
        for (int i = 0; i < word.length(); i++) {
            if (root.index >= 0 && root.index != wordIndex && isPalindrome(word, i, word.length() - 1)) {
                res.add(Arrays.asList(wordIndex, root.index));
            }
            root = root.next[word.charAt(i) - 'a'];
            if (root == null) return;
        }
        for (int other : root.list) {
            if (wordIndex != other) {
                res.add(Arrays.asList(wordIndex, other));
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end

