/*
 * @lc app=leetcode id=1000 lang=java
 *
 * [1000] Minimum Cost to Merge Stones
 */

// @lc code=start
class Solution {
    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        if (N == 1) return 0;
        if ((N - 1) % (K - 1) != 0) return -1;
        
        return helper(stones, K);
    }
    private int helper(int[] stones, int K) {
        if (stones.length == K) {
            int sum = 0;
            for (int num : stones) sum += num;
            return sum;
        }
        int[] next = new int[stones.length - (K - 1)];
        int minSum = 0;
        int minI = 0;
        int i = 0;
        int j = 0;
        for (; j < K; j++) {
            minSum += stones[j];
        }
        int currSum = minSum;
        for (; j < stones.length; i++, j++) {
            currSum += stones[j] - stones[i];
            if (currSum < minSum) {
                minSum = currSum;
                minI = i + 1;
            }
        }
        for (j = 0; j < minI; j++) {
            next[j] = stones[j];
        }
        next[minI] = minSum;
        for (j = minI + 1; j < next.length; j++) {
            next[j] = stones[j + K - 1];
        }
        return minSum + helper(next, K);
    }
}
// @lc code=end

