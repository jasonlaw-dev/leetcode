/*
 * @lc app=leetcode id=1483 lang=java
 *
 * [1483] Kth Ancestor of a Tree Node
 */

// @lc code=start
class TreeAncestor {
    private int[] parent;
    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
    }
    
    public int getKthAncestor(int node, int k) {
        if (k == 0) {
            return node;
        }
        if (node <= 0) {
            return -1;
        }
        TreeMap<Integer, Integer> tree = map.get(node);
        if (tree == null) {
            tree = new TreeMap<>();
            map.put(node, tree);
        }
        
        Map.Entry<Integer, Integer> entry = tree.floorEntry(k);
        int res;
        if (entry != null) {
            res = getKthAncestor(entry.getValue(), k - entry.getKey());
        } else {
            res = getKthAncestor(parent[node], k - 1);
        }
        map.get(node).put(k, res);
        return res;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
// @lc code=end

