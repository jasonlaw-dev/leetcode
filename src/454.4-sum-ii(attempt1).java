import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

 //discuss tradeoff vs sorting

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                abMap.put(a+b, abMap.getOrDefault(a+b, 0) + 1);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                count += abMap.getOrDefault(-(c+d), 0);
            }
        }
        return count;
    }
}
// @lc code=end

