import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=805 lang=java
 *
 * [805] Split Array With Same Average
 * 
 * we try to solve this equation
 * xsum / xcount == (sum - xsum) / (count - xcount)
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        int n = A.length;
        List<Set<Integer>> dp = new ArrayList<>();
        boolean isPossible = false;
        dp.add(new HashSet<>());
        dp.get(0).add(0);
        for (int i = 0; i <= n / 2; i++) {
            dp.add(new HashSet<>());
            isPossible = isPossible || (sum * i) % n == 0;
        }
        if (!isPossible) {
            return false;
        }
        for (int num : A) {
            for (int i = n / 2; i >= 1; i--) {
                Set<Integer> set = dp.get(i);
                for (int prev : dp.get(i - 1)) {
                    set.add(prev + num);
                }
            }
        }
        for (int i = 1; i <= n / 2; i++) {
            if ((sum * i) % n == 0 && dp.get(i).contains(sum * i / n)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

