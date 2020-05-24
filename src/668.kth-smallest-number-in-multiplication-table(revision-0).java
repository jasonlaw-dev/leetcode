import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=668 lang=java
 *
 * [668] Kth Smallest Number in Multiplication Table
 * 
 * O(m * n)
 * O(mn log (n))
 * 
 * [1, 2, 3]
 * [2, 2, 3]
 * [3, 2, 3]
 * 
1	2
2	4
3	6
4   8
5   10

int[2] [rowIndex, colIndex]

if we want to find 6th number

to get the ith square, we calc it by Math.ceiling(sqar(k))

if (the square can fit the table ) {
    index of the number = k - (i-1)^2
    i * ((index + 1) / 2)
} else {

}

int i = (int) (Math.ceil(Math.sqrt(k)));
        if (i <= m && i <= n) {
            int idx = k - (i - 1) * (i - 1);
            return i * ((idx + 1) / 2);
        }
*/

// @lc code=start
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int[] nums = new int[m * n];
        int min = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + 1) * (j + 1) <= min) {
                    count++;
                } else {
                    min = (i + 1) * (j + 1);
                }
                nums[i * n + j] = (i + 1) * (j + 1);
            }
        }
        Arrays.sort(nums);
        return nums[k - 1];
    }
}
// @lc code=end

