import java.util.Stack;

/*
 * @lc app=leetcode id=1504 lang=java
 *
 * [1504] Count Submatrices With All Ones
 */

// @lc code=start
class Solution {
    public int numSubmat(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            int[] heights = mat[i];
            for (int j = 0; j <= n; j++) {
                int currHeight = j < n ? heights[j] : 0;
                 while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {
                    int right = stack.pop();
                    int heightDiff = heights[right] - Math.max(currHeight, (stack.isEmpty() ? 0 : heights[stack.peek()]));
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int indexDiff = (j - left - 1);
                    int toAdd = heightDiff * (indexDiff * (indexDiff + 1) / 2);
                    res += toAdd;
                }
                stack.add(j);
            }
        }
        return res;
    }
}
// @lc code=end

