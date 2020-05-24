import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=975 lang=java
 *
 * [975] Odd Even Jump
 * 
 * Use montonic queue 
 * for odd numbered jumps, use a decreasing monotonic queue
 * for even numbered jumps, use a incraseing monotonic queue
 * WRONG!!!
 * 
 * For odd jumps, how do I know that it is the smallest possible value
 * if we maintain increasing stack, then 
 */

// @lc code=start
class Solution {
    public int oddEvenJumps(int[] A) {

        if (A.length == 0) return 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        boolean[] oddToEnd = new boolean[A.length];
        boolean[] evenToEnd = new boolean[A.length];

        oddToEnd[A.length - 1] = true;
        evenToEnd[A.length - 1] = true;

        int count = 1;

        map.put(A[A.length - 1], A.length - 1);

        for (int i = A.length - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> higher = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lower = map.floorEntry(A[i]);
            if (higher != null) {
                oddToEnd[i] = evenToEnd[higher.getValue()];
                if (oddToEnd[i]) {
                    count++;
                }
                
            }
            if (lower != null) {
                evenToEnd[i] = oddToEnd[lower.getValue()];
            }
            map.put(A[i], i);
        }
        return count;
    }
}
// [1,2,3,2,1,4,4,5]

// @lc code=end

