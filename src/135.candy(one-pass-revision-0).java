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
case 3: ratings[i] < ratings[i - 1]: count += ??

*/
// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;
        int count = 1;
        int prev = 1;
        int decreaseCount = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (decreaseCount > 0) {
                    count += (decreaseCount + 1) * decreaseCount / 2;
                    if (decreaseCount >= prev) {
                        count += decreaseCount - prev + 1;
                    }
                    decreaseCount = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : 1 + prev;
                count += prev;
            } else {
                decreaseCount++;
            }
        }
        if (decreaseCount > 0) {
            count += (decreaseCount + 1) * decreaseCount / 2;
            if (decreaseCount >= prev) {
                count += decreaseCount - prev + 1;
            }
        }
        return count;
    }
}
// @lc code=end

