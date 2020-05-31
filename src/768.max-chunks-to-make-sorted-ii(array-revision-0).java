
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
 * [1,1,2,3,4]
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] rightMins = new int[arr.length];
        int temp = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            rightMins[i] = temp;
            if (arr[i] < temp) {
                temp = arr[i];
            }
        }
        int res = 0;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (rightMins[i] >= max) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

