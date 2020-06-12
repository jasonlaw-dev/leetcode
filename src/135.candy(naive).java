import java.util.Arrays;

/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        Integer[] indices = new Integer[ratings.length];
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> ratings[a] - ratings[b]);

        int count = 0;
        for (int i : indices) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = 1 + candies[i - 1];
            } else {
                candies[i] = 1;
            }
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], 1 + candies[i + 1]);
            }
            count += candies[i];
        }
        return count;
    }
}
// @lc code=end

