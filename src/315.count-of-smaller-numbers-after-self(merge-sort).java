import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start

class Node {
    int val;
    int index;
    Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] smaller = new Integer[nums.length];
        Arrays.fill(smaller, 0);
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        sort(nodes, smaller);
        return Arrays.asList(smaller);
    }

    public Node[] sort(Node[] nodes, Integer[] smaller) {
        if (nodes.length <= 1) {
            return nodes;
        }
        int mid = nodes.length / 2;
        Node[] left = sort(Arrays.copyOfRange(nodes, 0, mid), smaller);
        Node[] right = sort(Arrays.copyOfRange(nodes, mid, nodes.length), smaller);
        int i = 0;
        int j = 0;
        int m = left.length;
        int n = right.length;
        while (i < m || j < n) {
            if (j == n || i < m && left[i].val <= right[j].val) {
                nodes[i+j] = left[i];
                smaller[left[i].index] += j;
                i++;
            } else {
                nodes[i+j] = right[j];
                j++;
            }
        }
        return nodes;
    }
}
// @lc code=end

