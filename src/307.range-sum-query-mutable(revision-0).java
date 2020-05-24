/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {

    int[] nums;
    int[] tree;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.tree = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            this.update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        for (i = i + 1; i < tree.length; i += i & (-i)) {
            tree[i] += delta;
        }
    }

    private int presum(int i) {
        int sum = 0;
        for (i = i + 1; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
    
    public int sumRange(int i, int j) {
        return presum(j) - presum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end

