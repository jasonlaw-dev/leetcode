import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0) {
                max = Math.max(max, iterateStackAndReturnMax(heights, stack));
                stack = new Stack<>();
            } else {
                int start = i;
                int end = i;
                while (stack.size() > 0 && heights[stack.peek()[1]] >= heights[end]) {
                    start = stack.pop()[0];
                    max = Math.max(max, (end - start + 1) * heights[end]);
                }
                stack.push(new int[]{ start, end });
            }
        }
        max = Math.max(max, iterateStackAndReturnMax(heights, stack));

        stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] == 0) {
                max = Math.max(max, iterateStackAndReturnMax2(heights, stack));
                stack = new Stack<>();
            } else {
                int start = i;
                int end = i;
                while (stack.size() > 0 && heights[stack.peek()[0]] >= heights[start]) {
                    end = stack.pop()[1];
                    max = Math.max(max, (end - start + 1) * heights[start]);
                }
                stack.push(new int[]{ start, end });
            }
        }
        max = Math.max(max, iterateStackAndReturnMax2(heights, stack));

        return max;
    }

    public int iterateStackAndReturnMax(int[] heights, Stack<int[]> stack) {
        int max = 0;

        if (stack.size() > 0) {
            int end = stack.peek()[1];
            while (stack.size() > 0) {
                int[] pair = stack.pop();
                max = Math.max(max,  (end - pair[0] + 1) * heights[pair[1]]);
            }
        }
        return max;
    } 

    public int iterateStackAndReturnMax2(int[] heights, Stack<int[]> stack) {
        int max = 0;

        if (stack.size() > 0) {
            int start = stack.peek()[0];
            while (stack.size() > 0) {
                int[] pair = stack.pop();
                max = Math.max(max,  (pair[1] - start + 1) * heights[pair[0]]);
            }
        }
        return max;
    } 
}
// @lc code=end

