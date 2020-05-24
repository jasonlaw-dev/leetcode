import java.util.TreeSet;

/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// 10 (rows) x 5 matrix
// cols: [0,0][0,1] to [0,4], [1,1]...[1,4]
// sum of each row i in sums[m]

/*
if we are looking at row 4,
we want to find a upper rectangle such that for area (i, 4) = area(0, 4) - area(0, i - 1) is the largest sum no larger than K

finding the minimum area(0, i - 1) >= area(0, 4) - k

if we have cumulative area, area(0,0), area(0, 1), area(0, 2)
if we use a treeset, then we can find the area in O(log(m))


O(n^2 * m * log(m))

*/

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;

        int m = matrix.length;
        int n = matrix[0].length;
        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cumSum = 0;
                for (int sum : sums) {
                    cumSum += sum;
                    Integer num = set.ceiling(cumSum - k);
                    if (num != null) {
                        res = Math.max(cumSum - num, res);
                    }
                    set.add(cumSum);
                }
            }
        }
        return res;
    }
}
// @lc code=end

