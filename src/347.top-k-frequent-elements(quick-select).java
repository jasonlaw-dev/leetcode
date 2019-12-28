import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[][] count = new int[map.size()][];
        int i = 0;
        for (int key : map.keySet()) {
            count[i++] = new int[] { key, map.get(key) };
        }
        int partition = quickSelect(count, 0, count.length - 1, k);
        List<Integer> res = new ArrayList<>();
        for (i = partition; i < count.length; i++) {
            res.add(count[i][0]);
        }
        return res;
    }

    int quickSelect(int[][] count, int start, int end, int k) {
        swap(count, start + (int) (Math.random() * (end - start + 1)), end);
        int pivotValue = count[end][1];
        int i = start;
        for (int j = start; j < end; j++) {
            if (count[j][1] < pivotValue) {
                swap(count, j, i);
                i++;
            }
        }
        swap(count, i, end);
        int highCount = end - i + 1;
        if (highCount == k) {
            return i;
        } else if (highCount > k) {
            return quickSelect(count, i + 1, end, k);
        } else {
            return quickSelect(count, start, i - 1, k - highCount);
        }
    }
    void swap(int[][] count, int i, int j) {
        int[] temp = count[i];
        count[i] = count[j];
        count[j] = temp;
    }
}
// @lc code=end

