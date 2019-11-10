import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 * 
 * Guess Time: O(n^2)
 * 
 *  Space: O(s.length * p.length)
 *  Time: O(s.length * p.length)
 *  NOTE: always remember to consider DP, I tried using iterative solution but it was too hard as there are many cases to consider.
 */

// @lc code=start

class Solution {

    Boolean[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0,0,s,p);
    }

    public boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        Boolean ans = null;
        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean currentMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j+1) == '*') {
                ans = currentMatch && dp(i+1, j, s, p) || dp(i, j+2, s, p);
            } else {
                ans = currentMatch && dp(i+1, j+1, s, p);
            }
        }


        memo[i][j] = ans;
        return ans;
    }
}
// @lc code=end

