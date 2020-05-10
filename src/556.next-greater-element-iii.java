import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 * 
 * what to do?
 * find a pair that is increasing, and the second number should be as small as possible
 * 2 6 5 5
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        TreeMap<Integer, Integer> map = new TreeMap<>();;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            Map.Entry<Integer, Integer> cand = map.higherEntry(num);
            if (cand != null) {
                arr[i] = (char)(cand.getKey() + '0');
                arr[cand.getValue()] = (char) (num + '0');
                Arrays.sort(arr, i + 1, arr.length);
                long l = Long.parseLong(new String(arr));
                return l > (long)Integer.MAX_VALUE ? -1 : (int) l;
            }
            map.put(num, i);
        }
        return -1;
    }
}
// @lc code=end

