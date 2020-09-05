#
# @lc app=leetcode id=28 lang=python3
#
# [28] Implement strStr()
#

# @lc code=start
# KMP algo
class Solution:
    def populateLps(self, needle: str, n: int) -> List[int]:
        lps = [0] * len(needle)
        for i in range(1, n):
            j = lps[i - 1]
            while j > 0 and needle[j] != needle[i]:
                j = lps[j - 1]
            if needle[j] == needle[i]:
                j += 1
            lps[i] = j
        return lps
    
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if n == 0:
            return 0
        if n > m:
            return -1
        
        lps = self.populateLps(needle, n)
        
        j = 0
        for i in range(0, m):
            while j > 0 and haystack[i] != needle[j]:
                j = lps[j - 1]
            if haystack[i] == needle[j]:
                j += 1
                if j == n:
                    return i - n + 1
        return -1
# @lc code=end

