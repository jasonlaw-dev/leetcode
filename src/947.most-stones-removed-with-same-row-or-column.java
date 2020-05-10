import java.util.Map;

/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start
class Solution {
    int islands = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            union(stone[0], 10000+stone[1]);
        }
        return stones.length - islands;
    }

    private int find(int x) {
        if (!map.containsKey(x)) {
            map.put(x, x);
            islands++;
        }
        if (map.get(x) != x) {
            map.put(x, find(map.get(x)));
        }
        return map.get(x);
    }

    private void union(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i != j) {
            islands--;
            map.put(i, j);
        }
    }
}
// @lc code=end

