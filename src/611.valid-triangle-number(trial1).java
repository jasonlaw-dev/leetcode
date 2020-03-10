import java.util.Arrays;

/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int k = 2; k < nums.length; k++) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    res += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

