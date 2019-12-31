import java.util.Arrays;

/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int[] tree = new int[nums.length + 1];
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int target = (int) Math.floor((nums[i] - 1) / 2.0);
            int targetIndex = findLastOccurence(sorted, target);
            if (targetIndex != -1) {
                count += prefixSum(tree, targetIndex);
            }
            update(tree, findLastOccurence(sorted, nums[i]), 1);
        }
        return count;
    }

    private int prefixSum(int[] tree, int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

    private void update(int[] tree, int index, int delta) {
        for (int i = index + 1; i < tree.length; i += i & (-i)) {
            tree[i] += delta;
        }
    }

    private int findLastOccurence(int[] sorted, int target) {
        int low = 0;
        int high = sorted.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (sorted[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return sorted[low] <= target ? low : -1;
    }
}
// @lc code=end

