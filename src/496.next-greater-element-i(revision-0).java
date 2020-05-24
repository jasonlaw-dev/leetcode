import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums1.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < nums2.length && count != nums1.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int j = stack.pop();
                if (map.containsKey(nums2[j])) {
                    res[map.get(nums2[j])] = nums2[i];
                    count++;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

