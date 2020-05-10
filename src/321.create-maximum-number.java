/*
 * @lc app=leetcode id=321 lang=java
 *
 * [321] Create Maximum Number
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int size1 = Math.max(0, k - nums2.length); size1 <= nums1.length && size1 <= k; size1++) {
            int size2 = k - size1;
            int[] cand = merge(maxArray(nums1, size1), maxArray(nums2, size2), k);
            for (int i = 0; i < k; i++) {
                if (cand[i] > res[i]) {
                    res = cand;
                    break;
                } else if (cand[i] < res[i]) {
                    break;
                }
            }
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int x = 0;
        int y = 0;
        for (int i = 0; i < k; i++) {
            if (greater(nums1, x, nums2, y)) {
                res[i] = nums1[x++];
            } else {
                res[i] = nums2[y++];
            }
        }
        return res;
    }

    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j > 0 && nums.length - i + j > k && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}
// @lc code=end

