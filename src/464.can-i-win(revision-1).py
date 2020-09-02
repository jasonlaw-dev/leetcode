#
# @lc app=leetcode id=464 lang=python3
#
# [464] Can I Win
#

# @lc code=start
class Solution:
    def dfs(self, dp, comb: int, sum: int, max: int, total: int) -> bool:
        if comb in dp:
            return dp[comb]
        dp[comb] = False
        for i in range(max, 0, -1):
            mask = 1 << i
            if comb & mask == 0 and (sum + i >= total or not self.dfs(dp, comb | mask, sum + i, max, total)):
                dp[comb] = True
                break
        return dp[comb]

    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        if (1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal:
            return False
        return self.dfs({}, 0, 0, maxChoosableInteger, desiredTotal)
        
# @lc code=end

