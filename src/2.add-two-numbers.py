#
# @lc app=leetcode id=2 lang=python3
#
# [2] Add Two Numbers
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        dummyHead = ListNode(0)
        node = dummyHead
        while l1 != None or l2 != None or carry != 0:
            sum = (l1.val if l1 != None else 0) + (l2.val if l2 != None else 0) + carry
            node.next = ListNode(sum % 10)
            carry = sum // 10
            node = node.next
            if l1 != None:
                l1 = l1.next
            if l2 != None:
                l2 = l2.next
        
        return dummyHead.next
        

# @lc code=end

