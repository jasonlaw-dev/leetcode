import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=668 lang=java
 *
 * [668] Kth Smallest Number in Multiplication Table
 * 
 * O(m * n)
 * O(mn log (n))
 * 
 * [1, 2, 3]
 * [2, 2, 3]
 * [3, 2, 3]
 * 
*/

// @lc code=start
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = count(m, n, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private int count(int m, int n, int target) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(target / i, n);
        }
        return count;
    }
}
// @lc code=end

