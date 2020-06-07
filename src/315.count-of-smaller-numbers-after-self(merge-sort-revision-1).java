import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int[] indices = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        merge(nums, indices, res, 0, nums.length - 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(res[i]);
        }
        return list;
    }
    private void merge(int[] nums, int[] indices, int[] res, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        merge(nums, indices, res, start, mid);
        merge(nums, indices, res, mid + 1, end);
        int[] left = Arrays.copyOfRange(indices, start, mid + 1);
        int[] right = Arrays.copyOfRange(indices, mid + 1, end + 1);
        int i = 0;
        int j = 0;
        int k = start;
        while (k <= end) {
            if (j == right.length || i != left.length && nums[left[i]] <= nums[right[j]]) {
                indices[k] = left[i];
                res[left[i]] += j - 0;
                i++;
            } else {
                indices[k] = right[j];
                j++;
            }
            k++;
        }
    }
}
// @lc code=end

