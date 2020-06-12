import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);

        // dp[i][0] will be the previous node
        // dp[i][1] will be the length
        int[][] dp = new int[nums.length][2];
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = i;
            dp[i][1] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j][1] >= dp[i][1]) {
                    dp[i][0] = j;
                    dp[i][1] = dp[j][1] + 1;
                }
            }

            if (dp[maxIndex][1] < dp[i][1]) {
                maxIndex = i;
            }
        }
        while (dp[maxIndex][0] != maxIndex) {
            res.add(nums[maxIndex]);
            maxIndex = dp[maxIndex][0];
        }
        res.add(nums[maxIndex]);
        return res;
    }
}
// @lc code=end

