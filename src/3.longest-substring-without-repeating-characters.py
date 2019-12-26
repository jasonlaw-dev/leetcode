#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = {}
        maxLen = 0
        start = 0
        for i in range(len(s)):
            if s[i] in charSet and start <= charSet[s[i]]:
                start = charSet[s[i]] + 1
            else:
                maxLen = max(maxLen, i - start + 1)
            charSet[s[i]] = i
        return maxLen
                

# @lc code=end

