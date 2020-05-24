/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

/*
Input: 
gas  = [2,3,4,5,1]
cost = [4,5,1,2,3]
*/

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cum = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            cum += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (cum < 0) {
            return -1;
        } else {
            return start;
        }
    }
}
// @lc code=end

