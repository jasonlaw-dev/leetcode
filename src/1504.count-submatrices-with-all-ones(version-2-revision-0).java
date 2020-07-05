import java.util.Stack;

/*
 * @lc app=leetcode id=1504 lang=java
 *
 * [1504] Count Submatrices With All Ones
 */

// @lc code=start
class Solution {
    int[] fact;
    public int numSubmat(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];
        
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                heights[j] = mat[i][j] == 1 ? heights[j] + 1 : 0;
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sum[j] = heights[j] * (j + 1);
                } else {
                    int prev = stack.peek();
                    sum[j] = heights[j] * (j - prev) + sum[prev];
                }
                res += sum[j];
                stack.add(j);
            }
        }
        return res;
    }
}
// @lc code=end

