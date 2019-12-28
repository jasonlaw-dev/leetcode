import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            queue.add(nums[i]);
        }
        int[] results = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i - k >= 0) {
                map.put(nums[i-k], map.getOrDefault(nums[i-k], 0) + 1);
            }
            int max = queue.peek();
            while (map.getOrDefault(max, 0) > 0) {
                queue.poll();
                map.put(max, map.get(max) - 1);
                max = queue.peek();
            }
            results[i - k + 1] = max;
        }
        return results;
    }
}
// @lc code=end

