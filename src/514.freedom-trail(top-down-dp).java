/*
 * @lc app=leetcode id=514 lang=java
 *
 * [514] Freedom Trail
 * 
 * dfs with memoization
 * memo[i][j] represents the steps it takes to match 
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        return dfs(ring.toCharArray(), key.toCharArray(), 0, 0, new int[ring.length()][key.length()]);
    }
    private int dfs(char[] ring, char[] key, int i, int j, int[][] memo) {
        if (j == key.length) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int right = 1;
        int left = 1;
        int k = i;
        while (ring[k] != key[j]) {
            k = (k + 1) % ring.length;
            right++;
        }
        right += dfs(ring, key, k, j + 1, memo);

        k = i;
        while (ring[k] != key[j]) {
            k = (k - 1 + ring.length) % ring.length;
            left++;
        }
        left += dfs(ring, key, k, j + 1, memo);
        
        memo[i][j] = Math.min(left, right);
        return memo[i][j];
    }
}
//"pqwcx"\n"cpqwx"
// @lc code=end

