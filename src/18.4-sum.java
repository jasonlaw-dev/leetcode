import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

//
/*
 1. sort nums

 for (i to nums.length - 4) {
    for (j to nums.length - 3) {
        
    }
 }

*/

// 1 1 1 1 2 5 7 9

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int k = j + 1;
                int m = nums.length - 1;
                while (k < m) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        k++;
                        m--;
                        while (k > j + 1 && k < m && nums[k - 1] == nums[k]) {
                            k++;
                        }
                        while (m < nums.length - 1 && k < m && nums[m + 1] == nums[m]) {
                            m--;
                        }
                    } else if (sum > target) {
                        m--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return results;
    }
}
// @lc code=end

