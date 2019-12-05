import java.util.Stack;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int lastHigh = 0;
        int prevMaxHeightCleared = 0;
        int sum = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int heightToClear = 0;
            if (i > 0) {
                if (height[i] >= lastHigh || height[i] > height[i - 1]) {
                    heightToClear = height[i];
                }
            }

            if (heightToClear > 0) {
                int prevStackTop = 0;
                while (!stack.isEmpty()) {
                    int[] stackTop = stack.peek();
                    if (heightToClear >= stackTop[0]) {
                        stack.pop();
                    }
                    int offset = heightToClear > prevMaxHeightCleared ? prevMaxHeightCleared : 0;
                    int toAdd = (Math.min(heightToClear, stackTop[0]) - height[i - 1] - offset) * (i - stackTop[1] - 1);
                    System.out.println(i + " " + toAdd);
                    if (toAdd > 0) {
                        sum += toAdd;
                    }
                    if (heightToClear <= stackTop[0]) {
                        break;
                    }
                }
            }

            if (heightToClear > prevMaxHeightCleared) {
                prevMaxHeightCleared = heightToClear;
            }

            if (height[i] >= lastHigh) {
                stack = new Stack<>();
                lastHigh = height[i];
            }
            if (i < height.length - 1 && height[i] > height[i + 1]) {
                stack.add(new int[]{height[i], i});
            }
        }
        return sum;
        // [0,1,0,2,1,0,1,3]
    }
}
// @lc code=end

