import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 * 
 *  Time: O(n log(n))
 *  Space: O(1)
 *  NOTE: no need to use HashMap as traversing once will be even slower and has more space complexity
 *  Always check i, j, k!!!
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // O(n log(n))
        if (nums.length < 3) {
            return results;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums [j-1]) {
                    j++;
                } else if (k < nums.length - 1 && nums[k] == nums[k+1]) {
                    k--;
                } else {
                    if (nums[j] + nums[k] == -nums[i]) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] > -nums[i]) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return results;
    }
}
// @lc code=end

