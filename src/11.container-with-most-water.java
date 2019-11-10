/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 * Time: O(n)
 * Space: O(1)
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        
        while (i < j) {
            int left = height[i];
            int right = height[j];
            area = Math.max(area, Math.min(left, right) * (j - i));
            if (left < right) {
                i++;
            } else if (right < left) {
                j--;
            } else {
                if (height[i + 1] >= height[j - 1]) { // NOTE: this is not necessary.
                    i++;
                } else {
                    j--;
                }
            }
        }

        return area;
    }
}
// @lc code=end

