import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        if (board.length == 0 || words.length == 0) return results;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int j = word.charAt(i) - 'a';
                if (curr.children[j] == null) {
                    curr.children[j] = new TrieNode();
                }
                curr = curr.children[j];
            }
            curr.word = word;
        }

        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, results);
            }
        }
        return results;
    }
    void dfs(char[][] board, int i, int j, TrieNode root, List<String> results) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        int c = board[i][j];
        board[i][j] = '#';
        TrieNode child = root.children[c -  'a'];
        if (child != null) {
            if (child.word != null) {
                results.add(child.word);
                child.word = null;
            }
            dfs(board, i - 1, j, child, results);
            dfs(board, i + 1, j, child, results);
            dfs(board, i, j - 1, child, results);
            dfs(board, i, j + 1, child, results);
        }
        board[i][j] = (char) c;
    }
}
// @lc code=end

