from collections import deque
#
# @lc app=leetcode id=662 lang=python3
#
# [662] Maximum Width of Binary Tree
#
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        queue = deque()
        queue.append((root, 0))
        res = 0
        while queue:
            left = queue[0][1]
            right = left
            for i in range(len(queue)):
                curr = queue.popleft()
                right = curr[1]
                if curr[0].left is not None:
                    queue.append((curr[0].left, curr[1] * 2))
                if curr[0].right is not None:
                    queue.append((curr[0].right, curr[1] * 2 + 1))
            res = max(res, right - left + 1)
        return res



# @lc code=end

