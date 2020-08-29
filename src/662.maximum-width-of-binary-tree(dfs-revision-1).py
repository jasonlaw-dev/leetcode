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
        self.max = 0
        self.left = list()
        self.dfs(root, 0, 0)
        return self.max
    def dfs(self, root: TreeNode, depth: int, idx: int) -> None:
        if root is not None:
            if len(self.left) == depth:
                self.left.append(idx)
            self.max = max(self.max, idx - self.left[depth] + 1)
            self.dfs(root.left, depth + 1, idx * 2)
            self.dfs(root.right, depth + 1, idx * 2 + 1)
# @lc code=end

