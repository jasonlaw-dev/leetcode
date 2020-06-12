import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                int idx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
// @lc code=end

