import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// O(1): no hashmap

// how many elemtns?
// 9

// 4 4

// num: 1, count: 3 | num: unknown, count = 0


// 1 2 3 1 2 3 1 2

// 1 3 3 1 1 2 2 2

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num1 == num) {
                count1++;
            } else if (num2 == num) {
                count2++;
            } else {
                if (count1 == 0) {
                    num1 = num;
                    count1++;
                } else if (count2 == 0) {
                    num2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num1 == num) {
                count1++;
            } else if (num2 == num) {
                count2++;
            }
        }
        int target = nums.length / 3;
        if (count1 > target) {
            results.add(num1);
        }
        if (count2 > target) {
            results.add(num2);
        }
        return results;
    }
}
// @lc code=end

