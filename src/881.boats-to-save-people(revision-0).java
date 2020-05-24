import java.util.Arrays;

/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int i = 0;
        int j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] > limit) {
                res++;
                j--;
            } else {
                j--;
                i++;
                res++;
            }
        }
        if (i == j) {
            res++;
        }
        return res;
    }
}
// @lc code=end

