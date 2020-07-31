import java.util.Arrays;

/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

/* 
start index
case 1: ratings[i] == ratings[i - 1]: count += 1; start = i;
case 2: ratings[i] > ratings[i - 1]: count += 1 + prev; start = i;
case 3: ratings[i] < ratings[i - 1]: count += i - start + 1

5 3 3 4 4 
1
2 1
2 1 1
2 1 1 2
2 1 1 2 1

1 2 3 1 0
1 2 3 1
*/
// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(1 + candies[i + 1], candies[i]);
            }
        }
        int res = 0;
        for (int candy : candies) res += candy;
        return res;
    }
}
// @lc code=end

