/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int[] edge : edges) {
            int setI = find(parent, edge[0]);
            int setJ = find(parent, edge[1]);
            if (setI == setJ) {
                return edge;
            }
            parent[setI] = setJ;
        }
        return null;
    }
    private int find(int[] parent, int i) {
        while (parent[i] != 0) {
            i = parent[i];
        }
        return i;
    }
}
// @lc code=end

