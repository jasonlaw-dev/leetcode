#
# @lc app=leetcode id=132 lang=python3
#
# [132] Palindrome Partitioning II
#

# @lc code=start
class Solution:
    def minCut(self, s: str) -> int:
        n = len(s)
        dp = [0] * n
        pal = [[False] * n for i in range(n)]
        for j in range(n):
            dp[j] = j
            for i in range(0, j+ 1):
                if s[i] == s[j] and ( j - i <= 1 or pal[i+1][j-1] ):
                    pal[i][j] = True
                    dp[j] = min(dp[j], (1 + dp[i-1]) if i > 0 else 0)

        return dp[n - 1]
                    

        
# @lc code=end

