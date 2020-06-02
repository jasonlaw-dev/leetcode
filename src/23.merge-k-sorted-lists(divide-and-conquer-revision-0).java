import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 * 
 * Time: O(N log K) where k is number of lists
 * Space: O(1)
 */

 /*
 so log k gives you how many levels your tree will have, or how many times you can divide k by 2 to reach 1, or how many times you will perform a total merge. Let's assume that k = 8 so we have 8 arrays. We know that merging two arrays can be performed in linear time: O(size(arr1)+size(arr2)) So, if group those 8 arrays in groups of two, we will have 4 groups, which is equivalent to say that we will perform 4 merge operations. correct? This is, 4 merge operations with cost O(N/8+N/8), which is 4O(2N/8), if we move the constant out then 4(2/8)*O(N). This is O(N). If N is the total number of elements considering all the arrays, then we spent O(N) time in the merge operation. This will give us 4 new arrays. We will apply the same logic again, form groups of 2 and merge them. In this case, we will have 2 groups, and the merge operation will give us 2 new arrays. If we do this one more time we will merge those 2 arrays into one, reaching our base case. How many total merge operations we performed at each level? O(N) for the level of 8 arrays, then O(N) for the level of 4 arrays, then O(N) for the level of 2 arrays, and O(n) for the level of 1 array. So in total we performed 4 total merge operations, this is described by the following equation: O(log(8) + 1) which is O(log(8)). Remember that 8 = k, then O(log(k)).
 /*

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // 1 2 3 4 5 6 7
 // 1 3 5 7
 // 1 5
// 1
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int n = 1;
        while (n < lists.length) {
            for (int i = 0; i < lists.length; i += n * 2) {
                if (i + n < lists.length) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + n]);
                }
            }
            n *= 2;
        }
        return lists[0];
    }

    // copied from LC #21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (true) {
            if (curr1 == null || curr2 == null) {
                tail.next = curr1 != null ? curr1 : curr2;
                break;
            }
            ListNode smaller;
            if (curr1.val <= curr2.val) {
                smaller = curr1;
                curr1 = curr1.next;
            } else {
                smaller = curr2;
                curr2 = curr2.next;
            }
            tail.next = smaller;
            tail = smaller;
        }

        return head.next;
    }
}
// @lc code=end

