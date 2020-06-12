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
    long sum = 0;
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
            set.add(idx);
            add(A[idx] * (idx - left) * (right - idx));
        }
        return (int) (sum % d);
    }

    public void add(int n) {
        sum+=n;
    } 
}
// @lc code=end

