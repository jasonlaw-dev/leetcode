from typing import List
#
# @lc app=leetcode id=524 lang=python3
#
# [524] Longest Word in Dictionary through Deleting
#

# @lc code=start
class Solution:
    def findLongestWord(self, s: str, d: List[str]) -> str:
        res = ""
        d.sort()
        d.sort(key = lambda el: -len(el))
        for word in d:
            if len(word) > len(s):
                continue
            i = 0
            j = 0
            while i < len(s) and j < len(word) and len(word) - j <= len(s) - i:
                if s[i] == word[j]:
                    j += 1
                i += 1
            if j == len(word):
                res = word
                break
        return res
# @lc code=end

