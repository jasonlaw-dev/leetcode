import java.util.Stack;

/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 * 
 * if we do this manually, for every number, we need to check whether there is a smaller number on the right
 * If not, then this number can be splitted into one group
 * what if there is an range?
 * 7 5 6
 * 
 * brute force -> O(n^2)
 * a better way would be using a heap
 * 
 * can we do O(n)? 
 * scan from right to left
 * record decreasing number
 * why ? a larger number shouldn't matter
 * 
 * then what?
 * scan from left to right
 * for each index, we check whether front of the queue is valid
 * [1,3,4,4]
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[stack.peek()]) {
                stack.add(i);
            }
        }
        int res = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peek() <= i) {
                stack.pop();
            }
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                j = stack.pop();
            }
            if (i >= j) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

