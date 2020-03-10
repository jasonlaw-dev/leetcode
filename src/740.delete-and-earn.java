/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] counts = new int[10001];
    
        for (int num : nums) {
            counts[num]++;
        }

        int prevNum = Integer.MAX_VALUE;

        int score1 = 0;
        int score2 = 0;

        for (int i = 10000; i > 0; i--) {
            if (counts[i] > 0) {
                int score = 0;
                if (prevNum == i + 1) {
                    score = Math.max(score1, counts[i] * i + score2);
                } else {
                    score = counts[i] * i + Math.max(score1, score2);
                }
                prevNum = i;
                score2 = score1;
                score1 = score;
            }
        }
        return Math.max(score1, score2);
    }
}
// @lc code=end

