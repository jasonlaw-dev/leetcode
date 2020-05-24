import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    int sum = 0;
    int d = (int)Math.pow(10, 9) + 7;
    public int sumSubarrayMins(int[] A) {
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < A.length; i++) sorted.add(i);
        Collections.sort(sorted, (a, b) -> A[a] == A[b] ? a - b : A[a] - A[b]);
        for (int idx : sorted) {
            Integer left = set.lower(idx);
            Integer right = set.higher(idx);
            if (left == null) {
                left = -1;
            }
            if (right == null) {
                right = A.length;
            }
            int width = right - left - 1;
            int count = 1;
            for (int i = 1; i < width; i++) {
                int upper = Math.min(right - 1, idx + i);
                int lower = Math.max(left + 1, idx - i);
                count += upper - lower - 1;
                System.out.println("Adding " + (upper - lower + 1) + " width: " + i);
            }
            set.add(idx);
            add(A[idx] * count);
        }
        return sum;
    }

    public void add(int n) {
        sum = (sum + n) % d;
    } 
}
// @lc code=end

