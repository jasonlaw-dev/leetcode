/*
 * @lc app=leetcode id=1481 lang=java
 *
 * [1481] Least Number of Unique Integers after K Removals
 */

// @lc code=start
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        int unique = map.size();
        if (k == 0) return unique;
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        for (int num : list) {
            if (num > k) {
                break;
            }
            unique--;
            k -= num;
        }
        return unique;
    }
}
// @lc code=end

