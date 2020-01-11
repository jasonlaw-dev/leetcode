import java.util.Stack;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int max = 0;
        
        // 1 2 0 2 1 1
        // 1 2 3 5 5 6

        // 2 1 0 0
        for (int i = 0; i < rows; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= cols; j++) {
                int height = 0;
                if (j < cols && matrix[i][j] == '1') {
                    height = heights[j] + 1;
                }
                if (j < cols) {
                    heights[j] = height;
                }
                while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                    int prevHeight = heights[stack.pop()];
                    int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                    max = Math.max(max, prevHeight * width);
                }
                stack.push(j);
            }
        }
        return max;
    }
}
// @lc code=end

