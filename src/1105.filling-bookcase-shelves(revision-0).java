/*
 * @lc app=leetcode id=1105 lang=java
 *
 * [1105] Filling Bookcase Shelves
 * 
 * brute force (O(2^n))
 * 
 * for each book, we should try to place it on the same shelf
 * if height of curr book  <= height of the shelf
 */

// @lc code=start
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            dp[i + 1] = dp[i] + books[i][1];
            int width = books[i][0];
            int height = books[i][1];
            for (int j = i - 1; j >= 0 && width + books[j][0] <= shelf_width; j--) {
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + height);
            }
        }
        return dp[books.length];
    }
}
// @lc code=end

