import java.util.Arrays;

/*
 * @lc app=leetcode id=826 lang=java
 *
 * [826] Most Profit Assigning Work
 * 
 * Sort profit -> O(n log n)
 * for each worker, scan thru soorted profit, O(n)
 * O(n^2)
 * O(n)
 * O(n log n)
 * 
 * Sort(worker's ability desc)
 * Sort(profit descending)
 * 
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = difficulty[i];
            tasks[i][1] = profit[i];
        }
        Arrays.sort(tasks, (a,b) -> b[1] - a[1]);
        Arrays.sort(worker);
        int res = 0;
        for (int i = worker.length - 1, j = 0; i >= 0; i--) {
            while (j < n && tasks[j][0] > worker[i]) {
                j++;
            }
            if (j < n) {
                res += tasks[j][1];
            } else {
                break;
            }
        }
        return res;
    }
}
// @lc code=end

