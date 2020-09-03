#
# @lc app=leetcode id=214 lang=python3
#
# [214] Shortest Palindrome
#

# @lc code=start
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        ret = None
        for mid in range((len(s) - 1) // 2, -1, -1):
            if (mid != (len(s) - 1) // 2) or (len(s) % 2 == 0):
                ret = self.makePalindrome(s, mid, mid+1)
                if ret != None:
                    break
            ret = self.makePalindrome(s, mid, mid)
            if ret != None:
                break
        return ret if ret != None else ""



    def makePalindrome(self, s, start, end):
        #print(start, end)
        if start < 0:
            return None
        while start >= 0 and s[start] == s[end]:
            start -= 1
            end +=1
        if start == -1:
            repeatPart = s[end:]
            return repeatPart[::-1] + s[:end] + repeatPart
        return None


# @lc code=end

