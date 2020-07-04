/*
 * @lc app=leetcode id=470 lang=java
 *
 * [470] Implement Rand10() Using Rand7()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int r;
        do {
            r = (rand7() - 1) * 7 + rand7() - 1;
        } while (r > 39);
        return r % 10 + 1;
    }
}
// @lc code=end

