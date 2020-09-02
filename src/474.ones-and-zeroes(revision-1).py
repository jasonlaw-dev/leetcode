#
# @lc app=leetcode id=474 lang=python3
#
# [474] Ones and Zeroes
#

# @lc code=start
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0] * (n + 1) for i in range(m + 1)]
        for str in strs:
            ones = sum(map(lambda x: int(x), str))
            # for c in str:
            #     ones += (1 if c == "1" else 0)
            zeros = len(str) - ones
            for i in range(m, zeros - 1, -1):
                for j in range(n, ones - 1, -1):
                    dp[i][j] = max(dp[i][j], 1 + dp[i - zeros][j - ones])

        return dp[m][n]
            
# @lc code=end

