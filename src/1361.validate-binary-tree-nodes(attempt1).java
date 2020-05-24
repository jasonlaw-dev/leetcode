import java.util.Arrays;

/*
 * @lc app=leetcode id=1361 lang=java
 *
 * [1361] Validate Binary Tree Nodes
 */

 // only 1 node would have no parent, all other nodes would have 1 parent

 // we have a cycle on the left, and a single right

// @lc code=start
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n]; // parnet[i] = parent of node i
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] != -1) {
                    return false;
                }
                parent[leftChild[i]] = i;
            }
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] != -1) {
                    return false;
                }
                parent[rightChild[i]] = i;
            }
        }
        int count = 0; // count number of nodes with parent
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                count++;
            } else {
                if (n != 1 && leftChild[i] == -1 && rightChild[i] == -1)  {
                    return false;
                }
            }
        }
        return count == n - 1;
    }
}
// @lc code=end

