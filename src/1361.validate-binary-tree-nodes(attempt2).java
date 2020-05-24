import java.util.Arrays;

/*
 * @lc app=leetcode id=1361 lang=java
 *
 * [1361] Validate Binary Tree Nodes
 * 
 * 1. every number will only appear once in both arrays. => no diamond path
 * 2. only one node does not have a parent, and that node must have a child if n > 1

 */




// @lc code=start
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (visited[leftChild[i]]) {
                    return false;
                }
                visited[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                if (visited[rightChild[i]]) {
                    return false;
                }
                visited[rightChild[i]] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (n != 1 && leftChild[i] == -1 && rightChild[i] == -1) {
                    return false;
                } 
                count++;
                if (count == 2) {
                    return false;
                }

            }
        }
        return count == 1;
    }

}
// @lc code=end

