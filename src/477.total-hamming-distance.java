import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=477 lang=java
 *
 * [477] Total Hamming Distance
 */

// a - z
// count(a ^ b) + count(a ^ c) + count (b ^ c)

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++) 
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}
// @lc code=end

