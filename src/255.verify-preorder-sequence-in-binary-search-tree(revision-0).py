#
# @lc app=leetcode id=255 lang=python3
#
# [255] Verify Preorder Sequence in Binary Search Tree
#

# @lc code=start
class Solution:
    def verifyPreorder(self, preorder: List[int]) -> bool:
        low = float('-inf')
        stackIdx = -1
        for num in preorder:
            if num < low:
                return False
            while stackIdx >= 0 and preorder[stackIdx] < num:
                low = preorder[stackIdx]
                stackIdx -= 1
            stackIdx += 1
            preorder[stackIdx] = num
        return True
        
# @lc code=end

