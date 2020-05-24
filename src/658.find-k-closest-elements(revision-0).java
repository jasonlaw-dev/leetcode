/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
          int mid = (i + j + 1) / 2;
          if (arr[mid] > x) {
            j = mid - 1;
          } else {
            i = mid;
          }
        }
        j = i + 1;
        LinkedList<Integer> res = new LinkedList<>();
        while (k > 0) {
          if (i >= 0 && j < arr.length) {
            int leftDist = Math.abs(x - arr[i]);
            int rightDist = Math.abs(arr[j] - x);
            if (leftDist <= rightDist) {
              res.addFirst(arr[i--]);
            } else {
              res.addLast(arr[j++]);
            }
          } else if (i < 0) {
            res.addLast(arr[j++]);
          } else {
            res.addFirst(arr[i--]);
          }
          k--;
        }
        return res;
    }
}
// @lc code=end

