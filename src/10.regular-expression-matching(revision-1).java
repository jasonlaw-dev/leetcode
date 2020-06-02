import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Node {
    char c;
    boolean isStar = false;
    Node (char c) {
        this.c = c;
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            Node node = new Node(p.charAt(i));
            if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
                node.isStar = true;
                i++;
            }
            nodes.add(node);
        }
        boolean[][] dp = new boolean[s.length() + 1][nodes.size() + 1];
        dp[0][0] = true;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).isStar) {
                dp[0][i+1] = true;
            } else {
                break;
            }
        }
        /*
        T T T F
        ? T T F
        ? F T F

        */
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                Node node = nodes.get(j);
                // dp[i + 1][j + 1] = dp[i][j] && (node.isStar || node.c == '.' ||  node.c == s.charAt(i)) || dp[i][j+1] && (node.isStar && (node.c == '.' || node.c == s.charAt(i)));
                boolean isCurrMatch = node.c == '.' || node.c == s.charAt(i);
                // dp[i + 1][j + 1] = dp[i][j] && isCurrMatch || isCurrMatch && node.isStar && dp[i][j+1];
                if (node.isStar) {
                    dp[i + 1][j + 1] = dp[i+1][j] || // if this char was already matched some time before
                     dp[i][j+1] && isCurrMatch;  // why we check j+1? that's because the prev i could have been matched at j+1
                } else {
                    dp[i + 1][j + 1] = dp[i][j] && isCurrMatch;
                }
            }
        }
        return dp[s.length()][nodes.size()];
    }
}
// @lc code=end

