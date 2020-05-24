import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;

        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    dp[j] += val;
                } else if (j == i) {
                    dp[j] = dp[j - 1] + val;
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + val;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int sum : dp) {
            min = Math.min(min, sum);
        }
        return min;
    }
}
// @lc code=end

