import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new double[0];
        }
        TreeSet<int[]> leftTree = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : (a[0] < b[0] ? -1 : 1));
        TreeSet<int[]> rightTree = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : (a[0] < b[0] ? -1 : 1));
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (leftTree.isEmpty() || nums[i] <= leftTree.last()[0]) {
                leftTree.add(new int[]{nums[i], i});
            } else {
                rightTree.add(new int[]{nums[i], i});
            }
            if (i - k + 1 >= 0) {
                if (i - k >= 0) {
                    int[] val = new int[]{nums[i-k], i-k};
                    boolean isLeft = leftTree.contains(val);
                    TreeSet<int[]> tree = isLeft ? leftTree : rightTree;
                    tree.remove(val);
                }
                rebalance(leftTree, rightTree);
                if (k % 2 == 1) {
                    res[i - k + 1] = leftTree.last()[0];
                } else {
                    res[i - k + 1] = ((double)leftTree.last()[0] + (double)rightTree.first()[0]) / 2.0;
                }
            }
        }
        return res;
    }
    private void rebalance(TreeSet<int[]> leftTree, TreeSet<int[]> rightTree) {
        int leftTreeTargetSize = (leftTree.size() + rightTree.size() + 1) / 2;
        while (leftTree.size() > leftTreeTargetSize) {
            rightTree.add(leftTree.pollLast());
        }
        while (leftTree.size() < leftTreeTargetSize) {
            leftTree.add(rightTree.pollFirst());
        }
    }
}
// @lc code=end

