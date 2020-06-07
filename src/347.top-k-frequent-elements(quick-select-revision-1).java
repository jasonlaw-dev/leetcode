import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        nums = new int[map.size()];
        int i = 0;
        for (int num : map.keySet()) {
            nums[i++] = num;
        }
        int left = 0;
        int right = nums.length - 1;
        i = left;
        while (left <= right) {
            i = left;
            swap(nums, right, (int)(left + (right - left + 1) * Math.random()));
            int pivotValue = map.get(nums[right]);
            for (int j = left; j < right; j++) {
                if (map.get(nums[j]) < pivotValue) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, right);
            int count = (right - i + 1);
            if (count == k) {
                break;
            }
            if (count < k) {
                right = i - 1;
                k -= count;
            } else {
                left = i + 1;
            }
        }
        return Arrays.copyOfRange(nums, i, nums.length);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

