import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        for (int i = 0, j = 0; j <= nums.length; j++) {
            if (j == nums.length || j > i && nums[j] != nums[j - 1] + 1) {
                if (i == j - 1) {
                    res.add(nums[i] + "");
                } else {
                    res.add(nums[i] + "->" + nums[j - 1]);
                }
                i = j;
            }
        }
        return res;
    }
}
// @lc code=end

