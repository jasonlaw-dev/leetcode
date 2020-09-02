#
# @lc app=leetcode id=209 lang=python3
#
# [209] Minimum Size Subarray Sum
#

# @lc code=start
class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        i = 0
        j = 0
        sum = 0
        res = len(nums) + 1
        while j < len(nums):
            sum += nums[j]
            j += 1
            while sum >= s:
                res = min(res, j - i)
                sum -= nums[i]
                i += 1
        return res if res <= len(nums) else 0
# @lc code=end

