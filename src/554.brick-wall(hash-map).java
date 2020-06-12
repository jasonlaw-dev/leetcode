import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */
// use heap
// int[startingInterval so far, rowIndex, brickIndex]

// [0, 0,0] [0, 1, 0] .. [0, n-1, 0];   n: number of rows;
// need a way to store currnet point and also number of edges
// initial condition, point = 0, edge = 0;
// then keep polling until the top of the heap has a different point or if heap is empty

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int len = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                len += row.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
                count = Math.max(count, map.get(len));
            }
        }
        return wall.size() - count;
    }
}
// @lc code=end

